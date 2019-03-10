package ares.cjc.dubboconsumer;


import ares.cjc.dubboapi.api.UserServiceBo;
import ares.cjc.dubboconsumer.service.ConsumerService;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableDubboConfiguration
@RestController
@ComponentScan(basePackages = {"ares.cjc.dubboconsumer"})
public class DubboConsumerApplication {

	@Autowired
	private ConsumerService consumerService;

	public static void main(String[] args) {

		SpringApplication.run(DubboConsumerApplication.class, args);
	}

	@RequestMapping("/")
	String home(){
		return "hello demo";
	}

	@RequestMapping(value = "/testHello/{name}",method = RequestMethod.GET)
	String testSayHello(@PathVariable("name") String name){
		return consumerService.sayHello(name);
	}

}
