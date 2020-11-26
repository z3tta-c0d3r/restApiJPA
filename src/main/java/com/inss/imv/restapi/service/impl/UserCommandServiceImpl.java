package com.inss.imv.restapi.service.impl;

import com.inss.imv.restapi.entity.MasUser;
import com.inss.imv.restapi.repository.UserRepository;
import com.inss.imv.restapi.service.UserCommandService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("UserCommandService")
@AllArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(MasUser masUser) {
        userRepository.save(masUser);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

}
