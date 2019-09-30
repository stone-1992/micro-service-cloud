package com.atguigu.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
public class RandomRule_ZY extends AbstractLoadBalancerRule {
	// total = 0 // 当total == 5以后，指针往下走
	// index = 0 // 当前对外提供服务的服务器地址
	// 当total需要清洗置为0，但是已经达到过一个5次，我们的index = 1
	private int total = 0; // 总共被调用的次数，目前要求每次被调用5次
	private int index = 0; // 当前提供服务的机器好
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {return null;}
        Server server = null;
        while (server == null) {
            if (Thread.interrupted()) {return null;}
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();
            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }
            if(total < 5) {
            	server = upList.get(index);
            	total++;
            }else {
            	total = 0;index++;
            	if(index >= upList.size()) {
            		index = 0;}}
            if (server == null) {
                Thread.yield();continue;
            }
            if (server.isAlive()) {return (server);}
            server = null;
            Thread.yield();
        }
        return server;
    }
	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}
	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
	}
}