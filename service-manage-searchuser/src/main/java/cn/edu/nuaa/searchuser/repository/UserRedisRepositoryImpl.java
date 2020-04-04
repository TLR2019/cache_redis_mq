package cn.edu.nuaa.searchuser.repository;

import cn.edu.nuaa.searchuser.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class UserRedisRepositoryImpl implements UserRepository {
    private static final String HASH_NAME = "user";

    private RedisTemplate<String, User> redisTemplate;
    private HashOperations hashOperations;

    public UserRedisRepositoryImpl() {
        super();
    }

    @Autowired
    private UserRedisRepositoryImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }


    public void saveUser(User user) {
        hashOperations.put(HASH_NAME, user.getId(), user);
    }

    public User findUser(String userId) {
        return (User) hashOperations.get(HASH_NAME, userId);
    }
}
