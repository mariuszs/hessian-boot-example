package mariuszs.hessian;

import mariuszs.hessian.api.Foo;
import mariuszs.hessian.api.FooRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.assertj.core.api.BDDAssertions.then;

@IntegrationTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class RestTest {

    private RestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        restTemplate = new RestTemplate();
    }

    @Test
    public void shouldSayHello() {
        //given
        FooRequest fooRequest = new FooRequest("foo", 1, BigDecimal.ZERO);

        Foo foo = restTemplate.postForObject("http://localhost:8080/foo",
            fooRequest,
            Foo.class);


        then(foo.getName())
            .isEqualTo("foo");

    }


}
