package com.itwyc;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

//启动类
@SpringBootApplication()
@MapperScan(value = "com.itwyc.mapper")
@EnableEurekaClient    //在服务启动后自动注册到eureka中
@EnableDiscoveryClient  //服务发现
@EnableCircuitBreaker    //添加对熔断的支持
public class DeptProvider_Hystrix_8001 {

    /**
     *  服务熔断： 服务端~   某个服务超时或者异常，引起服务熔断~   类似保险丝~
     *  服务降级： 客户端    从整体网站请求负载考虑，当某个服务熔断或者关闭之后，服务将不再被调用~
     *            此时在客户端，我们可以准备一个FallbackFactory，返回一个默认的值（缺省值），整体的服务水平下降了~但是，好歹能用~
     *            比直接挂到强~
     */

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_Hystrix_8001.class, args);
    }



    // 增加一个 Servlet
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        servletRegistrationBean.addUrlMappings("/actuator/hystrix.stream");
        return servletRegistrationBean;
    }

}
