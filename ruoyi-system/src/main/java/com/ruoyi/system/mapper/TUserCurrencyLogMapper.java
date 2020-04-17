package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.currency.TUserCurrencyLog;

import java.util.List;

/**
 * 用户书币变动记录Mapper接口
 *
 * @author ruoyi
 * @date 2020-04-17
 */
public interface TUserCurrencyLogMapper
{
    /**
     * 查询用户书币变动记录
     *
     * @param id 用户书币变动记录ID
     * @return 用户书币变动记录
     */
    public TUserCurrencyLog selectTUserCurrencyLogById(Long id);

    /**
     * 查询用户书币变动记录列表
     *
     * @param tUserCurrencyLog 用户书币变动记录
     * @return 用户书币变动记录集合
     */
    public List<TUserCurrencyLog> selectTUserCurrencyLogList(TUserCurrencyLog tUserCurrencyLog);

    /**
     * 新增用户书币变动记录
     *
     * @param tUserCurrencyLog 用户书币变动记录
     * @return 结果
     */
    public int insertTUserCurrencyLog(TUserCurrencyLog tUserCurrencyLog);

    /**
     * 修改用户书币变动记录
     *
     * @param tUserCurrencyLog 用户书币变动记录
     * @return 结果
     */
    public int updateTUserCurrencyLog(TUserCurrencyLog tUserCurrencyLog);

    /**
     * 删除用户书币变动记录
     *
     * @param id 用户书币变动记录ID
     * @return 结果
     */
    public int deleteTUserCurrencyLogById(Long id);

    /**
     * 批量删除用户书币变动记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTUserCurrencyLogByIds(String[] ids);
}
