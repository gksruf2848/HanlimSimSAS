package org.tain.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import skt.tmall.talk.dto.PushTalkParameter;
import skt.tmall.talk.dto.type.AppKdCdType;
import skt.tmall.talk.dto.type.BlockBoldText;
import skt.tmall.talk.dto.type.BlockBtnView;
import skt.tmall.talk.dto.type.BlockImg500;
import skt.tmall.talk.dto.type.BlockLinkUrl;
import skt.tmall.talk.dto.type.BlockTopCap;
import skt.tmall.talk.service.PushTalkSendService;

public class PushTalk3TestMain {

	//private AppKdCdType appKdCd = AppKdCdType.ELEVENSTAPP;
	//  private AppKdCdType appKdCd = ELEVENSTAPP; // 발송대상 앱코드

	public String getMemno() { return this.memNo; }
	public void setMemno(String memno) { this.memNo = memno; }

	public String getTalkDispYn() { return this.talkDispYn; }
	public void setTalkDispYn(String talkDispYn) { this.talkDispYn = talkDispYn; }

	public String getTalkMsgTmpltNo() { return this.talkMsgTmpltNo; }
	public void setTalkMsgTmpltNo(String talkMsgTmpltNo) { this.talkMsgTmpltNo = talkMsgTmpltNo; }

	public String getAndroid_TopmessageData() { return this.android_TopmessageData; }
	public void setAndroid_TopmessageData(String android_messageData) { this.android_TopmessageData = android_messageData; }

	public String getAndroid_BtmmessageData() { return this.android_BtmmessageData; }
	public void setAndroid_BtmmessageData(String android_messageData) { this.android_BtmmessageData = android_messageData; }

	public String getIos_messageData() { return this.ios_messageData; }
	public void setIos_messageData(String ios_messageData) { this.ios_messageData = ios_messageData; }

	public String getDetailUrl() { return this.detailUrl; }
	public void setDetailUrl(String detailUrl) { this.detailUrl = detailUrl; }

	public String getBannerUrl() { return this.bannerUrl; }
	public void setBannerUrl(String bannerUrl) { this.bannerUrl = bannerUrl; }

	public String getTalkTitle() { return this.talkTitle; }
	public void setTalkTitle(String talkTitle) { this.talkTitle = talkTitle; }

	public String getBlockTopCapMain_Value() { return this.BlockTopCapMain_Value; }
	public void setBlockTopCapMain_Value(String BlockTopCapMain_Value) { this.BlockTopCapMain_Value = BlockTopCapMain_Value; }

	public String getBlockTopCapSub_Value() { return this.BlockTopCapSub_Value; }
	public void setBlockTopCapSub_Value(String BlockTopCapSub_Value) { this.BlockTopCapSub_Value = BlockTopCapSub_Value; }

	public String getBlockBoldTextMain_Value() { return this.BlockBoldTextMain_Value; }
	public void setBlockBoldTextMain_Value(String BlockBoldTextMain_Value) { this.BlockBoldTextMain_Value = BlockBoldTextMain_Value; }

	public String getBlockBoldTextSub_Value() { return this.BlockBoldTextSub_Value; }
	public void setBlockBoldTextSub_Value(String BlockBoldTextSub_Value) { this.BlockBoldTextSub_Value = BlockBoldTextSub_Value; }

	public String getBlockImg500_Value() { return this.BlockImg500_Value; }
	public void setBlockImg500_Value(String BlockImg500_Value) { this.BlockImg500_Value = BlockImg500_Value; }

	public String getBlockBtnView_Value() { return this.BlockBtnView_Value; }
	public void setBlockBtnView_Value(String BlockBtnView_Value) { this.BlockBtnView_Value = BlockBtnView_Value; }

	public String getBlockLinkUrlMobile_Value() { return this.BlockLinkUrlMobile_Value; }
	public void setBlockLinkUrlMobile_Value(String BlockLinkUrlMobile_Value) { this.BlockLinkUrlMobile_Value = BlockLinkUrlMobile_Value; }

	public String getBlockLinkUrlWeb_Value() { return this.BlockLinkUrlWeb_Value; }
	public void setBlockLinkUrlWeb_Value(String BlockLinkUrlWeb_Value) { this.BlockLinkUrlWeb_Value = BlockLinkUrlWeb_Value; }

	public String getEtcData() { return this.etcData; }
	public void setEtcData(String etcData) { this.etcData = etcData; }
	
	private String android_TopmessageData = "안드로이드 메시지~~Top개인화테스트~69번째(포맷변경)";
	private String android_BtmmessageData = "안드로이드 메시지~~Btm개인화테스트~69번째(포맷변경)";
	private String ios_messageData = "아이폰 메시지~개인화테스트입니다~69번째(포맷유지)";
	private String detailUrl = "http://m.11st.co.kr/MW/TData/dataFree.tmall";

	private String bannerUrl = "http://m.11st.co.kr";

	private String memNo = "20750578";
	private String talkDispYn = "Y";
	private String talkMsgTmpltNo = "001";
	private String talkTitle = "주문 알림톡입니다.(69)";
	
	private String BlockTopCapMain_Value = "패션워크";
	private String BlockTopCapSub_Value = "광고";
	
	private String BlockBoldTextMain_Value = "반값 타임딜 하루 69번 오픈";
	private String BlockBoldTextSub_Value = "놓치지마세요!";

	private String BlockImg500_Value = "{ \"imgUrl\" : [\"http://i.011st.com/ui_img/11talk/img_500_500_sample2.png\" ,\"http://i.011st.com/ui_img/11talk/img_500_500_sample1.png\n\n\"  ]}";

	private String BlockBtnView_Value = "상세보기(69)";

	private String BlockLinkUrlMobile_Value = "http://m.11st.co.kr/MW/MyPage/V1/benefitCouponDownList.tmall";
	private String BlockLinkUrlWeb_Value = "http://11st.co.kr";
	private String etcData = "{ \"campaigncode\":\"CAMP00000\", \"treatmentcode\":\"TR00000\" }";

	public PushTalk3TestMain() {}
	
	@SuppressWarnings("unchecked")
	public int exec() throws Exception {
		/*
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
	block_img500_value          varchar(2000),
	block_top_cap_main_value    varchar( 500),
	block_top_cap_sub_value     varchar( 100),
	
	block_bold_text_main_value  varchar( 500),
	block_bold_text_sub_value   varchar( 500),
	
	block_btn_view_value        varchar( 100),
	block_link_url_mobile_value varchar( 500),
	block_link_url_web_value    varchar( 500),
	request_dt                  varchar(  20),
	return_code                 varchar( 500),
		 */
		Map<String,Object> map = new HashMap<>();
		map.put("iosMessageData", "아이폰 메시지~개인화테스트입니다~69번째(포맷유지)");
		map.put("androidTopMessageData","안드로이드 메시지~~Top개인화테스트~69번째(포맷변경)");
		map.put("androidBtmMessageData","안드로이드 메시지~~Btm개인화테스트~69번째(포맷변경)");
		map.put("talkMsgTmpltNo","001");
		map.put("memNo","18468196");
		map.put("detailUrl","http://m.11st.co.kr/MW/TData/dataFree.tmall");
		map.put("bannerUrl","http://m.11st.co.kr");
		map.put("etcData","{ \"campaigncode\":\"CAMP00000\", \"treatmentcode\":\"TR00000\" }");
		map.put("talkTitle","주문 알림톡입니다.(69)");
		map.put("blockImg500Value","{ \"imgUrl\" : [\"http://i.011st.com/ui_img/11talk/img_500_500_sample2.png\" ,\"http://i.011st.com/ui_img/11talk/img_500_500_sample1.png\n\n\"  ]}");
		map.put("blockTopCapMainValue","패션워크");
		map.put("blockTopCapSubValue","광고");
		map.put("blockBoldTextMainValue","반값 타임딜 하루 69번 오픈");
		map.put("blockBoldTextSubValue","놓치지마세요!");
		map.put("blockBtnViewValue", "상세보기(69)");
		map.put("blockLinkUrlMobileValue", "http://m.11st.co.kr/MW/MyPage/V1/benefitCouponDownList.tmall");
		map.put("blockLinkUrlWebValue", "http://11st.co.kr");
		
		System.setProperty("server.type", "real");
		//푸시메시지
		
		//알림톡메시지
		
		//etcData (캠페인 정보 추가 )
		//HashMap<String,String> mapEtcData = gson.fromJson(etcData, new TypeToken<Map<String, String>>() {}.getType());
		
		//메시지 셋팅
		String talkMsgTmpltNo = String.valueOf(map.get("talkMsgTmpltNo"));
		String memNo = String.valueOf(map.get("memNo")); //"18468196"; //42751905 18468196 20750578
		PushTalkParameter data = new PushTalkParameter(talkMsgTmpltNo , Long.valueOf(memNo));
		
		data.setAppKdCd(AppKdCdType.ELEVENSTAPP);  // 발송대상 앱코드
		
		JsonObject obj = new JsonObject();
		obj.addProperty("IOS_MSG", String.valueOf(map.get("iosMessageData")));
		obj.addProperty("AND_TOP_MSG", String.valueOf(map.get("androidTopMessageData")));
		obj.addProperty("AND_BTM_MSG", String.valueOf(map.get("androidBtmMessageData")));
		System.out.println(">>>>> obj: " + obj);
		data.setPushTopMessage(obj.toString());
		data.setPushBottomMessage(obj.toString());
		data.setPushIosMessage(obj.toString());
		
		data.setTalkDispYn("Y");                                      // 고정 처리 (Y) 알림-혜택톡방 동시 사용함
		data.setDetailUrl(String.valueOf(map.get("detailUrl")));      //   일반푸시 사용시- 클릭URL
		data.setBannerUrl(String.valueOf(map.get("bannerUrl")));      //   푸시배너이미지. 없을경우 생략가능
		//data.setMsgGrpNo(1235L);         //   메시지 식별 그룹번호. 없을경우 생략가능
		Map<String,String> mapEtcData = new Gson().fromJson(String.valueOf(map.get("etcData")), new TypeToken<Map<String, String>>(){}.getType());
		data.setEtcData(mapEtcData);
		data.setTalkSummaryMessage(String.valueOf(map.get("talkTitle"))); //알림톡방 리스트에 노출 할 메시지
		
		Map<String, Object> map2 = new Gson().fromJson(String.valueOf(map.get("blockImg500Value")), new TypeToken<Map<String, Object>>(){}.getType());  // important
		List<String> lstUrls = (List<String>) map2.get("imgUrl");  // important
		List<BlockImg500.Value> lists = new ArrayList<>();  // important
		for (String strUrl : lstUrls) {
			lists.add(new BlockImg500.Value(strUrl));	// important
		}
		
		List<Block> composites = Lists.newArrayList(
				new BlockTopCap(new BlockTopCap.Value(String.valueOf(map.get("blockTopCapMainValue")), String.valueOf(map.get("blockTopCapSubValue"))))
				, new BlockBoldText(new BlockBoldText.Value(String.valueOf(map.get("blockBoldTextMainValue")), String.valueOf(map.get("blockBoldTextSubValue"))))
				, new BlockImg500(Lists.newArrayList( lists ))
				, new BlockBtnView(new BlockBtnView.Value(String.valueOf(map.get("blockBtnViewValue"))
						, new BlockLinkUrl(String.valueOf(map.get("blockLinkUrlMobileValue")), String.valueOf(map.get("blockLinkUrlWebValue")))
						// new BlockLinkUrl("http://m.11st.co.kr/MW/Product/productBasicInfo.tmall?prdNo=2147806088&detailViewType=webviewReady", "http://11st.co.kr")
						))
				);
		data.setTalkMessage(composites);
		
		System.out.println(">>>>> composites: " + composites);
		
		//예약발송
		//data.setSendAllwBgnDt(new Date()); //예약발송시 설정.  예약발송시간을 java.util.Date 타입으로 작성.
		
		//SMS 셋팅 http://wiki.11stcorp.com/pages/viewpage.action?pageId=214088691
		//data.setSmsMsg("SMS 스펙에 해당하는 데이터 작성");
		//테스트 데이터 셋팅  , 운영모드 일 경우 Remarking
		
		// Request Body 확인시
		//System.out.println(">>>>> Request Body: " + new GsonBuilder().serializeNulls().create().toJson(Arrays.asList(data)));
		System.out.println(">>>>> Request Body: " + new GsonBuilder().setPrettyPrinting().create().toJson(Arrays.asList(data)));
		
		//알림톡 전송
		int ret = -1;
		if (!Boolean.TRUE) {
			ret = PushTalkSendService.INSTANCE.remoteSyncPush(Lists.newArrayList(data));
		}
		return ret;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 *[
	 *  {
	 *    "talkVersion": "1.3.8",
	 *    "talkMsgTmpltNo": "001",
	 *    "appKdCd": "01",
	 *    "memNo": 18468196,
	 *    "pushTopMessage": "{\"IOS_MSG\":\"아이폰 메시지~개인화테스트입니다~45번째(포맷유지)\",\"AND_TOP_MSG\":\"안드로이드 메시지~~Top개인화테스트~69번째(포맷변경)\",\"AND_BTM_MSG\":\"안드로이드 메시지~~Btm개인화테스트~69번째(포맷변경)\"}",
	 *    "pushBottomMessage": "{\"IOS_MSG\":\"아이폰 메시지~개인화테스트입니다~45번째(포맷유지)\",\"AND_TOP_MSG\":\"안드로이드 메시지~~Top개인화테스트~69번째(포맷변경)\",\"AND_BTM_MSG\":\"안드로이드 메시지~~Btm개인화테스트~69번째(포맷변경)\"}",
	 *    "pushIosMessage": "{\"IOS_MSG\":\"아이폰 메시지~개인화테스트입니다~45번째(포맷유지)\",\"AND_TOP_MSG\":\"안드로이드 메시지~~Top개인화테스트~69번째(포맷변경)\",\"AND_BTM_MSG\":\"안드로이드 메시지~~Btm개인화테스트~69번째(포맷변경)\"}",
	 *    "talkSummaryMessage": "주문 알림톡입니다.(69)",
	 *    "talkMessage": [
	 *      {
	 *        "id": "Block_Top_Cap",
	 *        "payload": {
	 *          "text1": "패션워크",
	 *          "sub_text1": "광고"
	 *        }
	 *      },
	 *      {
	 *        "id": "Block_Bold_Text",
	 *        "payload": {
	 *          "text1": "반값 타임딜 하루 69번 오픈",
	 *          "sub_text1": "놓치지마세요!"
	 *        }
	 *      },
	 *      {
	 *        "id": "Block_Img_500",
	 *        "payload": [
	 *          {
	 *            "imgUrl1": "http://i.011st.com/ui_img/11talk/img_500_500_sample2.png"
	 *          },
	 *          {
	 *            "imgUrl1": "http://i.011st.com/ui_img/11talk/img_500_500_sample1.png\n\n"
	 *          }
	 *        ]
	 *      },
	 *      {
	 *        "id": "Block_Btn_View",
	 *        "payload": {
	 *          "text1": "상세보기(69)",
	 *          "linkUrl1": {
	 *            "mobile": "http://m.11st.co.kr/MW/MyPage/V1/benefitCouponDownList.tmall",
	 *            "web": "http://11st.co.kr"
	 *          }
	 *        }
	 *      }
	 *    ],
	 *    "talkDispYn": "Y",
	 *    "detailUrl": "http://m.11st.co.kr/MW/TData/dataFree.tmall",
	 *    "bannerUrl": "http://m.11st.co.kr",
	 *    "etcData": {
	 *      "treatmentcode": "TR00000",
	 *      "campaigncode": "CAMP00000"
	 *    }
	 *  }
	 *]
	 */
	public static void _main(String[] args) throws Exception {
		System.out.println(">>> PushTalk3TestMain");
		
		PushTalk3TestMain instance = new PushTalk3TestMain();
		
		//camp1
		//json1.txt (100)
		
		//테스트 데이터 셋팅  , 운영모드 일 경우 Remarking
		// instance.setAndroid_messageData("안드로이드 메시지~~개인화테스트입니다~45번째(포맷변경)");
		
		//instance.setIos_messageData("아이폰 메시지~개인화테스트입니다~45번째(포맷유지)");
		//instance.setTalkMsgTmpltNo("001");
		//instance.setMemno("18468196"); //42751905 18468196 20750578
		
		int ret = instance.exec();
		System.out.println(">>>>> ret = " + ret);
	}
}
