package org.tain.schedule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonData {

	private static final boolean flag = true;
	
	public static void _main(String[] args) throws Exception {
		if (flag) test01();
	}
	
	private static void test01() throws Exception {
		String jsonString = getJsonString();
		System.out.println(">>> " + jsonString);
		ObjectMapper objectMapper = new ObjectMapper();
		List<Map<String,Object>> listMap = objectMapper.readValue(jsonString, new TypeReference<List<Map<String,Object>>>() {});
		String jsonPretty = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listMap);
		System.out.println(">>> " + jsonPretty);
		for (Map<String,Object> map : listMap) {
			System.out.println(">>> map: " + map);
		}
		
	}
	
	public static String getJsonString() throws Exception {
		return getJsonString("CAMP00000", "TR00000");
	}
	
	public static String getJsonString(String campaigncode, String treatmentcode) throws Exception {
		Map<String,Object> map = new HashMap<>();
		map.put("campaigncode", campaigncode);
		map.put("treatmentcode", treatmentcode);
		map.put("Ios_messageData", "아이폰 메시지~개인화테스트입니다~69번째(포맷유지)");
		map.put("Android_TopmessageData","안드로이드 메시지~~Top개인화테스트~69번째(포맷변경)");
		map.put("Android_BtmmessageData","안드로이드 메시지~~Btm개인화테스트~69번째(포맷변경)");
		map.put("TalkMsgTmpltNo","001");
		map.put("Memno","18468196");
		map.put("DetailUrl","http://m.11st.co.kr/MW/TData/dataFree.tmall");
		map.put("BannerUrl","http://m.11st.co.kr");
		map.put("EtcData","{ \"campaigncode\":\"" + campaigncode + "\", \"treatmentcode\":\"" + treatmentcode + "\" }");
		map.put("TalkTitle","주문 알림톡입니다.(69)");
		map.put("BlockImg500_Value","{ \"imgUrl\" : [\"http://i.011st.com/ui_img/11talk/img_500_500_sample2.png\" ,\"http://i.011st.com/ui_img/11talk/img_500_500_sample1.png\n\n\"  ]}");
		map.put("BlockTopCapMain_Value","패션워크");
		map.put("BlockTopCapSub_Value","광고");
		map.put("BlockBoldTextMain_Value","반값 타임딜 하루 69번 오픈");
		map.put("BlockBoldTextSub_Value","놓치지마세요!");
		map.put("BlockBtnView_Value", "상세보기(69)");
		map.put("BlockLinkUrlMobile_Value", "http://m.11st.co.kr/MW/MyPage/V1/benefitCouponDownList.tmall");
		map.put("BlockLinkUrlWeb_Value", "http://11st.co.kr");
		
		map.put("AppKdCd", "01");
		map.put("TalkDispYn", "Y");

		String jsonString = null;
		jsonString = new ObjectMapper().writeValueAsString(map);
		jsonString = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(map);
		
		return jsonString;
	}
	
	@Deprecated
	public static String _getJsonString_20220414() {
		StringBuilder sb = new StringBuilder();
		String comma = "";
		sb.append("[");
		for (int i=100; i < 110; i++) {
			sb.append(comma);
			sb.append(String.format("{\"campCode\":\"code%03d\", \"campContent\":\"content%03d\"}", i, i));
			comma = ",";
			
		}
		if (flag) {
			sb.append(comma);
			sb.append(String.format("{\"campCode\":\"한글\", \"campContent\":\"한글\"}"));
		}
		sb.append("]");
		return sb.toString();
	}
}
