package com.ruoyi.system.domain.site;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 第三方支付配置对象 t_pay_config
 *
 * @author ruoyi
 * @date 2020-04-11
 */
public class TPayConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 商户密钥 */
    @Excel(name = "商户密钥")
    private String companyKey;

    /** 商户号 */
    @Excel(name = "商户号")
    private String companyNo;

    /** 支付名称 */
    @Excel(name = "支付名称")
    private String payCompanyName;

    /** 启用状态 */
    @Excel(name = "启用状态")
    private Integer status = 0;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCompanyKey(String companyKey)
    {
        this.companyKey = companyKey;
    }

    public String getCompanyKey()
    {
        return companyKey;
    }
    public void setCompanyNo(String companyNo)
    {
        this.companyNo = companyNo;
    }

    public String getCompanyNo()
    {
        return companyNo;
    }
    public void setPayCompanyName(String payCompanyName)
    {
        this.payCompanyName = payCompanyName;
    }

    public String getPayCompanyName()
    {
        return payCompanyName;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("companyKey", getCompanyKey())
            .append("companyNo", getCompanyNo())
            .append("payCompanyName", getPayCompanyName())
            .append("status", getStatus())
            .toString();
    }
}
