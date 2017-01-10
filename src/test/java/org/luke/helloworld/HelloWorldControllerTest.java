package org.luke.helloworld;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class HelloWorldControllerTest {

    @Test
    public void requestMapping() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk());
    }
}
