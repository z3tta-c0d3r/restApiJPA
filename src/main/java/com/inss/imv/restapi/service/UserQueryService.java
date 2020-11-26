package com.inss.imv.restapi.service;

import com.inss.imv.restapi.entity.MasUser;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    public List<MasUser> findAll();
    public Optional<MasUser> findById(int id);
    public MasUser findByEmail(String email);
}