package mariuszs.hessian.api;

import java.math.BigDecimal;

public interface HelloService {
    String sayHello();

    Foo foo(FooRequest fooRequest);
}
