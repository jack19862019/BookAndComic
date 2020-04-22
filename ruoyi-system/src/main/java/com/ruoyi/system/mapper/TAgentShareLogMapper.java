package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.share.TAgentShareLog;

import java.util.List;

/**
 * 分佣记录Mapper接口
 *
 * @author ruoyi
 * @date 2020-04-21
 */
public interface TAgentShareLogMapper
{
    /**
     * 查询分佣记录
     *
     * @param id 分佣记录ID
     * @return 分佣记录
     */
    public TAgentShareLog selectTAgentShareLogById(Long id);

    /**
     * 查询分佣记录列表
     *
     * @param tAgentShareLog 分佣记录
     * @return 分佣记录集合
     */
    public List<TAgentShareLog> selectTAgentShareLogList(TAgentShareLog tAgentShareLog);

    /**
     * 新增分佣记录
     *
     * @param tAgentShareLog 分佣记录
     * @return 结果
     */
    public int insertTAgentShareLog(TAgentShareLog tAgentShareLog);

    /**
     * 修改分佣记录
     *
     * @param tAgentShareLog 分佣记录
     * @return 结果
     */
    public int updateTAgentShareLog(TAgentShareLog tAgentShareLog);

    /**
     * 删除分佣记录
     *
     * @param id 分佣记录ID
     * @return 结果
     */
    public int deleteTAgentShareLogById(Long id);

    /**
     * 批量删除分佣记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTAgentShareLogByIds(String[] ids);

    /**
     * 查询今日分成
     */
    public Double shareDay();
    /**
     * 查询昨日分成
     */
    public Double shareYesterday();
    /**
     * 查询本月分成
     */
    public Double shareMonth();
    /**
     * 查询累计分成
     */
    public Double shareTotal();
}
