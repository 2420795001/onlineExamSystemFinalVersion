package com.example.demo.service.papermanage;

import com.example.demo.entity.paperdetail.PaperDetail;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/26 19:17
 */
public interface PaperManageService {

    public boolean addPaper(PaperDetail paperDetail) throws Exception;

    public boolean delPaper(int pid) throws Exception;

    public boolean updatePaper(PaperDetail paperDetail) throws Exception;

    public List<PaperDetail> listAllPaper() throws Exception;

    public List<PaperDetail> queryPaper(String keyword) throws Exception;

    public List<PaperDetail> listPaper(int pid) throws Exception;


}
