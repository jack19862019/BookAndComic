package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.site.TRechargeConfig;
import org.apache.ibatis.annotations.Param;

/**
 * 充值赠送配置Mapper接口
 *
 * @author ruoyi
 * @date 2020-04-11
 */
public interface TRechargeConfigMapper
{
    /**
     * 查询充值赠送配置
     *
     * @param id 充值赠送配置ID
     * @return 充值赠送配置
     */
    public TRechargeConfig selectTRechargeConfigById(Long id);

    /**
     * 查询充值赠送配置列表
     *
     * @param tRechargeConfig 充值赠送配置
     * @return 充值赠送配置集合
     */
    public List<TRechargeConfig> selectTRechargeConfigList(TRechargeConfig tRechargeConfig);

    /**
     * 新增充值赠送配置
     *
     * @param tRechargeConfig 充值赠送配置
     * @return 结果
     */
    public int insertTRechargeConfig(TRechargeConfig tRechargeConfig);

    /**
     * 修改充值赠送配置
     *
     * @param tRechargeConfig 充值赠送配置
     * @return 结果
     */
    public int updateTRechargeConfig(TRechargeConfig tRechargeConfig);

    /**
     * 删除充值赠送配置
     *
     * @param id 充值赠送配置ID
     * @return 结果
     */
    public int deleteTRechargeConfigById(Long id);

    /**
     * 批量删除充值赠送配置
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTRechargeConfigByIds(String[] ids);

    /**
     * 检查充值金额是否重复
     *
     * @param rechargeNum 充值金额
     * @return 结果
     */
    public Integer checkRechargeNumUnique(@Param("rechargeNum") int rechargeNum);
}
