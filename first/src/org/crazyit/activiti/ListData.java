package org.crazyit.activiti;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class ListData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ������������
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// �õ���ݷ������ʵ��
		IdentityService identityService = engine.getIdentityService();
		// д��5 ���û�������
		createGroup(identityService, "1", "GroupA", "typeA");
		createGroup(identityService, "2", "GroupB", "typeB");
		createGroup(identityService, "3", "GroupC", "typeC");
		createGroup(identityService, "4", "GroupD", "typeD");
		createGroup(identityService, "5", "GroupE", "typeE");
		// ʹ��list������ѯȫ���Ĳ�������
		List<Group> datas = identityService.createGroupQuery().list();
		for (Group data : datas) {
			System.out.println(data.getId() + "---" + data.getName() + " ");
		}
	}
	
	// ���û������ݱ��浽���ݿ���
	public static void createGroup(IdentityService identityService, String id, String name, String type) {
		// ���� newGroup �������� Group ʵ��
		Group group = identityService.newGroup(id);
		group.setName(name);
		group.setType(type);
		identityService.saveGroup(group);
	}

}
