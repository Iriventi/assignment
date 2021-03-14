package com.rackspace.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ReversedWordsResponse {

    private String reversed;

}
