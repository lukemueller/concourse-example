package org.luke.calculator;

import org.junit.Test;
import org.luke.addition.AdderModule;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AdditionServiceTest {
    private AdditionService additionService;

    @Test
    public void test_delegatesToAdditionModulesAndReturnsResult() {
        int expectedResult = 10;
        AdderModule mockAdderModule = Mockito.mock(AdderModule.class);
        Mockito.doReturn(expectedResult).when(mockAdderModule).add(5, 5);

        additionService = new AdditionService(mockAdderModule);
        int actualResult = additionService.add(5, 5);

        assertThat(actualResult, is(expectedResult));
        Mockito.verify(mockAdderModule).add(5, 5);
    }
}