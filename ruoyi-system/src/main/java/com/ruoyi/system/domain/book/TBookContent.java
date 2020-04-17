package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 小说章节对象 t_book_content
 *
 * @author ruoyi
 * @date 2020-04-17
 */
public class TBookContent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 小说章节id */
    private Long id;

    /** 小说编号 */
    @Excel(name = "小说编号")
    private Long bid;

    /** 章节名称 */
    @Excel(name = "章节名称")
    private String title;

    /** 章节内容 */
    @Excel(name = "章节内容")
    private String content;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setBid(Long bid)
    {
        this.bid = bid;
    }

    public Long getBid()
    {
        return bid;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("bid", getBid())
                .append("title", getTitle())
                .append("content", getContent())
                .toString();
    }
}
