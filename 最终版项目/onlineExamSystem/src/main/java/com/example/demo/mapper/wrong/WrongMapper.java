package com.example.demo.mapper.wrong;

import com.example.demo.entity.wrong.Wrong;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/6/3 13:33
 */
@Mapper
@Repository
public interface WrongMapper {

    /**
     * 添加错题
     * @param wrong
     * @return
     * @throws Exception
     */
    public boolean addWrong(@Param("wrong")Wrong wrong) throws Exception;

    /**
     * 列出用户错题
     * @param uid
     * @return
     * @throws Exception
     */
    public List<Wrong> listWrongByUserId(@Param("uid") int uid) throws Exception;
}
