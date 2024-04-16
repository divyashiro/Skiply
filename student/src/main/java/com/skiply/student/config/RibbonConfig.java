//package com.skiply.student.config;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.context.annotation.Bean;
//
//import com.netflix.loadbalancer.IPing;
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.PingUrl;
//import com.netflix.loadbalancer.RoundRobinRule;
//import com.netflix.loadbalancer.Server;
//import com.netflix.loadbalancer.ServerList;
//
//
//@RibbonClient(name="receipt-service")
//public class RibbonConfig {
//	
//	@Bean
//	public IRule loadBalancingRule() {
//		return new RoundRobinRule();
//	}
//	
//	@Bean
//	public IPing pingConfiguration(ServerList<Server> servers) {
//		
//		String pingPath = "/actuator/health";
//		IPing ping = new PingUrl(false, pingPath);				
//		System.out.println("Configuring ping URI to [{}]"+ pingPath);
//		
//		return ping;		
//	}
//	
//	@Bean
//	public ServerList<Server> serverList() {
//		
//		return new ServerList<Server>() {
//			
//			@Override
//			public List<Server> getUpdatedListOfServers() {
//
//				List<Server> serverList = Arrays.asList(new Server("http", "localhost", 9091), new Server("http", "localhost", 9092));				
//				System.out.println("Returning updated list of servers [{}]" + serverList);
//				return serverList;
//			}
//			
//			@Override
//			public List<Server> getInitialListOfServers() {
//
//				return Arrays.asList(new Server("http", "localhost", 9091), new Server("http", "localhost", 9092));
//			}
//		};
//	}
//
//}
