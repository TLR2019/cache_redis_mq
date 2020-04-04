package cn.edu.nuaa.searchuser.repository;

import cn.edu.nuaa.searchuser.model.User;

public interface UserRepository {

    User findUser(String userId);
    void saveUser(User user);
}
