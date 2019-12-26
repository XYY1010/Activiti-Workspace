package org.crazyit.activiti.oa.service;

import org.activiti.engine.repository.ProcessDefinition;

import java.util.List;

/**
 * 流程定义服务
 * @Author: xyy
 * @Date: 2019/12/26 9:05
 */
public interface ProcessDefinitionService {
    /**
     * 查询全部的流程定义
     */
    List<ProcessDefinition> list();
}
