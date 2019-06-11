package com.example.demo.score;

import com.example.demo.entity.score.Score;
import com.example.demo.service.score.ScoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : kongyy
 * @time : 2019/5/28 23:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScoreTest {

    @Autowired
    ScoreService scoreService;

    @Test
    public void testListScoreByPaper() throws Exception{
        int pid = 2;
        System.out.println(scoreService.listScoreByPaper(pid));
    }

    @Test
    public void testSelectByUserId() throws Exception{
        int uid=1;
        System.out.println(scoreService.listScoreByUser(uid));
    }

    @Test
    public void testSelectByMark1() throws Exception{
        int pid=2;
        System.out.println(scoreService.listScoreByMark1(pid));
    }

    @Test
    public void testSelectByMark2() throws Exception{
        int pid=2;
        System.out.println(scoreService.listScoreByMark2(pid));
    }

    @Test
    public void testAddScore() throws Exception{
        Score score = new Score();
        score.setUid(5);
        score.setPid(2);
        score.setMark(89);
        System.out.println(scoreService.addScore(score));
    }

    @Test
    public void testListAllScore() throws Exception{
        System.out.println(scoreService.listAllScore());
    }

    @Test
    public void testListUserScore() throws Exception{
        int uid = 1;
        System.out.println(scoreService.listUserScore(uid));
    }
}
