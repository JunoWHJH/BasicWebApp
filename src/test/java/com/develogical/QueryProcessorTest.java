package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void largerNumber() throws Exception {
        assertThat(queryProcessor.process("ab1234: which of the following numbers is the largest: 88, 120"), containsString("120"));
    }

    @Test
    public void largestNumber() throws Exception {
        assertThat(queryProcessor.process("ab1234: which of the following numbers is the largest: 88, 120, 480, 23"), containsString("480"));
    }

    @Test
    public void whatIsYourName() throws Exception {
        assertThat(queryProcessor.process("what is your name"), containsString("Jigsaw"));
    }


    @Test
    public void addition() throws Exception {
        assertThat(queryProcessor.process("ef478990: what is 6 plus 12"), containsString("18"));
    }

    @Test
    public void multiply() throws Exception {
        assertThat(queryProcessor.process("ef478990: what is 8 multiplied by 2"), containsString("16"));
    }

}
