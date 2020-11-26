package com.inss.imv.restapi.util.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inss.imv.restapi.domain.Simple;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimpleResponse {
    @JsonProperty("list")
    private List<Simple> simpleList;
}