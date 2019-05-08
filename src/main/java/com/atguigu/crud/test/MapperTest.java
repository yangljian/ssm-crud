package com.atguigu.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmployeeMapper;
import com.atguigu.crud.entities.Department;
import com.atguigu.crud.entities.Employee;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employee;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void test() {
		//System.out.println(departmentMapper);
//		departmentMapper.insert(new Department(null, "测试部"));
//		departmentMapper.insert(new Department(null, "开发部"));
//		employee.insert(new Employee(null, "ylj", "M", "ylj@qq.com", 5));
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i = 0;i < 100;i++) {
			String uid = UUID.randomUUID().toString().substring(0, 5) + i;
			mapper.insert(new Employee(null, uid, "M", uid + "@qq.com", 5));
		}
		System.out.println("batch success!");
	}
}
