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
@RequestMapping("/statistics/user")
public class TUserStatisticsController extends BaseController
{
    private String prefix = "userStatistics";

    @Autowired
    private ITUserService tUserService;

    @RequiresPermissions("statistics:user:view")
    @GetMapping()
    public String user(ModelMap mmap)
    {
        mmap.put("userDay", tUserService.userDay());
        mmap.put("userYesterday", tUserService.userYesterday());
        mmap.put("userMonth", tUserService.userMonth());
        mmap.put("userTotal", tUserService.userTotal());
        return prefix + "/list";
    }

    /**
     * 查询用户基本信息列表
     */
    @RequiresPermissions("statistics:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TUser tUser)
    {
        startPage();
        List<TUser> list = tUserService.selectTUserList(tUser);
        return getDataTable(list);
    }

}
