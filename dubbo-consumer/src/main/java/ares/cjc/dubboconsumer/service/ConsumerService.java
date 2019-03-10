package ares.cjc.dubboconsumer.service;

import ares.cjc.dubboapi.api.UserServiceBo;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

    @Reference(group = "dubbo",interfaceClass = UserServiceBo.class,version = "1.0.0")
    private UserServiceBo userServiceBo;

    public String sayHello(String name){
        return userServiceBo.sayHello(name);
    }
}
