package ares.cjc.dubboconsumer;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 服务泛化调用,在没有引入api包的情况下使用
 */
public class TestConsumerApiGeneric {
    public static void main(String[] args) throws IOException {
        //当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubboConsumer");

        //连接注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("192.168.128.129:2181");
        registryConfig.setProtocol("zookeeper");

        //泛型参数设置为GenericService
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setApplication(applicationConfig);
        reference.setRegistry(registryConfig);
        reference.setVersion("1.0.0");
        reference.setGroup("dubbo");
        reference.setTimeout(3000);

        //设置为泛化
        reference.setInterface("ares.cjc.dubboapi.api.UserServiceBo");
        reference.setGeneric(true);

        //用GenericService替代所有接口引用
        GenericService userService = reference.get();

        Object result = userService.$invoke("sayHello",new String[]{"java.lang.String"},new String[]{"哈哈哈哈"});
        System.out.println(JSON.json(result));

        Map<String,Object> map = new HashMap<String ,Object>();
        map.put("class","ares.cjc.dubboapi.vo.User");
        map.put("name","ares");
        map.put("age",18);

        result = userService.$invoke("testUser",new String[]{"ares.cjc.dubboapi.vo.User"},new Object[]{map});
        System.out.println(result);


    }
}
