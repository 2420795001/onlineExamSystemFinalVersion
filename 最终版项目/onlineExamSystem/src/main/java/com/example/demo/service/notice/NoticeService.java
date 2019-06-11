package com.example.demo.service.notice;


import com.example.demo.entity.notice.Notice;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/26 22:24
 */
public interface NoticeService {

    public boolean addNotice(Notice notice) throws Exception;

    public boolean delNotice(int nid) throws Exception;

    public boolean updateNotice(Notice notice) throws Exception;

    public List<Notice> listAllNotice() throws Exception;

    public List<Notice> queryNotice(String keyword) throws Exception;
}
