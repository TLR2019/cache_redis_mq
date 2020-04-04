package cn.edu.nuaa.manage_user.controller;

import cn.edu.nuaa.manage_user.api.UserControllerApi;
import cn.edu.nuaa.manage_user.model.User;
import cn.edu.nuaa.manage_user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController implements UserControllerApi {
    @Autowired
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable("userId") String userId) {
        logger.debug("Looking up data for org {} with correlation id {}", userId);
        User user = userService.getUser(userId);
        return user;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable("userId") String userId, @RequestBody User user) {
        userService.updateUser(user);
    }

    @RequestMapping(value = "/{save}", method = RequestMethod.POST)
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @RequestMapping(value = "/{user}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("user") User user) {
        userService.deleteUser(user);
    }
}
