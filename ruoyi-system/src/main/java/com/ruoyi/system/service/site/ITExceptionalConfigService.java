package com.ruoyi.system.service.site;

import java.util.List;
import com.ruoyi.system.domain.site.TExceptionalConfig;

/**
 * 打赏配置Service接口
 *
 * @author ruoyi
 * @date 2020-04-11
 */
public interface ITExceptionalConfigService
{
    /**
     * 查询打赏配置
     *
     * @param id 打赏配置ID
     * @return 打赏配置
     */
    public TExceptionalConfig selectTExceptionalConfigById(Long id);

    /**
     * 查询打赏配置列表
     *
     * @param tExceptionalConfig 打赏配置
     * @return 打赏配置集合
     */
    public List<TExceptionalConfig> selectTExceptionalConfigList(TExceptionalConfig tExceptionalConfig);

    /**
     * 新增打赏配置
     *
     * @param tExceptionalConfig 打赏配置
     * @return 结果
     */
    public int insertTExceptionalConfig(TExceptionalConfig tExceptionalConfig);

    /**
     * 修改打赏配置
     *
     * @param tExceptionalConfig 打赏配置
     * @return 结果
     */
    public int updateTExceptionalConfig(TExceptionalConfig tExceptionalConfig);

    /**
     * 批量删除打赏配置
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTExceptionalConfigByIds(String ids);

    /**
     * 删除打赏配置信息
     *
     * @param id 打赏配置ID
     * @return 结果
     */
    public int deleteTExceptionalConfigById(Long id);
}
