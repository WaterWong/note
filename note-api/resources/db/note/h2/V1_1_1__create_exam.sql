create table "exam"
(
    "id"             character varying(36)  not null
        primary key,
    "name" character varying(36),
    "create_user_id" character varying(36)  not null,
    "create_user"    character varying(32)  not null,
    "create_time"    timestamp(6)           not null,
    "update_user_id" character varying(36),
    "update_user"    character varying(32),
    "update_time"    timestamp(6)
);

comment on table "exam" is '测验';
comment on column "exam"."name" is '测验标题';


create table "exam_log"
(
    "id"             character varying(36)  not null
        primary key,
    "exam_id"       character varying(36) not null,
    "item_id"       character varying(36) not null,
    "result"        boolean not null ,
    "origin"        character varying(256) not null,
    "translate"     character varying(256) not null,
    "answer"        character varying(256) not null

);

comment on table "exam_log" is '测验日志';
comment on column "exam_log"."result" is '詞條数量';
comment on column "exam_log"."origin" is '原文';
comment on column "exam_log"."translate" is '译文';
comment on column "exam_log"."answer" is '答案';

