package com.hr.product_consumer.contorller;

import com.hr.product_consumer.client.ProductClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("consumer")
public class ProductController {
    @Autowired
    //http://127.0.0.1:8081/product/
    private RestTemplate restTemplate;

    //记录服务消费者被访问的次数
    private static int count;

    @Resource
    private ProductClient ProductClient;

    //发现服务：从注册中心拉去服务提供者列表
    //想要使用必须DiscoveryClient必须在启动类上使用了@EnableDiscov
    @Autowired
    private DiscoveryClient discoveryClient;







    @GetMapping("/{pid}")
//    @HystrixCommand(fallbackMethod = "getProductByIdFallback")单独使用ribbon，如果使用的是feign
    public String getProductById(@PathVariable Integer pid){
        //获得注册中心中服务名为PRODUCT-SERVICE的 服务列表
//        List<ServiceInstance> instances = discoveryClient.getInstances("PRODUCT-PRODUCER");


//        instances.forEach(instance -> {
//            String host = instance.getHost();
//            int port = instance.getPort();
//            System.out.println("从注册中心拉取的服务地址："+host+":"+port);
//        });

        //每一次客户请求，次数自增
//        count++;
//
//        //轮训算法
//        int index = count % instances.size();
//

//         ServiceInstance instance = instances.get(index);
//        String host = instance.getHost();
//            int port = instance.getPort();

        //获得第一个服务对象
//        ServiceInstance serviceInstance = instances.get(0);
        //拼接地址
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/" + pid;
//        System.out.println(url);
        //提供者的信息
//        Product product = restTemplate.getForObject("http://"+host+":"+port+"/product/"+pid, Product.class);
//        System.out.println("------------"+product);
            //estful: 多服务传输数据
        //producer：将对象通过objcetMapper转成json格式的字符串，然后传输到consumer，消费者在通过objcetMapper将json字符串重新组装成对象
//        String url = "http://PRODUCT-PRODUCER/product/" + pid;
//        String product = restTemplate.getForObject(url, String.class);
        return ProductClient.getProductById(pid);
    }

    //失败方法参数列表与返回类型必须完全一样
    public String getProductByIdFallback(Integer pid){
        return "soryy,服务器太拥挤,请刷新后重试!";
    }

}