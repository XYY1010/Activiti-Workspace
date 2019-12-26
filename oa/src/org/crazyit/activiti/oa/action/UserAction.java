package org.crazyit.activiti.oa.action;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.crazyit.activiti.oa.action.bean.UserVO;
import org.crazyit.activiti.oa.service.GroupService;
import org.crazyit.activiti.oa.service.UserService;
import org.crazyit.activiti.oa.util.DateUtil;

import java.util.List;

/**
 * @Author: xyy
 * @Date: 2019/12/24 16:25
 */
public class UserAction extends BaseAction {

    static Log logger = LogFactory.getLog(UserAction.class);

    private UserService userService;

    private GroupService groupService;

    private List<UserVO> users;

    private List<Group> groups;

    private UserVO userForm;

    private String userId;

    // 用户登录信息
    private String loginMsg;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public GroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    public List<UserVO> getUsers() {
        return users;
    }

    public void setUsers(List<UserVO> users) {
        this.users = users;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public UserVO getUserForm() {
        return userForm;
    }

    public void setUserForm(UserVO userForm) {
        this.userForm = userForm;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginMsg() {
        return loginMsg;
    }

    public void setLoginMsg(String loginMsg) {
        this.loginMsg = loginMsg;
    }

    public String list() {
        this.users = this.userService.list();
        return SUCCESS;
    }

    // 打开添加用户界面时，查询全部用户组
    public String openAddUser() {
        this.groups = this.groupService.list();
        return "openAddUser";
    }

    public String add() {
        // 保存一个用户
        this.userService.save(getUserForm());
        return "add";
    }

    public String delete() {
        this.userService.delete(this.userId);
        return "delete";
    }

    // 用户登录
    public String login() {
        User user = this.userService.loginValidate(userForm);
        if (user != null) {
            // 将用户放到 session 中
            ServletActionContext.getContext().getSession().put("user", user);
            // 将用户组放到 session 中
            Group group = this.userService.getGroup(user.getId());
            ServletActionContext.getContext().getSession().put("group", group);
            logger.info("userId: " + user.getId());
            return "loginSuccess";
        } else {
            this.loginMsg = "用户名或密码错误";
            return "loginFail";
        }
    }
}
