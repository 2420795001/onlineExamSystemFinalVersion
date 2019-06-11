package com.example.demo.controller.score;

import com.example.demo.entity.score.Score;
import com.example.demo.service.score.ScoreService;
import com.example.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/6/1 23:47
 */
@CrossOrigin(allowCredentials = "true")
@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

//    @Resource
//    UserService userService;
//
//    /**
//     * 在个人中心列出学生成绩
//     * @param request
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "listUserScore")
//    public List<Score> listUserScore(HttpServletRequest request) throws Exception{
//        List<Score> userScoreList = Collections.emptyList();
//        HttpSession session = request.getSession();
//        String username = String.valueOf(session.getAttribute("usernameSession"));
//        int uid = userService.getUserId(username).getUid();
//        userScoreList = scoreService.listUserScore(uid);
//        return userScoreList;
//    }

    /**
     * 在个人中心列出学生成绩
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "listUserScore")
    public List<Score> listUserScore(String uidStr) throws Exception{
        List<Score> userScoreList = Collections.emptyList();
        int uid = Integer.parseInt(uidStr);
        userScoreList = scoreService.listUserScore(uid);
        return userScoreList;
    }

    /**
     * 列出某套卷子分数在60分以下的学生（老师端）
     * @param pid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "listScoreByMark1")
    public List<Score> listScoreByMark1(int pid) throws Exception{
        List<Score> markUnderSixty = Collections.emptyList();
        markUnderSixty = scoreService.listScoreByMark1(pid);
        return markUnderSixty;
    }

    /**
     * 列出某套卷子分数在60分以上的学生（老师端）
     * @param pid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "listScoreByMark2")
    public List<Score> listScoreByMark2(int pid) throws Exception{
        List<Score> markUnderSixty = Collections.emptyList();
        markUnderSixty = scoreService.listScoreByMark2(pid);
        return markUnderSixty;
    }

    /**
     * 在列出某套卷子全部的成绩（老师端）
     * @param pid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "listScoreByPaper")
    public List<Score> listScoreByPaper(int pid) throws Exception{
        List<Score> scoreByPaper = Collections.emptyList();
        scoreByPaper = scoreService.listScoreByPaper(pid);
        return scoreByPaper;
    }
}
