package com.ruoyi.system.domain.agent;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 充值记录对象 t_agent_balance_log
 *
 * @author ruoyi
 * @date 2020-04-19
 */
public class TAgentBalanceLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 充值金额 */
    @Excel(name = "充值金额")
    private Double money;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNo;

    /** 订单类型 */
    private Long orderType;

    /** 用户id */
    private Long userId;

    /** 代理id */
    private Long proxyId;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    private String beginMoney;

    private String endMoney;
    /**用户名称**/
    private String userName;
    /**代理昵称**/
    private String proxyNickName;

    public String getProxyNickName() {
        return proxyNickName;
    }

    public void setProxyNickName(String proxyNickName) {
        this.proxyNickName = proxyNickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBeginMoney() {
        return beginMoney;
    }

    public void setBeginMoney(String beginMoney) {
        this.beginMoney = beginMoney;
    }

    public String getEndMoney() {
        return endMoney;
    }

    public void setEndMoney(String endMoney) {
        this.endMoney = endMoney;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setMoney(Double money)
    {
        this.money = money;
    }

    public Double getMoney()
    {
        return money;
    }
    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo()
    {
        return orderNo;
    }
    public void setOrderType(Long orderType)
    {
        this.orderType = orderType;
    }

    public Long getOrderType()
    {
        return orderType;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
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
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("money", getMoney())
            .append("orderNo", getOrderNo())
            .append("orderType", getOrderType())
            .append("userId", getUserId())
            .append("proxyId", getProxyId())
            .append("status", getStatus())
            .toString();
    }
}
