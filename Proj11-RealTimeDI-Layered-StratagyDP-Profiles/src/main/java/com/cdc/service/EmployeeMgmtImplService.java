package com.cdc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdc.model.Employee;
import com.cdc.repository.IEmployeeDao;

public class EmployeeMgmtImplService implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeDao dao;

	@Override
	public List<Employee> fetchEmployeesByDesg(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> list = dao.getEmployeesByDesignation(desg1, desg2, desg3);
		return list;
	}

}
