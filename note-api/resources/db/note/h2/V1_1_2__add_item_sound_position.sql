
alter table "item" add column if not exists "sound_position" int;
comment on column "item"."sound_position" is '读音';