package com.ruoyi.system.service.site;

import java.util.List;
import com.ruoyi.system.domain.site.TAdvertisingConfig;

/**
 * 广告配置Service接口
 *
 * @author ruoyi
 * @date 2020-04-11
 */
public interface ITAdvertisingConfigService
{
    /**
     * 查询广告配置
     *
     * @param id 广告配置ID
     * @return 广告配置
     */
    public TAdvertisingConfig selectTAdvertisingConfigById(Long id);

    /**
     * 查询广告配置列表
     *
     * @param tAdvertisingConfig 广告配置
     * @return 广告配置集合
     */
    public List<TAdvertisingConfig> selectTAdvertisingConfigList(TAdvertisingConfig tAdvertisingConfig);

    /**
     * 新增广告配置
     *
     * @param tAdvertisingConfig 广告配置
     * @return 结果
     */
    public int insertTAdvertisingConfig(TAdvertisingConfig tAdvertisingConfig);

    /**
     * 修改广告配置
     *
     * @param tAdvertisingConfig 广告配置
     * @return 结果
     */
    public int updateTAdvertisingConfig(TAdvertisingConfig tAdvertisingConfig);

    /**
     * 批量删除广告配置
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTAdvertisingConfigByIds(String ids);

    /**
     * 删除广告配置信息
     *
     * @param id 广告配置ID
     * @return 结果
     */
    public int deleteTAdvertisingConfigById(Long id);
}
