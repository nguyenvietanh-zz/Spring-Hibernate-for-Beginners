package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String [] data = {
			"Nguyen Viet Anh",
			"Day la bai test",
			"So 2",
			"So 5"
	};
	
	private Random myRandom = new Random();
	
	

	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
