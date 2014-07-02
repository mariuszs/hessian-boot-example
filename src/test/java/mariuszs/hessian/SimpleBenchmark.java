package mariuszs.hessian;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import mariuszs.hessian.api.Foo;
import mariuszs.hessian.api.FooRequest;
import mariuszs.hessian.api.HelloService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.assertj.core.api.BDDAssertions.then;

@IntegrationTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, TestConfig.class})
public class SimpleBenchmark extends AbstractBenchmark {

    @Rule
    public TestRule benchmarkRun = new BenchmarkRule();

    private static int COUNT = 500;
    private static RestTemplate restTemplate;

    @BeforeClass
    public static void setUp() throws Exception {
        restTemplate = new RestTemplate();
    }

    @Autowired
    private HelloService helloClient;

    @Test
    public void testHessian() {
        Foo foo = null;

        //when
        for (int i = 0; i < COUNT; i++) {
            foo = helloClient.foo(new FooRequest("test" + i, i, BigDecimal.valueOf(i)));
        }
    }

    @Test
    public void testReast() {
        Foo foo = null;
        FooRequest fooRequest = new FooRequest("foo", 1, BigDecimal.ZERO);

        //when
        for (int i = 0; i < COUNT; i++) {
             foo = restTemplate.postForObject("http://localhost:8080/foo",
                fooRequest,
                Foo.class);
        }
    }


}
