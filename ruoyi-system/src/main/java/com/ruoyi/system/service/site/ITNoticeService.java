package com.ruoyi.system.service.site;

import java.util.List;
import com.ruoyi.system.domain.site.TNotice;

/**
 * 公告管理Service接口
 * 
 * @author ruoyi
 * @date 2020-04-17
 */
public interface ITNoticeService 
{
    /**
     * 查询公告管理
     * 
     * @param id 公告管理ID
     * @return 公告管理
     */
    public TNotice selectTNoticeById(Long id);

    /**
     * 查询公告管理列表
     * 
     * @param tNotice 公告管理
     * @return 公告管理集合
     */
    public List<TNotice> selectTNoticeList(TNotice tNotice);

    /**
     * 新增公告管理
     * 
     * @param tNotice 公告管理
     * @return 结果
     */
    public int insertTNotice(TNotice tNotice);

    /**
     * 修改公告管理
     * 
     * @param tNotice 公告管理
     * @return 结果
     */
    public int updateTNotice(TNotice tNotice);

    /**
     * 批量删除公告管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTNoticeByIds(String ids);

    /**
     * 删除公告管理信息
     * 
     * @param id 公告管理ID
     * @return 结果
     */
    public int deleteTNoticeById(Long id);
}
