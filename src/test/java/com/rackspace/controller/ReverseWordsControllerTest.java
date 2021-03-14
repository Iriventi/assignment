package com.rackspace.controller;

import com.rackspace.dto.ReversedWordsResponse;
import com.rackspace.service.ReverseWordsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class ReverseWordsControllerTest {

    @InjectMocks
    ReverseWordsController reverseWordsController;

    @Mock
    ReverseWordsService reverseWordsService;

    private static final String TEST_INPUT= "Hello World";
    private static final String EXPECTED_OUTPUT= "World Hello";

    @Test
    public void testReversedString() {
        ReversedWordsResponse reverseStringResponse = ReversedWordsResponse.builder().reversed(EXPECTED_OUTPUT).build();
        Mockito.when(reverseWordsService.getReversedString("Hello World")).thenReturn(reverseStringResponse);
        ReversedWordsResponse response = reverseWordsController.getReversedString(TEST_INPUT);
        assertEquals(EXPECTED_OUTPUT, response.getReversed());
    }

    @Test(expected = Exception.class)
    public void shouldFailReversedString() {
        Mockito.when(reverseWordsService.getReversedString(TEST_INPUT)).thenThrow(new Exception());
        reverseWordsController.getReversedString(TEST_INPUT);
    }
}
