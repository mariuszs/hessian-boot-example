package mariuszs.hessian;

import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(){
        return "Hello World";
    }

    @Override
    public Foo foo() {
        return new Foo("foo");
    }
}
