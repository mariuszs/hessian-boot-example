package mariuszs.hessian;

import mariuszs.hessian.api.Bar;
import mariuszs.hessian.api.Foo;
import mariuszs.hessian.api.FooRequest;
import mariuszs.hessian.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;

@RestController("helloService")
public class HelloServiceImpl implements HelloService {

    private static Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String sayHello() {
        return "Hello World";
    }

    @Override
    @RequestMapping("/foo")
    public Foo foo(@RequestBody FooRequest fooRequest) {
//        LOGGER.info("IN {}", fooRequest);
        return new Foo(fooRequest.getI(), fooRequest.getName(), new Bar(BigDecimal.ONE, Arrays.asList(1L, 2L, 3L)));
    }
}
