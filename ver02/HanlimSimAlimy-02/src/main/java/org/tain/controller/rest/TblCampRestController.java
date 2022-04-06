package org.tain.controller.rest;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

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

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = {"/rest"})
@Slf4j
public class TblCampRestController {

	@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600)
	@RequestMapping(value = {"/campContent"}, method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<?> test(HttpEntity<String> httpEntity) throws Exception {
		String reqBody = null;
		if (Boolean.TRUE) {
			HttpHeaders reqHeaders = httpEntity.getHeaders();
			reqBody = httpEntity.getBody();
			log.info(">>>>> reqHeaders: " + reqHeaders.toString());
			log.info(">>>>> reqBody1: " + reqBody);
			if (reqBody != null && !"".equals(reqBody)) {
				reqBody = URLDecoder.decode(reqBody, "utf-8");
				log.info(">>>>> reqBody2: " + reqBody);
			}
		}
		
		// job process
		if (Boolean.TRUE) try { Thread.sleep(2 * 1000); } catch (InterruptedException e) {}
		
		// response
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		
		Map<String, Object> mapOut = new HashMap<>();
		mapOut.put("message", "SUCCESS");
		return new ResponseEntity<>(mapOut, headers, HttpStatus.OK);
	}
}
