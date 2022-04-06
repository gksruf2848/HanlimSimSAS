package org.tain.test;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonData {
	
private static final boolean flag = true;
	
	private static void test01() throws Exception {
		String jsonString = getJsonString();
		System.out.println(jsonString);
	}
	
	public static String getJsonString() {
		StringBuilder sb = new StringBuilder();
		String comma = "";
		sb.append("[");
		for (int i=100; i < 110; i++) {
			sb.append(comma);
			sb.append(String.format("{\"id\":%d, \"campCode\":\"code%d\", \"campContent\":\"content%d\"}", i, i, i));
			comma = ",";
		}
		sb.append("]");
		return sb.toString();
	}
}