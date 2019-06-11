package com.example.demo.service.question;

import com.example.demo.entity.paperdetail.PaperDetail;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/6/2 10:07
 */
public interface QuestionService {

    public boolean addQuestion(PaperDetail paperDetail) throws Exception;

    public boolean delQuestion(int qid) throws Exception;

    public boolean updateQuestion( PaperDetail paperDetail) throws Exception;

    public List<PaperDetail> listAllQuestion() throws Exception;

    public List<PaperDetail> listQuestionByType(String types) throws Exception;
}
