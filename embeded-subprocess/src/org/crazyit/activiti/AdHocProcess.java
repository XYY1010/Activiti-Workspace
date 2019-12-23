package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * 
 * @author xyy
 *
 */
public class AdHocProcess {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ������������
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// �õ����̴洢�������
		RepositoryService repositoryService = processEngine
				.getRepositoryService();
		// �õ�����ʱ�������
		RuntimeService runtimeService = processEngine.getRuntimeService();
		TaskService taskService = processEngine.getTaskService();
		// ���������ļ�
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/AdHocProcess.bpmn").deploy();
		// ��������
		ProcessInstance pi = runtimeService
				.startProcessInstanceByKey("simpleSubProcess");
		System.out.println("��ʼ���̺�ִ����������" + runtimeService
				.createExecutionQuery().processInstanceId(pi.getId()).count());
		// ��ѯ�����̵�ִ����
		Execution exe = runtimeService.createExecutionQuery()
				.processInstanceId(pi.getId()).activityId("adhocSubProcess")
				.singleResult();
		// ��ִ��������ڶ�������
		runtimeService.executeActivityInAdhocSubProcess(exe.getId(), 
				"subProcessTask2");
		// ��ѯִ��������
		System.out.println("��ִ��������ڶ��������ִ����������" + runtimeService
				.createExecutionQuery().processInstanceId(pi.getId()).count());
		// ��ɵڶ�������
		Task subprocessTask2 = taskService.createTaskQuery()
				.processInstanceId(pi.getId())
				.taskDefinitionKey("subProcessTask2").singleResult();
		taskService.complete(subprocessTask2.getId());
		// ��ѯִ��������
		System.out.println("��������̵ĵڶ��������ִ����������" + runtimeService
				.createExecutionQuery().processInstanceId(pi.getId()).count());
		// ����ر�������
		runtimeService.completeAdhocSubProcess(exe.getId());
		
		// ��ѯ����
		System.out.println("��������ر������̺󣬵�ǰ�������ƣ�" + taskService
				.createTaskQuery().processInstanceId(pi.getId()).singleResult()
				.getName());
		
	}

}
