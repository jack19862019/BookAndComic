package com.ruoyi.system.service.site.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TExceptionalConfigMapper;
import com.ruoyi.system.domain.site.TExceptionalConfig;
import com.ruoyi.system.service.site.ITExceptionalConfigService;
import com.ruoyi.common.core.text.Convert;

/**
 * 打赏配置Service业务层处理
 *
 * @author ruoyi
 * @date 2020-04-11
 */
@Service
public class TExceptionalConfigServiceImpl implements ITExceptionalConfigService
{
    @Autowired
    private TExceptionalConfigMapper tExceptionalConfigMapper;

    /**
     * 查询打赏配置
     *
     * @param id 打赏配置ID
     * @return 打赏配置
     */
    @Override
    public TExceptionalConfig selectTExceptionalConfigById(Long id)
    {
        return tExceptionalConfigMapper.selectTExceptionalConfigById(id);
    }

    /**
     * 查询打赏配置列表
     *
     * @param tExceptionalConfig 打赏配置
     * @return 打赏配置
     */
    @Override
    public List<TExceptionalConfig> selectTExceptionalConfigList(TExceptionalConfig tExceptionalConfig)
    {
        return tExceptionalConfigMapper.selectTExceptionalConfigList(tExceptionalConfig);
    }

    /**
     * 新增打赏配置
     *
     * @param tExceptionalConfig 打赏配置
     * @return 结果
     */
    @Override
    public int insertTExceptionalConfig(TExceptionalConfig tExceptionalConfig)
    {
        tExceptionalConfig.setCreateTime(DateUtils.getNowDate());
        return tExceptionalConfigMapper.insertTExceptionalConfig(tExceptionalConfig);
    }

    /**
     * 修改打赏配置
     *
     * @param tExceptionalConfig 打赏配置
     * @return 结果
     */
    @Override
    public int updateTExceptionalConfig(TExceptionalConfig tExceptionalConfig)
    {
        tExceptionalConfig.setUpdateTime(DateUtils.getNowDate());
        return tExceptionalConfigMapper.updateTExceptionalConfig(tExceptionalConfig);
    }

    /**
     * 删除打赏配置对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTExceptionalConfigByIds(String ids)
    {
        return tExceptionalConfigMapper.deleteTExceptionalConfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除打赏配置信息
     *
     * @param id 打赏配置ID
     * @return 结果
     */
    @Override
    public int deleteTExceptionalConfigById(Long id)
    {
        return tExceptionalConfigMapper.deleteTExceptionalConfigById(id);
    }
}
