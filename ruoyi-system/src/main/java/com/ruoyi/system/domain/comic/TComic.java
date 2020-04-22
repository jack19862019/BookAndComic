package com.ruoyi.system.domain.comic;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 漫画管理对象 t_comic
 * 
 * @author ruoyi
 * @date 2020-04-22
 */
public class TComic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 漫画编号 */
    private Long id;

    /** null */
    private Long chargeMoney;

    /** null */
    private Long chargeNum;

    /** null */
    private Long collect;

    /** null */
    private Long comicId;

    /** null */
    private Long episodes;

    /** null */
    private Long freeType;

    /** null */
    private Long isNew;

    /** null */
    private Long isRecommend;

    /** null */
    private Long likes;

    /** null */
    private Long readNum;

    /** null */
    private Long reader;

    /** null */
    private Long send;

    /** 作者 */
    @Excel(name = "作者")
    private String author;

    /** 分类 */
    @Excel(name = "分类")
    private String category;

    /** 封面图(列表) */
    @Excel(name = "封面图(列表)")
    private String coverPic;

    /** 详情页图片 */
    @Excel(name = "详情页图片")
    private String detailPic;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 作品简介 */
    @Excel(name = "作品简介")
    private String summary;

    /** 漫画名称 */
    @Excel(name = "漫画名称")
    private String title;

    /** 漫画路径 */
    @Excel(name = "漫画路径")
    private String uri;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setChargeMoney(Long chargeMoney) 
    {
        this.chargeMoney = chargeMoney;
    }

    public Long getChargeMoney() 
    {
        return chargeMoney;
    }
    public void setChargeNum(Long chargeNum) 
    {
        this.chargeNum = chargeNum;
    }

    public Long getChargeNum() 
    {
        return chargeNum;
    }
    public void setCollect(Long collect) 
    {
        this.collect = collect;
    }

    public Long getCollect() 
    {
        return collect;
    }
    public void setComicId(Long comicId) 
    {
        this.comicId = comicId;
    }

    public Long getComicId() 
    {
        return comicId;
    }
    public void setEpisodes(Long episodes) 
    {
        this.episodes = episodes;
    }

    public Long getEpisodes() 
    {
        return episodes;
    }
    public void setFreeType(Long freeType) 
    {
        this.freeType = freeType;
    }

    public Long getFreeType() 
    {
        return freeType;
    }
    public void setIsNew(Long isNew) 
    {
        this.isNew = isNew;
    }

    public Long getIsNew() 
    {
        return isNew;
    }
    public void setIsRecommend(Long isRecommend) 
    {
        this.isRecommend = isRecommend;
    }

    public Long getIsRecommend() 
    {
        return isRecommend;
    }
    public void setLikes(Long likes) 
    {
        this.likes = likes;
    }

    public Long getLikes() 
    {
        return likes;
    }
    public void setReadNum(Long readNum) 
    {
        this.readNum = readNum;
    }

    public Long getReadNum() 
    {
        return readNum;
    }
    public void setReader(Long reader) 
    {
        this.reader = reader;
    }

    public Long getReader() 
    {
        return reader;
    }
    public void setSend(Long send) 
    {
        this.send = send;
    }

    public Long getSend() 
    {
        return send;
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
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
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
            .append("chargeMoney", getChargeMoney())
            .append("chargeNum", getChargeNum())
            .append("collect", getCollect())
            .append("comicId", getComicId())
            .append("episodes", getEpisodes())
            .append("freeType", getFreeType())
            .append("isNew", getIsNew())
            .append("isRecommend", getIsRecommend())
            .append("likes", getLikes())
            .append("readNum", getReadNum())
            .append("reader", getReader())
            .append("send", getSend())
            .append("author", getAuthor())
            .append("category", getCategory())
            .append("coverPic", getCoverPic())
            .append("detailPic", getDetailPic())
            .append("sort", getSort())
            .append("status", getStatus())
            .append("summary", getSummary())
            .append("title", getTitle())
            .append("uri", getUri())
            .toString();
    }
}
