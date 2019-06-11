package com.example.demo.entity.score;

/**
 * @author : kongyy
 * @time : 2019/5/28 21:51
 */
public class Score {

    private Integer sid;

    private Integer uid;

    private Integer pid;

    private Integer mark;

    private String username;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Score{" +
                "sid=" + sid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", mark=" + mark +
                ", username='" + username + '\'' +
                '}';
    }
}
