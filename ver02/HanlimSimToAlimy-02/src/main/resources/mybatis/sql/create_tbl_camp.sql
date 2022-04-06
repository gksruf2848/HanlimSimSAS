drop table tbl_camp;

-------------------------
create table if not exists tbl_camp 
(
	id           bigint       not null auto_increment,
	camp_code    varchar(128) not null,
	camp_content varchar(4096) not null,
	flag_send    varchar(1),
	time_insert  timestamp default current_timestamp,
	time_send    timestamp
);

-------------------------
select
	id
	, camp_code
	, camp_content
	, flag_send
	, time_insert
	, time_send
from
	tbl_camp
where 1=1
	and id = 1
;
-------------------------
insert into tbl_camp
(
	camp_code,
	camp_content,
	flag_send
)
values
(
	'camp000',
	'content000',
	'N'
);
select * from tbl_camp;
-------------------------
update
	tbl_camp
set
	flag_send = 'Y',
	time_send = current_timestamp()
where
	id = 1
;
select * from tbl_camp;
-------------
update
	tbl_camp
set
	flag_send = 'Y',
	time_send = parsedatetime('2001-07-12 03:05:06.123','yyyy-MM-dd HH:mm:ss.SSS')
where
	id = 1
;
select * from tbl_camp;
-------------
update
	tbl_camp
set
	flag_send = 'Y',
	time_send = {ts '2012-09-17 18:47:52.777'}
where
	id = 1
;
select * from tbl_camp;
---------------
update
	tbl_camp
set
	flag_send = null
	, time_send = null
where 1=1
;
select * from tbl_camp;
---------------
call parsedatetime('2001-07-12 03:05:06','yyyy-MM-dd HH:mm:ss');

