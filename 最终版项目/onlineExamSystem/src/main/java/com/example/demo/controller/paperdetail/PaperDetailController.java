package com.example.demo.controller.paperdetail;

import com.example.demo.entity.paperdetail.PaperDetail;
import com.example.demo.service.exam.ExamService;
import com.example.demo.service.paperdetailmanage.PaperDetailManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/6/2 9:38
 */
@CrossOrigin(allowCredentials = "true")
@RestController
@RequestMapping("/paperDetail")
public class PaperDetailController {

    @Autowired
    PaperDetailManageService paperDetailManageService;

    @Resource
    ExamService examService;


    /**
     * 在题库管理界面调用该方法，往试卷里添加试题
     * @throws Exception
     */
    @RequestMapping(value = "addPaperDetail")
    public void addPaperDetail(String pidStr, String qidStr) throws Exception{
        PaperDetail paperDetail = new PaperDetail();
        int pid = Integer.parseInt(pidStr);
        int qid = Integer.parseInt(qidStr);
        if(paperDetailManageService.addPaperDetail(paperDetail)){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }

    /**
     * 删除这套试卷中的题目
     * @param pdidStr
     * @throws Exception
     */
    @RequestMapping(value = "delPaperDetail")
    public void delPaperDetail(String pdidStr)throws Exception{
        int pdid = Integer.parseInt(pdidStr);
        if(paperDetailManageService.delPaperDetail(pdid)){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    /**
     * 在试卷页面，列出这套试卷所有的题目
     * @param pidStr
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "listPaperDetail")
    public List<PaperDetail> listPaperDetail(String pidStr) throws Exception{
        List<PaperDetail> paperDetailList = Collections.emptyList();
        int pid = Integer.parseInt(pidStr);
        paperDetailList = examService.listExamPaper(pid);
        return paperDetailList;
    }
}
