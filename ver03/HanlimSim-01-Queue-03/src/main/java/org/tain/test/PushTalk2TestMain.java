package org.tain.test;

import java.util.Arrays;
import java.util.Date;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import skt.tmall.talk.dto.PushTalkParameter;
import skt.tmall.talk.dto.type.AppKdCdType;

public class PushTalk2TestMain {

	public static void _main(String[] args) throws Exception {
		System.out.println(">>> PushTalkTestMain");
		
		String talkMsgTmpltNo = "900";                 // 개인화 메시지 타입코드 900 
		Long memNo = 10000276L;                        //회원번호 
		AppKdCdType appKdCd = AppKdCdType.ELEVENSTAPP; // 발송대상 앱코드
		
		JsonObject andTopJsonObj = new JsonObject();
		andTopJsonObj.addProperty("AND_TOP_MSG", "안드로이드 상단 메시지");
		
		JsonObject andBtmJsonObj = new JsonObject();
		andBtmJsonObj.addProperty("AND_BTM_MSG", "안드로이드 하단 메시지");
		
		JsonObject iosJsonObj = new JsonObject(); 
		iosJsonObj.addProperty("IOS_MSG", "아이폰 메시지"); 
		
		PushTalkParameter data = new PushTalkParameter(talkMsgTmpltNo, memNo);  //   템플릿 번호와 회원번호 셋팅 
		
		data.setAppKdCd(appKdCd);                                               //   대상앱 지정 
		data.setPushTopMessage(andTopJsonObj.toString());                       //   안드로이드 상단메시지 JSON데이터 
		data.setPushBottomMessage(andBtmJsonObj.toString());                    //   안드로이드 하단메시지 JSON데이터 
		data.setPushIosMessage(iosJsonObj.toString());                          //   아이폰 메시지 JSON데이터 
		data.setTalkDispYn("N");                                                //   알림-혜택톡방 사용안함. 일반 푸시발송시 사용 
		data.setDetailUrl("http://m.11st.co.kr/MW/TData/dataFree.tmall");       //   일반푸시 사용시- 클릭URL 
		data.setBannerUrl("이미지URL");                                           //   푸시배너이미지. 없을경우 생략가능 
		data.setMsgGrpNo(1235L);                                                //   메시지 식별 그룹번호. 없을경우 생략가능 
		data.setSendAllwBgnDt(new Date());                                      //   예약발송을 할경우 셋팅. 없을경우 생략가능 
		 
		//SMS 사용시 
		data.setSmsMsg("json data");    //  https://wiki.11stcorp.com/pages/viewpage.action?pageId=214088691
		
		// Request Body 확인시 
		//System.out.println(">>> " + new GsonBuilder().serializeNulls().create().toJson(Arrays.asList(data)));
		System.out.println(">>> " + new GsonBuilder().setPrettyPrinting().create().toJson(Arrays.asList(data)));
		//PushTalkSendService.INSTANCE.remoteSyncPush(Lists.newArrayList(data));
		
		
	}
}
