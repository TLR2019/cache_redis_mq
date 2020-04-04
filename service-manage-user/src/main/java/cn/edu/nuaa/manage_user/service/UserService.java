package cn.edu.nuaa.manage_user.service;

import cn.edu.nuaa.manage_user.model.User;
import cn.edu.nuaa.manage_user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(String userId) {
        Optional<User> optional = userRepository.findById(userId);
        return optional.get();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void updateUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }
}