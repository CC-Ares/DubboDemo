package ares.cjc.dubboprovider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDubboConfiguration
@RestController
@ComponentScan(basePackages = {"ares.cjc.dubboprovider"})
public class DubboProviderApplication {

	@RequestMapping("/")
	String home(){
		return "hello Demo";
	}

	public static void main(String[] args) {
		SpringApplication.run(DubboProviderApplication.class, args);
	}

}
