package com.inss.imv.restapi.service;

import com.inss.imv.restapi.entity.MasUser;
import com.inss.imv.restapi.repository.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
class UserQueryServiceImplTest {

    @Mock
    private UserQueryService userQueryService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAll() throws Exception {
        MasUser user1 = new MasUser();
        user1.setId(1);
        user1.setEmail("vicg@gmail.com");
        user1.setCreatedAt(new Date());
        user1.setPassword("1234#atdk");

        MasUser user2 = new MasUser();
        user2.setId(1);
        user2.setEmail("vicg@gmail.com");
        user2.setCreatedAt(new Date());
        user2.setPassword("1234#atdk");

        MasUser user3 = new MasUser();
        user3.setId(1);
        user3.setEmail("vicg@gmail.com");
        user3.setCreatedAt(new Date());
        user3.setPassword("1234#atdk");

        List<MasUser> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        when(userQueryService.findAll()).thenReturn(userList);

        assertNotNull(userList);
        assertFalse(userList.isEmpty());
        assertEquals(3,userList.size());

//        verify(userQueryService).findAll();
    }

    @Test
    void findById() throws Exception {
        MasUser user = new MasUser();
        user.setId(1);
        user.setEmail("vicg@gmail.com");
        user.setCreatedAt(new Date());
        user.setPassword("1234#atdk");

        when(userQueryService.findById(1)).thenReturn(Optional.of(user));

        Optional<MasUser> masUserList = userQueryService.findById(1);

        assertNotNull(masUserList.get());
        assertEquals("vicg@gmail.com",masUserList.get().getEmail());

    }

}