package com.my.hr.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
//commander로 쓰려면 setter 혹은 생성자가 필요하다.
//model로 쓰려면 getter가 필요하다.
public class Laborer {
	private int laborerId;
	private String laborerName;
	private LocalDate hireDate;
}
