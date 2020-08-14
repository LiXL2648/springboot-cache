package com.li.springboot;

import com.li.springboot.bean.Employee;
import com.li.springboot.dao.DepartmentDao;
import com.li.springboot.dao.EmployeeDao;
import com.li.springboot.service.EmployeeService;
import com.li.springboot.utils.DateTimeUtile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.SQLException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootCacheApplicationTests {

	@Autowired
	private DataSource druid;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private RedisTemplate<Object, Employee> empRedisTemplate;

	@Test
	public void testRedisTemplate() {
		Employee emp = employeeService.getEmp(20001);
		// redisTemplate.opsForValue().set("emp01", emp);
		empRedisTemplate.opsForValue().set("emp01", emp);
	}

	@Test
	public void testStringRedisTemplate() {
		stringRedisTemplate.opsForValue().set("hello", "world");
	}

	@Test
	public void testEmployeeService() {
//		Employee employee = new Employee("LiXL", "LiXL@qq.com", 1, DateTimeUtile.getDate("1996-05-04"), 10001);
//		employee.setId(20001);
//		employeeService.updateEmp(employee);

		System.out.println(employeeService.getEmp(20001));
	}

	@Test
	public void testDepartmentDao() {
		System.out.println(departmentDao.getDep(10001));
	}

	@Test
	public void testEmployeeDao() {
		System.out.println(employeeDao.getEmp(20001));
	}

	@Test
	public void testDataSource() throws SQLException {
		System.out.println(druid);
		System.out.println(druid.getConnection());
	}

}
