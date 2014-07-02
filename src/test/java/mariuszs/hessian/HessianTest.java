package mariuszs.hessian;

import mariuszs.hessian.api.Bar;
import mariuszs.hessian.api.Foo;
import mariuszs.hessian.api.FooRequest;
import mariuszs.hessian.api.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;

import static org.assertj.core.api.BDDAssertions.then;

@IntegrationTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, TestConfig.class})
public class HessianTest {

    @Autowired
    private HelloService helloClient;

    @Test
    public void shouldSayHello() {

        //when
        String message = helloClient.sayHello();

        then(message)
            .isNotEmpty()
            .isEqualTo("Hello World");
    }

    @Test
    public void shouldReceiveFoo() {
        //given
        FooRequest fooRequest = new FooRequest("foo", 0, BigDecimal.ZERO);

        //when
        Foo foo = helloClient.foo(fooRequest);

        then(foo.getName())
            .isEqualTo("foo");
    }

    @Test
    public void shouldReceiveBar() {
        //given
        FooRequest fooRequest = new FooRequest("test", 1, BigDecimal.ONE);

        //when
        Bar bar = helloClient.foo(fooRequest).getBar();

        then(bar.getAmount())
            .isEqualTo(BigDecimal.ONE);
        then(bar.getLongs())
            .contains(1L, 2L, 3L);
    }

}
