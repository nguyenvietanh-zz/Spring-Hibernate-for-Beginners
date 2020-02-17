package com.luv2code.springdemo;

public class MyApp {

	public static void main(String[] args) {
		
		//tao 1 doi tuong
		Coach theCoach = new TrackCoach();
		//su dung doi tuong
		System.out.println(theCoach.getDailyWorkout());

	}

}
