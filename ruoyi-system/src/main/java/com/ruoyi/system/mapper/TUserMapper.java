package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.user.TUser;
import com.ruoyi.system.domain.user.params.TUserDetail;

import java.util.List;

/**
 * 用户基本信息Mapper接口
 *
 * @author ruoyi
 * @date 2020-04-15
 */
public interface TUserMapper
{
    /**
     * 查询用户基本信息
     *
     * @param id 用户基本信息ID
     * @return 用户基本信息
     */
    public TUser selectTUserById(Long id);

    /**
     * 查询用户基本信息列表
     *
     * @param tUser 用户基本信息
     * @return 用户基本信息集合
     */
    public List<TUser> selectTUserList(TUser tUser);

    /**
     * 新增用户基本信息
     *
     * @param tUser 用户基本信息
     * @return 结果
     */
    public int insertTUser(TUser tUser);

    /**
     * 修改用户基本信息
     *
     * @param tUser 用户基本信息
     * @return 结果
     */
    public int updateTUser(TUser tUser);

    /**
     * 删除用户基本信息
     *
     * @param id 用户基本信息ID
     * @return 结果
     */
    public int deleteTUserById(Long id);

    /**
     * 批量删除用户基本信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTUserByIds(String[] ids);

    String selectUserUpOneLevel(Long id);

    String selectUserUpTwoLevel(Long id);
}
