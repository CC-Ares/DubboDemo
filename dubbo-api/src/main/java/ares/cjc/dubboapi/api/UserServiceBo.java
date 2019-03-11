package ares.cjc.dubboapi.api;

import ares.cjc.dubboapi.vo.User;

public interface UserServiceBo {
    String sayHello(String name);

    User testUser(User user);
}
