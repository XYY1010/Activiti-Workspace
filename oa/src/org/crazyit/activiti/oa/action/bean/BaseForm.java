package org.crazyit.activiti.oa.action.bean;

import org.crazyit.activiti.oa.util.DateUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 表单基类
 * @Author: xyy
 * @Date: 2019/12/25 9:17
 */
public abstract class BaseForm implements Serializable {

    // 申请日期
    private String requestDate = DateUtil.getTodayString();

    // 申请人 id
    private String userId;

    // 申请标题
    private String title;

    // 申请人名称
    private String userName;

    // 单据类型
    private String businessType;

    // 表单的域
    private List<FormField> fields = new ArrayList<>();

    // 用于存放 FormField 对象
    private Map<String, FormField> fieldMap = new HashMap<>();

    // 请假类型
    public final static String VACATION = "vacation";
    public final static String SALARY = "salary";
    public final static String EXPENSE = "expense";

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    // 返回表单属性和值
    public List<FormField> getFormFields() {
        this.fields.add(getFormField("requestDate", "申请时间", this.requestDate));
        this.fields.add(getFormField("title", "标题", this.title));
        this.fields.add(getFormField("userName", "申请用户", this.userName));
        this.fields.add(getFormField("businessType", "单据类型",
                this.businessType));
        createFormFields(this.fields);
        return fields;
    }

    protected FormField getFormField(String key, String text, String value) {
        if (fieldMap.get(key) == null) {
            FormField field = new FormField(text, value);
            fieldMap.put(key, field);
        }
        return fieldMap.get(key);
    }

    // 由子类设置表单属性
    public abstract void createFormFields(List<FormField> fields);
}
