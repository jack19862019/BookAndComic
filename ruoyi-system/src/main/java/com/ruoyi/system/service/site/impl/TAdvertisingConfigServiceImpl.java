package com.ruoyi.system.service.site.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.site.TAdvertisingConfig;
import com.ruoyi.system.mapper.TAdvertisingConfigMapper;
import com.ruoyi.system.service.site.ITAdvertisingConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 广告配置Service业务层处理
 *
 * @author ruoyi
 * @date 2020-04-11
 */
@Service
public class TAdvertisingConfigServiceImpl implements ITAdvertisingConfigService {
    @Autowired
    private TAdvertisingConfigMapper tAdvertisingConfigMapper;

    /**
     * 查询广告配置
     *
     * @param id 广告配置ID
     * @return 广告配置
     */
    @Override
    public TAdvertisingConfig selectTAdvertisingConfigById(Long id) {
        return tAdvertisingConfigMapper.selectTAdvertisingConfigById(id);
    }

    /**
     * 查询广告配置列表
     *
     * @param tAdvertisingConfig 广告配置
     * @return 广告配置
     */
    @Override
    public List<TAdvertisingConfig> selectTAdvertisingConfigList(TAdvertisingConfig tAdvertisingConfig) {
        return tAdvertisingConfigMapper.selectTAdvertisingConfigList(tAdvertisingConfig);
    }

    /**
     * 新增广告配置
     *
     * @param tAdvertisingConfig 广告配置
     * @return 结果
     */
    @Override
    public int insertTAdvertisingConfig(TAdvertisingConfig tAdvertisingConfig) {
        Long bid = tAdvertisingConfig.getBid();
        if (bid==0) {
            List<TAdvertisingConfig> tAdvertisingConfigs = tAdvertisingConfigMapper.selectTAdvertisingConfigList(new TAdvertisingConfig());
            if (!CollectionUtils.isEmpty(tAdvertisingConfigs)) {
                for (TAdvertisingConfig tg : tAdvertisingConfigs) {
                    if (tg.getBid() == 0) {
                        throw new BusinessException("已经配置小说广告");
                    }
                }
            }
        }
        if (bid==1) {
            List<TAdvertisingConfig> tAdvertisingConfigs = tAdvertisingConfigMapper.selectTAdvertisingConfigList(new TAdvertisingConfig());
            if (!CollectionUtils.isEmpty(tAdvertisingConfigs)) {
                for (TAdvertisingConfig tg : tAdvertisingConfigs) {
                    if (tg.getBid() == 1) {
                        throw new BusinessException("已经配置漫画广告");
                    }
                }
            }
        }
        tAdvertisingConfig.setCreateTime(DateUtils.getNowDate());
        return tAdvertisingConfigMapper.insertTAdvertisingConfig(tAdvertisingConfig);
    }

    /**
     * 修改广告配置
     *
     * @param tAdvertisingConfig 广告配置
     * @return 结果
     */
    @Override
    public int updateTAdvertisingConfig(TAdvertisingConfig tAdvertisingConfig) {
        tAdvertisingConfig.setUpdateTime(DateUtils.getNowDate());
        return tAdvertisingConfigMapper.updateTAdvertisingConfig(tAdvertisingConfig);
    }

    /**
     * 删除广告配置对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTAdvertisingConfigByIds(String ids) {
        return tAdvertisingConfigMapper.deleteTAdvertisingConfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除广告配置信息
     *
     * @param id 广告配置ID
     * @return 结果
     */
    @Override
    public int deleteTAdvertisingConfigById(Long id) {
        return tAdvertisingConfigMapper.deleteTAdvertisingConfigById(id);
    }
}
