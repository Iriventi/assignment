package com.rackspace.service;

import com.rackspace.dto.ReversedWordsResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ReverseWordsServiceTest {

    @InjectMocks
    ReverseWordsService reverseWordsService;

    private static final String TEST_INPUT_1 = "Hello World";
    private static final String TEST_INPUT_2 = "Hello";
    private static final String EXPECTED_OUTPUT = "World Hello";

    @Test
    public void testReversedString() {
        ReversedWordsResponse reversedStringEntity = reverseWordsService.getReversedString(TEST_INPUT_1);
        String reversedString = reversedStringEntity.getReversed();
        assertEquals(EXPECTED_OUTPUT, reversedString);
    }

    @Test
    public void testReversedStringForOneWord() {
        ReversedWordsResponse reversedStringEntity = reverseWordsService.getReversedString(TEST_INPUT_2);
        String reversedString = reversedStringEntity.getReversed();
        assertEquals(TEST_INPUT_2, reversedString);
    }

    @Test
    public void shouldConsiderSpacesInStringWhileReversing() {
        String reversedStringExpected = "World   Hello";
        ReversedWordsResponse reversedStringEntity = reverseWordsService.getReversedString("Hello   World");
        String reversedString = reversedStringEntity.getReversed();
        assertEquals(reversedStringExpected, reversedString);
    }

    @Test (expected = NullPointerException.class)
    public void shouldFailIfInputIsNull() {
        reverseWordsService.getReversedString(null);
    }
}
