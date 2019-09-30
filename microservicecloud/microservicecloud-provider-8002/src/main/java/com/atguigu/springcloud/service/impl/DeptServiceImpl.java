package com.atguigu.springcloud.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atguigu.springcloud.enties.Dept;
import com.atguigu.springcloud.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService{

	@Override
	public boolean add(Dept dept) {
		return false;
	}

	@Override
	public Dept get(Long id) {
		return null;
	}

	@Override
	public List<Dept> list() {
		return null;
	}
	

}
