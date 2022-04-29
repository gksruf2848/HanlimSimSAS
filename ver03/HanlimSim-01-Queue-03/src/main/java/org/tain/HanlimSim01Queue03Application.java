package org.tain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HanlimSim01Queue03Application {

	public static void main(String[] args) {
		SpringApplication.run(HanlimSim01Queue03Application.class, args);
	}

	///////////////////////////////////////////////////////////////
	
	/*
	@Value("${my.custom.send.flag}") // true이면 PushTalk 서버에 전송
	private boolean myCustomSendFlag;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>>>" + myCustomSendFlag);
	}
	*/
}
