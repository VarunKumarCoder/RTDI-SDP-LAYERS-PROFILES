package com.cdc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private Integer deptNo;
	private String desg;
	private String ename;
	private Integer eNo;
	private Double salary;
}
