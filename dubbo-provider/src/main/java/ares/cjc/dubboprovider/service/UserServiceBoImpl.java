package ares.cjc.dubboprovider.service;

import ares.cjc.dubboapi.api.UserServiceBo;
import ares.cjc.dubboapi.vo.User;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service(interfaceClass = UserServiceBo.class,group = "dubbo",version = "1.0.0",timeout = 30000)
@Component
public class UserServiceBoImpl implements UserServiceBo{
    @Override
    public String sayHello(String name) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello " + name;
    }

    @Override
    public User testUser(User user) {
        return user;
    }
}
