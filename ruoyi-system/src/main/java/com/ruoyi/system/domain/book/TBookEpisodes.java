package com.ruoyi.system.domain.book;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 小说章节对象 t_book_episodes
 * 
 * @author ruoyi
 * @date 2020-04-18
 */
public class TBookEpisodes extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 上节编号 */
    @Excel(name = "上节编号")
    private Long beforeNo;

    /** 小说编号 */
    @Excel(name = "小说编号")
    private Long bid;

    /** 章节内容路径 */
    @Excel(name = "章节内容路径")
    private String info;

    /** 章节集号 */
    @Excel(name = "章节集号")
    private Long jiNo;

    /** 阅读需要的费用 */
    @Excel(name = "阅读需要的费用")
    private Double money;

    /** 下节编号 */
    @Excel(name = "下节编号")
    private Long nextNo;

    /** 章节名称 */
    @Excel(name = "章节名称")
    private String title;

    /** 章节内容 */
    @Excel(name = "章节内容")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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
    public void setBid(Long bid) 
    {
        this.bid = bid;
    }

    public Long getBid() 
    {
        return bid;
    }
    public void setInfo(String info) 
    {
        this.info = info;
    }

    public String getInfo() 
    {
        return info;
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
            .append("beforeNo", getBeforeNo())
            .append("bid", getBid())
            .append("info", getInfo())
            .append("jiNo", getJiNo())
            .append("money", getMoney())
            .append("nextNo", getNextNo())
            .append("title", getTitle())
            .toString();
    }
}
