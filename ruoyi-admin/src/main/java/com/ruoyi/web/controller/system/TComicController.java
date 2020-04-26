package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.book.TBookEpisodes;
import com.ruoyi.system.domain.book.TBookParams;
import com.ruoyi.system.domain.comic.ComicParams;
import com.ruoyi.system.domain.comic.TComic;
import com.ruoyi.system.domain.comic.TComicEpisodes;
import com.ruoyi.system.service.comic.ITComicEpisodesService;
import com.ruoyi.system.service.comic.ITComicService;
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
 * 漫画管理Controller
 * 
 * @author ruoyi
 * @date 2020-04-22
 */
@Controller
@RequestMapping("/system/comic")
public class TComicController extends BaseController
{
    private String prefix = "/comic";

    @Autowired
    private ITComicService tComicService;
    @Autowired
    private ITComicEpisodesService itComicEpisodesService;
    @RequiresPermissions("system:comic:view")
    @GetMapping()
    public String comic()
    {
        return prefix + "/list";
    }

    /**
     * 查询漫画管理列表
     */
    @RequiresPermissions("system:comic:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TComic tComic)
    {
        startPage();
        List<TComic> list = tComicService.selectTComicList(tComic);
        return getDataTable(list);
    }

    /**
     * 导出漫画管理列表
     */
    @RequiresPermissions("system:comic:export")
    @Log(title = "漫画管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TComic tComic)
    {
        List<TComic> list = tComicService.selectTComicList(tComic);
        ExcelUtil<TComic> util = new ExcelUtil<TComic>(TComic.class);
        return util.exportExcel(list, "comic");
    }

    /**
     * 新增漫画管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存漫画管理
     */
    @RequiresPermissions("system:comic:add")
    @Log(title = "漫画管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TComic tComic)
    {
        return toAjax(tComicService.insertTComic(tComic));
    }

    /**
     * 修改漫画管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TComic tComic = tComicService.selectTComicById(id);
        mmap.put("tComic", tComic);
        return prefix + "/edit";
    }

    /**
     * 修改保存漫画管理
     */
    @RequiresPermissions("system:comic:edit")
    @Log(title = "漫画管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TComic tComic)
    {
        return toAjax(tComicService.updateTComic(tComic));
    }

    /**
     * 删除漫画管理
     */
    @RequiresPermissions("system:comic:remove")
    @Log(title = "漫画管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tComicService.deleteTComicByIds(ids));
    }

    /**
     * 进入漫画收费设置
     */
    @RequiresPermissions("system:comic:setUp")
    @Log(title = "漫画收费设置", businessType = BusinessType.UPDATE)
    @GetMapping("/setUp/{id}")
    public String setUp(@PathVariable("id") Long id, ModelMap mmap)
    {
        ComicParams comic = itComicEpisodesService.comicSetUp(id);
        if(comic==null){
            ComicParams c = new ComicParams();
            c.setComicId(id);
            c.setMoney(0.00);
            c.setJiNo(0);
            Long num = itComicEpisodesService.count(id);
            c.setNum(num);
            mmap.put("comic", c);
        }else{
            mmap.put("comic", comic);
        }
        return prefix + "/setUp";

    }

    /**
     * 新增保存小说
     */
    @RequiresPermissions("system:comic:setUp")
    @Log(title = "漫画收费设置", businessType = BusinessType.INSERT)
    @PostMapping("/setUp")
    @ResponseBody
    public AjaxResult updateTComic(ComicParams comicParams)
    {
        tComicService.comicUpdate(comicParams);
        return toAjax(1);
    }
}
