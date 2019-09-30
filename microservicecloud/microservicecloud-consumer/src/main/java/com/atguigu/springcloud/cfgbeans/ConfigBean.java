package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

/**
 * 替代以前的applicationContext.xml
 * @Configuration配置 = applicationContext.xml
 * @Bean 等于下面的配置
 * <bean id="RestTemplate" class="org.springframework.web.client.RestTemplate"/>
 */
@Configuration
public class ConfigBean {
	
	@Bean
	@LoadBalanced // 开启负责均衡
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
//	@Bean
//	public IRule myRule() {
//		// return new RoundRobinRule(); // 达到目的，用我们重新选择的随机算法替代默认的轮询
//		return new RandomRule();
//	}

}
