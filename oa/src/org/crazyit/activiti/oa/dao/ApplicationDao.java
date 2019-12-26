package org.crazyit.activiti.oa.dao;

import org.crazyit.activiti.oa.entity.ExpenseAccount;
import org.crazyit.activiti.oa.entity.SalaryAdjust;
import org.crazyit.activiti.oa.entity.Vacation;

import java.util.List;

/**
 * @Author: xyy
 * @Date: 2019/12/25 10:58
 */
public interface ApplicationDao {

    /**
     * 保存一次请假记录到 OA_VACATION 表中
     * @param vac
     */
    void saveVacation(Vacation vac);

    /**
     * 根据用户查询请假记录
     * @param userId
     * @return
     */
    List<Vacation> listVacation(String userId);

    /**
     * 保存一次薪资调整记录到 OA_SALARY_ADJUST 表中
     * @param salaryAdjust
     */
    void saveSalaryAdjust(SalaryAdjust salaryAdjust);

    /**
     * 保存一次报销申请到 OA_EXPENSE_ACCOUNT 表中
     * @param expenseAccount
     */
    void saveExpenseAccount(ExpenseAccount expenseAccount);

    /**
     * 根据用户查询薪资调整申请记录
     * @param userId
     * @return
     */
    List<SalaryAdjust> listSalaryAdjust(String userId);

    /**
     * 根据用户查询报销记录
     * @param userId
     * @return
     */
    List<ExpenseAccount> listExpenseAccount(String userId);
}
