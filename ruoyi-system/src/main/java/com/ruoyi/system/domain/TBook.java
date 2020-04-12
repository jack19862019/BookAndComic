package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 小说对象 t_book
 * 
 * @author ruoyi
 * @date 2020-04-12
 */
public class TBook extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** null */
    @Excel(name = "null")
    private String author;

    /** null */
    @Excel(name = "null")
    private String category;

    /** null */
    @Excel(name = "null")
    private String coverPic;

    /** null */
    @Excel(name = "null")
    private String detailPic;

    /** null */
    @Excel(name = "null")
    private Long sort;

    /** null */
    @Excel(name = "null")
    private Long status;

    /** null */
    @Excel(name = "null")
    private String summary;

    /** null */
    @Excel(name = "null")
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
    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }
    public void setCoverPic(String coverPic) 
    {
        this.coverPic = coverPic;
    }

    public String getCoverPic() 
    {
        return coverPic;
    }
    public void setDetailPic(String detailPic) 
    {
        this.detailPic = detailPic;
    }

    public String getDetailPic() 
    {
        return detailPic;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setSummary(String summary) 
    {
        this.summary = summary;
    }

    public String getSummary() 
    {
        return summary;
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
            .append("category", getCategory())
            .append("coverPic", getCoverPic())
            .append("detailPic", getDetailPic())
            .append("sort", getSort())
            .append("status", getStatus())
            .append("summary", getSummary())
            .append("title", getTitle())
            .toString();
    }
}
