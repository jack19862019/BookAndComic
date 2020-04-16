package com.ruoyi.system.service.user;

import com.ruoyi.system.domain.user.TUser;
import com.ruoyi.system.domain.user.params.TUserDetail;

import java.util.List;

/**
 * 用户基本信息Service接口
 *
 * @author ruoyi
 * @date 2020-04-15
 */
public interface ITUserService
{
    /**
     * 查询用户基本信息
     *
     * @param id 用户基本信息ID
     * @return 用户基本信息
     */
    public TUser selectTUserById(Long id);

    /**
     * 查询用户上一级
     * @param id
     * @return
     */
    String selectUserUpOneLevel(Long id);

    /**
     * 查询用户上二级
     * @param id
     * @return
     */
    String selectUserUpTwoLevel(Long id);

    /**
     * 查询用户基本信息列表
     *
     * @param tUser 用户基本信息
     * @return 用户基本信息集合
     */
    public List<TUser> selectTUserList(TUser tUser);

}
