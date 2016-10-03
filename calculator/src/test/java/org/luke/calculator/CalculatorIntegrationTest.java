package org.luke.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class CalculatorIntegrationTest {

    @Value("${local.server.port}")
    private String localPort;

    @Test
    public void addEndpoint_addsQueryParamsTogetherAndReturnsResult() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:" + localPort + "/add?operand1=5&operand2=10";

        String responseBody = restTemplate.getForObject(url, String.class);

        JSONAssert.assertEquals("{\n" +
            "  \"operands\": [5, 10],\n" +
            "  \"result\": 15\n" +
            "}", responseBody, true);
    }
}
