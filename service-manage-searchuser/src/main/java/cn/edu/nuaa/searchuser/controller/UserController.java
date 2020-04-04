package cn.edu.nuaa.searchuser.controller;

import cn.edu.nuaa.searchuser.api.UserSearchControllerApi;
import cn.edu.nuaa.searchuser.model.User;
import cn.edu.nuaa.searchuser.service.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/searchuser")
public class UserController implements UserSearchControllerApi {
    @Autowired
    UserSearchService userSearchService;
    @Override
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable("userId") String userId) {
        return userSearchService.getUser(userId);
    }
}
