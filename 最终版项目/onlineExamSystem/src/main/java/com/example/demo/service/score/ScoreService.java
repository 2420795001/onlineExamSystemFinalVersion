package com.example.demo.service.score;

import com.example.demo.entity.score.Score;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/28 21:58
 */
public interface ScoreService {

    public List<Score> listScoreByPaper(int pid) throws Exception;

    public List<Score> listScoreByUser(int uid) throws Exception;

    public List<Score> listScoreByMark1(int pid) throws Exception;

    public List<Score> listScoreByMark2(int pid) throws Exception;

    public boolean addScore(Score score)throws Exception;

    public List<Score> listAllScore() throws Exception;

    public List<Score> listUserScore(int uid) throws Exception;
}
