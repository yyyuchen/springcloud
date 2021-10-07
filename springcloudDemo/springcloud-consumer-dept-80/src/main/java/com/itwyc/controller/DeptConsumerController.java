package com.itwyc.controller;

import com.itwyc.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    //Ribbon实现负载均衡的时候，这里的地址应该是一个变量，因为用户每次的请求都要随机选择一个服务器进行访问
    //应该通过服务名访问
    private static final String REST_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    //理解：消费者，不应该有service层
    //RestTemplate    其中有对应的请求   调用就可以，，注册到spring中
    //(url, 实体： map, Class<T> responseType)

    @Autowired
    private RestTemplate restTemplate;   //提供多种便捷访问远程http服务的方法，简单的Restful服务模板

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_PREFIX + "/dept/add", dept, boolean.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> getList(){
        return restTemplate.getForObject(REST_PREFIX + "/dept/list", List.class);
    }

}
