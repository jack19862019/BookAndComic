package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.balance.TUserBalanceLog;

import java.util.List;

/**
 * 用户充值，提现Mapper接口
 *
 * @author ruoyi
 * @date 2020-04-16
 */
public interface TUserBalanceLogMapper
{
    /**
     * 查询用户充值，提现
     *
     * @param id 用户充值，提现ID
     * @return 用户充值，提现
     */
    public TUserBalanceLog selectTUserBalanceLogById(Long id);

    /**
     * 查询用户充值，提现列表
     *
     * @param tUserBalanceLog 用户充值，提现
     * @return 用户充值，提现集合
     */
    public List<TUserBalanceLog> selectTUserBalanceLogList(TUserBalanceLog tUserBalanceLog);

    /**
     * 新增用户充值，提现
     *
     * @param tUserBalanceLog 用户充值，提现
     * @return 结果
     */
    public int insertTUserBalanceLog(TUserBalanceLog tUserBalanceLog);

    /**
     * 修改用户充值，提现
     *
     * @param tUserBalanceLog 用户充值，提现
     * @return 结果
     */
    public int updateTUserBalanceLog(TUserBalanceLog tUserBalanceLog);

    /**
     * 删除用户充值，提现
     *
     * @param id 用户充值，提现ID
     * @return 结果
     */
    public int deleteTUserBalanceLogById(Long id);

    /**
     * 批量删除用户充值，提现
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTUserBalanceLogByIds(String[] ids);
}
