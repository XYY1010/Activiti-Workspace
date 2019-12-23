package org.crazyit.activiti;

import java.util.HashMap;
import java.util.Map;

import org.activiti.dmn.api.DmnDecisionTable;
import org.activiti.dmn.api.DmnDeployment;
import org.activiti.dmn.api.DmnRepositoryService;
import org.activiti.dmn.api.DmnRuleService;
import org.activiti.dmn.api.RuleEngineExecutionResult;
import org.activiti.dmn.engine.DmnEngine;
import org.activiti.dmn.engine.DmnEngineConfiguration;

public class FirstDmn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����Ĭ�����ô������������ʵ��
        DmnEngineConfiguration config = DmnEngineConfiguration
                .createDmnEngineConfigurationFromResourceDefault();
        // ������������
        DmnEngine engine = config.buildDmnEngine();
        // ��ȡ����Ĵ洢�������
        DmnRepositoryService rService = engine.getDmnRepositoryService();
        // ��ȡ����������
        DmnRuleService ruleService = engine.getDmnRuleService();
        // ���й��� ����
        DmnDeployment dep = rService.createDeployment()
                .addClasspathResource("dmn/first.dmn").deploy();
        // �������ݲ�ѯ
        DmnDecisionTable dt = rService.createDecisionTableQuery()
                .deploymentId(dep.getId()).singleResult();
        // ��ʼ������
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("personAge", 19);
        // �������ִ�о��ߣ������ؽ��
        RuleEngineExecutionResult result = ruleService.executeDecisionByKey(
                dt.getKey(), params);
        // ����̨������
        System.out.println(result.getResultVariables().get("myResult"));
        // �������ò���
        params.put("personAge", 5);
        // ����ִ�о���
        result = ruleService.executeDecisionByKey(dt.getKey(), params);
        // ����̨����������
        System.out.println(result.getResultVariables().get("myResult"));
	}

}
