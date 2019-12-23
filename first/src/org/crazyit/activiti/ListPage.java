package org.crazyit.activiti;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class ListPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������������
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// �õ���ݷ������ʵ��
		IdentityService identityService = engine.getIdentityService();
		// д��5���û�������
		createGroup(identityService, "11", "GroupA", "typeA");
		createGroup(identityService, "12", "GroupB", "typeB");
		createGroup(identityService, "13", "GroupC", "typeC");
		createGroup(identityService, "14", "GroupD", "typeD");
		createGroup(identityService, "15", "GroupE", "typeE");
		//����listPage������������Ϊ2�ļ�¼��ʼ����ѯ3����¼
		List<Group> datas = identityService.createGroupQuery().listPage(2, 3);
		for (Group data : datas) {
			System.out.println(data.getId() + "---" + data.getName() + " ");
		}
	}
	
	// ���û������ݱ��浽���ݿ���
	public static void createGroup(IdentityService identityService, String id,
			String name, String type) {
		// ����newGroup��������Groupʵ��
		Group group = identityService.newGroup(id);
		group.setName(name);
		group.setType(type);
		identityService.saveGroup(group);
	}

}
