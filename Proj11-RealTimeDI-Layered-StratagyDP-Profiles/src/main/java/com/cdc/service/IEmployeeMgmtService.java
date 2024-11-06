package com.cdc.service;

import java.util.List;

import com.cdc.model.Employee;

public interface IEmployeeMgmtService {

	public List<Employee> fetchEmployeesByDesg(String desg1, String desg2, String desg3) throws Exception;
}
