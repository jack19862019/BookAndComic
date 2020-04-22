package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.share.TAgentShareLog;
import com.ruoyi.system.service.share.ITAgentShareLogService;
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
 * 分佣记录Controller
 *
 * @author ruoyi
 * @date 2020-04-21
 */
@Controller
@RequestMapping("/share/log")
public class TAgentShareLogController extends BaseController
{
    private String prefix = "share";

    @Autowired
    private ITAgentShareLogService tAgentShareLogService;

    @RequiresPermissions("share:log:view")
    @GetMapping()
    public String log(String id, ModelMap mmap)
    {
        mmap.put("agentId", id);
        return prefix + "/log";
    }

    /**
     * 查询分佣记录列表
     */
    @RequiresPermissions("share:log:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TAgentShareLog tAgentShareLog)
    {
        startPage();
        List<TAgentShareLog> list = tAgentShareLogService.selectTAgentShareLogList(tAgentShareLog);
        return getDataTable(list);
    }

    /**
     * 导出分佣记录列表
     */
    @RequiresPermissions("share:log:export")
    @Log(title = "分佣记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TAgentShareLog tAgentShareLog)
    {
        List<TAgentShareLog> list = tAgentShareLogService.selectTAgentShareLogList(tAgentShareLog);
        ExcelUtil<TAgentShareLog> util = new ExcelUtil<TAgentShareLog>(TAgentShareLog.class);
        return util.exportExcel(list, "log");
    }

    /**
     * 新增分佣记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存分佣记录
     */
    @RequiresPermissions("share:log:add")
    @Log(title = "分佣记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TAgentShareLog tAgentShareLog)
    {
        return toAjax(tAgentShareLogService.insertTAgentShareLog(tAgentShareLog));
    }

    /**
     * 修改分佣记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TAgentShareLog tAgentShareLog = tAgentShareLogService.selectTAgentShareLogById(id);
        mmap.put("tAgentShareLog", tAgentShareLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存分佣记录
     */
    @RequiresPermissions("share:log:edit")
    @Log(title = "分佣记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TAgentShareLog tAgentShareLog)
    {
        return toAjax(tAgentShareLogService.updateTAgentShareLog(tAgentShareLog));
    }

    /**
     * 删除分佣记录
     */
    @RequiresPermissions("share:log:remove")
    @Log(title = "分佣记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tAgentShareLogService.deleteTAgentShareLogByIds(ids));
    }
}
