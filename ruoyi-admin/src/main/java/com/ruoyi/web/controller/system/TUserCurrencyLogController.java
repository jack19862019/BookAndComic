package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.currency.TUserCurrencyLog;
import com.ruoyi.system.service.currency.ITUserCurrencyLogService;
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
 * 用户书币变动记录Controller
 *
 * @author ruoyi
 * @date 2020-04-17
 */
@Controller
@RequestMapping("/currency/log")
public class TUserCurrencyLogController extends BaseController
{
    private String prefix = "currency";

    @Autowired
    private ITUserCurrencyLogService tUserCurrencyLogService;

    @RequiresPermissions("currency:log:view")
    @GetMapping()
    public String log()
    {
        return prefix + "/list";
    }

    /**
     * 查询用户书币变动记录列表
     */
    @RequiresPermissions("currency:log:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TUserCurrencyLog tUserCurrencyLog)
    {
        startPage();
        List<TUserCurrencyLog> list = tUserCurrencyLogService.selectTUserCurrencyLogList(tUserCurrencyLog);
        return getDataTable(list);
    }

    /**
     * 导出用户书币变动记录列表
     */
    @RequiresPermissions("currency:log:export")
    @Log(title = "用户书币变动记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TUserCurrencyLog tUserCurrencyLog)
    {
        List<TUserCurrencyLog> list = tUserCurrencyLogService.selectTUserCurrencyLogList(tUserCurrencyLog);
        ExcelUtil<TUserCurrencyLog> util = new ExcelUtil<TUserCurrencyLog>(TUserCurrencyLog.class);
        return util.exportExcel(list, "log");
    }

    /**
     * 新增用户书币变动记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户书币变动记录
     */
    @RequiresPermissions("currency:log:add")
    @Log(title = "用户书币变动记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TUserCurrencyLog tUserCurrencyLog)
    {
        return toAjax(tUserCurrencyLogService.insertTUserCurrencyLog(tUserCurrencyLog));
    }

    /**
     * 修改用户书币变动记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TUserCurrencyLog tUserCurrencyLog = tUserCurrencyLogService.selectTUserCurrencyLogById(id);
        mmap.put("tUserCurrencyLog", tUserCurrencyLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户书币变动记录
     */
    @RequiresPermissions("currency:log:edit")
    @Log(title = "用户书币变动记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TUserCurrencyLog tUserCurrencyLog)
    {
        return toAjax(tUserCurrencyLogService.updateTUserCurrencyLog(tUserCurrencyLog));
    }

    /**
     * 删除用户书币变动记录
     */
    @RequiresPermissions("currency:log:remove")
    @Log(title = "用户书币变动记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tUserCurrencyLogService.deleteTUserCurrencyLogByIds(ids));
    }
}
