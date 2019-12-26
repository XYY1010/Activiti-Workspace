package org.crazyit.activiti.oa.action.bean;

import org.activiti.engine.impl.cmd.SetTimerJobRetriesCmd;

/**
 * @Author: xyy
 * @Date: 2019/12/25 10:25
 */
public class TaskVO {

    // 待办任务表示
    public final static String CANDIDATE = "candidate";

    // 受理任务表示
    public final static String ASSIGNEE = "assignee";

    // 标题
    private String title;

    // 请求用户名称
    private String requestUser;

    // 请求日期
    private String requestDate;

    // 流程实例 id
    private String processInstanceId;

    // 任务 id
    private String taskId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRequestUser() {
        return requestUser;
    }

    public void setRequestUser(String requestUser) {
        this.requestUser = requestUser;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
