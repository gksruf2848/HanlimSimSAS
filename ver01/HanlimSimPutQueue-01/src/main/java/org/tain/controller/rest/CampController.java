package org.tain.controller.rest;

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
import org.tain.mybatis.mappers.CampMapper;
import org.tain.utils.IpPrint;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = {"/rest"})
@Slf4j
public class CampController {

	@Autowired
	private CampMapper campMapper;
	
	@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600)
	@RequestMapping(value = {"/camps"}, method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<?> test(HttpEntity<String> httpEntity) throws Exception {
		if (Boolean.TRUE) {
			HttpHeaders headers = httpEntity.getHeaders();
			String body = httpEntity.getBody();
			log.info(">>>>> ip.info: " + IpPrint.get());
			log.info(">>>>> request.headers: " + headers.toString());
			log.info(">>>>> request.body: " + body);
		}
		
		List<Map<String,Object>> lst = null;
		if (Boolean.TRUE) {
			Map<String,Object> mapIn = new HashMap<>();
			lst = this.campMapper.selectAll(mapIn);
			log.info(">>>>> lst: {}", lst);
		}
		
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		return new ResponseEntity<>(lst, headers, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600)
	@RequestMapping(value = {"/save"}, method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<?> save(HttpEntity<String> httpEntity) throws Exception {
		String body = "";
		if (Boolean.TRUE) {
			HttpHeaders headers = httpEntity.getHeaders();
			body = httpEntity.getBody();
			log.info(">>>>> ip.info: " + IpPrint.get());
			log.info(">>>>> request.headers: " + headers.toString());
			log.info(">>>>> request.body: " + body);
		}
		
		int ret = 0;
		if (Boolean.TRUE) {
			ObjectMapper objectMapper = new ObjectMapper();
			List<Map<String,Object>> listMap = objectMapper.readValue(body, new TypeReference<List<Map<String,Object>>>() {});
			//String jsonPretty = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listMap);
			//System.out.println(">>> " + jsonPretty);
			for (Map<String,Object> map : listMap) {
				ret = this.campMapper.insertOne(map);
			}
			log.info(">>>>> ret: {}", ret);
		}
		
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		return new ResponseEntity<>(ret, headers, HttpStatus.OK);
	}
}
