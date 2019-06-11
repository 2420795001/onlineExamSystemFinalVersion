package com.example.demo.mapper.papermanage;

import com.example.demo.entity.paperdetail.PaperDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/26 18:33
 */
@Mapper
@Repository
public interface PaperManageMapper {

    /**
     * 添加试卷
     * @param paperDetail
     * @return
     * @throws Exception
     */
    public boolean addPaper(@Param("paperDetail") PaperDetail paperDetail) throws Exception;

    /**
     * 删除试卷
     * @param pid
     * @return
     * @throws Exception
     */
    public boolean delPaper(@Param("pid") int pid) throws Exception;

    /**
     * 修改试卷信息
     * @param paperDetail
     * @return
     * @throws Exception
     */
    public boolean updatePaper(@Param("paperDetail") PaperDetail paperDetail) throws Exception;

    /**
     * 列出所有试卷
     * @return
     * @throws Exception
     */
    public List<PaperDetail> listAllPaper() throws Exception;

    /**
     * 查询试卷
     * @param keyword
     * @return
     * @throws Exception
     */
    public List<PaperDetail> queryPaper(@Param("keyword") String keyword) throws Exception;

    /**
     * 列出某套试卷题目
     * @param pid
     * @return
     * @throws Exception
     */
    public List<PaperDetail> listPaper(@Param("pid") int pid) throws Exception;


}
