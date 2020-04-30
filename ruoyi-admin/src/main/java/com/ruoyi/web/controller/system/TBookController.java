package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.book.TBookEpisodes;
import com.ruoyi.system.domain.book.TBookParams;
import com.ruoyi.system.service.book.ITBookEpisodesService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.book.TBook;
import com.ruoyi.system.service.book.ITBookService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;


/**
 * 小说Controller
 *
 * @author ruoyi
 * @date 2020-04-17
 */
@Controller
@RequestMapping("/business/book")
public class TBookController extends BaseController
{
    private String prefix = "book";

    @Autowired
    private ITBookService tBookService;

    @Autowired
    private ITBookEpisodesService itBookEpisodesService;

    @RequiresPermissions("business:book:view")
    @GetMapping()
    public String book()
    {
        return prefix + "/list";
    }

    /**
     * 查询小说列表
     */
    @RequiresPermissions("business:book:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TBook tBook)
    {
        startPage();
        List<TBook> list = tBookService.selectTBookList(tBook);
        return getDataTable(list);
    }

    /**
     * 导出小说列表
     */
    @RequiresPermissions("business:book:export")
    @Log(title = "小说", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TBook tBook)
    {
        List<TBook> list = tBookService.selectTBookList(tBook);
        ExcelUtil<TBook> util = new ExcelUtil<TBook>(TBook.class);
        return util.exportExcel(list, "book");
    }

    /**
     * 新增小说
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存小说
     */
    @RequiresPermissions("business:book:add")
    @Log(title = "小说", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TBook tBook)
    {
        return toAjax(tBookService.insertTBook(tBook));
    }

    /**
     * 修改小说
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TBook tBook = tBookService.selectTBookById(id);
        mmap.put("tBook", tBook);
        return prefix + "/edit";
    }

    /**
     * 修改保存小说
     */
    @RequiresPermissions("business:book:edit")
    @Log(title = "小说", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TBook tBook)
    {
        return toAjax(tBookService.updateTBook(tBook));
    }

    /**
     * 删除小说
     */
    @RequiresPermissions("business:book:remove")
    @Log(title = "小说", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tBookService.deleteTBookByIds(ids));
    }

    /*
    返回一本小说所有章节
     */
    @PostMapping("/chapterList")
    @ResponseBody
    public TableDataInfo list(TBookEpisodes tBookEpisodes)
    {
        startPage();
        List<TBookEpisodes> list =itBookEpisodesService.selectTBookEpisodesList(tBookEpisodes);
        return getDataTable(list);
    }

//    /*
//    返回一本小说所有章节
//     */
//    @PostMapping("/updateUrl")
//    @ResponseBody
//    public void updateUrl()
//    {
//        List<TBook> list = tBookService.selectList();
//        for (int i=0; i<list.size(); i++){
//            tBookService.updateUrl(list.get(i));
//        }
//    }


    /**
     * 进入小说收费设置
     */
    @RequiresPermissions("business:book:setUp")
    @Log(title = "小说收费设置", businessType = BusinessType.UPDATE)
    @GetMapping("/setUp/{id}")
    public String setUp(@PathVariable("id") Long id, ModelMap mmap)
    {
        TBookParams tBook = itBookEpisodesService.bookSetUp(id);
        if(tBook==null){
            TBookParams t =new TBookParams();
            t.setBid(id);
            t.setMoney(0.00);
            t.setSort(0);
            Long num = itBookEpisodesService.count(id);
            t.setNum(num);
            mmap.put("tBook", t);
        }else{
            mmap.put("tBook", tBook);
        }
        return prefix + "/setUp";
    }

    /**
     * 新增保存小说
     */
    @RequiresPermissions("business:book:setUp")
    @Log(title = "小说收费设置", businessType = BusinessType.INSERT)
    @PostMapping("/setUp")
    @ResponseBody
    public AjaxResult updateTBook(TBookParams tBookParams)
    {
        tBookService.bookUpdate(tBookParams);
        return toAjax(1);
    }

}
