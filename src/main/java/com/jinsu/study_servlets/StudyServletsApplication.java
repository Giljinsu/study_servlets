package com.jinsu.study_servlets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // spring boot로 가져왔기 떄문에 servlet으로 바꾸기 위해선 이걸 적는다. 그래야 작동함
@SpringBootApplication
public class StudyServletsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyServletsApplication.class, args);
	}

}
