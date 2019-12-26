package org.crazyit.activiti.oa.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: xyy
 * @Date: 2019/12/24 14:25
 */
@Entity
@Table(name = "OA_EXPENSE_ACCOUNT")
public class ExpenseAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;

    // 申请人
    @Column(name = "USER_ID")
    private String userId;

    // 报销金额
    @Column(name = "MONEY")
    private BigDecimal money;

    // 日期
    @Column(name = "DATE")
    private Date date;

    // 流程实例 ID
    @Column(name = "PROC_INST_ID")
    private String processInstanceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }
}
