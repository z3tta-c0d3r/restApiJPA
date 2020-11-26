package com.inss.imv.restapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Simple {

    @Id
    @JsonIgnore
    private String id;

    @JsonProperty("id")
    private String simpleId;

    private String name;

    private Integer age;

    @JsonIgnore
    public boolean isEmpty() {
        return (id == null || id.isEmpty())
                && (simpleId == null || simpleId.isEmpty())
                && (name == null || name.isEmpty());
    }
}