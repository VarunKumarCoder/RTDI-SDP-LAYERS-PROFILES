package com.cdc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.cdc.model.Employee;

@Repository("ora-emp-dao")
@Profile({ "uat", "prod" })
public class OracleEmployeeDaoImpl implements IEmployeeDao {
	private static final String GET_EMPY_BY_DESG = "SELECT EMPNO, ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	@Autowired
	private DataSource ds;
	List<Employee> list = null;

	@Override
	public List<Employee> getEmployeesByDesignation(String desg1, String desg2, String desg3) throws Exception {
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_EMPY_BY_DESG)) {
			pstmt.setString(1, desg1);
			pstmt.setString(2, desg2);
			pstmt.setString(3, desg3);
			try (ResultSet rs = pstmt.executeQuery()) {
				list = new ArrayList();
				while (rs.next()) {
					Employee emp = new Employee();
					emp.setENo(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setDesg(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					emp.setDeptNo(rs.getInt(5));
					list.add(emp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}
}
