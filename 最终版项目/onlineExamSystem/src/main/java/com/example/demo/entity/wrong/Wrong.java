package com.example.demo.entity.wrong;

/**
 * @author : kongyy
 * @time : 2019/5/30 19:48
 */
public class Wrong {

    private Integer wid;

    private Integer pdid;

    private Integer uid;

    private String answer;

    private String right;

    private Integer pid;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getPdid() {
        return pdid;
    }

    public void setPdid(Integer pdid) {
        this.pdid = pdid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Wrong{" +
                "wid=" + wid +
                ", pdid=" + pdid +
                ", uid=" + uid +
                ", answer='" + answer + '\'' +
                ", right='" + right + '\'' +
                ", pid=" + pid +
                '}';
    }
}
