create table if not exists "jlpt_exam"
(
    "id"             character varying(36) not null
        primary key,
    "level"          character varying(2)  not null,
    "exam_ym"        character varying(6)  not null,
    "status"         character varying(16) not null,
    "start_time"     timestamp(6)          not null,
    "pause_time"     timestamp(6),
    "finish_time"    timestamp(6),
    "create_user_id" character varying(36) not null,
    "create_user"    character varying(32) not null,
    "create_time"    timestamp(6)          not null,
    "update_user_id" character varying(36),
    "update_user"    character varying(32),
    "update_time"    timestamp(6)
);

comment on table "jlpt_exam" is 'JLPT考试';
comment on column "jlpt_exam"."level" is 'JLPT等级';
comment on column "jlpt_exam"."exam_ym" is '考试年月, 格式yyyy07或yyyy12';
comment on column "jlpt_exam"."status" is '状态: RUNNING, PAUSED, FINISHED';

create table if not exists "jlpt_exam_record"
(
    "id"             character varying(36) not null
        primary key,
    "exam_id"        character varying(36) not null,
    "section_type"   character varying(32) not null,
    "question_no"    integer               not null,
    "doubt_flag"     character varying(1)  not null default 'n',
    "user_answer"    character varying(1),
    "correct_answer" character varying(1),
    "result"         boolean               not null default false,
    "create_user_id" character varying(36) not null,
    "create_user"    character varying(32) not null,
    "create_time"    timestamp(6)          not null,
    "update_user_id" character varying(36),
    "update_user"    character varying(32),
    "update_time"    timestamp(6)
);

comment on table "jlpt_exam_record" is 'JLPT考试作答记录';
comment on column "jlpt_exam_record"."section_type" is '考试内容';
comment on column "jlpt_exam_record"."doubt_flag" is '疑问: n=无, y=有';

create table if not exists "jlpt_exam_answer"
(
    "id"             character varying(36) not null
        primary key,
    "level"          character varying(2)  not null,
    "exam_ym"        character varying(6)  not null,
    "section_type"   character varying(32) not null,
    "question_no"    integer               not null,
    "correct_answer" character varying(1)  not null,
    "create_user_id" character varying(36) not null,
    "create_user"    character varying(32) not null,
    "create_time"    timestamp(6)          not null,
    "update_user_id" character varying(36),
    "update_user"    character varying(32),
    "update_time"    timestamp(6)
);

comment on table "jlpt_exam_answer" is 'JLPT正确答案配置';
comment on column "jlpt_exam_answer"."correct_answer" is '正确答案';

create unique index if not exists "uk_jlpt_exam_answer"
    on "jlpt_exam_answer" ("create_user_id", "level", "exam_ym", "section_type", "question_no");

create index if not exists "idx_jlpt_exam_user_ym"
    on "jlpt_exam" ("create_user_id", "level", "exam_ym");

create index if not exists "idx_jlpt_exam_record_exam"
    on "jlpt_exam_record" ("exam_id");
