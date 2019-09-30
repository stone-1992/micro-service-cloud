package com.atguigu.springcloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.enties.Dept;
import com.atguigu.springcloud.service.DeptService;

@RestController
public class DeptController {

	@Autowired
	private DeptService service;

	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean add(@RequestBody Dept dept)
	{
		return service.add(dept);
	}

	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id)
	{
		return service.get(id);
	}

	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	public List<Dept> list()
	{
		List<Dept> list = new ArrayList<Dept>();
		Dept dept = new Dept();
		dept.setDeptno(1L).setDname("部门1").setDb_source("8001库");
		list.add(dept);
		Dept dept1= new Dept();
		dept1.setDeptno(2L).setDname("部门2").setDb_source("8001库");
		list.add(dept1);
		return list;
	}

}
