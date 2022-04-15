drop table tbl_camp3;

-------------------------
create table if not exists tbl_camp3
(
	id                   bigint       not null auto_increment,

	-- camp_code            varchar(128) not null,
	-- mem_no               bigint,                       -- 회원번호
	-- talk_msg_tmplt_no    varchar(10)   default '900',  -- 개인화 메시지 타입코드 900
	-- app_kd_cd            varchar(10),                  -- 대상앱 지정: AppKdCdType.ELEVENSTAPP
	-- push_top_message     varchar(512),                 -- 안드로이드 상단메시지 JSON데이터
	-- push_bottom_message  varchar(512),                 -- 안드로이드 하단메시지 JSON데이터
	-- push_ios_message     varchar(512),                 -- 아이폰 메시지 JSON데이터
	-- talk_disp_yn         char(1),                      -- 알림-혜택톡방 사용안함. 일반 푸시발송시 사용
	-- detail_url           varchar(512),                 -- 일반푸시 사용시- 클릭URL
	-- banner_url           varchar(512),                 -- 푸시배너이미지. 없을 경우 생략 가능
	-- msg_grp_no           bigint,                       -- 메시지 식별 그룹 번호. 없을 경우 생략 가능
	-- send_allw_bgn_dt     varchar(512),                 -- 예약 발송을 할 경우 셋팅. 없을 경우 생략 가능

	-- SAS
	campaign_code               varchar(  20),
	treatment_code              varchar(  20),
	app_kd_cd                   varchar(   2),
	msg_typ_cd                  varchar(   2),
	mem_no                      varchar(  10),
	message_data                varchar(2000),
	alimi_data                  varchar(2000),
	talk_title                  varchar( 100),
	talk_disp_yn                varchar(  10),
	talk_msg_tmplt_no           varchar(  50),
	android_top_message_data    varchar(1000),
	android_btm_message_data    varchar(1000),
	ios_message_data            varchar(2000),
	banner_url                  varchar(1000),
	detail_url                  varchar(1000),
	etc_data                    varchar( 100),
	block_top_cap_main_value    varchar( 500),
	block_top_cap_sub_value     varchar( 100),
	block_bold_text_main_value  varchar( 500),
	block_bold_text_sub_value   varchar( 500),
	block_img500_value          varchar(2000),
	block_btn_view_value        varchar( 100),
	block_link_url_mobile_value varchar( 500),
	block_link_url_web_value    varchar( 500),
	request_dt                  varchar(  20),
	return_code                 varchar( 500),

	-- PushTalk status and times
	send_yn              char(1),
	time_insert          timestamp     default current_timestamp,
	time_send            timestamp
);

-------------------------
select
	id

	-- , app_kd_cd
	-- , push_top_message
	-- , push_bottom_message
	-- , push_ios_message
	-- , talk_disp_yn
	-- , detail_url
	-- , banner_url
	-- , msg_grp_no
	-- , send_allw_bgn_dt

	, campaign_code
	, treatment_code
	, app_kd_cd
	, msg_typ_cd
	, mem_no
	, message_data
	, alimi_data
	, talk_title
	, talk_disp_yn
	, talk_msg_tmplt_no
	, android_top_message_data
	, android_btm_message_data
	, ios_message_data
	, banner_url
	, detail_url
	, etc_data
	, block_top_cap_main_value
	, block_top_cap_sub_value
	, block_bold_text_main_value
	, block_bold_text_sub_value
	, block_img500_value
	, block_btn_view_value
	, block_link_url_mobile_value
	, block_link_url_web_value
	, request_dt
	, return_code

	, send_yn
	, time_insert
	, time_send
from
	tbl_camp3
where 1=1
	and id = 1
;
-------------------------
insert into tbl_camp3
(
	-- app_kd_cd,
	-- push_top_message,
	-- push_bottom_message,
	-- push_ios_message,
	-- talk_disp_yn,
	-- detail_url,
	-- banner_url,
	-- msg_grp_no,
	-- send_allw_bgn_dt,

	campaign_code,
	treatment_code,
	app_kd_cd,
	msg_typ_cd,
	mem_no,
	message_data,
	alimi_data,
	talk_title,
	talk_disp_yn,
	talk_msg_tmplt_no,
	android_top_message_data,
	android_btm_message_data,
	ios_message_data,
	banner_url,
	detail_url,
	etc_data,
	block_top_cap_main_value,
	block_top_cap_sub_value,
	block_bold_text_main_value,
	block_bold_text_sub_value,
	block_img500_value,
	block_btn_view_value,
	block_link_url_mobile_value,
	block_link_url_web_value,
	request_dt,
	return_code,

	send_yn
)
values
(
	-- 'appKdCd',
	-- 'top message',
	-- 'bottom message',
	-- 'ios message',
	-- 'N',
	-- 'http://m.11st.co.kr/MW/TData/dataFree.tmall',
	-- '이미지URL',
	-- '1235L',
	-- 'send_allw_bgn_dt',

	'CAMP00000',
	'TR00000',
	'01',
	null,
	'18468196',
	null,
	null,
	'주문 알림톡입니다.(69)',
	'Y',
	'001',
	'안드로이드 메시지~~Top개인화테스트~69번째(포맷변경)',
	'안드로이드 메시지~~Btm개인화테스트~69번째(포맷변경)',
	'아이폰 메시지~개인화테스트입니다~69번째(포맷유지)',
	'http://m.11st.co.kr',
	'http://m.11st.co.kr/MW/TData/dataFree.tmall',
	'{ "campaigncode":"CAMP00000", "treatmentcode":"TR00000" }',
	'패션워크',
	'광고',
	'반값 타임딜 하루 69번 오픈',
	'놓치지마세요!',
	'{ "imgUrl" : ["http://i.011st.com/ui_img/11talk/img_500_500_sample2.png" ,"http://i.011st.com/ui_img/11talk/img_500_500_sample1.png

	"  ]}',
	'상세보기(69)',
	'http://m.11st.co.kr/MW/MyPage/V1/benefitCouponDownList.tmall',
	'http://11st.co.kr',
	null,
	null,

	'N'
);
select * from tbl_camp3;
-------------------------
update
	tbl_camp3
set
	send_yn = 'Y',
	time_send = current_timestamp()
where
	id = 1
;
select * from tbl_camp3;
-------------
update
	tbl_camp3
set
	send_yn = 'Y',
	time_send = parsedatetime('2001-07-12 03:05:06.123','yyyy-MM-dd HH:mm:ss.SSS')
where
	id = 1
;
select * from tbl_camp3;
-------------
update
	tbl_camp3
set
	send_yn = 'Y',
	time_send = {ts '2012-09-17 18:47:52.777'}
where
	id = 1
;
select * from tbl_camp3;
---------------
update
	tbl_camp3
set
	send_yn = 'N'
	, time_send = null
where 1=1
;
select * from tbl_camp3;
---------------
call parsedatetime('2001-07-12 03:05:06','yyyy-MM-dd HH:mm:ss');
--

-- {"campCode":"code100","appKdCd":"appKdCd","pushTopMessage":"top message","pushBottomMessage":"bottom message","pushIosMessage":"ios message","talkDispYn":"N","detailUrl":"http://m.11st.co.kr/MW/TData/dataFree.tmall","bannerUrl":"이미지URL","msgGrpNo":"1235L","sendAllwBgnDt":"send_allw_bgn_dt","campContent":"content101"}
