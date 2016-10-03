package org.luke.addition;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AdderModuleTest {

    @Test
    public void add_returnsZero_whenNoOperandsAreProvided() {
        AdderModule adderModule = new AdderModule();

        assertThat(adderModule.add(), is(0));
    }

    @Test
    public void add_returnsProvidedValue_whenOnlyOneOperand() {
        AdderModule adderModule = new AdderModule();

        assertThat(adderModule.add(0), is(0));
        assertThat(adderModule.add(10), is(10));
        assertThat(adderModule.add(3), is(3));
    }

    @Test
    public void add_AddsMoreThanOneNumbersTogether() {
        AdderModule adderModule = new AdderModule();

        assertThat(adderModule.add(1, 1), is(2));
        assertThat(adderModule.add(10, 10), is(20));
        assertThat(adderModule.add(3, 3, 3), is(9));
        assertThat(adderModule.add(10, 20, 30), is(60));
    }
}
