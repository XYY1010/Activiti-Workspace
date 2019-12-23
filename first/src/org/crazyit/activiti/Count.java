package org.crazyit.activiti;

import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class Count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ������������
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// �õ���ݷ������ʵ��
		IdentityService identityService = engine.getIdentityService();
		// д��5���û�������
		createGroup(identityService, UUID.randomUUID().toString(), "GroupA", "typeA");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupB", "typeB");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupC", "typeC");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupD", "typeD");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupE", "typeE");
		// ʹ��list������ѯȫ���Ĳ�������
		long size = identityService.createGroupQuery().count();
		System.out.println("Group ������" + size);
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
