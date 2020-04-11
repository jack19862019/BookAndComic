package com.ruoyi.system.service.site.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TPayConfigMapper;
import com.ruoyi.system.domain.site.TPayConfig;
import com.ruoyi.system.service.site.ITPayConfigService;
import com.ruoyi.common.core.text.Convert;

/**
 * 第三方支付配置Service业务层处理
 *
 * @author ruoyi
 * @date 2020-04-11
 */
@Service
public class TPayConfigServiceImpl implements ITPayConfigService
{
    @Autowired
    private TPayConfigMapper tPayConfigMapper;

    /**
     * 查询第三方支付配置
     *
     * @param id 第三方支付配置ID
     * @return 第三方支付配置
     */
    @Override
    public TPayConfig selectTPayConfigById(Long id)
    {
        return tPayConfigMapper.selectTPayConfigById(id);
    }

    /**
     * 查询第三方支付配置列表
     *
     * @param tPayConfig 第三方支付配置
     * @return 第三方支付配置
     */
    @Override
    public List<TPayConfig> selectTPayConfigList(TPayConfig tPayConfig)
    {
        return tPayConfigMapper.selectTPayConfigList(tPayConfig);
    }

    /**
     * 新增第三方支付配置
     *
     * @param tPayConfig 第三方支付配置
     * @return 结果
     */
    @Override
    public int insertTPayConfig(TPayConfig tPayConfig)
    {
        tPayConfig.setCreateTime(DateUtils.getNowDate());
        return tPayConfigMapper.insertTPayConfig(tPayConfig);
    }

    /**
     * 修改第三方支付配置
     *
     * @param tPayConfig 第三方支付配置
     * @return 结果
     */
    @Override
    public int updateTPayConfig(TPayConfig tPayConfig)
    {
        tPayConfig.setUpdateTime(DateUtils.getNowDate());
        return tPayConfigMapper.updateTPayConfig(tPayConfig);
    }

    /**
     * 删除第三方支付配置对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTPayConfigByIds(String ids)
    {
        return tPayConfigMapper.deleteTPayConfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除第三方支付配置信息
     *
     * @param id 第三方支付配置ID
     * @return 结果
     */
    @Override
    public int deleteTPayConfigById(Long id)
    {
        return tPayConfigMapper.deleteTPayConfigById(id);
    }
}
