package com.ruoyi.system.service.currency.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.currency.TUserCurrencyLog;
import com.ruoyi.system.mapper.TUserCurrencyLogMapper;
import com.ruoyi.system.service.currency.ITUserCurrencyLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户书币变动记录Service业务层处理
 *
 * @author ruoyi
 * @date 2020-04-17
 */
@Service
public class TUserCurrencyLogServiceImpl implements ITUserCurrencyLogService
{
    @Autowired
    private TUserCurrencyLogMapper tUserCurrencyLogMapper;

    /**
     * 查询用户书币变动记录
     *
     * @param id 用户书币变动记录ID
     * @return 用户书币变动记录
     */
    @Override
    public TUserCurrencyLog selectTUserCurrencyLogById(Long id)
    {
        return tUserCurrencyLogMapper.selectTUserCurrencyLogById(id);
    }

    /**
     * 查询用户书币变动记录列表
     *
     * @param tUserCurrencyLog 用户书币变动记录
     * @return 用户书币变动记录
     */
    @Override
    public List<TUserCurrencyLog> selectTUserCurrencyLogList(TUserCurrencyLog tUserCurrencyLog)
    {
        return tUserCurrencyLogMapper.selectTUserCurrencyLogList(tUserCurrencyLog);
    }

    /**
     * 新增用户书币变动记录
     *
     * @param tUserCurrencyLog 用户书币变动记录
     * @return 结果
     */
    @Override
    public int insertTUserCurrencyLog(TUserCurrencyLog tUserCurrencyLog)
    {
        tUserCurrencyLog.setCreateTime(DateUtils.getNowDate());
        return tUserCurrencyLogMapper.insertTUserCurrencyLog(tUserCurrencyLog);
    }

    /**
     * 修改用户书币变动记录
     *
     * @param tUserCurrencyLog 用户书币变动记录
     * @return 结果
     */
    @Override
    public int updateTUserCurrencyLog(TUserCurrencyLog tUserCurrencyLog)
    {
        tUserCurrencyLog.setUpdateTime(DateUtils.getNowDate());
        return tUserCurrencyLogMapper.updateTUserCurrencyLog(tUserCurrencyLog);
    }

    /**
     * 删除用户书币变动记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTUserCurrencyLogByIds(String ids)
    {
        return tUserCurrencyLogMapper.deleteTUserCurrencyLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户书币变动记录信息
     *
     * @param id 用户书币变动记录ID
     * @return 结果
     */
    @Override
    public int deleteTUserCurrencyLogById(Long id)
    {
        return tUserCurrencyLogMapper.deleteTUserCurrencyLogById(id);
    }
}
