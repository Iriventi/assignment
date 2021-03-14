package com.rackspace.util;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArraysUtil {
    public static Integer[] getUniqueArray(Integer[] arrayWithDuplicates) {
        List<Integer> output = Arrays.stream(arrayWithDuplicates).distinct().collect(Collectors.toList());
        return output.toArray(new Integer[output.size()]);
    }
}
