package com.ruoyi.web.controller.system.resp;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 扣量记录对象 t_agent_buckle_log
 *
 * @author ruoyi
 * @date 2020-04-21
 */
public class TAgentBuckleParams extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 充值金额 */
    private Double cMoney;

    /** 扣量金额 */
    private Double kMoney;

    /** 订单编号 */
    private String orderNo;

    /** 代理编号 */
    private Long proxyId;
    private Long proxyName;

    /** null */
    @Excel(name = "null")
    private Long userId;
    private String userName;

    public Long getProxyName() {
        return proxyName;
    }

    public void setProxyName(Long proxyName) {
        this.proxyName = proxyName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setcMoney(Double cMoney)
    {
        this.cMoney = cMoney;
    }

    public Double getcMoney()
    {
        return cMoney;
    }
    public void setkMoney(Double kMoney)
    {
        this.kMoney = kMoney;
    }

    public Double getkMoney()
    {
        return kMoney;
    }
    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo()
    {
        return orderNo;
    }
    public void setProxyId(Long proxyId)
    {
        this.proxyId = proxyId;
    }

    public Long getProxyId()
    {
        return proxyId;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("cMoney", getcMoney())
            .append("kMoney", getkMoney())
            .append("orderNo", getOrderNo())
            .append("proxyId", getProxyId())
            .append("userId", getUserId())
            .toString();
    }
}
