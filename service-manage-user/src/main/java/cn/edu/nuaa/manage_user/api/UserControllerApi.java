package cn.edu.nuaa.manage_user.api;

import cn.edu.nuaa.manage_user.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "用户管理", description = "用户管理接口")
public interface UserControllerApi {
    @ApiOperation("新增用户")
    public void saveUser(User user);
    @ApiOperation("更新用户")
    public void updateUser(String userId, User user);
    @ApiOperation("删除用户")
    public void deleteUser(User user);
    @ApiOperation("根据ID查找用户")
    public User getUser(String userId);

}


