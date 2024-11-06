package com.cdc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cdc.model.Employee;
import com.cdc.service.IEmployeeMgmtService;

@Controller("payroll")
public class PayrollOperationsController {
	@Autowired
	private IEmployeeMgmtService service;

	public List<Employee> showEmployeesByDesignation(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> list = service.fetchEmployeesByDesg(desg1, desg2, desg3);
		return list;
	}

}
