package com.ruoyi.system.service.balance.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.balance.TUserBalanceLog;
import com.ruoyi.system.mapper.TUserBalanceLogMapper;
import com.ruoyi.system.service.balance.ITUserBalanceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户充值，提现Service业务层处理
 *
 * @author ruoyi
 * @date 2020-04-16
 */
@Service
public class TUserBalanceLogServiceImpl implements ITUserBalanceLogService
{
    @Autowired
    private TUserBalanceLogMapper tUserBalanceLogMapper;

    /**
     * 查询用户充值，提现
     *
     * @param id 用户充值，提现ID
     * @return 用户充值，提现
     */
    @Override
    public TUserBalanceLog selectTUserBalanceLogById(Long id)
    {
        return tUserBalanceLogMapper.selectTUserBalanceLogById(id);
    }

    /**
     * 查询用户充值，提现列表
     *
     * @param tUserBalanceLog 用户充值，提现
     * @return 用户充值，提现
     */
    @Override
    public List<TUserBalanceLog> selectTUserBalanceLogList(TUserBalanceLog tUserBalanceLog)
    {
        return tUserBalanceLogMapper.selectTUserBalanceLogList(tUserBalanceLog);
    }

    /**
     * 新增用户充值，提现
     *
     * @param tUserBalanceLog 用户充值，提现
     * @return 结果
     */
    @Override
    public int insertTUserBalanceLog(TUserBalanceLog tUserBalanceLog)
    {
        tUserBalanceLog.setCreateTime(DateUtils.getNowDate());
        return tUserBalanceLogMapper.insertTUserBalanceLog(tUserBalanceLog);
    }

    /**
     * 修改用户充值，提现
     *
     * @param tUserBalanceLog 用户充值，提现
     * @return 结果
     */
    @Override
    public int updateTUserBalanceLog(TUserBalanceLog tUserBalanceLog)
    {
        tUserBalanceLog.setUpdateTime(DateUtils.getNowDate());
        return tUserBalanceLogMapper.updateTUserBalanceLog(tUserBalanceLog);
    }

    /**
     * 删除用户充值，提现对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTUserBalanceLogByIds(String ids)
    {
        return tUserBalanceLogMapper.deleteTUserBalanceLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户充值，提现信息
     *
     * @param id 用户充值，提现ID
     * @return 结果
     */
    @Override
    public int deleteTUserBalanceLogById(Long id)
    {
        return tUserBalanceLogMapper.deleteTUserBalanceLogById(id);
    }
}
