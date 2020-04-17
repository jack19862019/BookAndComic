package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.site.TArticle;
import com.ruoyi.system.service.site.ITArticleService;
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
 * 消息管理Controller
 * 
 * @author ruoyi
 * @date 2020-04-17
 */
@Controller
@RequestMapping("/system/article")
public class TArticleController extends BaseController
{
    private String prefix = "system/article";

    @Autowired
    private ITArticleService tArticleService;

    @RequiresPermissions("system:article:view")
    @GetMapping()
    public String article()
    {
        return prefix + "/list";
    }

    /**
     * 查询消息管理列表
     */
    @RequiresPermissions("system:article:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TArticle tArticle)
    {
        startPage();
        List<TArticle> list = tArticleService.selectTArticleList(tArticle);
        return getDataTable(list);
    }

    /**
     * 导出消息管理列表
     */
    @RequiresPermissions("system:article:export")
    @Log(title = "消息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TArticle tArticle)
    {
        List<TArticle> list = tArticleService.selectTArticleList(tArticle);
        ExcelUtil<TArticle> util = new ExcelUtil<TArticle>(TArticle.class);
        return util.exportExcel(list, "article");
    }

    /**
     * 新增消息管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存消息管理
     */
    @RequiresPermissions("system:article:add")
    @Log(title = "消息管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TArticle tArticle)
    {
        return toAjax(tArticleService.insertTArticle(tArticle));
    }

    /**
     * 修改消息管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TArticle tArticle = tArticleService.selectTArticleById(id);
        mmap.put("tArticle", tArticle);
        return prefix + "/edit";
    }

    /**
     * 修改保存消息管理
     */
    @RequiresPermissions("system:article:edit")
    @Log(title = "消息管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TArticle tArticle)
    {
        return toAjax(tArticleService.updateTArticle(tArticle));
    }

    /**
     * 删除消息管理
     */
    @RequiresPermissions("system:article:remove")
    @Log(title = "消息管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tArticleService.deleteTArticleByIds(ids));
    }
}
