package com.inss.imv.restapi.controller.query;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inss.imv.restapi.entity.MasUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserQueryControllerTest {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        MvcResult storyResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andReturn();

        List<MasUser> userList = OBJECT_MAPPER.readValue(
                storyResult.getResponse().getContentAsString(),
                new TypeReference<List<MasUser>>(){});

        assertThat(userList).isNotNull();
        assertThat(userList).isNotEmpty();
    }

    @Test
    void findById() throws Exception {
        MvcResult storyResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/users/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andReturn();

        MasUser user = OBJECT_MAPPER.readValue(
                storyResult.getResponse().getContentAsString(),
                MasUser.class);
        assertThat(user).isNotNull();
    }
}