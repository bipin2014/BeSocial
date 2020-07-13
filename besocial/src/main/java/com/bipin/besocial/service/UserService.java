package com.bipin.besocial.service;

import com.bipin.besocial.domain.User;
import com.bipin.besocial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public User findById(Integer id) {
        return repository.findById(id).get();
    }

    public User edit(Integer id, User user) {
        User editUser = repository.findById(id).get();
        editUser.setUsername(user.getUsername());
        editUser.setPassword(user.getPassword());
        return repository.save(editUser);
    }

    public User findByUserName(String email){
        return repository.findByUsername(email);
    }
}
