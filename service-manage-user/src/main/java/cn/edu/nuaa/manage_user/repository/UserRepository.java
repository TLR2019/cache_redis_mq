package cn.edu.nuaa.manage_user.repository;

import cn.edu.nuaa.manage_user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
