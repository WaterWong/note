create table if not exists  sys_user_ext
(
    "id"             character varying(36) not null
        primary key,
    avatar varchar(256)
);

comment on table "sys_user_ext" is '用户扩展表';
comment on column "sys_user_ext"."avatar" is '用户头像';
