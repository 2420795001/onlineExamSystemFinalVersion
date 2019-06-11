package com.example.demo.paperdetailmanage;

import com.example.demo.entity.paperdetail.PaperDetail;
import com.example.demo.service.paperdetailmanage.PaperDetailManageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : kongyy
 * @time : 2019/5/26 14:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaperDetailManageServiceTest {

    @Autowired
    PaperDetailManageService paperDetailManageService;

    @Test
    public void testAddPaperDetail() throws Exception{
        PaperDetail paperDetail = new PaperDetail();
        paperDetail.setPid(1);
        paperDetail.setQid(7);
        paperDetailManageService.addPaperDetail(paperDetail);
    }

    @Test
    public void testDelPaperDetail() throws Exception{
        int pdid = 3;
        paperDetailManageService.delPaperDetail(pdid);
    }



}
