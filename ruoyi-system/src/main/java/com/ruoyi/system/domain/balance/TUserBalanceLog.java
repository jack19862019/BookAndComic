package com.ruoyi.system.domain.balance;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户充值，提现对象 t_user_balance_log
 *
 * @author ruoyi
 * @date 2020-04-16
 */
public class TUserBalanceLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 订单金额 */
    @Excel(name = "订单金额")
    private Double orderFee;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderNo;

    /** 订单类型 */
    @Excel(name = "订单类型")
    private String orderType;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Long userId;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String userName;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setOrderFee(Double orderFee)
    {
        this.orderFee = orderFee;
    }

    public Double getOrderFee()
    {
        return orderFee;
    }
    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo()
    {
        return orderNo;
    }
    public void setOrderType(String orderType)
    {
        this.orderType = orderType;
    }

    public String getOrderType()
    {
        return orderType;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("orderFee", getOrderFee())
            .append("orderNo", getOrderNo())
            .append("orderType", getOrderType())
            .append("status", getStatus())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .toString();
    }
}
