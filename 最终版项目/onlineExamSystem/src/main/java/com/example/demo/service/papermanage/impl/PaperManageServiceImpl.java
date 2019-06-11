package com.example.demo.service.papermanage.impl;

import com.example.demo.entity.paperdetail.PaperDetail;
import com.example.demo.mapper.papermanage.PaperManageMapper;
import com.example.demo.service.papermanage.PaperManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/26 19:18
 */
@Service
public class PaperManageServiceImpl implements PaperManageService {

    @Autowired
    PaperManageMapper paperManageMapper;

    @Override
    public boolean updatePaper(PaperDetail paperDetail) throws Exception{
        return paperManageMapper.updatePaper(paperDetail);
    }

    @Override
    public boolean addPaper(PaperDetail paperDetail) throws Exception{
        return paperManageMapper.addPaper(paperDetail);
    }

    @Override
    public boolean delPaper(int pid) throws Exception{
        return paperManageMapper.delPaper(pid);
    }

    @Override
    public List<PaperDetail> listAllPaper() throws Exception{
        List<PaperDetail> list = Collections.emptyList();
        list = paperManageMapper.listAllPaper();
        return list;
    }

    @Override
    public List<PaperDetail> queryPaper(String keyword) throws Exception{
        List<PaperDetail> list = Collections.emptyList();
        keyword = "%" + keyword + "%";
        list = paperManageMapper.queryPaper(keyword);
        return list;
    }

    @Override
    public List<PaperDetail> listPaper(int pid) throws Exception{
        List<PaperDetail> list = Collections.emptyList();
        list = paperManageMapper.listPaper(pid);
        return list;
    }
}
