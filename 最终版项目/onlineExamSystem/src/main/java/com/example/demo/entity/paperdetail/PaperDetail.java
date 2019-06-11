package com.example.demo.entity.paperdetail;

/**
 * @author : kongyy
 * @time : 2019/5/26 13:04
 */
public class PaperDetail {

    private Integer pdid;

    private Integer pid;

    private Integer qid;

    private String content;

    private String typeA;

    private String typeB;

    private String typeC;

    private String typeD;

    private String right;

    private String types;

    private Integer value;

    private String pname;

    private String answer;

    private Integer uid;

    private String duration;

    public Integer getPdid() {
        return pdid;
    }

    public void setPdid(Integer pdid) {
        this.pdid = pdid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTypeA() {
        return typeA;
    }

    public void setTypeA(String typeA) {
        this.typeA = typeA;
    }

    public String getTypeB() {
        return typeB;
    }

    public void setTypeB(String typeB) {
        this.typeB = typeB;
    }

    public String getTypeC() {
        return typeC;
    }

    public void setTypeC(String typeC) {
        this.typeC = typeC;
    }

    public String getTypeD() {
        return typeD;
    }

    public void setTypeD(String typeD) {
        this.typeD = typeD;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "PaperDetail{" +
                "pdid=" + pdid +
                ", pid=" + pid +
                ", qid=" + qid +
                ", content='" + content + '\'' +
                ", typeA='" + typeA + '\'' +
                ", typeB='" + typeB + '\'' +
                ", typeC='" + typeC + '\'' +
                ", typeD='" + typeD + '\'' +
                ", right='" + right + '\'' +
                ", types='" + types + '\'' +
                ", value=" + value +
                ", pname='" + pname + '\'' +
                ", answer='" + answer + '\'' +
                ", uid=" + uid +
                ", duration='" + duration + '\'' +
                '}';
    }
}
