package com.ruoyi.system.domain.site;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 充值赠送配置对象 t_recharge_config
 *
 * @author ruoyi
 * @date 2020-04-11
 */
public class TRechargeConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 获得赠送币 */
    @Excel(name = "获得赠送币")
    private int givingNum;

    /** 充值金额 */
    @Excel(name = "充值金额")
    private int rechargeNum;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public int getGivingNum() {
        return givingNum;
    }

    public void setGivingNum(int givingNum) {
        this.givingNum = givingNum;
    }

    public int getRechargeNum() {
        return rechargeNum;
    }

    public void setRechargeNum(int rechargeNum) {
        this.rechargeNum = rechargeNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("givingNum", getGivingNum())
            .append("rechargeNum", getRechargeNum())
            .toString();
    }
}
