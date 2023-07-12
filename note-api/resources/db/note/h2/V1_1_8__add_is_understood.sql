
alter table "item" add column if not exists "is_understood" boolean default false;
comment on column "item"."is_understood" is '是否:懂了(掌握了,免测试)';



