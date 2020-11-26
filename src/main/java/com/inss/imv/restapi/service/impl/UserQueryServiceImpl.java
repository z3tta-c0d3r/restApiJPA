package com.inss.imv.restapi.service.impl;

import com.inss.imv.restapi.entity.MasUser;
import com.inss.imv.restapi.repository.UserRepository;
import com.inss.imv.restapi.service.UserQueryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("UserQueryService")
@AllArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<MasUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<MasUser> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public MasUser findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
