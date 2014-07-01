package mariuszs.hessian;

import static org.assertj.core.api.BDDAssertions.then;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, TestConfig.class})
@WebAppConfiguration
@IntegrationTest
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

}
