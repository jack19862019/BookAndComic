package com.ruoyi.system.domain.site;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 广告配置对象 t_advertising_config
 *
 * @author ruoyi
 * @date 2020-04-11
 */
public class TAdvertisingConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 广告图片 */
    @Excel(name = "广告图片")
    private String advertisingImg;

    /** 广告链接 */
    @Excel(name = "广告链接")
    private String advertisingUrl;

    /** 书/漫画 */
    @Excel(name = "书/漫画")
    private Long bid;

    /** 是否开启 */
    @Excel(name = "是否开启")
    private Long isOpen;

    /** null */
    @Excel(name = "null")
    private String showChapter;

    /** null */
    @Excel(name = "null")
    private Long showMultiple;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setAdvertisingImg(String advertisingImg)
    {
        this.advertisingImg = advertisingImg;
    }

    public String getAdvertisingImg()
    {
        return advertisingImg;
    }
    public void setAdvertisingUrl(String advertisingUrl)
    {
        this.advertisingUrl = advertisingUrl;
    }

    public String getAdvertisingUrl()
    {
        return advertisingUrl;
    }
    public void setBid(Long bid)
    {
        this.bid = bid;
    }

    public Long getBid()
    {
        return bid;
    }
    public void setIsOpen(Long isOpen)
    {
        this.isOpen = isOpen;
    }

    public Long getIsOpen()
    {
        return isOpen;
    }
    public void setShowChapter(String showChapter)
    {
        this.showChapter = showChapter;
    }

    public String getShowChapter()
    {
        return showChapter;
    }
    public void setShowMultiple(Long showMultiple)
    {
        this.showMultiple = showMultiple;
    }

    public Long getShowMultiple()
    {
        return showMultiple;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("advertisingImg", getAdvertisingImg())
            .append("advertisingUrl", getAdvertisingUrl())
            .append("bid", getBid())
            .append("isOpen", getIsOpen())
            .append("showChapter", getShowChapter())
            .append("showMultiple", getShowMultiple())
            .toString();
    }
}
