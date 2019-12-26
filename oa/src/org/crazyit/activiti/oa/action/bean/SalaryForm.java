package org.crazyit.activiti.oa.action.bean;

import java.util.List;

/**
 * @Author: xyy
 * @Date: 2019/12/25 10:03
 */
public class SalaryForm extends BaseForm {

    // 薪资调整员工
    private String employeeName;

    // 薪资调整员工 ID
    private String employeeId;

    // 调整金额
    private String money;

    // 描述
    private String dscp;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDscp() {
        return dscp;
    }

    public void setDscp(String dscp) {
        this.dscp = dscp;
    }

    @Override
    public void createFormFields(List<FormField> fields) {
        fields.add(super.getFormField("employeeName", "调薪员工", employeeName));
        fields.add(super.getFormField("money", "金额", money));
        fields.add(super.getFormField("dscp", "描述",dscp));
    }
}
