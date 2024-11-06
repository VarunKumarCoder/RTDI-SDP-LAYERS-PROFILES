package com.cdc.repository;

import java.util.List;

import com.cdc.model.Employee;

public interface IEmployeeDao {
	public List<Employee> getEmployeesByDesignation(String desg1, String desg2, String desg3) throws Exception;
}
