package mariuszs.hessian;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@IntegrationTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, TestConfig.class})
public class ApplicationTest {

    @Autowired
    private HelloClient helloClient;

    @Test
    public void shouldSayHello() {

        //when
        String message = helloClient.sayHello();

        then(message)
                .isNotEmpty()
                .isEqualTo("Hello World");
    }

    @Test
    public void shouldReveiveFoo() {

        //when
        Foo foo = helloClient.foo();

        then(foo.getName())
                .isEqualTo("foo");
    }

}
