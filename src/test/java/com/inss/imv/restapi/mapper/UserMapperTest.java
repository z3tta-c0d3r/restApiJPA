package com.inss.imv.restapi.mapper;

import com.inss.imv.restapi.domain.UserDomain;
import com.inss.imv.restapi.entity.MasUser;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class UserMapperTest {

    @Test
    void UserDomainToUserEntityTest() {
        UserDomain userDomain = new UserDomain();
        userDomain.setId(null);
        userDomain.setEmail("mapper1@test.com");
        userDomain.setPassword("mapper123456");
        userDomain.setCreateDate(new Date());
        userDomain.setUpdatedAt(new Date());

        MasUser userEntity = UserMapper.INSTANCE.UserDomainToUserEntity(userDomain);

        assertEquals(userEntity.getId(),userDomain.getId());
        assertEquals(userEntity.getCreatedAt().toString(),userDomain.getCreateDate().toString());
        assertEquals(userEntity.getPassword(),userDomain.getPassword());
    }
}
