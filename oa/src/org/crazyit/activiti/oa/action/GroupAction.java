package org.crazyit.activiti.oa.action;

import org.activiti.engine.identity.Group;
import org.crazyit.activiti.oa.service.GroupService;
import org.hibernate.cfg.beanvalidation.GroupsPerOperation;

import java.util.List;

/**
 * 用户组 Action 控制器
 * @Author: xyy
 * @Date: 2019/12/24 15:44
 */
public class GroupAction extends BaseAction {

    // 用户组服务对象
    private GroupService groupService;

    private List<Group> groups;

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    public List<Group> getGroups() {
        return this.groups;
    }

    // 查询全部的用户组
    public String list() {
        this.groups = groupService.list();
        return SUCCESS;
    }
}
