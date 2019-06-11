package com.example.demo.service.score.impl;

import com.example.demo.entity.score.Score;
import com.example.demo.mapper.score.ScoreMapper;
import com.example.demo.service.score.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/28 21:58
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public List<Score> listScoreByPaper(int pid) throws Exception{
        List<Score> list = scoreMapper.listScoreByPaper(pid);
        return list;
    }

    @Override
    public List<Score> listScoreByUser(int uid) throws Exception{
        List<Score> list = scoreMapper.listScoreByUser(uid);
        return list;
    }

    @Override
    public List<Score> listScoreByMark1(int pid) throws Exception{
        List<Score> list = scoreMapper.listScoreByMark1(pid);
        return list;
    }

    @Override
    public List<Score> listScoreByMark2(int pid) throws Exception{
        List<Score> list = scoreMapper.listScoreByMark2(pid);
        return list;
    }

    @Override
    public boolean addScore(Score score) throws Exception{
        return scoreMapper.addScore(score);
    }

    @Override
    public List<Score> listAllScore() throws Exception{
        List<Score> list = scoreMapper.listAllScore();
        return list;
    }

    @Override
    public List<Score> listUserScore(int uid) throws Exception{
        List<Score> list = scoreMapper.listAllScore();
        list = scoreMapper.listUserScore(uid);
        return list;
    }
}
