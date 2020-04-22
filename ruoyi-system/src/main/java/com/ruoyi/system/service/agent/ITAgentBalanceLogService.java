package com.ruoyi.system.service.agent;

import com.ruoyi.system.domain.agent.TAgbaParams;
import com.ruoyi.system.domain.agent.TAgentBalanceLog;

import java.util.List;

/**
 * 充值记录Service接口
 *
 * @author ruoyi
 * @date 2020-04-19
 */
public interface ITAgentBalanceLogService
{
    /**
     * 查询充值记录
     *
     * @param id 充值记录ID
     * @return 充值记录
     */
    public TAgentBalanceLog selectTAgentBalanceLogById(Long id);

    /**
     * 查询充值记录列表
     *
     * @param tAgentBalanceLog 充值记录
     * @return 充值记录集合
     */
    public List<TAgentBalanceLog> selectTAgentBalanceLogList(TAgentBalanceLog tAgentBalanceLog);

    /**
     * 新增充值记录
     *
     * @param tAgentBalanceLog 充值记录
     * @return 结果
     */
    public int insertTAgentBalanceLog(TAgentBalanceLog tAgentBalanceLog);

    /**
     * 修改充值记录
     *
     * @param tAgentBalanceLog 充值记录
     * @return 结果
     */
    public int updateTAgentBalanceLog(TAgentBalanceLog tAgentBalanceLog);

    /**
     * 批量删除充值记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTAgentBalanceLogByIds(String ids);

    /**
     * 删除充值记录信息
     *
     * @param id 充值记录ID
     * @return 结果
     */
    public int deleteTAgentBalanceLogById(Long id);

    /**
     * 查询今日充值
     */
    public List<TAgbaParams> topUpDay();
    /**
     * 查询昨日充值
     */
    public List<TAgbaParams> topUpYesterday();
    /**
     * 查询本月充值
     */
    public List<TAgbaParams> topUpMonth();
    /**
     * 查询累计充值
     */
    public List<TAgbaParams> topUpTotal();
}
