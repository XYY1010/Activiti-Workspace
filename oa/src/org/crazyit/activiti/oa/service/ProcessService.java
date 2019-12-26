package org.crazyit.activiti.oa.service;

import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.crazyit.activiti.oa.action.bean.*;

import java.io.InputStream;
import java.util.List;

/**
 * @Author: xyy
 * @Date: 2019/12/25 9:56
 */
public interface ProcessService {

    /**
     * 启动一个请假流程
     * @param vacationForm
     * @return
     */
    ProcessInstance startVacation(VacationForm vacationForm);

    /**
     * 启动一个薪资调整流程
     * @param salaryForm
     * @return
     */
    ProcessInstance startSalaryAdjust(SalaryForm salaryForm);

    /**
     * 启动一个报销流程
     * @param expenseAccountForm
     * @return
     */
    ProcessInstance startExpenseAccount(ExpenseAccountForm expenseAccountForm);

    /**
     * 查询一个用户全部的请假申请
     * @param userId
     * @return
     */
    List<ProcessVO> listVacation(String userId);

    /**
     * 查询一个用户全部的报销申请
     * @param userId
     * @return
     */
    List<ProcessVO> listExpenseAccount(String userId);

    /**
     * 查询一个用户全部的薪资调整申请
     * @param userId
     * @return
     */
    List<ProcessVO> listSalaryAdjust(String userId);

    /**
     * 查询一个用户相关的全部候选任务
     * @param userId
     * @return
     */
    List<TaskVO> listTasks(String userId);

    /**
     * 查询一个用户受理的全部任务
     * @param userId
     * @return
     */
    List<TaskVO> listAssigneeTasks(String userId);

    /**
     * 分配任务受理人
     * @param taskId
     * @param userId
     */
    void claim(String taskId, String userId);

    /**
     * 根据任务 ID，查询用户填写的表单数据
     * @param taskId
     * @return
     */
    List<FormField> getFormFields(String taskId);

    /**
     * 查询一个流程的全部评论
     * @param taskId
     * @return
     */
    List<CommentVO> getComments(String taskId);

    /**
     * 完成任务并添加评论
     */
    void complete(String taskId, String content, String userId);

    /**
     * 取消薪资调整
     * @param taskId
     * @param comment
     * @param userId
     */
    void cancelAdjust(String taskId, String comment, String userId);

    /**
     * 获取流程图
     * @param processInstanceId
     * @return
     */
    InputStream getDiagram(String processInstanceId);

    /**
     * 系统记录薪资，由 ServiceTask 调用
     * @param exe
     */
    void recordSalary(Execution exe);

    /**
     * 银行转账，由 ServiceTask 调用
     * @param exe
     */
    void bankTransfer(Execution exe);

    /**
     * 取消薪资调整，由 ServiceTask 调用
     * @param exe
     */
    void cancelAdjust(Execution exe);
}
