// 点击试卷后的缩略信息
<template>
  <div id="msg">
    <div class="title">
      <span>试卷列表</span>
      <span>/  {{examData.source}}</span>
    </div>
    <div class="wrapper" style="margin-bottom:330px">
      <ul class="top">
        <li class="example">{{examData.pid}}</li>
        <li><i class="iconfont icon-pen-"></i></li>
        <li><i class="iconfont icon-share"></i></li>
        <li class="right">
          <div>
            <span class="count">总分</span>
            <!-- <span class="score">{{score[0]+score[1]+score[2]}}</span> -->
            <span class="score">100</span>
          </div>
        </li>
      </ul>
      <ul class="bottom">
        <!-- <li>更新于{{examData.examDate}}</li>
        <li>来自 {{examData.institute}}</li>
        <li class="btn">{{examData.type}}</li> -->
        <li>名称：{{examData.pname}}</li>
        <li>时长：{{examData.duration}}小时</li>
        <li class="right"><el-button @click="toAnswer(examData.pid)">开始答题</el-button></li>
      </ul>
      <ul class="info">
        <li @click="dialogVisible = true"><a href="javascript:;"><i class="iconfont icon-info"></i>考生须知</a></li>
      </ul>
    </div>
    <!--考生须知对话框-->
    <el-dialog
      title="考生须知"
      :visible.sync="dialogVisible"
      width="30%">
      <span>文明考试！对自己负责！</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">知道了</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import axios from 'axios'
import qs from 'qs'
export default {
  data() {
    return {
      dialogVisible: false, //对话框属性
      activeName: '0',  //默认打开序号
      topicCount: [],//每种类型题目的总数
      score: [],  //每种类型分数的总数
      examData: { //考试信息
        // source: null,
        // totalScore: null,
      },
      topic: {  //试卷信息

      },
    }
  },
  mounted() {
    this.init()
  },
  methods: {
    //初始化页面数据
    init() {
      let pid = this.$route.query.pid //获取路由传递过来的试卷编号
      let data=this.$qs.stringify({
        'pidStr':pid
      })
      axios({
        url:'http://47.103.10.220:8008/paper/listPaper',
        method:'post',
        data:data
        }).then(res => {  //通过examCode请求试卷详细信息
      console.log(res.data)
      this.examData=res.data[0]
        // res.data.data.examDate = res.data.data.examDate.substr(0,10)
        // this.examData = { ...res.data.data}
        // let paperId = this.examData.paperId
        // this.$axios(`/api/paper/${paperId}`).then(res => {  //通过paperId获取试题题目信息
        //   this.topic = {...res.data}
        //   let keys = Object.keys(this.topic) //对象转数组
        //   keys.forEach(e => {
        //     let data = this.topic[e]
        //     this.topicCount.push(data.length)
        //     let currentScore = 0
        //     for(let i = 0; i< data.length; i++) { //循环每种题型,计算出总分
        //       currentScore += data[i].score
        //     }
        //     this.score.push(currentScore) //把每种题型总分存入score
        //   })
        // })
      })
    },
    toAnswer(pid) {
      this.$router.push({path:"/answer",query:{pid: pid}})
    },
  }
}
</script>

<style lang="scss" scoped>
.bottom {
  .right{
    .el-button{
      color: #409EFF;
      border-color: #c6e2ff;
      background-color: #ecf5ff;
    }
  }
}
.right {
  margin-left: auto;
}
.inner .contenti .question {
  margin-left: 40px;
  color: #9a9a9a;
  font-size: 14px;
}
.content .inner .titlei {
  margin-left: 20px;
  font-size: 16px;
  color: #88949b;
  font-weight: bold;
}
.content .title .time {
  font-size: 16px;
  margin-left: 420px;
  color: #999;
}
.content .stitle {
  background-color: #0195ff;
}
.content .title span {
  margin-right: 10px;
}
#msg .content .title {
  font-size: 20px;
  margin: 0px;
  display: flex;
  align-items: center;
}
.content {
  margin-top: 20px;
  background-color: #fff;
}
.content .header {
  padding: 10px 30px;
}
.wrapper .info {
  margin: 20px 0px 0px 20px;
  border-top: 1px solid #eee;
  padding: 20px 0px 10px 0px;
}
.wrapper .info a {
  color: #88949b;
  font-size: 14px;
}
.wrapper .info a:hover {
  color: #0195ff;
}
.wrapper .bottom .btn {
  cursor: pointer;
  padding: 5px 10px;
  border: 1px solid #88949b;
  border-radius: 4px;
} 
.wrapper .bottom {
  display: flex;
  margin-left: 20px;
  color: #999;
  font-size: 14px;
  align-items: center;
}
.wrapper .bottom li {
  margin-right: 14px;
}
#msg {
  background-color: #eee;
  width: 980px;
  margin: 0 auto;
}
#msg .title {
  margin: 20px;
}
#msg .wrapper {
  background-color: #fff;
  padding: 10px;
}
.wrapper .top {
  display: flex;
  margin: 20px;
  align-items: center;
}
.wrapper .top .right {
  margin-left: auto;
}
.wrapper .top .example {
  color: #333;
  font-size: 22px;
  font-weight: 700;
}
.wrapper .top li i {
  margin-left: 20px;
  color: #88949b;
}
.wrapper .right .count {
  margin-right: 60px;
  color: #fff;
  padding: 4px 10px;
  background-color: #88949b;
  border-top-left-radius: 4px;
  border-bottom-left-radius: 4px;
  border: 1px solid #88949b;
}
.wrapper .right .score {
  position: absolute;
  left: 53px;
  top: -5px;
  padding: 1px 12px;
  font-size: 20px;
  color: #88949b;
  border: 1px dashed #88949b;
  border-left: none;
  border-top-right-radius: 4px;
  border-bottom-right-radius: 4px;
  font-weight: bold;
}
.wrapper .right div {
  position: relative;
}
</style>
