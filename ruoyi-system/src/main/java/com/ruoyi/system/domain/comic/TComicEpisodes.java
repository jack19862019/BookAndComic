package com.ruoyi.system.domain.comic;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 漫画章节对象 t_comic_episodes
 * 
 * @author ruoyi
 * @date 2020-04-26
 */
public class TComicEpisodes extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 上一章 */
    @Excel(name = "上一章")
    private Long beforeNo;

    /** 漫画编号 */
    @Excel(name = "漫画编号")
    private Long comicId;

    /** 章节编号 */
    @Excel(name = "章节编号")
    private Long jiNo;

    /** 金额 */
    @Excel(name = "金额")
    private Double money;

    /** 下一章 */
    @Excel(name = "下一章")
    private Long nextNo;

    /**  */
    private String pics;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 路径 */
    @Excel(name = "路径")
    private String uri;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBeforeNo(Long beforeNo) 
    {
        this.beforeNo = beforeNo;
    }

    public Long getBeforeNo() 
    {
        return beforeNo;
    }
    public void setComicId(Long comicId) 
    {
        this.comicId = comicId;
    }

    public Long getComicId() 
    {
        return comicId;
    }
    public void setJiNo(Long jiNo) 
    {
        this.jiNo = jiNo;
    }

    public Long getJiNo() 
    {
        return jiNo;
    }
    public void setMoney(Double money) 
    {
        this.money = money;
    }

    public Double getMoney() 
    {
        return money;
    }
    public void setNextNo(Long nextNo) 
    {
        this.nextNo = nextNo;
    }

    public Long getNextNo() 
    {
        return nextNo;
    }
    public void setPics(String pics) 
    {
        this.pics = pics;
    }

    public String getPics() 
    {
        return pics;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setUri(String uri) 
    {
        this.uri = uri;
    }

    public String getUri() 
    {
        return uri;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("beforeNo", getBeforeNo())
            .append("comicId", getComicId())
            .append("jiNo", getJiNo())
            .append("money", getMoney())
            .append("nextNo", getNextNo())
            .append("pics", getPics())
            .append("title", getTitle())
            .append("uri", getUri())
            .toString();
    }
}
