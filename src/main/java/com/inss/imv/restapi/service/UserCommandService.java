package com.inss.imv.restapi.service;

import com.inss.imv.restapi.entity.MasUser;

public interface UserCommandService {
    void save(MasUser masUser);
    void deleteById(int id);
}