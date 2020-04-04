package cn.edu.nuaa.searchuser.api;


import cn.edu.nuaa.searchuser.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "查询用户信息", description = "用户查询接口")
public interface UserSearchControllerApi {
    @ApiOperation("根据ID查找用户")
    public User getUser(String userId);

}


