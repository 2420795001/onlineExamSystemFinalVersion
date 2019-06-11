package com.example.demo.service.notice.impl;

import com.example.demo.entity.notice.Notice;
import com.example.demo.mapper.notice.NoticeMapper;
import com.example.demo.service.notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/26 22:26
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public boolean addNotice(Notice notice) throws Exception{
        return noticeMapper.addNotice(notice);
    }

    @Override
    public boolean delNotice(int nid) throws Exception{
        return noticeMapper.delNotice(nid);
    }

    @Override
    public boolean updateNotice(Notice notice) throws Exception{
        return noticeMapper.updateNotice(notice);
    }

    @Override
    public List<Notice> listAllNotice() throws Exception{
        List<Notice> list = Collections.emptyList();
        list = noticeMapper.listAllNotice();
        return list;
    }

    @Override
    public List<Notice> queryNotice(String keyword) throws Exception{
        List<Notice> list = Collections.emptyList();
        keyword = "%" + keyword + "%" ;
        list = noticeMapper.queryNotice(keyword);
        return list;
    }
}
