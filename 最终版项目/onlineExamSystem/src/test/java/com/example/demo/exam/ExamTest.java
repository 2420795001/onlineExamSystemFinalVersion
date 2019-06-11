package com.example.demo.exam;

import com.example.demo.service.exam.ExamService;
import net.sf.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * @author : kongyy
 * @time : 2019/5/29 15:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExamTest {

    @Autowired
    ExamService examService;

    @Test
    public void testListExamPaper() throws Exception{
        int pid = 1;
        System.out.println(examService.listExamPaper(pid));
    }

//    @Test
//    public void testJudgeQuestion() throws Exception{
//        String jsonString = "[{\"answer\":\"A\",\"right\":\"A\", \"pdid\":\"1\",\"pid\":\"2\" }, {\"answer\":\"A\",\"right\":\"A\",\"pdid\":\"2\",\"pid\":\"2\" },{\"answer\":\"A\",\"right\":\"B\",\"pdid\":\"3\" ,\"pid\":\"2\"}]";
//        JSONArray jsonArray = JSONArray.fromObject(jsonString);
////        HttpServletRequest request = null;
////        HttpSession session = request.getSession();
////        session.setAttribute("usernameSession","1");int result = examService.judgeQuestion(jsonArray);System.out.println(result);
//    }
//
//    @Test
//    public void testListWrongByUserId() throws Exception{
//        int uid = 1;
//        System.out.println(examService.listWrongByUserId(uid));
//    }

}
