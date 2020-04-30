package com.ruoyi.system.service.book.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.book.TBook;
import com.ruoyi.system.domain.book.TBookEpisodes;
import com.ruoyi.system.domain.book.TBookParams;
import com.ruoyi.system.mapper.TBookMapper;
import com.ruoyi.system.service.book.ITBookEpisodesService;
import com.ruoyi.system.service.book.ITBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 小说Service业务层处理
 *
 * @author ruoyi
 * @date 2020-04-17
 */
@Service
public class TBookServiceImpl implements ITBookService {
    @Autowired
    private TBookMapper tBookMapper;

    /**
     * 查询小说
     *
     * @param id 小说ID
     * @return 小说
     */
    @Override
    public TBook selectTBookById(Long id) {
        return tBookMapper.selectTBookById(id);
    }

    /**
     * 查询小说列表
     *
     * @param tBook 小说
     * @return 小说
     */
    @Override
    public List<TBook> selectTBookList(TBook tBook) {
        return tBookMapper.selectTBookList(tBook);
    }

    /**
     * 新增小说
     *
     * @param tBook 小说
     * @return 结果
     */
    @Override
    public int insertTBook(TBook tBook) {
        tBook.setCreateTime(DateUtils.getNowDate());
        return tBookMapper.insertTBook(tBook);
    }

    /**
     * 修改小说
     *
     * @param tBook 小说
     * @return 结果
     */
    @Override
    public int updateTBook(TBook tBook) {
        tBook.setUpdateTime(DateUtils.getNowDate());
        return tBookMapper.updateTBook(tBook);
    }

    /**
     * 删除小说对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTBookByIds(String ids) {
        return tBookMapper.deleteTBookByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小说信息
     *
     * @param id 小说ID
     * @return 结果
     */
    @Override
    public int deleteTBookById(Long id) {
        return tBookMapper.deleteTBookById(id);
    }

//    @Override
//    public List<TBook> selectList() {
//        return tBookMapper.selectList();
//    }
//
//    @Override
//    public void updateUrl(TBook tBook) {
//        try {
//            Document document = JsoupUtil.getDoc(tBook.getCoverPic());
//            String img = document.select("div>img").attr("abs:src");
//            tBook.setCoverPic(img);
//            tBookMapper.updateUrl(tBook);
//        } catch (Exception e) {
//            e.getMessage();
//        }
//    }
    @Autowired
    private ITBookEpisodesService itBookEpisodesService;


    @Override
    public void bookUpdate(TBookParams tBookParams) {
        try {
            TBookEpisodes tBookEpisodes = new TBookEpisodes();
            tBookEpisodes.setBid(tBookParams.getBid());
            List<TBookEpisodes> list = itBookEpisodesService.selectTBookEpisodesList(tBookEpisodes);
            for (int i = 0; i < list.size(); i++) {
                if ((i + 1) >= tBookParams.getSort()) {
                    tBookEpisodes.setMoney(tBookParams.getMoney());
                } else {
                    tBookEpisodes.setMoney(0.00);
                }
                tBookEpisodes.setId(list.get(i).getId());
                itBookEpisodesService.updateTBookEpisodes(tBookEpisodes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
