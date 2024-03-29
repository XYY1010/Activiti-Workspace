package org.crazyit.activiti.oa.service.impl;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.crazyit.activiti.oa.action.bean.UserVO;
import org.crazyit.activiti.oa.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 用户服务实现类
 * @Author: xyy
 * @Date: 2019/12/24 16:03
 */
public class UserServiceImpl implements UserService {

    // Activiti 身份服务组件
    private IdentityService identityService;

    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }

    // 查询全部用户
    @Override
    public List<UserVO> list() {
        List<User> users = this.identityService.createUserQuery().list();
        List<UserVO> result = new ArrayList<>();
        for (User user : users) {
            UserVO userVO = new UserVO();
            userVO.setUserId(user.getId());
            userVO.setLastName(user.getLastName());
            // 查询用户组信息
            Group group =
                    this.identityService.createGroupQuery().groupMember(
                            user.getId()).singleResult();
            // 查询年龄信息
            String age = identityService.getUserInfo(user.getId(), "age");
            userVO.setGroupName(group.getName());
            userVO.setAge(Integer.parseInt(age));
            result.add(userVO);
        }
        return result;
    }

    // 新建一个用户
    @Override
    public void save(UserVO userForm) {
        // 生成一个唯一的用户 id
        String uuid = UUID.randomUUID().toString();
        User user = this.identityService.newUser(uuid);
        user.setLastName(userForm.getLastName());
        user.setPassword(userForm.getPasswd());
        this.identityService.saveUser(user);
        // 加入年龄信息
        this.identityService.setUserInfo(user.getId(), "age",
                String.valueOf(userForm.getAge()));
        // 设置与用户组的关系
        this.identityService.createMembership(user.getId(),
                userForm.getGroupId());
    }

    @Override
    public void delete(String userId) {
        this.identityService.deleteUser(userId);
    }

    // 验证用户
    @Override
    public User loginValidate(UserVO userForm) {
        // 根据用户的名称查询用户
        User user =
                this.identityService.createUserQuery()
                        .userLastName(userForm.getLastName()).singleResult();
        if (user == null) {
            return null;
        }
        // 验证密码
        if (userForm.getPasswd().equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public Group getGroup(String userId) {
        return this.identityService.createGroupQuery().groupMember(userId)
                .singleResult();
    }
}
