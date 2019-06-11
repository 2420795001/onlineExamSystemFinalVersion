package com.example.demo.controller.notice;

import com.example.demo.entity.notice.Notice;
import com.example.demo.service.notice.NoticeService;
import com.example.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/6/2 0:06
 */
@CrossOrigin(allowCredentials = "true")
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;


//    /**
//     * 增加通告
//     * @param request
//     * @param title
//     * @param content
//     */
//    @RequestMapping(value = "/addNotice")
//    public void addNotice(HttpServletRequest request, String title, String content) throws Exception{
//        HttpSession session = request.getSession();
//        String username = String.valueOf(session.getAttribute("usernameSession"));
//        int uid = userService.getUserId(username).getUid();
//        Notice notice = new Notice();
//        notice.setUid(uid);
//        notice.setTitle(title);
//        notice.setContent(content);
//        Date date = new Date();
//        String dateStr = String.valueOf(date);
//        notice.setTime(dateStr);
//        if(noticeService.addNotice(notice)){
//            System.out.println("添加成功");
//        }
//    }

    /**
     * 增加通告

     * @param title
     * @param content
     */
    @RequestMapping(value = "/addNotice")
    public void addNotice(String title, String content) throws Exception{
        int uid = 1;
        Notice notice = new Notice();
        notice.setUid(uid);
        notice.setTitle(title);
        notice.setContent(content);
        Date date = new Date();
        String dateStr = String.valueOf(date);
        notice.setTime(dateStr);
        if(noticeService.addNotice(notice)){
            System.out.println("添加成功");
        }
    }

    /**
     * 删除通告
     * @param nid
     * @throws Exception
     */
    @RequestMapping(value = "delNotice")
    public void delNotice(int nid) throws Exception{
        if(noticeService.delNotice(nid)){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    /**
     * 对通告进行模糊查询
     * @param keyword
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryNotice")
    public List<Notice> queryNotice(String keyword) throws Exception{
        List<Notice> queryNoticeList = Collections.emptyList();
        queryNoticeList = noticeService.queryNotice(keyword);
        return queryNoticeList;
    }

    /**
     * 列出所有通告
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "listAllNotice")
    public List<Notice> listAllNotice() throws Exception{
        List<Notice> noticeList = Collections.emptyList();
        noticeList = noticeService.listAllNotice();
        return noticeList;
    }

    /**
     * 修改公告
     * @param title
     * @param nid
     * @param content
     * @throws Exception
     */
    @RequestMapping(value = "updateNotice")
    public void updateNotice(String title, int nid, String content) throws Exception{
        Notice notice = new Notice();
        notice.setNid(nid);
        notice.setTitle(title);
        notice.setContent(content);
        Date date = new Date();
        String dateStr = String.valueOf(date);
        notice.setTime(dateStr);
        if(noticeService.updateNotice(notice)){
            System.out.println("修改成功");
        }
    }

}
