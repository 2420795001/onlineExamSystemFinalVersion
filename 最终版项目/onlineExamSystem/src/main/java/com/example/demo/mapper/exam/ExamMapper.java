package com.example.demo.mapper.exam;

import com.example.demo.entity.paperdetail.PaperDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/29 15:00
 */
@Mapper
@Repository
public interface ExamMapper {

    /**
     * 列出某套卷子的题目
     * @param pid
     * @return
     * @throws Exception
     */
    public List<PaperDetail> listExamPaper(@Param("pid") int pid) throws Exception;

}
