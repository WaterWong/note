create table if not exists files_tag (
    "id" Long   primary key,
    "desc" character varying(24)
);
comment on table "files_tag" is '文件标签';
comment on column "files_tag"."desc" is '文件标签描述';

create table if not exists files_catalog (
    "id"   Long   primary key,
    "desc" character varying(24)
);
comment on table "files_catalog" is '文件分类';
comment on column "files_catalog"."desc" is '文件分类描述';