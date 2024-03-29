package org.crazyit.activiti.oa.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: xyy
 * @Date: 2019/12/24 14:21
 */
@Entity
@Table(name = "OA_SALARY_ADJUST")
public class SalaryAdjust {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;

    // 用户 ID
    @Column(name = "USER_ID")
    private String userId;

    // 调整金额
    @Column(name = "ADJUST_MONEY", scale = 2)
    private BigDecimal adjustMoney;

    // 日期
    @Column(name = "DATE")
    private Date date;

    // 描述
    @Column(name = "DSCP")
    private String dscp;

    // 流程实例
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

    public BigDecimal getAdjustMoney() {
        return adjustMoney;
    }

    public void setAdjustMoney(BigDecimal adjustMoney) {
        this.adjustMoney = adjustMoney;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDscp() {
        return dscp;
    }

    public void setDscp(String dscp) {
        this.dscp = dscp;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }
}
