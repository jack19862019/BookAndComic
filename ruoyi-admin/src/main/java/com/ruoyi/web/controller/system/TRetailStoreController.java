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
import com.ruoyi.system.domain.site.TRetailStore;
import com.ruoyi.system.service.site.ITRetailStoreService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 分销配置Controller
 *
 * @author lucifer
 * @date 2020-04-11
 */

@Controller
@RequestMapping("/system/store")
public class TRetailStoreController extends BaseController
{
    private String prefix = "system/store";

    @Autowired
    private ITRetailStoreService tRetailStoreService;

    @RequiresPermissions("system:store:view")
    @GetMapping()
    public String store()
    {
        return prefix + "/store";
    }

    /**
     * 查询分销配置列表
     */
    @RequiresPermissions("system:store:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TRetailStore tRetailStore)
    {
        startPage();
        List<TRetailStore> list = tRetailStoreService.selectTRetailStoreList(tRetailStore);
        return getDataTable(list);
    }

    /**
     * 导出分销配置列表
     */
    @RequiresPermissions("system:store:export")
    @Log(title = "分销配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TRetailStore tRetailStore)
    {
        List<TRetailStore> list = tRetailStoreService.selectTRetailStoreList(tRetailStore);
        ExcelUtil<TRetailStore> util = new ExcelUtil<TRetailStore>(TRetailStore.class);
        return util.exportExcel(list, "store");
    }

    /**
     * 新增分销配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存分销配置
     */
    @RequiresPermissions("system:store:add")
    @Log(title = "分销配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TRetailStore tRetailStore)
    {
        return toAjax(tRetailStoreService.insertTRetailStore(tRetailStore));
    }

    /**
     * 修改分销配置
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TRetailStore tRetailStore = tRetailStoreService.selectTRetailStoreById(id);
        mmap.put("tRetailStore", tRetailStore);
        return prefix + "/edit";
    }

    /**
     * 修改保存分销配置
     */
    @RequiresPermissions("system:store:edit")
    @Log(title = "分销配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TRetailStore tRetailStore)
    {
        return toAjax(tRetailStoreService.updateTRetailStore(tRetailStore));
    }

    /**
     * 删除分销配置
     */
    @RequiresPermissions("system:store:remove")
    @Log(title = "分销配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tRetailStoreService.deleteTRetailStoreByIds(ids));
    }
}
