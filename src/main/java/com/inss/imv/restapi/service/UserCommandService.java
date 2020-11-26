package com.inss.imv.restapi.service;

import com.inss.imv.restapi.entity.MasUser;
import java.util.List;
import java.util.Optional;

public interface UserCommandService {
    public void save(MasUser masUser);
    public void deleteById(int id);
}