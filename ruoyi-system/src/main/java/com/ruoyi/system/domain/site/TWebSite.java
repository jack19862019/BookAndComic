package com.ruoyi.system.domain.site;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 站点配置对象 t_web_site
 *
 * @author lucifer
 * @date 2020-04-11
 */
public class TWebSite extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 客服QQ */
    @Excel(name = "客服QQ")
    private String customerQq;

    /** 客服微信 */
    @Excel(name = "客服微信")
    private String customerWx;

    /** 分享赠送 */
    @Excel(name = "分享赠送")
    private Long dayShareGifts;

    /** 漫画默认扣除章节费用 */
    private Long mhDeduct;

    /** 平台二维码 */
    private String platformQrCode;

    /** 充值比例 */
    @Excel(name = "充值比例")
    private Long proportion;

    /** 签到送币 */
    @Excel(name = "签到送币")
    private Long signToGive;

    /** 站点名称 */
    @Excel(name = "站点名称")
    private String siteName;

    /** VIP包年价格 */
    @Excel(name = "VIP包年价格")
    private Long vipYear;

    /** 小说默认扣除章节费用 */
    private Long xsDeduct;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCustomerQq(String customerQq)
    {
        this.customerQq = customerQq;
    }

    public String getCustomerQq()
    {
        return customerQq;
    }
    public void setCustomerWx(String customerWx)
    {
        this.customerWx = customerWx;
    }

    public String getCustomerWx()
    {
        return customerWx;
    }
    public void setDayShareGifts(Long dayShareGifts)
    {
        this.dayShareGifts = dayShareGifts;
    }

    public Long getDayShareGifts()
    {
        return dayShareGifts;
    }
    public void setMhDeduct(Long mhDeduct)
    {
        this.mhDeduct = mhDeduct;
    }

    public Long getMhDeduct()
    {
        return mhDeduct;
    }
    public void setPlatformQrCode(String platformQrCode)
    {
        this.platformQrCode = platformQrCode;
    }

    public String getPlatformQrCode()
    {
        return platformQrCode;
    }
    public void setProportion(Long proportion)
    {
        this.proportion = proportion;
    }

    public Long getProportion()
    {
        return proportion;
    }
    public void setSignToGive(Long signToGive)
    {
        this.signToGive = signToGive;
    }

    public Long getSignToGive()
    {
        return signToGive;
    }
    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }

    public String getSiteName()
    {
        return siteName;
    }
    public void setVipYear(Long vipYear)
    {
        this.vipYear = vipYear;
    }

    public Long getVipYear()
    {
        return vipYear;
    }
    public void setXsDeduct(Long xsDeduct)
    {
        this.xsDeduct = xsDeduct;
    }

    public Long getXsDeduct()
    {
        return xsDeduct;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("customerQq", getCustomerQq())
            .append("customerWx", getCustomerWx())
            .append("dayShareGifts", getDayShareGifts())
            .append("mhDeduct", getMhDeduct())
            .append("platformQrCode", getPlatformQrCode())
            .append("proportion", getProportion())
            .append("signToGive", getSignToGive())
            .append("siteName", getSiteName())
            .append("vipYear", getVipYear())
            .append("xsDeduct", getXsDeduct())
            .toString();
    }
}
