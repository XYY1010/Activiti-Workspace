package org.crazyit.activiti.oa.service.impl;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.crazyit.activiti.oa.service.GroupService;

import java.util.List;

/**
 * 用户组服务实现类
 * @Author: xyy
 * @Date: 2019/12/24 15:48
 */
public class GroupServiceImpl implements GroupService {

    private IdentityService identityService;

    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }

    @Override
    public List<Group> list() {
        return identityService.createGroupQuery().list();
    }
}
