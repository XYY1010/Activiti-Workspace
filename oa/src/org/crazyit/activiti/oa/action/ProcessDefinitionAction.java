package org.crazyit.activiti.oa.action;

import org.activiti.engine.repository.ProcessDefinition;
import org.crazyit.activiti.oa.action.BaseAction;
import org.crazyit.activiti.oa.service.ProcessDefinitionService;

import java.util.List;

/**
 * @Author: xyy
 * @Date: 2019/12/26 9:03
 */
public class ProcessDefinitionAction extends BaseAction {

    private ProcessDefinitionService processDefinitionService;

    private List<ProcessDefinition> defs;

    public List<ProcessDefinition> getDefs() {
        return defs;
    }

    public void setProcessDefinitionService(
            ProcessDefinitionService processDefinitionService) {
        this.processDefinitionService = processDefinitionService;
    }

    public String list() {
        this.defs = this.processDefinitionService.list();
        return SUCCESS;
    }
}
