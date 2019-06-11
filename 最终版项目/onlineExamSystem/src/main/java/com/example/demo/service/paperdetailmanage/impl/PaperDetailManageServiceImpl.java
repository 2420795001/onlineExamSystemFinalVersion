package com.example.demo.service.paperdetailmanage.impl;

import com.example.demo.entity.paperdetail.PaperDetail;
import com.example.demo.mapper.paperdetailmanage.PaperDetailManageMapper;
import com.example.demo.service.paperdetailmanage.PaperDetailManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/26 13:13
 */
@Service
public class PaperDetailManageServiceImpl implements PaperDetailManageService {

    @Autowired
    PaperDetailManageMapper paperDetailManageMapper;

    @Override
    public boolean addPaperDetail(PaperDetail paperDetail) throws Exception{
        return paperDetailManageMapper.addPaperDetail(paperDetail);
    }

    @Override
    public boolean delPaperDetail(int pdid) throws Exception{
        return paperDetailManageMapper.delPaperDetail(pdid);
    }

}
