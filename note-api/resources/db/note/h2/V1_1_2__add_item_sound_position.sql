
alter table "item" add column "sound_position" int;
comment on column "item"."sound_position" is '读音';