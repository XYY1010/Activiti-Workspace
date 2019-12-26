package org.crazyit.activiti.oa.service;

import org.activiti.engine.identity.Group;

import java.util.List;

/**
 * 用户组服务接口
 * @Author: xyy
 * @Date: 2019/12/24 15:46
 */
public interface GroupService {
    /**
     * 查询全部的用户组
     */
    List<Group> list();
}
