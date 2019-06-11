package com.example.demo.mapper.paperdetailmanage;

import com.example.demo.entity.paperdetail.PaperDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author : kongyy
 * @time : 2019/5/26 13:08
 */
@Mapper
@Repository
public interface PaperDetailManageMapper {

    /**
     * 往卷子中添加题目
     * @param paperDetail
     * @return
     * @throws Exception
     */
    public boolean addPaperDetail(@Param("paperDetail") PaperDetail paperDetail) throws Exception;

    /**
     * 删除题目
     * @param pdid
     * @return
     * @throws Exception
     */
    public boolean delPaperDetail(@Param("pdid") int pdid) throws Exception;

}
