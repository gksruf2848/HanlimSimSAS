package org.tain.controller.rest;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tain.mybatis.mappers.TblCampMapper;
import org.tain.utils.IpPrint;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = {"/rest"})
@Slf4j
public class TblCampRestController {

	@Autowired
	private TblCampMapper tblCampMapper;
	
	@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600)
	@RequestMapping(value = {"/camp"}, method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<?> test(HttpEntity<String> httpEntity) throws Exception {
		String reqBody = null;
		if (Boolean.TRUE) {
			HttpHeaders reqHeaders = httpEntity.getHeaders();
			reqBody = httpEntity.getBody();
			log.info(">>>>> ip.info: " + IpPrint.get());
			log.info(">>>>> reqHeaders: " + reqHeaders.toString());
			log.info(">>>>> reqBody1: " + reqBody);
			//reqBody = URLDecoder.decode(reqBody, "utf-8");
			//log.info(">>>>> reqBody2: " + reqBody);
			//reqBody = "{\"code\": \"C001\"}";
			if (reqBody == null)
				reqBody = "{}";
		}
		
		List<Map<String,Object>> lst = null;
		if (Boolean.TRUE) {
			Map<String, Object> mapIn = new ObjectMapper().readValue(reqBody, new TypeReference<Map<String, Object>>() {});
			lst = this.tblCampMapper.selectAll(mapIn);
			log.info(">>>>> lst: {}", lst);
		}
		
		// response
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		
		Map<String, Object> mapOut = new HashMap<>();
		mapOut.put("list", lst);
		return new ResponseEntity<>(mapOut, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/campArrInsert"}, method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<?> campArrInsert(HttpEntity<String> httpEntity) throws Exception {
		String reqBody = null;
		if (Boolean.TRUE) {
			HttpHeaders reqHeaders = httpEntity.getHeaders();
			reqBody = httpEntity.getBody();
			log.info(">>>>> ip.info: " + IpPrint.get());
			log.info(">>>>> reqHeaders: " + reqHeaders.toString());
			
			reqBody = URLDecoder.decode(reqBody, "utf-8");
			log.info(">>>>> reqBody: " + reqBody);
			if (reqBody == null)
				reqBody = "{}";
		}
		
		int cntInsert = 0;
		if (Boolean.TRUE) {
			ObjectMapper objectMapper = new ObjectMapper();
			List<Map<String,Object>> listMap = objectMapper.readValue(reqBody, new TypeReference<List<Map<String,Object>>>() {});
			//String jsonPretty = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listMap);
			//System.out.println(">>> " + jsonPretty);
			cntInsert = listMap.size();
			System.out.println(">>> cntInsert: " + cntInsert);
			for (Map<String,Object> map : listMap) {
				System.out.println(">>> map: " + map);
				this.tblCampMapper.insertOne(map);
			}
			
		}
		
		// response
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		
		Map<String, Object> mapOut = new HashMap<>();
		mapOut.put("cntInsert", cntInsert);
		return new ResponseEntity<>(mapOut, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/campInsert"}, method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<?> campInsert(HttpEntity<String> httpEntity) throws Exception {
		String reqBody = null;
		if (Boolean.TRUE) {
			HttpHeaders reqHeaders = httpEntity.getHeaders();
			reqBody = httpEntity.getBody();
			log.info(">>>>> ip.info: " + IpPrint.get());
			log.info(">>>>> reqHeaders: " + reqHeaders.toString());
			
			reqBody = URLDecoder.decode(reqBody, "utf-8");
			log.info(">>>>> reqBody: " + reqBody);
			if (reqBody == null)
				reqBody = "{}";
		}
		
		int ret = 0;
		if (Boolean.TRUE) {
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String,Object> mapin = objectMapper.readValue(reqBody, new TypeReference<Map<String,Object>>() {});
			//String jsonPretty = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listMap);
			//System.out.println(">>> " + jsonPretty);
			System.out.println(">>> map: " + mapin);
			this.tblCampMapper.insertOne(mapin);
		}
			
		
		// response
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		
		return new ResponseEntity<>(ret, headers, HttpStatus.OK);
	}
}
