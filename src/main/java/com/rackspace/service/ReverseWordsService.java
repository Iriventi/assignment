package com.rackspace.service;

import com.rackspace.dto.ReversedWordsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReverseWordsService {
    private static final String SPACE = "\\s";

    public ReversedWordsResponse getReversedString(String inputWords){

        String words[] = inputWords.trim().split(SPACE);
        String reversedString = "";
        for (int i = words.length-1; i >=0 ; i--) {
            reversedString =  reversedString + " "+words[i];
        }
        return new ReversedWordsResponse(reversedString.trim());
    }
}
