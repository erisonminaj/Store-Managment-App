package com.Main.StorageManagment.Service;

import com.Main.StorageManagment.Repository.UserRepository;
import com.Main.StorageManagment.exception.UserNotFoundException;
import com.Main.StorageManagment.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> FindAllUsers() {
        return userRepository.findAll();
    }
    public User generateBussinessCode(User user){
        user.setBusinessCode(UUID.randomUUID().toString());
        return userRepository.save(user);
    }
    public User UpdateUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found."));
    }

    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteUserById(id);
    }
}
