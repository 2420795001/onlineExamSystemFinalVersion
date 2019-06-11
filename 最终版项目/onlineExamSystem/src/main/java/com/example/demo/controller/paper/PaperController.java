package com.example.demo.controller.paper;

import com.example.demo.entity.paperdetail.PaperDetail;
import com.example.demo.service.papermanage.PaperManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/6/2 9:37
 */
@CrossOrigin(allowCredentials = "true")
@RestController
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    PaperManageService paperManageService;

    /**
     * 在试卷管理页面添加试卷
     * @param pname
     * @param duration
     * @throws Exception
     */
    @RequestMapping(value = "/addPaper")
    public void addPaper(String pname, String duration) throws Exception{
        PaperDetail paperDetail = new PaperDetail();
        paperDetail.setPname(pname);
        paperDetail.setDuration(duration);
        if(paperManageService.addPaper(paperDetail)){
            System.out.println("添加成功");
        }
        else {
            System.out.println("添加失败");
        }
    }

    /**
     * 在试卷管理页面删除试卷
     * @param pidStr
     * @throws Exception
     */
    @RequestMapping(value = "/delPaper")
    public void delPaper(String pidStr) throws Exception{
        int pid = Integer.parseInt(pidStr);
        if(paperManageService.delPaper(pid)){
            System.out.println("删除成功");
        }
        else {
            System.out.println("删除失败");
        }
    }

    /**
     * 在试卷管理页面修改试卷的名字，考试时长等
     * @param pidStr
     * @param pname
     * @param duration
     * @throws Exception
     */
    @RequestMapping(value = "updatePaper")
    public void updatePaper(String pidStr, String pname, String duration)throws Exception{
        PaperDetail paperDetail = new PaperDetail();
        int pid = Integer.parseInt(pidStr);
        paperDetail.setPid(pid);
        paperDetail.setPname(pname);
        paperDetail.setDuration(duration);
        if(paperManageService.updatePaper(paperDetail)){
            System.out.println("修改成功");
        }
        else {
            System.out.println("修改失败");
        }
    }

    /**
     * 在试卷管理页面列出所有试卷
     * @return
     * @throws Exception
     */
    @RequestMapping("/listAllPaper")
    public List<PaperDetail> listAllPaper() throws Exception{
        List<PaperDetail> allPaper = Collections.emptyList();
        allPaper = paperManageService.listAllPaper();
        return allPaper;
    }

    /**
     * 在试卷管理页面查询试卷
     * @param keyword
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryPaper")
    public List<PaperDetail> queryPaper(String keyword) throws Exception{
        List<PaperDetail> queryPaper = Collections.emptyList();
        queryPaper = paperManageService.queryPaper(keyword);
        return queryPaper;
    }

    @RequestMapping("/listPaper")
    public List<PaperDetail> listPaper(String pidStr) throws Exception{
        int pid = Integer.parseInt(pidStr);
        List<PaperDetail> listPaper = Collections.emptyList();
        listPaper = paperManageService.listPaper(pid);
        return listPaper;
    }
}
