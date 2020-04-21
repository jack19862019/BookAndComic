package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.agent.TAgentBalanceLog;
import com.ruoyi.system.service.agent.ITAgentBalanceLogService;
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
 * 代理用户充值记录Controller
 *
 * @author ruoyi
 * @date 2020-04-19
 */
@Controller
@RequestMapping("/agent/balance/log")
public class TAgentBalanceLogController extends BaseController
{
    private String prefix = "agba";

    @Autowired
    private ITAgentBalanceLogService tAgentBalanceLogService;

    @RequiresPermissions("agba:log:view")
    @GetMapping()
    public String log(String id, ModelMap mmap)
    {
        mmap.put("agentId", id);
        return prefix + "/list";
    }

    /**
     * 查询充值记录列表
     */
    @RequiresPermissions("agba:log:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TAgentBalanceLog tAgentBalanceLog)
    {
        startPage();
        List<TAgentBalanceLog> list = tAgentBalanceLogService.selectTAgentBalanceLogList(tAgentBalanceLog);
        return getDataTable(list);
    }

    /**
     * 导出充值记录列表
     */
    @RequiresPermissions("agba:log:export")
    @Log(title = "充值记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TAgentBalanceLog tAgentBalanceLog)
    {
        List<TAgentBalanceLog> list = tAgentBalanceLogService.selectTAgentBalanceLogList(tAgentBalanceLog);
        ExcelUtil<TAgentBalanceLog> util = new ExcelUtil<TAgentBalanceLog>(TAgentBalanceLog.class);
        return util.exportExcel(list, "log");
    }

    /**
     * 新增充值记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存充值记录
     */
    @RequiresPermissions("agba:log:add")
    @Log(title = "充值记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TAgentBalanceLog tAgentBalanceLog)
    {
        return toAjax(tAgentBalanceLogService.insertTAgentBalanceLog(tAgentBalanceLog));
    }

    /**
     * 修改充值记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TAgentBalanceLog tAgentBalanceLog = tAgentBalanceLogService.selectTAgentBalanceLogById(id);
        mmap.put("tAgentBalanceLog", tAgentBalanceLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存充值记录
     */
    @RequiresPermissions("agba:log:edit")
    @Log(title = "充值记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TAgentBalanceLog tAgentBalanceLog)
    {
        return toAjax(tAgentBalanceLogService.updateTAgentBalanceLog(tAgentBalanceLog));
    }

    /**
     * 删除充值记录
     */
    @RequiresPermissions("agba:log:remove")
    @Log(title = "充值记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tAgentBalanceLogService.deleteTAgentBalanceLogByIds(ids));
    }
}
