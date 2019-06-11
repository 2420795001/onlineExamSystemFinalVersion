package com.example.demo.controller.question;

import com.example.demo.entity.paperdetail.PaperDetail;
import com.example.demo.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/6/2 10:54
 */
@CrossOrigin(allowCredentials = "true")
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    /**
     * 往题库中添加试题
     * @param content
     * @param typeA
     * @param typeB
     * @param typeC
     * @param typeD
     * @param right
     * @param valueStr
     * @param types
     * @throws Exception
     */
    @RequestMapping(value = "addQuestion")
    public void addQuestion(String content, String typeA, String typeB, String typeC, String typeD, String right, String valueStr, String types) throws Exception{
        PaperDetail paperDetail = new PaperDetail();
        int value = Integer.parseInt(valueStr);
        paperDetail.setContent(content);
        paperDetail.setTypeA(typeA);
        paperDetail.setTypeB(typeB);
        paperDetail.setTypeC(typeC);
        paperDetail.setTypeD(typeD);
        paperDetail.setTypes(types);
        paperDetail.setRight(right);
        paperDetail.setValue(value);
        if(questionService.addQuestion(paperDetail)){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }

    /**
     * 删除试题
     * @param qidStr
     * @throws Exception
     */
    @RequestMapping(value = "delQuestion")
    public void delQuestion(String qidStr)throws Exception{
        int qid = Integer.parseInt(qidStr);
        if(questionService.delQuestion(qid)){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    /**
     * 修改试题
     * @param qidStr
     * @param content
     * @param typeA
     * @param typeB
     * @param typeC
     * @param typeD
     * @param right
     * @param valueStr
     * @param types
     * @throws Exception
     */
    @RequestMapping(value = "updateQuestion")
    public void updateQuestion(String qidStr, String content, String typeA, String typeB, String typeC, String typeD, String right, String valueStr, String types) throws Exception{
        PaperDetail paperDetail = new PaperDetail();
        int qid = Integer.parseInt(qidStr);
        int value = Integer.parseInt(valueStr);
        paperDetail.setQid(qid);
        paperDetail.setContent(content);
        paperDetail.setTypeA(typeA);
        paperDetail.setTypeB(typeB);
        paperDetail.setTypeC(typeC);
        paperDetail.setTypeD(typeD);
        paperDetail.setTypes(types);
        paperDetail.setRight(right);
        paperDetail.setValue(value);
        if(questionService.updateQuestion(paperDetail)){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    /**
     * 列出所有题目
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "listAllQuestion")
    public List<PaperDetail> listAllQuestion() throws Exception{
        List<PaperDetail> allQuestion = Collections.emptyList();
        allQuestion = questionService.listAllQuestion();
        return allQuestion;
    }

    /**
     * 根据题目类型列出题目
     * @param types
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "listQuestionByType")
    public List<PaperDetail> listQuestionByType(String types) throws Exception{
        List<PaperDetail> questionByTypes = Collections.emptyList();
        questionByTypes = questionService.listQuestionByType(types);
        return questionByTypes;
    }
}
