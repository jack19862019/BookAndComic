package com.ruoyi.system.domain.currency;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户书币变动记录对象 t_user_currency_log
 *
 * @author ruoyi
 * @date 2020-04-17
 */
public class TUserCurrencyLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 本次变动书币 */
    @Excel(name = "本次变动书币")
    private Long currency;

    /** 本次变动类型 */
    @Excel(name = "本次变动类型")
    private Long currencyType;

    /** 书币来源 */
    @Excel(name = "书币来源")
    private String otherUserId;

    /** 用户ID */
    @Excel(name = "用户ID")
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
    public void setCurrency(Long currency)
    {
        this.currency = currency;
    }

    public Long getCurrency()
    {
        return currency;
    }
    public void setCurrencyType(Long currencyType)
    {
        this.currencyType = currencyType;
    }

    public Long getCurrencyType()
    {
        return currencyType;
    }
    public void setOtherUserId(String otherUserId)
    {
        this.otherUserId = otherUserId;
    }

    public String getOtherUserId()
    {
        return otherUserId;
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
            .append("currency", getCurrency())
            .append("currencyType", getCurrencyType())
            .append("otherUserId", getOtherUserId())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .toString();
    }
}
