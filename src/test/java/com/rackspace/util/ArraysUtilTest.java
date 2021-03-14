package com.rackspace.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertArrayEquals;

public class ArraysUtilTest {

    ArraysUtil arraysUtil;

    @Test
    public void shouldGetUniqueArray() {
        Integer[] duplicatesArray = new Integer[] { 1, 6, 1, 5, 6, 2 };
        Integer[] expectedUniqueArray = new Integer[] { 1, 6, 5, 2 };
        Integer[] uniqueArray = arraysUtil.getUniqueArray(duplicatesArray);
        assertArrayEquals(expectedUniqueArray, uniqueArray);
    }

    @Test
    public void shouldNotFailIfInputArrayIsEmpty() {
        Integer[] duplicatesArray = new Integer[] { };
        Integer[] expectedUniqueArray = new Integer[] { };
        Integer[] uniqueArray = arraysUtil.getUniqueArray(duplicatesArray);
        assertArrayEquals(expectedUniqueArray, uniqueArray);
    }

    @Test(expected = NullPointerException.class)
    public void shouldFailIfInputArrayIsNull() {
        Integer[] duplicatesArray = null;
        Integer[] expectedUniqueArray = new Integer[] { };
        Integer[] uniqueArray = arraysUtil.getUniqueArray(duplicatesArray);
        assertArrayEquals(expectedUniqueArray, uniqueArray);
    }
}
