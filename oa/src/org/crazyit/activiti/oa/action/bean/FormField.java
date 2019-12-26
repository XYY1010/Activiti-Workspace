package org.crazyit.activiti.oa.action.bean;

import java.io.Serializable;

/**
 * @Author: xyy
 * @Date: 2019/12/25 9:24
 */
public class FormField implements Serializable {
    // 表单域的文本
    private String fieldText;

    // 表单域的值
    private String fieldValue;

    public FormField(String fieldText, String fieldValue) {
        this.fieldText = fieldText;
        this.fieldValue = fieldValue;
    }

    public String getFieldText() {
        return fieldText;
    }

    public void setFieldText(String fieldText) {
        this.fieldText = fieldText;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
