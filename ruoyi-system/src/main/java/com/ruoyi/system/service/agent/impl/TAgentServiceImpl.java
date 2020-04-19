package com.ruoyi.system.service.agent.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.agent.TAgent;
import com.ruoyi.system.service.agent.ITAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TAgentMapper;
import com.ruoyi.common.core.text.Convert;

/**
 * 代理Service业务层处理
 *
 * @author ruoyi
 * @date 2020-04-19
 */
@Service
public class TAgentServiceImpl implements ITAgentService
{
    @Autowired
    private TAgentMapper tAgentMapper;

    /**
     * 查询代理
     *
     * @param id 代理ID
     * @return 代理
     */
    @Override
    public TAgent selectTAgentById(Long id)
    {
        return tAgentMapper.selectTAgentById(id);
    }

    /**
     * 查询代理列表
     *
     * @param tAgent 代理
     * @return 代理
     */
    @Override
    public List<TAgent> selectTAgentList(TAgent tAgent)
    {
        return tAgentMapper.selectTAgentList(tAgent);
    }

    /**
     * 新增代理
     *
     * @param tAgent 代理
     * @return 结果
     */
    @Override
    public int insertTAgent(TAgent tAgent)
    {
        tAgent.setCreateTime(DateUtils.getNowDate());
        tAgent.setBalance(0D);
        tAgent.setStatus(0L);
        return tAgentMapper.insertTAgent(tAgent);
    }

    /**
     * 修改代理
     *
     * @param tAgent 代理
     * @return 结果
     */
    @Override
    public int updateTAgent(TAgent tAgent)
    {
        tAgent.setUpdateTime(DateUtils.getNowDate());
        return tAgentMapper.updateTAgent(tAgent);
    }

    /**
     * 删除代理对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTAgentByIds(String ids)
    {
        return tAgentMapper.deleteTAgentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除代理信息
     *
     * @param id 代理ID
     * @return 结果
     */
    @Override
    public int deleteTAgentById(Long id)
    {
        return tAgentMapper.deleteTAgentById(id);
    }
}
