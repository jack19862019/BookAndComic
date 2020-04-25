package com.ruoyi.system.service.agent.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.agent.TAgbaParams;
import com.ruoyi.system.domain.agent.TAgentBalanceLog;
import com.ruoyi.system.service.agent.ITAgentBalanceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TAgentBalanceLogMapper;
import com.ruoyi.common.core.text.Convert;

/**
 * 充值记录Service业务层处理
 *
 * @author ruoyi
 * @date 2020-04-19
 */
@Service
public class TAgentBalanceLogServiceImpl implements ITAgentBalanceLogService
{
    @Autowired
    private TAgentBalanceLogMapper tAgentBalanceLogMapper;

    /**
     * 查询充值记录
     *
     * @param id 充值记录ID
     * @return 充值记录
     */
    @Override
    public TAgentBalanceLog selectTAgentBalanceLogById(Long id)
    {
        return tAgentBalanceLogMapper.selectTAgentBalanceLogById(id);
    }

    /**
     * 查询充值记录列表
     *
     * @param tAgentBalanceLog 充值记录
     * @return 充值记录
     */
    @Override
    public List<TAgentBalanceLog> selectTAgentBalanceLogList(TAgentBalanceLog tAgentBalanceLog)
    {
        return tAgentBalanceLogMapper.selectTAgentBalanceLogList(tAgentBalanceLog);
    }

    /**
     * 新增充值记录
     *
     * @param tAgentBalanceLog 充值记录
     * @return 结果
     */
    @Override
    public int insertTAgentBalanceLog(TAgentBalanceLog tAgentBalanceLog)
    {
        tAgentBalanceLog.setCreateTime(DateUtils.getNowDate());
        return tAgentBalanceLogMapper.insertTAgentBalanceLog(tAgentBalanceLog);
    }

    /**
     * 修改充值记录
     *
     * @param tAgentBalanceLog 充值记录
     * @return 结果
     */
    @Override
    public int updateTAgentBalanceLog(TAgentBalanceLog tAgentBalanceLog)
    {
        tAgentBalanceLog.setUpdateTime(DateUtils.getNowDate());
        return tAgentBalanceLogMapper.updateTAgentBalanceLog(tAgentBalanceLog);
    }

    /**
     * 删除充值记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTAgentBalanceLogByIds(String ids)
    {
        return tAgentBalanceLogMapper.deleteTAgentBalanceLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除充值记录信息
     *
     * @param id 充值记录ID
     * @return 结果
     */
    @Override
    public int deleteTAgentBalanceLogById(Long id)
    {
        return tAgentBalanceLogMapper.deleteTAgentBalanceLogById(id);
    }

    @Override
    public List<TAgbaParams> topUpDay(TAgentBalanceLog tAgentBalanceLog) {
        return tAgentBalanceLogMapper.topUpDay(tAgentBalanceLog);
    }

    @Override
    public List<TAgbaParams> topUpYesterday(TAgentBalanceLog tAgentBalanceLog) {
        return tAgentBalanceLogMapper.topUpYesterday(tAgentBalanceLog);
    }

    @Override
    public List<TAgbaParams> topUpMonth(TAgentBalanceLog tAgentBalanceLog) {
        return tAgentBalanceLogMapper.topUpMonth(tAgentBalanceLog);
    }

    @Override
    public List<TAgbaParams> topUpTotal(TAgentBalanceLog tAgentBalanceLog) {
        return tAgentBalanceLogMapper.topUpTotal(tAgentBalanceLog);
    }
}
