package com.example.demo.service.exam.impl;


import com.example.demo.entity.paperdetail.PaperDetail;
import com.example.demo.entity.wrong.Wrong;
import com.example.demo.mapper.exam.ExamMapper;
import com.example.demo.mapper.wrong.WrongMapper;
import com.example.demo.service.exam.ExamService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/29 15:09
 */
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamMapper examMapper;

    @Resource
    WrongMapper wrongMapper;

    @Override
    public List<PaperDetail> listExamPaper(int pid) throws Exception{
        List<PaperDetail> list = Collections.emptyList();
        list = examMapper.listExamPaper(pid);
        return list;
    }

    @Override
    public int judgeQuestion(JSONArray jsonArray, int uid) {
        int result = 0;
//        HttpSession session = request.getSession();
//        String uidStr = String.valueOf(session.getAttribute("userIdSession"));
        try{
            //String jsonString = "[{\"answer\":\"A\",\"right\":\"A\"}, {\"answer\":\"A\",\"right\":\"A\"},{\"answer\":\"A\",\"right\":\"B\"}]";
            for(int i=0;i<jsonArray.size();i++){
                Wrong wrong = new Wrong();
                wrong.setRight(jsonArray.getJSONObject(i).getString("right"));
                wrong.setAnswer(jsonArray.getJSONObject(i).getString("answer"));
                String pdidStr = jsonArray.getJSONObject(i).getString("pdid");
                String pidStr = jsonArray.getJSONObject(i).getString("pid");
                int pdid = Integer.parseInt(pdidStr);
                int pid = Integer.parseInt(pidStr);
                wrong.setPdid(pdid);
                wrong.setUid(uid);
                wrong.setPid(pid);
                if(wrong.getAnswer().equals(wrong.getRight())){
                    result += 5;
                }
                else{
                    System.out.println(wrongMapper.addWrong(wrong));

                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Wrong> listWrongByUserId(int uid) throws Exception{
        List<Wrong> list = Collections.emptyList();
        list = wrongMapper.listWrongByUserId(uid);
        return list;
    }
}
