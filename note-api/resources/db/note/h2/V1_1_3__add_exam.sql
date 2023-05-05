drop view if exists v_exam;
drop table  if exists exam;
drop table  if exists exam_log;
create table if not exists "exam"
(
    "id"             character varying(36) not null
        primary key,
    "name"           character varying(36),
    "create_user_id" character varying(36) not null,
    "create_user"    character varying(32) not null,
    "create_time"    timestamp(6)          not null,
    "update_user_id" character varying(36),
    "update_user"    character varying(32),
    "update_time"    timestamp(6)
);

comment on table "exam" is '测验';
comment on column "exam"."name" is '测验标题';


create table if not exists "exam_log"
(
    "id"             character varying(36)  not null
        primary key,
    "exam_id"       character varying(36) not null,
    "item_id"       character varying(36) not null,
    "result"        boolean not null ,
    "question"      character varying(256) not null,
    "answer"        character varying(256) not null,
    "create_user_id" character varying(36)  not null,
    "create_user"    character varying(32)  not null,
    "create_time"    timestamp(6)           not null,
    "update_user_id" character varying(36),
    "update_user"    character varying(32),
    "update_time"    timestamp(6)

);

comment on table "exam_log" is '测验日志';
comment on column "exam_log"."result" is '詞條数量';
comment on column "exam_log"."question" is '原文';
comment on column "exam_log"."answer" is '答案';



drop view if exists v_exam;
CREATE VIEW if not exists "v_exam" AS
SELECT "ex"."id",
       "ex"."name",
       COUNT("el"."id") AS "count",
       COUNT(CASE WHEN "el"."result"  THEN 1 ELSE 0 END) AS "score"
FROM "exam" "ex"
         LEFT JOIN "exam_log" "el" ON "ex"."id" = "el"."exam_id"
GROUP BY "ex"."id", "ex"."name";


