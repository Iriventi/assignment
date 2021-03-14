package com.rackspace.controller;

import com.rackspace.dto.ReversedWordsResponse;
import com.rackspace.service.ReverseWordsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ReverseWordsController {

    @Autowired
    ReverseWordsService reverseWordsService;

    @GetMapping("/api/{inputWords}")
    public ReversedWordsResponse getReversedString(@PathVariable("inputWord") String inputWords){
        log.info("received request for reversing word {}", inputWords);
        ReversedWordsResponse reverseStringResponse = reverseWordsService.getReversedString(inputWords);
        return reverseStringResponse;
    }
}
