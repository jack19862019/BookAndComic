package com.ruoyi.system.service.withdrawal.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.withdrawal.TAgentWithdrawalLog;
import com.ruoyi.system.mapper.TAgentWithdrawalLogMapper;
import com.ruoyi.system.service.withdrawal.ITAgentWithdrawalLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 提现记录Service业务层处理
 *
 * @author ruoyi
 * @date 2020-04-22
 */
@Service
public class TAgentWithdrawalLogServiceImpl implements ITAgentWithdrawalLogService
{
    @Autowired
    private TAgentWithdrawalLogMapper tAgentWithdrawalLogMapper;

    /**
     * 查询提现记录
     *
     * @param id 提现记录ID
     * @return 提现记录
     */
    @Override
    public TAgentWithdrawalLog selectTAgentWithdrawalLogById(Long id)
    {
        return tAgentWithdrawalLogMapper.selectTAgentWithdrawalLogById(id);
    }

    /**
     * 查询提现记录列表
     *
     * @param tAgentWithdrawalLog 提现记录
     * @return 提现记录
     */
    @Override
    public List<TAgentWithdrawalLog> selectTAgentWithdrawalLogList(TAgentWithdrawalLog tAgentWithdrawalLog)
    {
        return tAgentWithdrawalLogMapper.selectTAgentWithdrawalLogList(tAgentWithdrawalLog);
    }

    /**
     * 新增提现记录
     *
     * @param tAgentWithdrawalLog 提现记录
     * @return 结果
     */
    @Override
    public int insertTAgentWithdrawalLog(TAgentWithdrawalLog tAgentWithdrawalLog)
    {
        tAgentWithdrawalLog.setCreateTime(DateUtils.getNowDate());
        return tAgentWithdrawalLogMapper.insertTAgentWithdrawalLog(tAgentWithdrawalLog);
    }

    /**
     * 修改提现记录
     *
     * @param tAgentWithdrawalLog 提现记录
     * @return 结果
     */
    @Override
    public int updateTAgentWithdrawalLog(TAgentWithdrawalLog tAgentWithdrawalLog)
    {
        tAgentWithdrawalLog.setUpdateTime(DateUtils.getNowDate());
        return tAgentWithdrawalLogMapper.updateTAgentWithdrawalLog(tAgentWithdrawalLog);
    }

    /**
     * 删除提现记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTAgentWithdrawalLogByIds(String ids)
    {
        return tAgentWithdrawalLogMapper.deleteTAgentWithdrawalLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除提现记录信息
     *
     * @param id 提现记录ID
     * @return 结果
     */
    @Override
    public int deleteTAgentWithdrawalLogById(Long id)
    {
        return tAgentWithdrawalLogMapper.deleteTAgentWithdrawalLogById(id);
    }
}
