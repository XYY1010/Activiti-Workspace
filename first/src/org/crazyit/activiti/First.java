package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
    *    ��һ������������
 * @author xyy
 *
 */
public class First {
	public static void main(String[] args) {
		// ������������
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// �õ����̴洢�������
		RepositoryService repositoryService = engine.getRepositoryService();
		// �õ�����ʱ�������
		RuntimeService runtimeService = engine.getRuntimeService();
		// ��ȡ�����������
		TaskService taskService = engine.getTaskService();
		// ���������ļ�
		repositoryService.createDeployment().addClasspathResource("bpmn/First.bpmn").deploy();
		// ��������
		runtimeService.startProcessInstanceByKey("myProcess");
		// ��ѯ��һ������
		Task task = taskService.createTaskQuery().singleResult();
		System.out.println("��һ���������ǰ����ǰ�������ƣ�" + task.getName());
		// ��ɵ�һ������
		taskService.complete(task.getId());
		// ��ѯ�ڶ�������
		task = taskService.createTaskQuery().singleResult();
		System.out.println("�ڶ����������ǰ����ǰ�������ƣ�" + task.getName());
		// ��ɵڶ����������̽�����
		taskService.complete(task.getId());
		task = taskService.createTaskQuery().singleResult();
		System.out.println("���̽����󣬲�������" + task);
		// �˳�
		System.exit(0);
	}
}
