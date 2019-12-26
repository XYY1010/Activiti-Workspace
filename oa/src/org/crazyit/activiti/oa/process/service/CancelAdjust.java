package org.crazyit.activiti.oa.process.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * @Author: xyy
 * @Date: 2019/12/26 9:14
 */
public class CancelAdjust implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("取消调整========");
    }
}
