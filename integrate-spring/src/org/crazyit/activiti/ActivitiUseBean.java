package org.crazyit.activiti;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActivitiUseBean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"activiti.use.bean.xml"});
		// �õ� Activiti �ķ������
		RepositoryService repositoryService = (RepositoryService)ctx.getBean("repositoryService");
		RuntimeService runtimeService = (RuntimeService)ctx.getBean("runtimeService");
		// ���������ļ�
		repositoryService.createDeployment().addClasspathResource("bpmn/ActivitiUseBean.bpmn").deploy();
		// ��ʼ�����̲���
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("name", "crazyit");
		// ��������
		runtimeService.startProcessInstanceByKey("process1", vars);
	}

}
