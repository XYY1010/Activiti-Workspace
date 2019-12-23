package org.crazyit.activiti;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DeployModeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ��ʼ��Sprin���������������ļ�
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "activiti.cfg.xml" });
		// �����������ö���
		SpringProcessEngineConfiguration engineConfig = (SpringProcessEngineConfiguration) ctx
				.getBean("processEngineConfiguration");
		// ���ò�����Դ������defaultֵ
		Resource[] res = createResources(new String[] {
				"bpmn/default-config/1.txt", "bpmn/default-config/2.txt" });
		engineConfig.setDeploymentResources(res);
		/*
		 * ���ò���ģʽΪdefault��Ĭ��ֵ��
		 */
		engineConfig.setDeploymentMode("default");
		// ������������
		ProcessEngine engine = engineConfig.buildProcessEngine();
		// ��ѯ��������
		long depCount = engine.getRepositoryService().createDeploymentQuery()
				.count();
		System.out.println("����ģʽΪĬ��ֵ�������������" + depCount);
		// �ر���������
		engine.close();
		/*
		 * �������ò���ģʽΪ resource-parent-folder
		 */
		res = createResources(new String[] {
				"bpmn/parent-folder/folder1/3.txt",
				"bpmn/parent-folder/folder1/4.txt",
				"bpmn/parent-folder/folder2/5.txt",
				"bpmn/parent-folder/folder2/6.txt" });
		engineConfig.setDeploymentResources(res);
		engineConfig.setDeploymentMode("resource-parent-folder");
		engineConfig.buildProcessEngine();
		depCount = engine.getRepositoryService().createDeploymentQuery()
				.count();
		System.out.println("����ģʽΪ resource-parent-folder�������������" + depCount);
		engine.close();
		/*
		 * �������ò���ģʽΪ single-resource
		 */
		res = createResources(new String[] { "bpmn/single-resource/7.txt",
				"bpmn/single-resource/8.txt" });
		engineConfig.setDeploymentResources(res);
		engineConfig.setDeploymentMode("single-resource");
		engineConfig.buildProcessEngine();
		depCount = engine.getRepositoryService().createDeploymentQuery()
				.count();
		System.out.println("����ģʽΪ single-resource�������������" + depCount);
		engine.close();
	}
	
	/**
	 * ������Դ����
	 */
	private static Resource[] createResources(String[] paths) {
		List<Resource> res = new ArrayList<Resource>();
		for (String path : paths) {
			Resource r = new ClassPathResource(path);
			res.add(r);
		}
		return res.toArray(new Resource[] {});
	}

}
