drop table tbl_camp2;

-------------------------
create table if not exists tbl_camp2 
(
	id                   bigint       not null auto_increment,
	camp_code            varchar(128) not null,
	
	mem_no               bigint,                       -- 회원번호
	talk_msg_tmplt_no    varchar(10)   default '900',  -- 개인화 메시지 타입코드 900 
	app_kd_cd            varchar(10),                  -- 대상앱 지정: AppKdCdType.ELEVENSTAPP
	push_top_message     varchar(512),                 -- 안드로이드 상단메시지 JSON데이터 
	push_bottom_message  varchar(512),                 -- 안드로이드 하단메시지 JSON데이터 
	push_ios_message     varchar(512),                 -- 아이폰 메시지 JSON데이터
	talk_disp_yn         char(1),                      -- 알림-혜택톡방 사용안함. 일반 푸시발송시 사용 
	detail_url           varchar(512),                 -- 일반푸시 사용시- 클릭URL
	banner_url           varchar(512),                 -- 푸시배너이미지. 없을 경우 생략 가능 
	msg_grp_no           bigint,                       -- 메시지 식별 그룹 번호. 없을 경우 생략 가능 
	send_allw_bgn_dt     varchar(512),                 -- 예약 발송을 할 경우 셋팅. 없을 경우 생략 가능
	
	send_yn              char(1),
	time_insert          timestamp     default current_timestamp,
	time_send            timestamp
);

-------------------------
select
	id
	, camp_code
	
	, mem_no
	, talk_msg_tmplt_no
	, app_kd_cd
	, push_top_message
	, push_bottom_message
	, push_ios_message
	, talk_disp_yn 
	, detail_url
	, banner_url 
	, msg_grp_no 
	, send_allw_bgn_dt
	
	, send_yn
	, time_insert
	, time_send
from
	tbl_camp2
where 1=1
	and id = 1
;
-------------------------
insert into tbl_camp2
(
	camp_code,
	
	mem_no,
	talk_msg_tmplt_no,
	app_kd_cd,
	push_top_message,
	push_bottom_message,
	push_ios_message,
	talk_disp_yn,
	detail_url,
	banner_url,
	msg_grp_no,
	send_allw_bgn_dt,
	
	send_yn
)
values
(
	'camp000',
	
	123456,
	'900',
	'appKdCd',
	'top message',
	'bottom message',
	'ios message',
	'N',
	'http://m.11st.co.kr/MW/TData/dataFree.tmall',
	'이미지URL',
	1235L,
	'send_allw_bgn_dt',
	
	'N'
);
select * from tbl_camp2;
-------------------------
update
	tbl_camp2
set
	send_yn = 'Y',
	time_send = current_timestamp()
where
	id = 1
;
select * from tbl_camp2;
-------------
update
	tbl_camp2
set
	send_yn = 'Y',
	time_send = parsedatetime('2001-07-12 03:05:06.123','yyyy-MM-dd HH:mm:ss.SSS')
where
	id = 1
;
select * from tbl_camp2;
-------------
update
	tbl_camp2
set
	send_yn = 'Y',
	time_send = {ts '2012-09-17 18:47:52.777'}
where
	id = 1
;
select * from tbl_camp2;
---------------
update
	tbl_camp2
set
	send_yn = 'N'
	, time_send = null
where 1=1
;
select * from tbl_camp2;
---------------
call parsedatetime('2001-07-12 03:05:06','yyyy-MM-dd HH:mm:ss');
--

{"campCode":"code100","appKdCd":"appKdCd","pushTopMessage":"top message","pushBottomMessage":"bottom message","pushIosMessage":"ios message","talkDispYn":"N","detailUrl":"http://m.11st.co.kr/MW/TData/dataFree.tmall","bannerUrl":"이미지URL","msgGrpNo":"1235L","sendAllwBgnDt":"send_allw_bgn_dt"}
