create table if not exists files
(
    "id"             character varying(36) not null
        primary key,
    "path"           varchar(256),
    "hash"           varchar(128),

    "create_user_id" character varying(36) not null,
    "create_user"    character varying(32) not null,
    "create_time"    timestamp(6)          not null,
    "update_user_id" character varying(36),
    "update_user"    character varying(32),
    "update_time"    timestamp(6)
);

comment on table "files" is '文件';
comment on column "files"."path" is '文件目录';
comment on column "files"."hash" is '文件hash,避免重复';

create table if not exists files_tag_rel
(
    "id"        character varying(36) not null
        primary key,
    file_tag_id Long,
    file_id     character varying(36)
);


create table if not exists files_catalog_rel
(
    "id"            character varying(36) not null
        primary key,
    file_catalog_id Long,
    file_id         character varying(36)
);
