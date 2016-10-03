package org.luke.calculator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AdditionControllerTest {

    private AdditionService mockAdditionService;
    private AdditionController additionController;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockAdditionService = Mockito.mock(AdditionService.class);
        additionController = new AdditionController(mockAdditionService);
        mockMvc = MockMvcBuilders
            .standaloneSetup(additionController)
            .build();
    }

    @Test
    public void add_DefinesRequestMapping() throws Exception {
        mockMvc
            .perform(get("/add?operand1=3&operand2=2"))
            .andExpect(status().isOk());
    }

    @Test
    public void add_delegatesToAdditionServiceWithProvidedQueryParameters() throws Exception {
        mockMvc
            .perform(get("/add?operand1=5&operand2=6"))
            .andExpect(status().isOk());

        Mockito.verify(mockAdditionService).add(5, 6);
    }

    @Test
    public void add_returnsResultOfAdditionService() {
        Mockito.doReturn(30).when(mockAdditionService).add(10, 20);

        AdditionController.AddApiResponse apiResponse = additionController.add("10", "20");

        assertThat(apiResponse.getOperands(), hasSize(2));
        assertThat(apiResponse.getOperands(), contains(10, 20));
        assertThat(apiResponse.getResult(), is(30));
    }

}
