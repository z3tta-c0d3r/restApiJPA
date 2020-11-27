package com.inss.imv.restapi.mapper;

import com.inss.imv.restapi.domain.UserDomain;
import com.inss.imv.restapi.entity.MasUser;
import com.inss.imv.restapi.mapper.qualifiers.DateConverter;
import com.inss.imv.restapi.mapper.qualifiers.ParseTimestamp;
import org.hibernate.type.descriptor.java.JdbcTimestampTypeDescriptor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Mapper( uses = DateToTimestamp.class )
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mapping(target="createdAt", source="createDate", qualifiedBy ={ DateConverter.class, ParseTimestamp.class})
    //@Mapping(target="createdAt", source="createDate",qualifiedByName ="ParseTimestamp")
    MasUser UserDomainToUserEntity(UserDomain userDomain);

    @Mapping(target="createDate", source="createdAt")
    UserDomain UserEntityToUserDomain(MasUser masUser);

//    SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    @Named("ParseTimestamp")
//    public static java.util.Date parseTimestamp(Date timestamp) {
//        try {
//            String value = DATE_TIME_FORMAT.format(timestamp);
//            return DATE_TIME_FORMAT.parse(value);
//        } catch (ParseException e) {
//            throw new IllegalArgumentException(e);
//        }
//    }
}
