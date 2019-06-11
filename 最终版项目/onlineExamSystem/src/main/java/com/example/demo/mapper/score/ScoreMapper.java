package com.example.demo.mapper.score;

import com.example.demo.entity.score.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/28 21:53
 */
@Repository
@Mapper
public interface ScoreMapper {

    /**
     * 列出某张卷子的成绩
     * @param pid
     * @return
     * @throws Exception
     */
    public List<Score> listScoreByPaper(@Param("pid") int pid) throws Exception;

    /**
     * 列出某个同学的成绩
     * @param uid
     * @return
     * @throws Exception
     */
    public List<Score> listScoreByUser(@Param("uid") int uid) throws Exception;

    /**
     * 列出某张卷子及格的学生
     * @param pid
     * @return
     * @throws Exception
     */
    public List<Score> listScoreByMark1(@Param("pid") int pid) throws Exception;

    /**
     * 列出某张卷子未及格的学生
     * @param pid
     * @return
     * @throws Exception
     */
    public List<Score> listScoreByMark2(@Param("pid") int pid) throws Exception;

    /**
     * 列出全部成绩
     * @return
     * @throws Exception
     */
    public List<Score> listAllScore() throws Exception;

    /**
     * 增加成绩
     * @param score
     * @return
     * @throws Exception
     */
    public boolean addScore(@Param("score") Score score)throws Exception;

    /**
     * 列出某个同学的成绩
     * @param uid
     * @return
     * @throws Exception
     */
    public List<Score> listUserScore(@Param("uid") int uid) throws Exception;


}
