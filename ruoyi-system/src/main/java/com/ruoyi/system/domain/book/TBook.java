package com.ruoyi.system.domain.book;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 小说对象 t_book
 *
 * @author ruoyi
 * @date 2020-04-17
 */
public class TBook extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 作者 */
    @Excel(name = "作者")
    private String author;

    /** 分类 */
    @Excel(name = "分类")
    private Long category;

    /** 封面图(列表) */
    @Excel(name = "封面图(列表)")
    private String coverPic;

    /** 详情页图片 */
    @Excel(name = "详情页图片")
    private String detailPic;

    /** 排序权值 */
    @Excel(name = "排序权值")
    private Long sort;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 作品简介 */
    @Excel(name = "作品简介")
    private String summary;

    /** 书名 */
    @Excel(name = "书名")
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
    public void setCategory(Long category)
    {
        this.category = category;
    }

    public Long getCategory()
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
