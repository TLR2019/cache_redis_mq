package cn.edu.nuaa.searchuser.service;

import cn.edu.nuaa.searchuser.model.User;
import cn.edu.nuaa.searchuser.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserSearchService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserRepository userRedisRepo;

    private User checkRedisCache(String userId) {
        try {
            return userRedisRepo.findUser(userId);
        }
        catch (Exception ex){
            logger.error("Error encountered while trying to retrieve user {} check Redis Cache.  Exception {}", userId, ex);
            return null;
        }
    }

    private void cacheUserObject(User user) {
        try {
            userRedisRepo.saveUser(user);
        }catch (Exception ex){
            logger.error("Unable to cache user {} in Redis. Exception {}", user.getId(), ex);
        }
    }
    private static final Logger logger = LoggerFactory.getLogger(UserSearchService.class);
    public User getUser(String userId){

        User user = checkRedisCache(userId);

        if (user!=null){
            logger.debug("I have successfully retrieved an user {} from the redis cache: {}", userId, user);
            return user;
        }

        logger.debug("Unable to locate user from the redis cache: {}.", userId);

        ResponseEntity<User> restExchange =
                restTemplate.exchange(
                        "http://localhost:7005/user/{userId}",
                        HttpMethod.GET,
                        null, User.class, userId);

        /*Save the record from cache*/
        user = restExchange.getBody();

        if (user!=null) {
            cacheUserObject(user);
        }

        return user;
    }
}
