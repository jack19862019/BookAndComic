package com.ruoyi.system.domain.site;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 公告管理对象 t_notice
 * 
 * @author ruoyi
 * @date 2020-04-17
 */
public class TNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公告id */
    private Long id;

    /** 公告内容 */
    @Excel(name = "公告内容")
    private String content;

    /** 公告标题 */
    @Excel(name = "公告标题")
    private String title;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("content", getContent())
            .append("title", getTitle())
            .toString();
    }
}
