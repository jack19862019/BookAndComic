package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.site.TAdvertisingConfig;
import com.ruoyi.system.service.site.ITAdvertisingConfigService;
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
 * 广告配置Controller
 *
 * @author ruoyi
 * @date 2020-04-14
 */
@Controller
@RequestMapping("/advertising/config")
public class TAdvertisingConfigController extends BaseController
{
    private String prefix = "advertising";

    @Autowired
    private ITAdvertisingConfigService tAdvertisingConfigService;

    @RequiresPermissions("advertising:config:view")
    @GetMapping()
    public String config()
    {
        return prefix + "/config";
    }

    /**
     * 查询广告配置列表
     */
    @RequiresPermissions("advertising:config:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TAdvertisingConfig tAdvertisingConfig)
    {
        startPage();
        List<TAdvertisingConfig> list = tAdvertisingConfigService.selectTAdvertisingConfigList(tAdvertisingConfig);
        return getDataTable(list);
    }

    /**
     * 图片上传
     */
    @GetMapping("/img")
    public String avatar()
    {
        return prefix + "/profile/advertisingImg";
    }

    /**
     * 新增广告配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存广告配置
     */
    @RequiresPermissions("advertising:config:add")
    @Log(title = "广告配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TAdvertisingConfig tAdvertisingConfig)
    {
        return toAjax(tAdvertisingConfigService.insertTAdvertisingConfig(tAdvertisingConfig));
    }

    /**
     * 修改广告配置
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TAdvertisingConfig tAdvertisingConfig = tAdvertisingConfigService.selectTAdvertisingConfigById(id);
        mmap.put("tAdvertisingConfig", tAdvertisingConfig);
        return prefix + "/edit";
    }

    /**
     * 修改保存广告配置
     */
    @RequiresPermissions("advertising:config:edit")
    @Log(title = "广告配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TAdvertisingConfig tAdvertisingConfig)
    {
        return toAjax(tAdvertisingConfigService.updateTAdvertisingConfig(tAdvertisingConfig));
    }

    /**
     * 删除广告配置
     */
    @RequiresPermissions("advertising:config:remove")
    @Log(title = "广告配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tAdvertisingConfigService.deleteTAdvertisingConfigByIds(ids));
    }
}
