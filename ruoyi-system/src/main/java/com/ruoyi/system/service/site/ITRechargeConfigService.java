package com.ruoyi.system.service.site;

import java.util.List;
import com.ruoyi.system.domain.site.TRechargeConfig;

/**
 * 充值赠送配置Service接口
 *
 * @author ruoyi
 * @date 2020-04-11
 */
public interface ITRechargeConfigService
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
     * 批量删除充值赠送配置
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTRechargeConfigByIds(String ids);

    /**
     * 删除充值赠送配置信息
     *
     * @param id 充值赠送配置ID
     * @return 结果
     */
    public int deleteTRechargeConfigById(Long id);
}
