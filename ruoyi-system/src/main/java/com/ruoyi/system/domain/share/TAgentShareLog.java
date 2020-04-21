package com.ruoyi.system.domain.share;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分佣记录对象 t_agent_share_log
 *
 * @author ruoyi
 * @date 2020-04-21
 */
public class TAgentShareLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 充值金额 */
    @Excel(name = "充值金额")
    private Double cMoney;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNo;

    /** 代理ID */
    @Excel(name = "代理ID")
    private Long proxyId;
    private String proxyName;

    /** 分佣金额 */
    @Excel(name = "分佣金额")
    private Double fMoney;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;
    private String userName;

    public String getProxyName() {
        return proxyName;
    }

    public void setProxyName(String proxyName) {
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
    public void setfMoney(Double fMoney)
    {
        this.fMoney = fMoney;
    }

    public Double getfMoney()
    {
        return fMoney;
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
            .append("orderNo", getOrderNo())
            .append("proxyId", getProxyId())
            .append("fMoney", getfMoney())
            .append("userId", getUserId())
            .toString();
    }
}
