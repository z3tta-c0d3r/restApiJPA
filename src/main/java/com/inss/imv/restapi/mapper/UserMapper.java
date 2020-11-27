package com.inss.imv.restapi.mapper;

import com.inss.imv.restapi.domain.UserDomain;
import com.inss.imv.restapi.entity.MasUser;
import com.inss.imv.restapi.mapper.qualifiers.DateConverter;
import com.inss.imv.restapi.mapper.qualifiers.ParseTimestamp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper( uses = DateToTimestamp.class )
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mapping(target="createdAt", source="createDate", qualifiedBy ={ DateConverter.class, ParseTimestamp.class})
    MasUser UserDomainToUserEntity(UserDomain userDomain);

    @Mapping(target="createDate", source="createdAt")
    UserDomain UserEntityToUserDomain(MasUser masUser);
}
