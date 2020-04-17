package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.site.TNotice;
import com.ruoyi.system.service.site.ITNoticeService;
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
 * 公告管理Controller
 * 
 * @author ruoyi
 * @date 2020-04-17
 */
@Controller
@RequestMapping("/notice/config")
public class TNoticeController extends BaseController
{
    private String prefix = "notice";

    @Autowired
    private ITNoticeService tNoticeService;

    @RequiresPermissions("notice:config:view")
    @GetMapping()
    public String notice()
    {
        return prefix + "/config";
    }

    /**
     * 查询公告管理列表
     */
    @RequiresPermissions("notice:config:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TNotice tNotice)
    {
        startPage();
        List<TNotice> list = tNoticeService.selectTNoticeList(tNotice);
        return getDataTable(list);
    }

    /**
     * 导出公告管理列表
     */
    @RequiresPermissions("notice:config:export")
    @Log(title = "公告管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TNotice tNotice)
    {
        List<TNotice> list = tNoticeService.selectTNoticeList(tNotice);
        ExcelUtil<TNotice> util = new ExcelUtil<TNotice>(TNotice.class);
        return util.exportExcel(list, "notice");
    }

    /**
     * 新增公告管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存公告管理
     */
    @RequiresPermissions("notice:config:add")
    @Log(title = "公告管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TNotice tNotice)
    {
        return toAjax(tNoticeService.insertTNotice(tNotice));
    }

    /**
     * 修改公告管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TNotice tNotice = tNoticeService.selectTNoticeById(id);
        mmap.put("tNotice", tNotice);
        return prefix + "/edit";
    }

    /**
     * 修改保存公告管理
     */
    @RequiresPermissions("notice:config:edit")
    @Log(title = "公告管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TNotice tNotice)
    {
        return toAjax(tNoticeService.updateTNotice(tNotice));
    }

    /**
     * 删除公告管理
     */
    @RequiresPermissions("notice:config:remove")
    @Log(title = "公告管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tNoticeService.deleteTNoticeByIds(ids));
    }
}
