package com.example.demo.question;

import com.example.demo.entity.paperdetail.PaperDetail;
import com.example.demo.service.question.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : kongyy
 * @time : 2019/6/2 10:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionTest {

    @Autowired
    QuestionService questionService;

    @Test
    public void testAddQuestion() throws Exception{
        PaperDetail paperDetail = new PaperDetail();
        paperDetail.setContent("你猜猜今天星期几");
        paperDetail.setTypeA("1");
        paperDetail.setTypeB("2");
        paperDetail.setTypeC("3");
        paperDetail.setTypeD("7");
        paperDetail.setRight("D");
        paperDetail.setTypes("单选题");
        paperDetail.setValue(3);
        questionService.addQuestion(paperDetail);
    }

    @Test
    public void testDelQuestion() throws Exception{
        int qid = 1;
        System.out.println(questionService.delQuestion(qid));
    }

    @Test
    public void testUpdateQuestion() throws Exception{
        PaperDetail paperDetail = new PaperDetail();
        paperDetail.setContent("你猜猜今天星期几");
        paperDetail.setQid(2);
        paperDetail.setTypeA("1");
        paperDetail.setTypeB("2");
        paperDetail.setTypeC("3");
        paperDetail.setTypeD("4");
        paperDetail.setRight("D");
        paperDetail.setTypes("单选题");
        paperDetail.setValue(3);
        System.out.println(questionService.updateQuestion(paperDetail));
    }

    @Test
    public void testListAllQuestion() throws Exception{
        System.out.println(questionService.listAllQuestion());
    }

    @Test
    public void testListQuestionByTypes() throws Exception{
        String types = "单选题";
        System.out.println(questionService.listQuestionByType(types));
    }
}
