package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysBook;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.service.ISysBookService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 小说管理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/book")
public class SysBookController extends BaseController
{
    @Autowired
    private ISysBookService bookService;

    private String prefix = "system/book";

    @RequiresPermissions("system:book:view")
    @GetMapping()
    public String book()
    {
        return prefix + "/book";
    }


    @RequiresPermissions("system:book:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysBook book)
    {
        startPage();
        List<SysBook> list = bookService.selectBookList(book);
        return getDataTable(list);
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
     * 新增小说
     */
    @RequiresPermissions("system:book:add")
    @Log(title = "小说", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysBook book)
    {
        book.setCreateTime(new Date());
        book.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(bookService.insertBook(book));
    }



    /**
     * 修改小说
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        mmap.put("book", bookService.selectBookById(id));
        return prefix + "/edit";
    }
    /**
     * 修改保存小说
     */
    @RequiresPermissions("system:book:edit")
    @Log(title = "小说", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public String editSave(SysBook book)
    {
        return "";
    }

    @RequiresPermissions("system:book:remove")
    @Log(title = "小说管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(bookService.deleteBookById(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }


    /**
     * 校验小说
     */
    @PostMapping("/checkTitleUnique")
    @ResponseBody
    public int checkTitleUnique(String title)
    {
        return bookService.checkTitleUnique(title);
    }

}