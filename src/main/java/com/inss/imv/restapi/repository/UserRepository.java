package com.inss.imv.restapi.repository;

import com.inss.imv.restapi.entity.MasUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<MasUser, Integer> {
    public MasUser findByEmail(String email);
}
