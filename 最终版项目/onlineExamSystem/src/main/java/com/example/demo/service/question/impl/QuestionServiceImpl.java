package com.example.demo.service.question.impl;

import com.example.demo.entity.paperdetail.PaperDetail;
import com.example.demo.mapper.question.QuestionMapper;
import com.example.demo.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/6/2 10:08
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Override
    public boolean addQuestion(PaperDetail paperDetail) throws Exception{
        return questionMapper.addQuestion(paperDetail);
    }

    @Override
    public boolean delQuestion(int qid) throws Exception{
        return questionMapper.delQuestion(qid);
    }

    @Override
    public boolean updateQuestion(PaperDetail paperDetail) throws Exception{
        return questionMapper.updateQuestion(paperDetail);
    }

    @Override
    public List<PaperDetail> listAllQuestion() throws Exception{
        List<PaperDetail> list = Collections.emptyList();
        list = questionMapper.listAllQuestion();
        return list;
    }

    @Override
    public List<PaperDetail> listQuestionByType(String types) throws Exception{
        List<PaperDetail> list = Collections.emptyList();
        list = questionMapper.listQuestionByType(types);
        return list;
    }
}
