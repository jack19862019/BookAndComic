package com.ruoyi.web.controller.system;

import java.util.List;
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
import com.ruoyi.system.domain.site.TWebSite;
import com.ruoyi.system.service.site.ITWebSiteService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 站点配置Controller
 *
 * @author lucifer
 * @date 2020-04-11
 */
@Controller
@RequestMapping("/system/site")
public class TWebSiteController extends BaseController
{
    private String prefix = "system/site";

    @Autowired
    private ITWebSiteService tWebSiteService;

    @RequiresPermissions("system:site:view")
    @GetMapping()
    public String site()
    {
        return prefix + "/site";
    }

    /**
     * 查询站点配置列表
     */
    @RequiresPermissions("system:site:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TWebSite tWebSite)
    {
        startPage();
        List<TWebSite> list = tWebSiteService.selectTWebSiteList(tWebSite);
        return getDataTable(list);
    }

    /**
     * 新增站点配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存站点配置
     */
    @RequiresPermissions("system:site:add")
    @Log(title = "站点配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TWebSite tWebSite)
    {
        return toAjax(tWebSiteService.insertTWebSite(tWebSite));
    }

    /**
     * 修改站点配置
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TWebSite tWebSite = tWebSiteService.selectTWebSiteById(id);
        mmap.put("tWebSite", tWebSite);
        return prefix + "/edit";
    }

    /**
     * 修改保存站点配置
     */
    @RequiresPermissions("system:site:edit")
    @Log(title = "站点配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TWebSite tWebSite)
    {
        return toAjax(tWebSiteService.updateTWebSite(tWebSite));
    }

    /**
     * 删除站点配置
     */
    @RequiresPermissions("system:site:remove")
    @Log(title = "站点配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tWebSiteService.deleteTWebSiteByIds(ids));
    }
}
