package com.inss.imv.restapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
public class UserDomain {
    private Integer id;
    private String email;
    private String password;
    private Date createDate;
    private Date updatedAt;
    public UserDomain(){}
}