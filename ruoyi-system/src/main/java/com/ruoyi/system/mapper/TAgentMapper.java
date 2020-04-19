package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.agent.TAgent;

import java.util.List;

/**
 * 代理Mapper接口
 *
 * @author ruoyi
 * @date 2020-04-19
 */
public interface TAgentMapper
{
    /**
     * 查询代理
     *
     * @param id 代理ID
     * @return 代理
     */
    public TAgent selectTAgentById(Long id);

    /**
     * 查询代理列表
     *
     * @param tAgent 代理
     * @return 代理集合
     */
    public List<TAgent> selectTAgentList(TAgent tAgent);

    /**
     * 新增代理
     *
     * @param tAgent 代理
     * @return 结果
     */
    public int insertTAgent(TAgent tAgent);

    /**
     * 修改代理
     *
     * @param tAgent 代理
     * @return 结果
     */
    public int updateTAgent(TAgent tAgent);

    /**
     * 删除代理
     *
     * @param id 代理ID
     * @return 结果
     */
    public int deleteTAgentById(Long id);

    /**
     * 批量删除代理
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTAgentByIds(String[] ids);
}
