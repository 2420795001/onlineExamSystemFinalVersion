package com.example.demo.controller.exam;

import com.example.demo.entity.paperdetail.PaperDetail;
import com.example.demo.entity.wrong.Wrong;
import com.example.demo.service.exam.ExamService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/6/2 13:38
 */
@CrossOrigin(allowCredentials = "true")
@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    ExamService examService;

    /**
     * 列出改试卷的所有题目
     * @param pidStr
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/listExamPaper")
    public List<PaperDetail> listExamPaper(String pidStr) throws Exception{
        int pid = Integer.parseInt(pidStr);
        List<PaperDetail> examPaper = Collections.emptyList();
        examPaper = examService.listExamPaper(pid);
        return examPaper;
    }

    /**
     *列出用户的错题
     * @param uidStr
     * @return
     * @throws Exception
     */
    @RequestMapping("/listWrongByUserId")
    public List<Wrong> listWrongByUserId(String uidStr) throws Exception{
        int uid = Integer.parseInt(uidStr);
        List<Wrong> wrongList = Collections.emptyList();
        wrongList = examService.listWrongByUserId(uid);
        return wrongList;
    }

    /**
     *判题
     * @param jsonArray
     * @param uidStr
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/judgeQuestion")
    public int judgeQuestion(JSONArray jsonArray, String uidStr) throws Exception{
        int uid = Integer.parseInt(uidStr);
        int result = examService.judgeQuestion(jsonArray, uid);
        return result;
    }

}
