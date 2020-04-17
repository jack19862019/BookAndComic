package com.ruoyi.system.domain.site;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消息管理对象 t_article
 * 
 * @author ruoyi
 * @date 2020-04-17
 */
public class TArticle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 消息编号 */
    private Long id;

    /** 作者 */
    @Excel(name = "作者")
    private String author;

    /** 内容 */
    @Excel(name = "内容")
    private String body;

    /** 封面图片 */
    @Excel(name = "封面图片")
    private String cover;

    /** 封面图是否显示在正文 */
    @Excel(name = "封面图是否显示在正文")
    private Long showCover;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public String getAuthor() 
    {
        return author;
    }
    public void setBody(String body) 
    {
        this.body = body;
    }

    public String getBody() 
    {
        return body;
    }
    public void setCover(String cover) 
    {
        this.cover = cover;
    }

    public String getCover() 
    {
        return cover;
    }
    public void setShowCover(Long showCover) 
    {
        this.showCover = showCover;
    }

    public Long getShowCover() 
    {
        return showCover;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
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
            .append("author", getAuthor())
            .append("body", getBody())
            .append("cover", getCover())
            .append("showCover", getShowCover())
            .append("sort", getSort())
            .append("title", getTitle())
            .toString();
    }
}
