package com.ruoyi.web.controller.system.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class TAgentParams {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 编号 */
    private Long id;

    /** 余额 */
    private Double balance;

    /** 推广二维码 */
    private String gqrCode;

    /** 代理账号 */
    private String name;

    /** 代理昵称 */
    private String proxyNickName;

    /** 扣除比例 */
    private Float ratio;

    /** 返佣比例 */
    private Float separate;

    /** 审核状态 */
    private Long status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
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

    public Float getSeparate() {
        return separate;
    }

    public void setSeparate(Float separate) {
        this.separate = separate;
    }

    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("createTime", getCreateTime())
                .append("balance", getBalance())
                .append("gqrCode", getGqrCode())
                .append("name", getName())
                .append("proxyNickName", getProxyNickName())
                .append("ratio", getRatio())
                .append("separate", getSeparate())
                .append("status", getStatus())
                .toString();
    }
}
