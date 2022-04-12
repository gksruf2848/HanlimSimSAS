package org.tain.schedule;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@EnableScheduling
@Slf4j
public class H2Scheduler {

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
	@Value("${my.h2.work.dir}")
	private String myH2WorkDir;
	
	@Value("${my.h2.path.bin}")
	private String myH2PathBin;
	
	@Value("${my.h2.cmd}")
	private String myH2Cmd;
	
	@Scheduled(cron = "${my.h2.cron}")
	public void myH2Cmd() {
		log.info(">>> myH2Cmd: " + new Date());
		log.info(">>> myH2Cmd: myH2WorkDir: " + this.myH2WorkDir);
		log.info(">>> myH2Cmd: myH2PathBin: " + this.myH2PathBin);
		log.info(">>> myH2Cmd: myH2Cmd:     " + this.myH2Cmd);
		
		if (Boolean.TRUE) {
			try {
				test01();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void test01() throws Exception {
		
		if (Boolean.TRUE) {
			/*
			 * begin-3
			 */
			//File workDir = new File("N:/");
			//String[] env = new String[] { "PATH=C:\\Windows\\SysWOW64;%PATH%", "STR=DIR" };
			//String cmd = "cmd /c dir | findstr %STR%";   // SUCCESS using a pipe
			// String cmd = "netstat -na | C:\\Windows\\SysWOW64\\findstr.exe 443";  // ERROR
			File workDir = new File(this.myH2WorkDir);
			String[] env = new String[] { "PATH=" + this.myH2PathBin + ":$PATH", "STR=DIR" };
			//String cmd = "sh docker.sh";
			//String cmd = "ls -alF";
			String cmd = this.myH2Cmd;
			
			Runtime run = Runtime.getRuntime();
			Process process = run.exec(cmd, env, workDir);
			
			if (process.waitFor() == 0) {
				/*
				 * success
				 */
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line;
				while ((line = br.readLine()) != null) {
					log.info("OUT LINE:{}", line);
				}
				br.close();
			} else {
				/*
				 * error
				 */
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
				String line;
				while ((line = br.readLine()) != null) {
					log.info("ERR LINE:{}", line);
				}
				br.close();
			}
			
			process.destroy();
		}
	}
}
