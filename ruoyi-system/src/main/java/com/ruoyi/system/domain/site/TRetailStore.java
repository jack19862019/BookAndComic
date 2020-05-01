package com.ruoyi.system.domain.site;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分销配置对象 t_retail_store
 *
 * @author lucifer
 * @date 2020-04-11
 */
public class TRetailStore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 分成模式 */
    @Excel(name = "分成模式")
    private Long divided;

    /** 一级分销名称 */
    @Excel(name = "一级分销名称")
    private String levelOne;

    /** 一级分销比例 */
    @Excel(name = "一级分销比例")
    private Float levelOneScale;

    /** 三级分销名称 */
    @Excel(name = "三级分销名称")
    private String levelThree;

    /** 三级分销比例 */
    @Excel(name = "三级分销比例")
    private Float levelThreeScale;

    /** 二级分销名称 */
    @Excel(name = "二级分销名称")
    private String levelTwo;

    /** 二级分销比例 */
    @Excel(name = "二级分销比例")
    private Float levelTwoScale;

    /** 分销名称 */
    @Excel(name = "分销名称")
    private String retailStoreName;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setDivided(Long divided)
    {
        this.divided = divided;
    }

    public Long getDivided()
    {
        return divided;
    }
    public void setLevelOne(String levelOne)
    {
        this.levelOne = levelOne;
    }

    public String getLevelOne()
    {
        return levelOne;
    }
    public void setLevelOneScale(Float levelOneScale)
    {
        this.levelOneScale = levelOneScale;
    }

    public Float getLevelOneScale()
    {
        return levelOneScale;
    }
    public void setLevelThree(String levelThree)
    {
        this.levelThree = levelThree;
    }

    public String getLevelThree()
    {
        return levelThree;
    }
    public void setLevelThreeScale(Float levelThreeScale)
    {
        this.levelThreeScale = levelThreeScale;
    }

    public Float getLevelThreeScale()
    {
        return levelThreeScale;
    }
    public void setLevelTwo(String levelTwo)
    {
        this.levelTwo = levelTwo;
    }

    public String getLevelTwo()
    {
        return levelTwo;
    }
    public void setLevelTwoScale(Float levelTwoScale)
    {
        this.levelTwoScale = levelTwoScale;
    }

    public Float getLevelTwoScale()
    {
        return levelTwoScale;
    }
    public void setRetailStoreName(String retailStoreName)
    {
        this.retailStoreName = retailStoreName;
    }

    public String getRetailStoreName()
    {
        return retailStoreName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("divided", getDivided())
            .append("levelOne", getLevelOne())
            .append("levelOneScale", getLevelOneScale())
            .append("levelThree", getLevelThree())
            .append("levelThreeScale", getLevelThreeScale())
            .append("levelTwo", getLevelTwo())
            .append("levelTwoScale", getLevelTwoScale())
            .append("retailStoreName", getRetailStoreName())
            .toString();
    }
}
