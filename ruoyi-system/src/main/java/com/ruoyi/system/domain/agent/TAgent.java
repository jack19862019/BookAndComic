package com.ruoyi.system.domain.agent;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 代理对象 t_agent
 *
 * @author ruoyi
 * @date 2020-04-19
 */
public class TAgent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 支付宝账号 */
    private String aliAccount;

    /** 支付宝姓名 */
    private String aliName;

    /** 余额 */
    @Excel(name = "余额")
    private Double balance;

    /** 推广二维码 */
    @Excel(name = "推广二维码")
    private String gqrCode;

    /** 代理账号 */
    private String name;

    /** 密码 */
    private String password;

    /** 电话 */
    private String phone;

    /** 代理昵称 */
    @Excel(name = "代理昵称")
    private String proxyNickName;

    /** 扣除比例 */
    private Float ratio;

    /** 返佣比例 */
    @Excel(name = "返佣比例")
    private Float separate;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private Long status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setAliAccount(String aliAccount)
    {
        this.aliAccount = aliAccount;
    }

    public String getAliAccount()
    {
        return aliAccount;
    }
    public void setAliName(String aliName)
    {
        this.aliName = aliName;
    }

    public String getAliName()
    {
        return aliName;
    }
    public void setBalance(Double balance)
    {
        this.balance = balance;
    }

    public Double getBalance()
    {
        return balance;
    }
    public void setGqrCode(String gqrCode)
    {
        this.gqrCode = gqrCode;
    }

    public String getGqrCode()
    {
        return gqrCode;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setProxyNickName(String proxyNickName)
    {
        this.proxyNickName = proxyNickName;
    }

    public String getProxyNickName()
    {
        return proxyNickName;
    }
    public void setRatio(Float ratio)
    {
        this.ratio = ratio;
    }

    public Float getRatio()
    {
        return ratio;
    }
    public void setSeparate(Float separate)
    {
        this.separate = separate;
    }

    public Float getSeparate()
    {
        return separate;
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
            .append("aliAccount", getAliAccount())
            .append("aliName", getAliName())
            .append("balance", getBalance())
            .append("gqrCode", getGqrCode())
            .append("name", getName())
            .append("password", getPassword())
            .append("phone", getPhone())
            .append("proxyNickName", getProxyNickName())
            .append("ratio", getRatio())
            .append("separate", getSeparate())
            .append("status", getStatus())
            .toString();
    }
}
