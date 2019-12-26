package org.crazyit.activiti.oa.process.service;

import org.activiti.engine.delegate.BpmnError;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.crazyit.activiti.oa.action.bean.ExpenseAccountForm;
import org.crazyit.activiti.oa.entity.ExpenseAccount;

/**
 * @Author: xyy
 * @Date: 2019/12/26 9:11
 */
public class BankTransfer implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        ExpenseAccountForm expenseAccountForm =
                (ExpenseAccountForm) delegateExecution.getVariable("arg");
        if (Integer.parseInt(expenseAccountForm.getMoney()) >= 100) {
            throw new BpmnError("too many");
        } else {
            System.out.println("银行转账成功！");
        }
    }
}
