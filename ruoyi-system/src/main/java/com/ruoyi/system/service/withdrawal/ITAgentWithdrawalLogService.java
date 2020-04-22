package com.ruoyi.system.service.withdrawal;

import com.ruoyi.system.domain.withdrawal.TAgentWithdrawalLog;

import java.util.List;

/**
 * 提现记录Service接口
 *
 * @author ruoyi
 * @date 2020-04-22
 */
public interface ITAgentWithdrawalLogService
{
    /**
     * 查询提现记录
     *
     * @param id 提现记录ID
     * @return 提现记录
     */
    public TAgentWithdrawalLog selectTAgentWithdrawalLogById(Long id);

    /**
     * 查询提现记录列表
     *
     * @param tAgentWithdrawalLog 提现记录
     * @return 提现记录集合
     */
    public List<TAgentWithdrawalLog> selectTAgentWithdrawalLogList(TAgentWithdrawalLog tAgentWithdrawalLog);

    /**
     * 新增提现记录
     *
     * @param tAgentWithdrawalLog 提现记录
     * @return 结果
     */
    public int insertTAgentWithdrawalLog(TAgentWithdrawalLog tAgentWithdrawalLog);

    /**
     * 修改提现记录
     *
     * @param tAgentWithdrawalLog 提现记录
     * @return 结果
     */
    public int updateTAgentWithdrawalLog(TAgentWithdrawalLog tAgentWithdrawalLog);

    /**
     * 批量删除提现记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTAgentWithdrawalLogByIds(String ids);

    /**
     * 删除提现记录信息
     *
     * @param id 提现记录ID
     * @return 结果
     */
    public int deleteTAgentWithdrawalLogById(Long id);
}
