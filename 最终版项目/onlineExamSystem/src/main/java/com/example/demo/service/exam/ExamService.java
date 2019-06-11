package com.example.demo.service.exam;

import com.example.demo.entity.paperdetail.PaperDetail;
import com.example.demo.entity.wrong.Wrong;
import net.sf.json.JSONArray;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/29 15:06
 */
public interface ExamService {

    public List<PaperDetail> listExamPaper(int pid) throws Exception;

    /**
     * 判题并算分
     * @param jsonArray
     * @param uid
     * @return
     * @throws Exception
     */
    public int judgeQuestion(JSONArray jsonArray, int uid) throws Exception;

    public List<Wrong> listWrongByUserId(int uid) throws Exception;

}
