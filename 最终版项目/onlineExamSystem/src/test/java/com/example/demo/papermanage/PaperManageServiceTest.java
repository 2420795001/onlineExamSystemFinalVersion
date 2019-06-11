package com.example.demo.papermanage;

import com.example.demo.entity.paperdetail.PaperDetail;
import com.example.demo.mapper.papermanage.PaperManageMapper;
import com.example.demo.service.papermanage.PaperManageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : kongyy
 * @time : 2019/5/26 20:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaperManageServiceTest {

    @Autowired
    PaperManageService paperManageService;

    @Test
    public void testAddPaper() throws Exception{
        PaperDetail paperDetail = new PaperDetail();
        paperDetail.setPname("2019年郑州外国语周练语文试题");
        System.out.println(paperManageService.addPaper(paperDetail));
    }

    @Test
    public void testDelPaper() throws Exception{
        int pid = 2;
        System.out.println(paperManageService.delPaper(pid));
    }

    @Test
    public void testUpdatePaper() throws Exception{
        PaperDetail paperDetail = new PaperDetail();
        paperDetail.setPname("2018郑州外国语月考数学试卷");
        paperDetail.setPid(1);
        System.out.println(paperManageService.updatePaper(paperDetail));
    }

    @Test
    public void testListPaper() throws Exception{
        int pid = 1;
        System.out.println(paperManageService.listPaper(pid));
    }

    @Test
    public void testQueryPaper() throws Exception{
        String keyword = "郑州";
        System.out.println(paperManageService.queryPaper(keyword));
    }
}
