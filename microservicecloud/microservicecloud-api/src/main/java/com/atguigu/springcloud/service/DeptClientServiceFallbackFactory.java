package com.atguigu.springcloud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.atguigu.springcloud.enties.Dept;
import feign.hystrix.FallbackFactory;
// 统一处理熔断
@Component//不要忘记添加，不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>
{
	@Override
	public DeptClientService create(Throwable throwable)
	{
		return new DeptClientService() {
			@Override
			public Dept get(long id) {
				return null;
			}
			@Override
			public List<Dept> list() {
				List<Dept> list = new ArrayList<>();
				list.add(new Dept().setDeptno(1l)
			               .setDname("该ID：没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
			               .setDb_source("no this database in MySQL"));
				return list;
			}
			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
	}
}



