package org.tain.schedule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.tain.mybatis.mappers.TblCamp3Mapper;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;
import skt.tmall.talk.dto.PushTalkParameter;
import skt.tmall.talk.dto.type.AppKdCdType;
import skt.tmall.talk.dto.type.Block;
import skt.tmall.talk.dto.type.BlockBoldText;
import skt.tmall.talk.dto.type.BlockBtnView;
import skt.tmall.talk.dto.type.BlockImg500;
import skt.tmall.talk.dto.type.BlockLinkUrl;
import skt.tmall.talk.dto.type.BlockTopCap;
import skt.tmall.talk.service.PushTalkSendService;

@Component
@EnableScheduling
@Slf4j
public class TblCamp3Scheduler {

	@Value("${my.custom.cmd}")
	private String myCustomCmd;
	
	/*
	 * // 순서별 정리
	 * 1. 초(0-59)
	 * 2. 분(0-59)
	 * 3. 시간(0-23)
	 * 4. 일(1-31)
	 * 5. 월(1-12)
	 * 6. 요일(0-7)
	 * 
	 * "0 0 * * * *" = the top of every hour of every day.
	 * "* /10 * * * * *" = 매 10초마다 실행한다.
	 * "0 0 8-10 * * *" = 매일 8, 9, 10시에 실행한다
	 * "0 0 6,19 * * *" = 매일 오전 6시, 오후 7시에 실행한다.
	 * "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30, 10:00 and 10:30 every day.
	 * "0 0 9-17 * * MON-FRI" = 오전 9시부터 오후 5시까지 주중(월~금)에 실행한다.
	 * "0 0 0 25 12 ?" = every Christmas Day at midnight
	 * 
	 * application.properties
	 * my.custom.cron = 10 * * * * *
	 */
	//@Scheduled(cron = "10 * * * * *")
	//@Scheduled(cron = "${my.custom.cron}")
	public void printDate() {
		System.out.printf(">>> Scheduler: %s: %s\n", this.myCustomCmd, new Date());
	}
	
	@Autowired
	private TblCamp3Mapper tblCamp3Mapper;
	
	@Scheduled(cron = "${my.custom.cron}")
	public void sendToPushTalkServer() throws Exception {
		System.out.printf(">>> Scheduler: %s: %s\n", this.myCustomCmd, new Date());
		//if (Boolean.TRUE) return;
		
		this.tblCamp3Mapper.updateReady();
		System.out.println(">>> Scheduler: updateReady");
		
		try {
			List<Map<String,Object>> listMap = null;
			if (Boolean.TRUE) {
				//Map<String, Object> mapIn = new ObjectMapper().readValue(reqBody, new TypeReference<Map<String, Object>>() {});
				listMap = this.tblCamp3Mapper.selectReady();
				//log.info(">>>>> listMap: {}", listMap);
				
				if (!Boolean.TRUE) {
					// (X) KANG-20220413: no use
					for (Map<String,Object> map : listMap) {
						log.info(">>> map: {}", map);
						
						if (Boolean.TRUE) {
							Map<String, Object> root = new HashMap<>();
							root.put("url", "http://localhost:8083/v0.1/pushtalk/send");
							root.put("method", "post");
							
							String reqBody = (String) map.get("campContent");
							System.out.println(">>> reqBody1: " + reqBody);
							//reqBody = URLEncoder.encode(reqBody, "utf-8");
							//System.out.println(">>> reqBody2: " + reqBody);
							root.put("request", reqBody);
							
							String response = HttpConnection.getResponse(root);
							System.out.println("--> response: " + response);
						}
						
						if (Boolean.TRUE) {
							Map<String, Object> mapIn = new HashMap<>();
							mapIn.put("id", map.get("id"));
							this.tblCamp3Mapper.updateById(mapIn);
						}
					
					}
				}
				
				if (!Boolean.TRUE) {
					// (X) KANG-20220413: check variables
					for (Map<String,Object> map : listMap) {
						System.out.println(">>> id               : " + String.valueOf(map.get("id")));
						System.out.println(">>> campCode         : " + String.valueOf(map.get("campCode")));
						System.out.println(">>> memNo            : " + String.valueOf(map.get("memNo")));
						System.out.println(">>> talkMsgTmpltNo   : " + String.valueOf(map.get("talkMsgTmpltNo")));
						System.out.println(">>> appKdCd          : " + String.valueOf(map.get("appKdCd")));
						System.out.println(">>> pushTopMessage   : " + String.valueOf(map.get("pushTopMessage")));
						System.out.println(">>> pushBottomMessage: " + String.valueOf(map.get("pushBottomMessage")));
						System.out.println(">>> pushIosMessage   : " + String.valueOf(map.get("pushIosMessage")));
						System.out.println(">>> talkDispYn       : " + String.valueOf(map.get("talkDispYn")));
						System.out.println(">>> detailUrl        : " + String.valueOf(map.get("detailUrl")));
						System.out.println(">>> bannerUrl        : " + String.valueOf(map.get("bannerUrl")));
						System.out.println(">>> msgGrpNo         : " + String.valueOf(map.get("msgGrpNo")));
						System.out.println(">>> sendAllwBgnDt    : " + String.valueOf(map.get("sendAllwBgnDt")));
						System.out.println(">>> sendYn           : " + String.valueOf(map.get("sendYn")));
						System.out.println(">>> timeInsert       : " + String.valueOf(map.get("timeInsert")));
						System.out.println(">>> timeSend         : " + String.valueOf(map.get("timeSend")));
						System.out.println("----------------------------------------------------");
					}
				}
				
				if (!Boolean.TRUE) {
					/* (X)
					 *  {
					 *    "talkVersion": "1.3.8",
					 *    "talkMsgTmpltNo": "900",
					 *    "appKdCd": "01",
					 *    "msgGrpNo": 1235,
					 *    "memNo": 10000276,
					 *    "pushTopMessage": "{\"AND_TOP_MSG\":\"안드로이드 상단 메시지\"}",
					 *    "pushBottomMessage": "{\"AND_BTM_MSG\":\"안드로이드 하단 메시지\"}",
					 *    "pushIosMessage": "{\"IOS_MSG\":\"아이폰 메시지\"}",
					 *    "talkDispYn": "N",
					 *    "detailUrl": "http://m.11st.co.kr/MW/TData/dataFree.tmall",
					 *    "bannerUrl": "이미지URL",
					 *    "sendAllwBgnDt": "Apr 13, 2022 8:01:25 PM",
					 *    "smsMsg": "json data"
					 *  }
					 */
					// (X) KANG-20220413: PushTalkSendService
					List<PushTalkParameter> listPtp = new ArrayList<>();
					for (Map<String,Object> map : listMap) {
						String talkMsgTmpltNo = String.valueOf(map.get("talkMsgTmpltNo"));        // 개인화 메시지 타입코드 900 
						Long memNo = (Long) map.get("memNo");                                     // 회원번호 
						PushTalkParameter data = new PushTalkParameter(talkMsgTmpltNo, memNo);    // 템플릿 번호와 회원번호 셋팅 
						
						data.setAppKdCd(AppKdCdType.ELEVENSTAPP);                                 //   대상앱 지정 
						JsonObject andTopJsonObj = new JsonObject();
						andTopJsonObj.addProperty("AND_TOP_MSG", String.valueOf(map.get("pushTopMessage")));
						data.setPushTopMessage(andTopJsonObj.toString());                       //   안드로이드 상단메시지 JSON데이터 
						
						JsonObject andBtmJsonObj = new JsonObject();
						andBtmJsonObj.addProperty("AND_BTM_MSG", String.valueOf(map.get("pushBottomMessage")));
						data.setPushBottomMessage(andBtmJsonObj.toString());                    //   안드로이드 하단메시지 JSON데이터 
						
						JsonObject iosJsonObj = new JsonObject(); 
						iosJsonObj.addProperty("IOS_MSG", String.valueOf(map.get("pushIosMessage"))); 
						data.setPushIosMessage(iosJsonObj.toString());                          //   아이폰 메시지 JSON데이터
						
						data.setTalkDispYn(String.valueOf(map.get("talkDispYn")));                                                //   알림-혜택톡방 사용안함. 일반 푸시발송시 사용 
						data.setDetailUrl(String.valueOf(map.get("detailUrl")));       //   일반푸시 사용시- 클릭URL 
						data.setBannerUrl(String.valueOf(map.get("bannerUrl")));                                           //   푸시배너이미지. 없을경우 생략가능 
						data.setMsgGrpNo(Long.valueOf(String.valueOf(map.get("msgGrpNo"))));                                                //   메시지 식별 그룹번호. 없을경우 생략가능 
						data.setSendAllwBgnDt(new Date());                                      //   예약발송을 할경우 셋팅. 없을경우 생략가능 
						//SMS 사용시 
						//data.setSmsMsg("json data");    //  https://wiki.11stcorp.com/pages/viewpage.action?pageId=214088691
						
						// Request Body 확인시
						//System.out.println(">>> " + new GsonBuilder().serializeNulls().create().toJson(Arrays.asList(data)));
						//System.out.println(">>> " + new GsonBuilder().setPrettyPrinting().create().toJson(Arrays.asList(data)));
						
						listPtp.add(data);
						//if (!Boolean.TRUE) PushTalkSendService.INSTANCE.remoteSyncPush(Lists.newArrayList(data));
						
						if (Boolean.TRUE) {
							Map<String, Object> mapIn = new HashMap<>();
							mapIn.put("id", map.get("id"));
							this.tblCamp3Mapper.updateById(mapIn);
						}
					}
					System.out.println(">>> " + new GsonBuilder().setPrettyPrinting().create().toJson(listPtp));
					if (!Boolean.TRUE) PushTalkSendService.INSTANCE.remoteSyncPush(listPtp);
				}
				
				if (Boolean.TRUE) {
					/* (O)
					 * 
					 */
					List<PushTalkParameter> listPtp = new ArrayList<>();
					for (Map<String,Object> map : listMap) {
						//메시지 셋팅
						String talkMsgTmpltNo = String.valueOf(map.get("talkMsgTmpltNo"));
						String memNo = String.valueOf(map.get("memNo")); //"18468196"; //42751905 18468196 20750578
						PushTalkParameter data = new PushTalkParameter(talkMsgTmpltNo , Long.valueOf(memNo));
						
						data.setAppKdCd(AppKdCdType.ELEVENSTAPP);  // 발송대상 앱코드
						
						JsonObject obj = new JsonObject();
						obj.addProperty("IOS_MSG", String.valueOf(map.get("iosMessageData")));
						obj.addProperty("AND_TOP_MSG", String.valueOf(map.get("androidTopMessageData")));
						obj.addProperty("AND_BTM_MSG", String.valueOf(map.get("androidBtmMessageData")));
						//System.out.println(">>>>> obj: " + obj);
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
						@SuppressWarnings("unchecked")
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
						//System.out.println(">>>>> composites: " + composites);
						
						//예약발송
						//data.setSendAllwBgnDt(new Date()); //예약발송시 설정.  예약발송시간을 java.util.Date 타입으로 작성.
						
						//SMS 셋팅 http://wiki.11stcorp.com/pages/viewpage.action?pageId=214088691
						//data.setSmsMsg("SMS 스펙에 해당하는 데이터 작성");
						//테스트 데이터 셋팅  , 운영모드 일 경우 Remarking
						
						// Request Body 확인시
						//System.out.println(">>>>> Request Body: " + new GsonBuilder().serializeNulls().create().toJson(Arrays.asList(data)));
						System.out.println(">>>>> Request Body: " + new GsonBuilder().setPrettyPrinting().create().toJson(Arrays.asList(data)));
						
						listPtp.add(data);
						//if (!Boolean.TRUE) PushTalkSendService.INSTANCE.remoteSyncPush(Lists.newArrayList(data));
						
						if (Boolean.TRUE) {
							Map<String, Object> mapIn = new HashMap<>();
							mapIn.put("id", map.get("id"));
							this.tblCamp3Mapper.updateById(mapIn);
						}
					}
					
					System.out.println(">>> listPtp: " + new GsonBuilder().setPrettyPrinting().create().toJson(listPtp));
					if (!Boolean.TRUE) PushTalkSendService.INSTANCE.remoteSyncPush(listPtp);
				}
			}
			
		} catch (Exception e) {
			System.out.println(">>> ERROR: " + e.getMessage());
			throw e;
		}
		
		if (Boolean.TRUE) System.exit(0);
	}
}
