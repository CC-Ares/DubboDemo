package ares.cjc.dubboprovider.service;

import ares.cjc.dubboapi.api.UserServiceBo;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service(interfaceClass = UserServiceBo.class,group = "dubbo",version = "1.0.0")
@Component
public class UserServiceBoImpl implements UserServiceBo{
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
