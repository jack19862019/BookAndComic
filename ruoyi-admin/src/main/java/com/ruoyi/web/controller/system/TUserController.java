package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.user.TUser;
import com.ruoyi.system.service.user.ITUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户基本信息Controller
 *
 * @author ruoyi
 * @date 2020-04-15
 */
@Controller
@RequestMapping("/business/user")
public class TUserController extends BaseController
{
    private String prefix = "/user";

    @Autowired
    private ITUserService tUserService;

    @RequiresPermissions("business:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/list";
    }

    /**
     * 查询用户基本信息列表
     */
    @RequiresPermissions("business:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TUser tUser)
    {
        startPage();
        List<TUser> list = tUserService.selectTUserList(tUser);
        return getDataTable(list);
    }

    /**
     * 导出用户基本信息列表
     */
    @RequiresPermissions("business:user:export")
    @Log(title = "用户基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TUser tUser)
    {
        List<TUser> list = tUserService.selectTUserList(tUser);
        ExcelUtil<TUser> util = new ExcelUtil<TUser>(TUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 修改用户基本信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TUser tUser = tUserService.selectTUserById(id);

        mmap.put("tUser", tUser);
        return prefix + "/edit";
    }
}
