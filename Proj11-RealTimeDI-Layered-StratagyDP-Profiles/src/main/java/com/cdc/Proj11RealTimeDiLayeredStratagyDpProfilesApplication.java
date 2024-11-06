package com.cdc;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.cdc.controller.PayrollOperationsController;
import com.cdc.model.Employee;

@SpringBootApplication
public class Proj11RealTimeDiLayeredStratagyDpProfilesApplication {

	@Autowired
	private Environment env;

	/*
	 * @Bean(name = "c3pods")
	 * 
	 * @Profile("test") public ComboPooledDataSource createD3PODS() throws Exception
	 * { ComboPooledDataSource cpds = new ComboPooledDataSource();
	 * cpds.setDriverClass(env.getRequiredProperty(
	 * "spring.datasource.driver-class-name"));
	 * cpds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
	 * cpds.setUser(env.getRequiredProperty("spring.datasource.username"));
	 * cpds.setPassword(env.getRequiredProperty("spring.datasource.password"));
	 * return cpds; }
	 */

	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = SpringApplication
				.run(Proj11RealTimeDiLayeredStratagyDpProfilesApplication.class, args)) {
			PayrollOperationsController ctrl = ctx.getBean("payroll", PayrollOperationsController.class);
			try {
				List<Employee> list = ctrl.showEmployeesByDesignation("CLERK", "MANAGER", "SALESMAN");
				list.forEach(emp -> {
					System.out.println(emp);
				});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
