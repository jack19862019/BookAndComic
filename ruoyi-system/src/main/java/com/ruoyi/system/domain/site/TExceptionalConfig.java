package com.ruoyi.system.domain.site;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 打赏配置对象 t_exceptional_config
 *
 * @author ruoyi
 * @date 2020-04-11
 */
public class TExceptionalConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 打赏币 */
    @Excel(name = "打赏币")
    private String bookCurrency;

    /** 图片 */
    @Excel(name = "图片")
    private String exceptionalImg;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setBookCurrency(String bookCurrency)
    {
        this.bookCurrency = bookCurrency;
    }

    public String getBookCurrency()
    {
        return bookCurrency;
    }
    public void setExceptionalImg(String exceptionalImg)
    {
        this.exceptionalImg = exceptionalImg;
    }

    public String getExceptionalImg()
    {
        return exceptionalImg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("bookCurrency", getBookCurrency())
            .append("exceptionalImg", getExceptionalImg())
            .toString();
    }
}
