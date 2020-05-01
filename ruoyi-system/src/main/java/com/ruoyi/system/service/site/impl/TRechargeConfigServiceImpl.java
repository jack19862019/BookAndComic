package com.ruoyi.system.service.site.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TRechargeConfigMapper;
import com.ruoyi.system.domain.site.TRechargeConfig;
import com.ruoyi.system.service.site.ITRechargeConfigService;
import com.ruoyi.common.core.text.Convert;

/**
 * 充值赠送配置Service业务层处理
 *
 * @author ruoyi
 * @date 2020-04-11
 */
@Service
public class TRechargeConfigServiceImpl implements ITRechargeConfigService
{
    @Autowired
    private TRechargeConfigMapper tRechargeConfigMapper;

    /**
     * 查询充值赠送配置
     *
     * @param id 充值赠送配置ID
     * @return 充值赠送配置
     */
    @Override
    public TRechargeConfig selectTRechargeConfigById(Long id)
    {
        return tRechargeConfigMapper.selectTRechargeConfigById(id);
    }

    /**
     * 查询充值赠送配置列表
     *
     * @param tRechargeConfig 充值赠送配置
     * @return 充值赠送配置
     */
    @Override
    public List<TRechargeConfig> selectTRechargeConfigList(TRechargeConfig tRechargeConfig)
    {
        return tRechargeConfigMapper.selectTRechargeConfigList(tRechargeConfig);
    }

    /**
     * 新增充值赠送配置
     *
     * @param tRechargeConfig 充值赠送配置
     * @return 结果
     */
    @Override
    public int insertTRechargeConfig(TRechargeConfig tRechargeConfig)
    {
        if (tRechargeConfigMapper.checkRechargeNumUnique(tRechargeConfig.getRechargeNum())>0){
            throw new BusinessException("充值金额已经存在！");
        }

        tRechargeConfig.setCreateTime(DateUtils.getNowDate());
        return tRechargeConfigMapper.insertTRechargeConfig(tRechargeConfig);
    }

    /**
     * 修改充值赠送配置
     *
     * @param tRechargeConfig 充值赠送配置
     * @return 结果
     */
    @Override
    public int updateTRechargeConfig(TRechargeConfig tRechargeConfig)
    {
        tRechargeConfig.setUpdateTime(DateUtils.getNowDate());
        return tRechargeConfigMapper.updateTRechargeConfig(tRechargeConfig);
    }

    /**
     * 删除充值赠送配置对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTRechargeConfigByIds(String ids)
    {
        return tRechargeConfigMapper.deleteTRechargeConfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除充值赠送配置信息
     *
     * @param id 充值赠送配置ID
     * @return 结果
     */
    @Override
    public int deleteTRechargeConfigById(Long id)
    {
        return tRechargeConfigMapper.deleteTRechargeConfigById(id);
    }
}
