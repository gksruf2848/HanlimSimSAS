package org.tain.schedule;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.tain.mybatis.mappers.TblCampMapper;
import org.tain.utils.HttpConnection;

import lombok.extern.slf4j.Slf4j;

@Component
@EnableScheduling
@Slf4j
public class Scheduler {

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
	private TblCampMapper tblCampMapper;
	
	@Scheduled(cron = "${my.custom.cron}")
	public void sendToAlimy() throws Exception {
		System.out.printf(">>> Scheduler: %s: %s\n", this.myCustomCmd, new Date());
		
		this.tblCampMapper.updateReady();
		System.out.println(">>> Scheduler: updateReady");
		
		try {
			List<Map<String,Object>> listMap = null;
			if (Boolean.TRUE) {
				//Map<String, Object> mapIn = new ObjectMapper().readValue(reqBody, new TypeReference<Map<String, Object>>() {});
				listMap = this.tblCampMapper.selectReady();
				//log.info(">>>>> listMap: {}", listMap);
				for (Map<String,Object> map : listMap) {
					log.info(">>> map: {}", map);
					
					if (Boolean.TRUE) {
						Map<String, Object> root = new HashMap<>();
						root.put("url", "http://localhost:8884/v0.1/rest/campContent");
						root.put("method", "get");
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
						this.tblCampMapper.updateById(mapIn);
					}
					
					//if (Boolean.TRUE) try { Thread.sleep(2*1000); } catch (InterruptedException e) {}
				}
			}
			
		} catch (Exception e) {
			System.out.println(">>> ERROR: " + e.getMessage());
		}
	}
}
