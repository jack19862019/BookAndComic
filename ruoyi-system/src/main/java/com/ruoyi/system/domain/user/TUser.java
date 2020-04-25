package com.ruoyi.system.domain.user;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户基本信息对象 t_user
 *
 * @author ruoyi
 * @date 2020-04-15
 */
public class TUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 支付宝账号 */
    @Excel(name = "支付宝账号")
    private String aliAccount;

    /** 支付宝名称 */
    @Excel(name = "支付宝名称")
    private String aliName;

    /** 余额 */
    @Excel(name = "余额")
    private Double balance;

    /** 书币 */
    @Excel(name = "书币")
    private Long bookCurrency;

    /** vip状态 */
    @Excel(name = "vip状态")
    private Long isVip;

    /** 来源代理 */
    @Excel(name = "来源代理")
    private Long proxyId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private String userNo;

    /** 用户来源 */
    @Excel(name = "用户来源")
    private Long userSource;

    /** 父级id */
    @Excel(name = "父级id")
    private String parentId;
    public String getParentId()
    {
        return parentId;
    }
    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }

    /** 上一级编号 */
    @Excel(name = "上一级编号")
    private String onFirstId;
    public String getOnFirstId()
    {
        return onFirstId;
    }
    public void setOnFirstId(String onFirstId)
    {
        this.onFirstId = onFirstId;
    }
    /** 上二级编号 */
    @Excel(name = "上二级编号")
    private String onSecondId;
    public String getOnSecondId()
    {
        return onSecondId;
    }
    public void setOnSecondId(String onSecondId)
    {
        this.onSecondId = onSecondId;
    }

    /** 一级下线 */
    @Excel(name = "一级下线")
    private String firstNum;
    public String getFirstNum()
    {
        return firstNum;
    }
    public void setFirstNum(String firstNum)
    {
        this.firstNum = firstNum;
    }

    /** 二级下线 */
    @Excel(name = "二级下线")
    private String secondNum;
    public String getSecondNum()
    {
        return secondNum;
    }
    public void setSecondNum(String secondNum)
    {
        this.secondNum = secondNum;
    }

    /** 三级下线 */
    @Excel(name = "三级下线")
    private String thirdNum;
    public String getThirdNum()
    {
        return thirdNum;
    }
    public void setThirdNum(String thirdNum)
    {
        this.thirdNum = thirdNum;
    }

    /**代理昵称**/
    private String proxyNickName;

    public String getProxyNickName() {
        return proxyNickName;
    }

    public void setProxyNickName(String proxyNickName) {
        this.proxyNickName = proxyNickName;
    }

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
    public void setBookCurrency(Long bookCurrency)
    {
        this.bookCurrency = bookCurrency;
    }

    public Long getBookCurrency()
    {
        return bookCurrency;
    }
    public void setIsVip(Long isVip)
    {
        this.isVip = isVip;
    }

    public Long getIsVip()
    {
        return isVip;
    }
    public void setProxyId(Long proxyId)
    {
        this.proxyId = proxyId;
    }

    public Long getProxyId()
    {
        return proxyId;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setUserNo(String userNo)
    {
        this.userNo = userNo;
    }

    public String getUserNo()
    {
        return userNo;
    }
    public void setUserSource(Long userSource)
    {
        this.userSource = userSource;
    }

    public Long getUserSource()
    {
        return userSource;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("aliAccount", getAliAccount())
                .append("aliName", getAliName())
                .append("balance", getBalance())
                .append("bookCurrency", getBookCurrency())
                .append("isVip", getIsVip())
                .append("proxyId", getProxyId())
                .append("userName", getUserName())
                .append("userNo", getUserNo())
                .append("userSource", getUserSource())
                .toString();
    }
}
