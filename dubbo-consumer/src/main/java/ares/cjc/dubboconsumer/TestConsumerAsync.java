package ares.cjc.dubboconsumer;

import ares.cjc.dubboapi.api.UserServiceBo;
import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.GenericService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 服务泛化调用,在没有引入api包的情况下使用
 */
public class TestConsumerAsync {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        //当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubboConsumer");

        //连接注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("192.168.128.129:2181");
        registryConfig.setProtocol("zookeeper");

        ReferenceConfig<UserServiceBo> reference = new ReferenceConfig<UserServiceBo>();
        reference.setApplication(applicationConfig);
        reference.setRegistry(registryConfig);
        reference.setInterface(UserServiceBo.class);
        reference.setVersion("1.0.0");
        reference.setGroup("dubbo");
        reference.setTimeout(30000);

        //设置为异步调用
        reference.setAsync(true);

        UserServiceBo userServiceBo = reference.get();

        long startTime = System.currentTimeMillis()/1000;

        //异步，返回null
        System.out.println(userServiceBo.sayHello("ares"));
        //拿到调用的Future引用，当结果返回后，会被通知和设置到此Future
        Future<String> userServiceFuture = RpcContext.getContext().getFuture();


        //阻塞调用
        System.out.println(userServiceFuture.get());

        long endTime = System.currentTimeMillis()/1000;
        System.out.println("=============================cost: " + (endTime - startTime));

    }
}
