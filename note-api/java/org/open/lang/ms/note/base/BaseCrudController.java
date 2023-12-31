package org.open.lang.ms.note.base;

import org.soul.ability.web.springmvc.consts.CommonRouter;
import org.soul.base.bean.IEntity;
import org.soul.base.bean.Pair;
import org.soul.base.lang.GenericTool;
import org.soul.base.query.result.Paging;
import org.soul.base.query.result.PagingResult;
import org.soul.base.support.model.common.BaseDeleteModel;
import org.soul.base.support.model.common.BasePagingModel;
import org.soul.base.support.service.IBaseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import java.util.List;


public class BaseCrudController<PK,
        B extends IBaseCrudService<M, PK>,
        M extends IEntity<PK>> {

    @Autowired
    protected B biz;

    /**
     * add 方法
     *
     * @param addVo 参数
     * @return 新增的数据
     */
    @RequestMapping(value = CommonRouter.BaseCrud.ADD, method = RequestMethod.POST)
    public PK add(@Valid @RequestBody M addVo) {
        if ("".equals(addVo.getId())) {
            addVo.setId(null);
        }
        int rs = biz.insert(addVo);
        return addVo.getId();
    }

    /**
     * edit 方法
     *
     * @param editVo 参数
     * @return 修改后的数据
     */
    @RequestMapping(value = CommonRouter.BaseCrud.CHANGE, method = RequestMethod.POST)
    public Boolean update(@Valid @RequestBody M editVo) {
        return biz.update(editVo);
    }

    /**
     * 删除指定主键的记录
     *
     * @param model 主键
     * @return WebResult是否删除成功
     */
    @RequestMapping(value = CommonRouter.BaseCrud.REMOVE, method = RequestMethod.POST)
    public boolean delete(@Valid @RequestBody BaseDeleteModel<PK> model) {
        return biz.deleteById(model.getId());
    }

    /**
     * 批量删除指定主键的记录
     *
     * @param ids 主键
     * @return WebResult(是否删除成功)
     */
    @RequestMapping(value = CommonRouter.BaseCrud.BATCH_REMOVE, method = RequestMethod.POST)
    public boolean batchDelete(@RequestBody List<PK> ids) {
        return biz.batchDelete(ids) == ids.size();
    }


}
