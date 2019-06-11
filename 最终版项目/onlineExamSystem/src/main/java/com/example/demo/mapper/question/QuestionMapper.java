package com.example.demo.mapper.question;

import com.example.demo.entity.paperdetail.PaperDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/6/2 10:02
 */
@RestController
@Mapper
public interface QuestionMapper {

    /**
     * 往题库中添加题目
     * @param paperDetail
     * @return
     * @throws Exception
     */
    public boolean addQuestion(@Param("paperDetail")PaperDetail paperDetail) throws Exception;

    /**
     * 删除题库中的题目
     * @param qid
     * @return
     * @throws Exception
     */
    public boolean delQuestion(@Param("qid") int qid) throws Exception;

    /**
     * 更新题库中的题目
     * @param paperDetail
     * @return
     * @throws Exception
     */
    public boolean updateQuestion(@Param("paperDetail") PaperDetail paperDetail) throws Exception;

    /**
     * 列出多有题目
     * @return
     * @throws Exception
     */
    public List<PaperDetail> listAllQuestion() throws Exception;

    /**
     * 根据类型列出题目
     * @param types
     * @return
     * @throws Exception
     */
    public List<PaperDetail> listQuestionByType(@Param("types")String types ) throws Exception;
}
