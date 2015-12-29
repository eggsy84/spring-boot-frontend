package hello;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class GreetingControllerUnitTest {

    protected MockMvc mockMvc;

    @Mock
    private CountService countService;

    @InjectMocks
    private GreetingController greetingController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(greetingController).build();
    }

    @Test
    public void testSomething() throws Exception {

        CountPojo countPojo = new CountPojo();
        countPojo.setCount(100);
        when(countService.getCountViaApiCall()).thenReturn(countPojo);

        // Perform the behavior being tested
        String uri = "/greeting";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                            .accept(MediaType.TEXT_HTML))
                            .andReturn();

        // Extract the response status and body
        int status = result.getResponse().getStatus();

        // Assert that service is called
        verify(countService, times(1)).getCountViaApiCall();

        // Assert that we got a 200 OK
        Assert.assertEquals("failure - expected HTTP status 200", HttpStatus.OK.value(), status);
    }
}
