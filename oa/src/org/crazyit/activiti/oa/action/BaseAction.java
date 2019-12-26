package org.crazyit.activiti.oa.action;

import com.opensymphony.xwork2.Action;

/**
 * @Author: xyy
 * @Date: 2019/12/24 13:54
 */
public class BaseAction implements Action {
    @Override
    public String execute() throws Exception {
        return "";
    }

    // 测试方法
    public String test() {
        System.out.println("test method");
        return SUCCESS;
    }
}
