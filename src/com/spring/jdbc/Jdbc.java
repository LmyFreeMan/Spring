package com.spring.jdbc;
import	java.util.HashMap;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Jdbc {
    private ApplicationContext ctx=null;
    private JdbcTemplate jdbcTemplate = null;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    {
        ctx=new ClassPathXmlApplicationContext("jdbc.xml");
        jdbcTemplate= (JdbcTemplate) ctx.getBean("jdbcTemplate");
        namedParameterJdbcTemplate=ctx.getBean(NamedParameterJdbcTemplate.class);
    }
    @Test
    /*
    * 好处:若有多个参数，则不用再去对应位置，直接对应参数名，便于维护
    * 缺点:较为麻烦
    * */
    public void testNamedParameterJdbcTemplate(){
        //String sql ="INSERT INTO employees(ID,LAST_NAME,EMAIL,DEPT_ID) VALUES(:Id,:Ln,:email,:deptId)";
        //Hash映射
//        Map<String, Object>paramMap=new HashMap<String, Object> ();
//        paramMap.put("Id",7);
//        paramMap.put("Ln","FF");
//        paramMap.put("email","FF@163.com");
//        paramMap.put("deptId",2);
//        namedParameterJdbcTemplate.update(sql,paramMap);
        //传入对象
        String sql ="INSERT INTO employees(ID,LAST_NAME,EMAIL,DEPT_ID) VALUES(:id,:lastName,:email,:deptId)";
        Employee employee=new Employee();
        employee.setId(8);
        employee.setLastName("xx");
        employee.setEmail("xxx@163.com");
        employee.setDeptId(2);
        SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(employee);
        namedParameterJdbcTemplate.update(sql,parameterSource);
    }
    //更新一条记录
    @Test
    public void testUpdate() {
        String sql ="UPDATE employees set LAST_NAME=? where id=?";
        jdbcTemplate.update(sql,"li",1);
    }
    //批量更新:批量的INSERT,UPDATE,DELETE
    @Test
    public void testBatchUpdate(){
        String sql ="INSERT INTO employees(ID,LAST_NAME,EMAIL,DEPT_ID) VALUES(?,?,?,?)";
        List batchArgs=new ArrayList();
        batchArgs.add(new Object[]{3,"AA","AA@qq.com",1});
        batchArgs.add(new Object[]{4,"BB","BB@qq.com",1});
        batchArgs.add(new Object[]{5,"CC","CC@qq.com",1});
        batchArgs.add(new Object[]{6,"DD","DD@qq.com",1});
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }
    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource=ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
    //从数据库中取出一条记录，实际得到一个对象
    @Test
    public void testQueryForObject(){
        String sql ="select ID,LAST_NAME,EMAIL from employees where ID=?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employees=jdbcTemplate.queryForObject(sql,rowMapper,1);
        System.out.println(employees);
        //获取单个列的值，或者做统计查询
        System.out.println(jdbcTemplate.queryForObject("select count(id) from employees",Long.class));
    }
    @Test
    public void testQueryForList(){
        String sql ="select ID,LAST_NAME,EMAIL from employees where ID>?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employees=jdbcTemplate.query(sql,rowMapper,1);
        System.out.println(employees);
    }
}