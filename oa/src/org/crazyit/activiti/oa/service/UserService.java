package org.crazyit.activiti.oa.service;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.crazyit.activiti.oa.action.bean.UserVO;

import java.util.List;

/**
 * 用户服务接口
 * @Author: xyy
 * @Date: 2019/12/24 15:58
 */
public interface UserService {

    /**
     * 查询全部用户
     */
    List<UserVO> list();

    /**
     * 保存一个用户
     */
    void save(UserVO userForm);

    /**
     * 删除一个用户
     * @param userId
     */
    void delete(String userId);

    /**
     * 验证用户身份（根据用户名称和密码）
     * @param userForm
     * @return User
     */
    User loginValidate(UserVO userForm);

    /**
     * 根据用户查询他所在的用户组
     * @param userId
     * @return Group
     */
    Group getGroup(String userId);
}
