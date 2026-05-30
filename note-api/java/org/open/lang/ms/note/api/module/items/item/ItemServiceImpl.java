package org.open.lang.ms.note.api.module.items.item;

import jakarta.validation.constraints.NotNull;
import org.open.lang.ms.note.api.module.items.favorite.ItemFavorite;
import org.open.lang.ms.note.api.module.items.favorite.ItemFavoriteService;
import org.open.lang.ms.note.api.module.items.log.ItemLog;
import org.open.lang.ms.note.api.module.items.log.ItemLogService;
import org.open.lang.ms.note.api.module.items.log.ItemLogType;
import org.soul.ability.data.rdb.mybatis.entity.BaseEntity;
import org.soul.ability.data.rdb.mybatis.service.BaseCrudService;
import org.soul.base.bean.BeanTool;
import org.soul.base.bean.Pair;
import org.soul.base.lang.BooleanTool;
import org.soul.base.lang.collections.CollectionTool;
import org.soul.base.lang.string.StringTool;
import org.soul.base.query.Criteria;
import org.soul.base.query.enums.OperatorEnum;
import org.soul.base.query.sort.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Roger
 *
 */
@Service
public class ItemServiceImpl extends BaseCrudService<Item, ItemMapper, String> implements ItemService {

    @Autowired
    private ItemFavoriteService itemFavoriteService;

    @Autowired
    private ItemLogService itemLogService;

    @Override
    public ItemRecordResult oneWord(String word, String createUserId) {
        Criteria criteria =
                Criteria.and(
                        Criteria.add(BaseEntity.FIELD_CREATE_USER_ID, OperatorEnum.EQ, createUserId),
                        Criteria.add(Item.FIELD_JAPANESE, OperatorEnum.EQ, word)
                );
        List<Item> items = mapper.search(criteria);
        List<ItemRecordResult> results = toVo(items);
        fillFavorite(createUserId, results);
        return results.get(0);
    }


    @Override
    public List<ItemRecordResult> recent(int pageNo,int pageSize, String createUserId) {
        Criteria criteria = Criteria .add(BaseEntity.FIELD_CREATE_USER_ID, OperatorEnum.EQ, createUserId);
        List<Item> items = mapper.pagingSearch(criteria, pageNo, pageSize, Order.desc(BaseEntity.FIELD_CREATE_TIME)).getKey();
        List<ItemRecordResult> results = toVo(items);
        fillFavorite(createUserId, results);
        return results;
    }

    @Override
    public List<ItemRecordResult> recentByCondition(ItemListCondition condition, String createUserId) {
        Criteria criteria = Criteria.add(BaseEntity.FIELD_CREATE_USER_ID, OperatorEnum.EQ, createUserId);
        criteria = criteria.addAnd(Criteria.add(Item.FIELD_TYPE, OperatorEnum.NE, "3"));

        ItemListCondition.DateRange dateRange = condition.getDateRange();
        if (dateRange != null && dateRange != ItemListCondition.DateRange.ALL) {
            Pair<Date, Date> duration = calcListDateRange(dateRange);
            criteria = criteria
                    .addAnd(Criteria.add(BaseEntity.FIELD_CREATE_TIME, OperatorEnum.GE, duration.getKey()))
                    .addAnd(Criteria.add(BaseEntity.FIELD_CREATE_TIME, OperatorEnum.LT, duration.getValue()));
        }

        String itemType = condition.getItemType();
        if (StringTool.isNotBlank(itemType) && !"0".equals(itemType)) {
            criteria = criteria.addAnd(Criteria.add(Item.FIELD_TYPE, OperatorEnum.EQ, itemType));
        }

        if (condition.getIsUnderstood() != null) {
            criteria = criteria.addAnd(
                    Criteria.add(Item.FIELD_IS_UNDERSTOOD, OperatorEnum.EQ, condition.getIsUnderstood())
            );
        }

        List<Item> items = mapper.pagingSearch(
                criteria,
                condition.getPageNo(),
                condition.getPageSize(),
                Order.desc(BaseEntity.FIELD_CREATE_TIME)
        ).getKey();
        List<ItemRecordResult> results = toVo(items);
        fillFavorite(createUserId, results);
        return results;
    }

    private Pair<Date, Date> calcListDateRange(ItemListCondition.DateRange dateRange) {
        return switch (dateRange) {
            case TODAY -> calcDate(0, 1);
            case YESTERDAY -> calcDate(-1, 0);
            case DAYS_3 -> calcDate(-3, 1);
            case DAYS_7 -> calcDate(-7, 1);
            case DAYS_15 -> calcDate(-15, 1);
            case DAYS_30 -> calcDate(-30, 1);
            default -> calcDate(-365, 1);
        };
    }

    private Pair<Date, Date> calcDate(int startDayOffset, int endDayOffset) {
        Instant now = Instant.now().truncatedTo(ChronoUnit.DAYS);
        Date dateStart = new Date(now.plus(Duration.ofDays(startDayOffset)).toEpochMilli());
        Date dateEnd = new Date(now.plus(Duration.ofDays(endDayOffset)).toEpochMilli());
        return new Pair<>(dateStart, dateEnd);
    }

    private void fillFavorite(String createUserId, List<ItemRecordResult> results) {
        if (CollectionTool.isNotEmpty(results)) {
            List<String> ids = results.stream()
                    .map( item -> item.getId())
                    .collect(Collectors.toList());

            //search the one favorite records
            List<ItemFavorite> byIds = itemFavoriteService.searchByItemIdByCreateUser(ids, createUserId);
            Set<String> favoriteIds = byIds.stream().map(i -> i.getItemId()).collect(Collectors.toSet());
            results.stream().forEach(rs -> {
                if (favoriteIds.contains(rs.getId())) {
                    rs.setFavorite(true);
                }
            });
        }
    }

    @NotNull
    private static List<ItemRecordResult> toVo(List<Item> items) {
        List<ItemRecordResult> results = items.stream()
                .map(a -> {
                    return BeanTool.copyProperties(a, new ItemRecordResult());
                })
                .collect(Collectors.toList());
        return results;
    }

    @Override
    @Transactional
    public ItemEditModel saveOrUpdate(ItemEditModel addVo) {
        String japanese = StringTool.defaultIfBlank(addVo.getJapanese(),"");
        String hiragana = StringTool.defaultIfBlank(addVo.getHiragana(),"");
        String chinese = StringTool.defaultIfBlank(addVo.getChinese(),"");
        //notice: \s 后面是全角空格
        japanese = japanese.replaceAll("^[\\s|　]*","").replaceAll("[\\s|　]*$","");
        hiragana = hiragana.replaceAll("^[\\s|　]*","").replaceAll("[\\s|　]*$","");
        chinese = chinese.replaceAll("^[\\s|　]*","").replaceAll("[\\s|　]*$","");

        addVo.setJapanese(japanese);
        addVo.setHiragana(hiragana);
        addVo.setChinese(chinese);
        if (StringTool.isNotBlank(addVo.getId())) {
            if (super.updateOnly(addVo)) {
                ItemLog itemLog = new ItemLog();
                itemLog.setItemId(addVo.getId());
                itemLog.setLogType(ItemLogType.EDIT.getCode());
                itemLogService.insert(itemLog);
                return addVo;
            }
        }
        Item item = new Item();
        BeanTool.copyProperties(addVo,item);
        int rs = insert(item);
        if (rs > 0) {
            BeanTool.copyProperties(item,addVo);
        }
        return addVo;
    }

    @Deprecated(since = "1.0.1")
    @Override
    public List<Item> fullSearch(String createUserId, String word,String type) {
        return fullSearch(createUserId,word,type,ItemFieldRange.ALL);
    }

    @Override
    public List<Item> searchByCondition(ItemSearchCondition condition) {
        return fullSearch(
                condition.getCreateUserId(),
                condition.getWord(),
                condition.getType(),
                condition.getFieldRange()
        );
    }

    private List<Item> fullSearch(String createUserId, String word,String type,ItemFieldRange fieldRange) {

        //词条内容查询字段:字段名条件
        Criteria fields = null;
        switch (fieldRange) {
            case JAPANESE -> fields = Criteria.add(Item.FIELD_JAPANESE, OperatorEnum.LIKE, word);
            case HIRAGANA -> fields = Criteria.add(Item.FIELD_HIRAGANA, OperatorEnum.LIKE, word);
            case CHINESE  -> fields = Criteria.add(Item.FIELD_CHINESE, OperatorEnum.LIKE, word);
            case ALL -> {
                fields = Criteria.or(
                        Criteria.add(Item.FIELD_JAPANESE, OperatorEnum.LIKE, word),
                        Criteria.add(Item.FIELD_HIRAGANA, OperatorEnum.LIKE, word),
                        Criteria.add(Item.FIELD_CHINESE, OperatorEnum.LIKE, word)

                );
            }
        }
        Criteria criteria = Criteria
                .add(BaseEntity.FIELD_CREATE_USER_ID, OperatorEnum.EQ, createUserId)
                .addAnd( fields )
                .addAnd(
                        Criteria.add(Item.FIELD_TYPE,OperatorEnum.EQ, type)
                )
                ;

        List<Item> items = mapper.pagingSearch(criteria, 1, 20, Order.desc(BaseEntity.FIELD_CREATE_TIME)).getKey();
        return items;
    }


    @Override
    public boolean understood(String itemId) {
        Item item = mapper.get(itemId);
        if (item != null) {
            boolean is = BooleanTool.toBoolean(item.getIsUnderstood());
            item.setIsUnderstood(!is);
            return mapper.updateOnly(item,Item.FIELD_IS_UNDERSTOOD);
        }
        return true;
    }

}