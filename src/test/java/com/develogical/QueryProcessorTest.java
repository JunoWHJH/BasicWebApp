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

    @Test
    public void squareAndCube() throws Exception {
        assertThat(queryProcessor.process("3f9dc420: which of the following numbers is both a square and a cube: 128, 729"), containsString("729"));
    }

    @Test
    public void mayElectionYear() throws Exception {
        assertThat(queryProcessor.process("8d1392a0: which year was Theresa May first elected as the Prime Minister of Great Britain"), containsString("2016"));
    }

    @Test
    public void prime() throws Exception {
        assertThat(queryProcessor.process("ef884590: which of the following numbers are primes: 92, 127, 53, 579, 3"), containsString("127, 53, 3"));
    } 
    
    @Test
    public void eiffel() throws Exception {
        assertThat(queryProcessor.process("fa5384e0: which city is the Eiffel tower in"), containsString("Paris"));
    }




}
