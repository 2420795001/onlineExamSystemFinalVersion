package com.example.demo.mapper.notice;

import com.example.demo.entity.notice.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/26 20:57
 */
@Repository
@Mapper
public interface NoticeMapper {

    /**
     *增加通告
     * @param notice
     * @return
     * @throws Exception
     */
    public boolean addNotice(@Param("notice") Notice notice) throws Exception;

    /**
     * 删除通告
     * @param nid
     * @return
     * @throws Exception
     */
    public boolean delNotice(@Param("nid") int nid) throws Exception;

    /**
     * 修改通告
     * @param notice
     * @return
     * @throws Exception
     */
    public boolean updateNotice(@Param("notice") Notice notice) throws Exception;

    /**
     * 列出所有通告
     * @return
     * @throws Exception
     */
    public List<Notice> listAllNotice() throws Exception;

    /**
     * 模糊查询通告
     * @param keyword
     * @return
     * @throws Exception
     */
    public List<Notice> queryNotice(@Param("keyword") String keyword) throws Exception;
}
