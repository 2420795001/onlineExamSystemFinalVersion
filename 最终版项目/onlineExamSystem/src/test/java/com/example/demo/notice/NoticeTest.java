package com.example.demo.notice;

import com.example.demo.entity.notice.Notice;
import com.example.demo.service.notice.NoticeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author : kongyy
 * @time : 2019/5/28 21:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticeTest {

    @Autowired
    NoticeService noticeService;

    @Test
    public void testAddNotice() throws Exception{
        Date date = new Date();
        String dateStr = String.valueOf(date);
        Notice notice = new Notice();
        notice.setTitle("特大消息");
        notice.setUid(3);
        notice.setContent("请梁莉莉同学联系一下孔一言老师");
        notice.setTime(dateStr);
        System.out.println(noticeService.addNotice(notice));
    }

    @Test
    public void testDelNotice() throws Exception{
        int nid = 5;
        System.out.println(noticeService.delNotice(nid));
    }

    @Test
    public void testUpdateNotice() throws Exception{
        Notice notice = new Notice();
        Date date = new Date();
        String dateStr = String.valueOf(date);
        notice.setNid(1);
        notice.setTitle("超级大消息");
        notice.setContent("我呵呵呵没啥事");
        notice.setTime(dateStr);
        System.out.println(noticeService.updateNotice(notice));
    }

    @Test
    public void testListAllNotice() throws Exception{
        System.out.println(noticeService.listAllNotice());
    }

    @Test
    public void testQueryNotice() throws Exception{
        String keyword = "月";
        System.out.println(noticeService.queryNotice(keyword));
    }

}
