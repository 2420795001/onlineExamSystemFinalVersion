package com.example.demo.service.paperdetailmanage;

import com.example.demo.entity.paperdetail.PaperDetail;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/26 13:12
 */
public interface PaperDetailManageService {

    public boolean addPaperDetail(PaperDetail paperDetail) throws Exception;

    public boolean delPaperDetail(int pdid) throws Exception;

}
