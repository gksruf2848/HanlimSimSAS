package org.tain.utils;

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
	
	public static String getJsonString() {
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
