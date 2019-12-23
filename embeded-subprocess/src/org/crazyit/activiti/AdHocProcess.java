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
		// 创建流程引擎
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务组件
		RepositoryService repositoryService = processEngine
				.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = processEngine.getRuntimeService();
		TaskService taskService = processEngine.getTaskService();
		// 部署流程文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/AdHocProcess.bpmn").deploy();
		// 启动流程
		ProcessInstance pi = runtimeService
				.startProcessInstanceByKey("simpleSubProcess");
		System.out.println("开始流程后，执行流数量：" + runtimeService
				.createExecutionQuery().processInstanceId(pi.getId()).count());
		// 查询子流程的执行流
		Execution exe = runtimeService.createExecutionQuery()
				.processInstanceId(pi.getId()).activityId("adhocSubProcess")
				.singleResult();
		// 让执行流到达第二个任务
		runtimeService.executeActivityInAdhocSubProcess(exe.getId(), 
				"subProcessTask2");
		// 查询执行流数量
		System.out.println("让执行流到达第二个任务后，执行流数量：" + runtimeService
				.createExecutionQuery().processInstanceId(pi.getId()).count());
		// 完成第二个任务
		Task subprocessTask2 = taskService.createTaskQuery()
				.processInstanceId(pi.getId())
				.taskDefinitionKey("subProcessTask2").singleResult();
		taskService.complete(subprocessTask2.getId());
		// 查询执行流数量
		System.out.println("完成子流程的第二个任务后，执行流数量：" + runtimeService
				.createExecutionQuery().processInstanceId(pi.getId()).count());
		// 完成特别子流程
		runtimeService.completeAdhocSubProcess(exe.getId());
		
		// 查询数量
		System.out.println("完成整个特别子流程后，当前任务名称：" + taskService
				.createTaskQuery().processInstanceId(pi.getId()).singleResult()
				.getName());
		
	}

}
