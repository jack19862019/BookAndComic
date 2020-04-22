package com.ruoyi.system.domain.withdrawal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 提现记录对象 t_agent_withdrawal_log
 *
 * @author ruoyi
 * @date 2020-04-22
 */
public class TAgentWithdrawalLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNo;

    /** 提现金额 */
    @Excel(name = "提现金额")
    private Double money;

    /** 代理ID */
    @Excel(name = "代理ID")
    private Long proxyId;
    private String proxyName;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    public String getProxyName() {
        return proxyName;
    }

    public void setProxyName(String proxyName) {
        this.proxyName = proxyName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo()
    {
        return orderNo;
    }
    public void setMoney(Double money)
    {
        this.money = money;
    }

    public Double getMoney()
    {
        return money;
    }
    public void setProxyId(Long proxyId)
    {
        this.proxyId = proxyId;
    }

    public Long getProxyId()
    {
        return proxyId;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderNo", getOrderNo())
            .append("money", getMoney())
            .append("proxyId", getProxyId())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
