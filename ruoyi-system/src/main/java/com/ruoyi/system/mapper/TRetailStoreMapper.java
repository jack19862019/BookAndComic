package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.site.TRetailStore;

/**
 * 分销配置Mapper接口
 *
 * @author lucifer
 * @date 2020-04-11
 */
public interface TRetailStoreMapper
{
    /**
     * 查询分销配置
     *
     * @param id 分销配置ID
     * @return 分销配置
     */
    public TRetailStore selectTRetailStoreById(Long id);

    /**
     * 查询分销配置列表
     *
     * @param tRetailStore 分销配置
     * @return 分销配置集合
     */
    public List<TRetailStore> selectTRetailStoreList(TRetailStore tRetailStore);

    /**
     * 新增分销配置
     *
     * @param tRetailStore 分销配置
     * @return 结果
     */
    public int insertTRetailStore(TRetailStore tRetailStore);

    /**
     * 修改分销配置
     *
     * @param tRetailStore 分销配置
     * @return 结果
     */
    public int updateTRetailStore(TRetailStore tRetailStore);

    /**
     * 删除分销配置
     *
     * @param id 分销配置ID
     * @return 结果
     */
    public int deleteTRetailStoreById(Long id);

    /**
     * 批量删除分销配置
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTRetailStoreByIds(String[] ids);

    /**
     * 统计所有条数
     * @return
     */
    int countList();

}
