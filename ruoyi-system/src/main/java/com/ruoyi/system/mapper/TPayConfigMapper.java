package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.site.TPayConfig;

/**
 * 第三方支付配置Mapper接口
 *
 * @author ruoyi
 * @date 2020-04-11
 */
public interface TPayConfigMapper
{
    /**
     * 查询第三方支付配置
     *
     * @param id 第三方支付配置ID
     * @return 第三方支付配置
     */
    public TPayConfig selectTPayConfigById(Long id);

    /**
     * 查询第三方支付配置列表
     *
     * @param tPayConfig 第三方支付配置
     * @return 第三方支付配置集合
     */
    public List<TPayConfig> selectTPayConfigList(TPayConfig tPayConfig);

    /**
     * 新增第三方支付配置
     *
     * @param tPayConfig 第三方支付配置
     * @return 结果
     */
    public int insertTPayConfig(TPayConfig tPayConfig);

    /**
     * 修改第三方支付配置
     *
     * @param tPayConfig 第三方支付配置
     * @return 结果
     */
    public int updateTPayConfig(TPayConfig tPayConfig);

    /**
     * 删除第三方支付配置
     *
     * @param id 第三方支付配置ID
     * @return 结果
     */
    public int deleteTPayConfigById(Long id);

    /**
     * 批量删除第三方支付配置
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTPayConfigByIds(String[] ids);

    /**
     * 启用状态修改
     *
     * @param tPayConfig 支付信息
     * @return 结果
     */
    public int changeStatus(TPayConfig tPayConfig);
}
