package org.tain.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonMapTestMain {

	public static void main(String[] args) throws Exception {
		List<Map<String,Object>> listMap = getListMap();
		
		if (Boolean.TRUE) testJackson(listMap);
		if (Boolean.TRUE) testGson(listMap);
		
	}
	
	private static List<Map<String,Object>> getListMap() {
		List<Map<String,Object>> listMap = new ArrayList<>();
		for (int i=0; i < 3; i++) {
			Map<String,Object> map = new HashMap<>();
			map.put("name", String.format("NAME-%s", i));
			map.put("desc", String.format("DESC-%s", i));
			listMap.add(map);
		}
		
		return listMap;
	}
	
	private static void testJackson(List<Map<String,Object>> listMap) throws Exception {
		String jsonString = new ObjectMapper().writeValueAsString(listMap);
		System.out.println("ObjectMapper >>> jsonString: " + jsonString);
		
		String jsonPrettyString = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(listMap);
		System.out.println("ObjectMapper >>> jsonPrettyString: " + jsonPrettyString);
		
		List<Map<String,Object>> listMap2 = new ObjectMapper().readValue(jsonPrettyString, new TypeReference<List<Map<String,Object>>>(){});
		System.out.println("ObjectMapper >>> listMap2: " + listMap2);
	}
	
	private static void testGson(List<Map<String,Object>> listMap) {
		//String jsonString = new Gson().toJson(listMap);
		String jsonString = new GsonBuilder().serializeNulls().create().toJson(listMap);
		System.out.println("Gson >>> jsonString: " + jsonString);
		
		String jsonPrettyString = new GsonBuilder().setPrettyPrinting().create().toJson(listMap);
		System.out.println("Gson >>> jsonPrettyString: " + jsonPrettyString);
		
		List<Map<String,Object>> listMap2 = new Gson().fromJson(jsonPrettyString, new TypeToken<List<Map<String,Object>>>() {}.getType());
		System.out.println("Gson >>> listMap2: " + listMap2);
	}
}
