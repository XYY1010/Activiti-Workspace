package org.crazyit.activiti.oa.service.impl;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.crazyit.activiti.oa.service.ProcessDefinitionService;

import java.util.List;

/**
 * @Author: xyy
 * @Date: 2019/12/26 9:06
 */
public class ProcessDefinitionServiceImpl implements ProcessDefinitionService {

    private RepositoryService repositoryService;

    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @Override
    public List<ProcessDefinition> list() {
        return this.repositoryService.createProcessDefinitionQuery().list();
    }
}
