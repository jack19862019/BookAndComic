package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.balance.TUserBalanceLog;
import com.ruoyi.system.service.balance.ITUserBalanceLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户充值，提现Controller
 *
 * @author ruoyi
 * @date 2020-04-16
 */
@Controller
@RequestMapping("/balance/log")
public class TUserBalanceLogController extends BaseController
{
    private String prefix = "balance";

    @Autowired
    private ITUserBalanceLogService tUserBalanceLogService;

    @RequiresPermissions("balance:log:view")
    @GetMapping()
    public String log()
    {
        return prefix + "/list";
    }

    /**
     * 查询用户充值，提现列表
     */
    @RequiresPermissions("balance:log:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TUserBalanceLog tUserBalanceLog)
    {
        startPage();
        List<TUserBalanceLog> list = tUserBalanceLogService.selectTUserBalanceLogList(tUserBalanceLog);
        return getDataTable(list);
    }

    /**
     * 导出用户充值，提现列表
     */
    @RequiresPermissions("balance:log:export")
    @Log(title = "用户充值，提现", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TUserBalanceLog tUserBalanceLog)
    {
        List<TUserBalanceLog> list = tUserBalanceLogService.selectTUserBalanceLogList(tUserBalanceLog);
        ExcelUtil<TUserBalanceLog> util = new ExcelUtil<TUserBalanceLog>(TUserBalanceLog.class);
        return util.exportExcel(list, "log");
    }

    /**
     * 新增用户充值，提现
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户充值，提现
     */
    @RequiresPermissions("balance:log:add")
    @Log(title = "用户充值，提现", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TUserBalanceLog tUserBalanceLog)
    {
        return toAjax(tUserBalanceLogService.insertTUserBalanceLog(tUserBalanceLog));
    }

    /**
     * 修改用户充值，提现
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TUserBalanceLog tUserBalanceLog = tUserBalanceLogService.selectTUserBalanceLogById(id);
        mmap.put("tUserBalanceLog", tUserBalanceLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户充值，提现
     */
    @RequiresPermissions("balance:log:edit")
    @Log(title = "用户充值，提现", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TUserBalanceLog tUserBalanceLog)
    {
        return toAjax(tUserBalanceLogService.updateTUserBalanceLog(tUserBalanceLog));
    }

    /**
     * 删除用户充值，提现
     */
    @RequiresPermissions("balance:log:remove")
    @Log(title = "用户充值，提现", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tUserBalanceLogService.deleteTUserBalanceLogByIds(ids));
    }
}
