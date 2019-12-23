package org.crazyit.activiti;

import java.util.List;
import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������������
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// �õ���ݷ������ʵ��
		IdentityService identityService = engine.getIdentityService();
		// д��5���û�������
		createGroup(identityService, UUID.randomUUID().toString(), "1", "typeA");
		createGroup(identityService, UUID.randomUUID().toString(), "2", "typeB");
		createGroup(identityService, UUID.randomUUID().toString(), "3", "typeC");
		createGroup(identityService, UUID.randomUUID().toString(), "4", "typeD");
		createGroup(identityService, UUID.randomUUID().toString(), "5", "typeE");
		//����orderByGroupId��asc���������Ϊ����ID��������
		System.out.println("asc��������");
		List<Group> datas = identityService.createGroupQuery().orderByGroupName().asc().list();
		for (Group data : datas) {
			System.out.println("    " + data.getId() + "---" + data.getName());
		}
		System.out.println("desc������");
		//����orderByGroupName��desc���������Ϊ���ƽ�������
		datas = identityService.createGroupQuery().orderByGroupName().desc().list();
		for (Group data : datas) {
			System.out.println("    " + data.getId() + "---" + data.getName());
		}
	}
	
	// ���û������ݱ��浽���ݿ���
	static void createGroup(IdentityService identityService, String id,
			String name, String type) {
		// ����newGroup��������Groupʵ��
		Group group = identityService.newGroup(id);
		group.setName(name);
		group.setType(type);
		identityService.saveGroup(group);
	}

}
