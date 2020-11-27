package com.inss.imv.restapi.controller.command;

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
class UserCommandControllerTest {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final String USER_DELETE = "8";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void save() throws Exception {
//        MasUser createdUser = createUser();
//        assertThat(createdUser.getId()).isNotNull();
    }

    @Test
    void deleteById() throws Exception {
//        String storyResult = deleteUser();
//        assertThat(storyResult).isEmpty();
    }

    // Create User
    private MasUser createUser() throws Exception {
        MasUser user = new MasUser();
        user.setEmail("v1@gmail.com");
        user.setCreatedAt(new Date());
        user.setPassword("v10001");

        String postValue = OBJECT_MAPPER.writeValueAsString(user);

        MvcResult storyResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postValue))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andReturn();

        return OBJECT_MAPPER.readValue(storyResult.getResponse().getContentAsString(), MasUser.class);
    }

    // Delete User
    private String deleteUser() throws Exception {
        MvcResult storyResult = mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/users/" + USER_DELETE)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andReturn();

        return storyResult.getResponse().getContentAsString();
    }
}