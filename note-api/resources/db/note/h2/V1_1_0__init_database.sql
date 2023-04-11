create table if not exists item (
    id varchar(36) primary key not null,
    type varchar(2) not null,
    japanese varchar(256) not null,
    hiragana varchar(256),
    chinese varchar(256),

    create_user_id varchar(36) not null,
    create_user    varchar(32) not null,
    create_time    timestamp(6) not null,
    update_user_id varchar(36),
    update_user    varchar(32),
    update_time    timestamp(6)
    );

create unique index if not exists uix_item_japanese_create_user_id on item(japanese,create_user_id);


comment on table item is '詞條';
comment on column item.type is '詞條類型: 1=單詞, 2=句子, 3=语法';
comment on column item.japanese is '日文';
comment on column item.hiragana is '假名';
comment on column item.chinese is '中文';


create table if not exists item_favorite (
    id varchar(36),
    item_id varchar(36),
    create_user_id varchar(36),
    create_user    varchar(32),
    create_time    timestamp(6),

    update_user_id varchar(36),
    update_user    varchar(32),
    update_time    timestamp(6)

    );
comment on table item_favorite is '詞條-收藏夾 ';
create unique index uix_item_favorite_item_id_create_user on item_favorite(item_id,create_user_id);

create table if not exists item_log(
    id varchar(36),
    item_id varchar(36),
    log_type varchar(12),

    create_user_id varchar(36),
    create_user    varchar(32),
    create_time    timestamp(6),
    update_user_id varchar(36),
    update_user    varchar(32),
    update_time    timestamp(6)

    );
comment on table item_log is '詞條-日誌 ';
comment on column item_log.log_type is '日誌類型: 1=創建, 2=查看, 3=編輯 ';

drop view  if exists v_item_favorite;
create view v_item_favorite(
                            id,
                            type,
                            japanese,
                            hiragana,
                            chinese
    )
as
select i.* from item i,item_favorite f
where i.id = f.item_id
;
comment on view v_item_favorite is '視圖:詞條-收藏夾 ';
comment on column v_item_favorite.type is '詞條類型: 1=單詞, 2=句子';
comment on column v_item_favorite.japanese is '日文';
comment on column v_item_favorite.hiragana is '假名';
comment on column v_item_favorite.chinese is '中文';

create table if not exists "sys_user" (
                                          id varchar(36) primary key not null,
                                          username varchar(36) not null,
                                          password varchar(128) not null
);

create unique index sys_user_username on "sys_user"(username);
