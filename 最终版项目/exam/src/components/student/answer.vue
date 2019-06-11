<template>
    <div id="answer1">
    <!--顶部信息栏-->
     <div class="top">
       <ul class="item">
         <li><i class="iconfont icon-menufold icon20" ref="toggle"></i></li>
         <li>
           <i class="iconfont icon-user icon20"></i>
         </li>
         <li><i class="iconfont icon-arrLeft icon20"></i></li>
       </ul>
     </div>
    <!-- 考试页面 -->
    <el-card id="answer" v-show="testing">
      <div slot="header" class="clearfix" style="text-align:center">
        <span>{{paper.pname}}</span>
        <br><br>
        <p>用时：{{str}}</p>
        <el-button type="warning" 
                  icon="el-icon-check" 
                  style="float: right; padding: 3px 0" 
                  size=""
                  @click="submiteAnwser()">确认提交</el-button>
      </div>
      <div v-for="(item,index) in question" :key="index">
        <p><span>{{index+1}}. </span><span>{{item.content}}</span></p>
        <el-radio-group 
            v-model="item.index"
            @change="handleRadioChange(item.index,item.qid)"
            v-show="radioShow">
            <el-radio label="A">A.{{item.typeA}}</el-radio>
            <el-radio label="B">B.{{item.typeB}}</el-radio>
            <el-radio label="C">C.{{item.typeC}}</el-radio>
            <el-radio label="D">D.{{item.typeD}}</el-radio>
          </el-radio-group>
        <!-- <el-checkbox-group
            v-model="item.index"
            @change="handleCheckChange(item.index,item.exerciseId)"
            v-show="checkShow">
            <el-checkbox label="A">A.{{item.typeA}}</el-checkbox>
            <el-checkbox label="B">B.{{item.typeB}}</el-checkbox>
            <el-checkbox label="C">C.{{item.typeC}}</el-checkbox>
            <el-checkbox label="D">D.{{item.typeD}}</el-checkbox>
          </el-checkbox-group> -->
      </div>
    </el-card>
    </div>
</template>

<script>
import axios from 'axios'
import qs from 'qs'
    export default{
        data(){
            return{
                str: '00:00:00',  //用时
                h: 0,
                m: 0,
                s: 0,
                time:0,
                paper:'', //试卷情况
                question:[],  //试卷问题
                testing:true,
                radioShow:true,
                radioAnswer:[],
            }
        },
        created(){
            this.getPaper()
            this.getQuestion()
            this.start()
        },
        methods:{
        timer(){
        //秒针走动
        this.s=this.s+1;
        //秒进位分，秒归零
        if(this.s>=60){
          this.m=this.m+1;
          this.s=0;
        }
        //分进位时，分归零
        if(this.m>=60){
          this.h=this.h+1;
          this.m=0;
        }
        this.str=this.addZero(this.h)+":"+this.addZero(this.m)+":"+this.addZero(this.s);
        // console.log(this.str);
        if(this.str == "02:00:00"){
          this.$alert('请停止答题，前往“我的成绩”中查询你的成绩', '考试时间到！', {
            confirmButtonText: '确定',
            callback: action => {
              this.testing = false;
              this.myScore = true;
            }
          });
          clearInterval(this.time);
        }
      },
      //补零
      addZero(t){
        if(t<10){
          return ("0"+t);
        }
        else{
          return t;
        }
      },
        start(){
            //1秒=1000毫秒
            this.time=setInterval(this.timer,1000);
        },
        handleRadioChange(chose, id){
            this.radioAnswer[id] = {index:id, value:chose};
            console.log(this.radioAnswer);
        },
        getPaper(){
            let pid = this.$route.query.pid //获取路由传递过来的试卷编号
            let data=this.$qs.stringify({
                'pidStr':pid
            })
            axios({
                url:'http://47.103.10.220:8008/paper/listPaper',
                method:'post',
                data:data
            }).then((res)=>{
                this.paper=res.data
                console.log(res.data)
                console.log("试卷信息"+this.paper)
            }).catch((error)=>{
                console.log(error)
            })
        },
        getQuestion(){
            let pid = this.$route.query.pid //获取路由传递过来的试卷编号
            let data=this.$qs.stringify({
                'pidStr':pid
            })
            axios({
                url:'http://47.103.10.220:8008/paperDetail/listPaperDetail',
                method:'post',
                data:data
            }).then((res)=>{
                console.log(res)
                this.question=res.data
            }).catch((error)=>{
                console.log(error)
            })
        },
        submiteAnwser() {
        clearInterval(this.time);
        this.$alert( '提交成功！', {
            confirmButtonText: '确定',
            callback: action => {
              this.myScore = true;
              this.$router.push('/student')
            //   this.$ajax({
            //     method: "post",
            //     url: "http://47.103.10.220:8008/score/queryScoreByUser",
            //     dataType: "json",
            //     crossDomain: true,
            //     cache: false,
            // }).then(resolve => {
            //     this.tableData1 = resolve.data;
            //     //获取数组长度赋值给total
            //     this.total1 = resolve.data.length;
            //     // this.peoLoading = false;
            //     console.log(resolve.data);
            // }, reject => {
            //     // this.peoLoading = true;
            //     console.log(reject);
            // });
          }
        });
        //算分
        let right = 0;
        for(let p=0; p<this.question.length; p++){
          for(let q=0; q<this.radioAnswer.length; q++){
            if(this.radioAnswer[q]!=undefined){
              if(this.question[p].exerciseId == this.radioAnswer[q].index){
                if(this.question[p].answer == this.radioAnswer[q].value){
                  right += this.question[p].score;
                }
              }
            }
          }
        }
        console.log(right);
        this.testing = true;
        this. sureTest = false;
        this.$ajax({
            method: "post",
            url: "http://47.103.10.220:8008/score/addScore",
            data: {
              paperIdStr: this.paperID,
              markStr: right,
            },
            dataType: "json",
            crossDomain: true,
            cache: false,
            transformRequest(obj){
                    var str = [];
                    for(var p in obj){
                        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                    }
                    return str.join("&");
                },
        }).then(resolve => {
          console.log(resolve.data);
        }, reject => {
            console.log(reject);
        });
      },

        },
    }
</script>

<style scoped>
  #testOrNot {
    width: 50%;
    position: absolute ;
    top: 150px;
    left: 27%;
  }
  #testYes{
    position: absolute ;
    width: 93%;
    top: 112px;
    left: 4%;
  }
  #answer{
    position: absolute ;
    width: 90%;
    top: 112px;
    left: 4%;
  }
  #score {
    position: absolute ;
    width: 93%;
    top:112px;
    left: 4%;
  }

  .iconfont.icon-time {
  color: #2776df;
  margin: 0px 6px 0px 20px;
}
.analysis {
  margin-top: 20px;
  .right {
    color: #2776df;
    font-size: 18px;
    border: 1px solid #2776df;
    padding: 0px 6px;
    border-radius: 4px;
    margin-left: 20px;
  }
  ul li:nth-child(2) {
    margin: 20px 0px;
  }
  ul li:nth-child(3) {
    padding: 10px;
    background-color: #d3c6c9;
    border-radius: 4px;
  }
}
.analysis span:nth-child(1) {
  font-size: 18px;
}
.mark {
  position: absolute;
  width: 4px;
  height: 4px;
  content: "";
  background-color: red;
  border-radius: 50%;
  top: 0px;
  left: 22px;
}
.border {
  position: relative;
  border: 1px solid #FF90AA !important;
}
.bg {
  background-color: #5188b8 !important;
}
.fill .el-input {
  display: inline-flex;
  width: 150px;
  margin-left: 20px;
  .el-input__inner {
    border: 1px solid transparent;
    border-bottom: 1px solid #eee;
    padding-left: 20px;
  }
}
/* slider过渡效果 */
.slider-fade-enter-active {
  transition: all .3s ease;
}
.slider-fade-leave-active {
  transition: all .3s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}
.slider-fade-enter, .slider-fade-leave-to {
  transform: translateX(-100px);
  opacity: 0;
}

.operation .end li:nth-child(2) {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: rgb(39, 118, 223);
  border-radius: 50%;
  width: 50px;
  height: 50px;
  color: #fff;
}
.operation .end li {
  cursor: pointer;
  margin: 0 100px;
}
.operation {
  background-color: #fff;
  border-radius: 4px;
  padding: 10px 0px;
  margin-right: 10px;
}
.operation .end {
  display: flex;
  justify-content: center;
  align-items: center;
  color: rgb(39, 118, 223);
}
.content .number {
  display: inline-flex;
  justify-content: center;
  align-items: center;
  width: 20px;
  height: 20px;
  background-color: rgb(39, 118, 223);
  border-radius: 4px;
  margin-right: 4px;
}
.content {
  padding: 0px 20px;
}
.content .topic {
  padding: 20px 0px;
  padding-top: 30px; 
}
.right .content {
  background-color: #fff;
  margin: 10px;
  margin-left: 0px;
  height: 470px;
}
.content .el-radio-group label {
  color: #000;
  margin: 5px 0px;
}
.content .el-radio-group {
  display: flex;
  flex-direction:column;
}
.right .title p {
  margin-left: 20px;
}
.flexarea {
  display: flex;
}
.flexarea .right {
  flex: 1;
}
.auto-right {
  margin-left: auto;
  color: #2776df;
  margin-right: 10px;
}
.right .title {
  margin-right: 10px;
  padding-right: 30px;
  display: flex;
  margin-top: 10px;
  background-color: #fff;
  height: 50px;
  line-height: 50px;
}
.clearfix {
  clear: both;
}
.l-bottom .final {
  cursor: pointer;
  display: inline-block;
  text-align: center;
 background-color: rgb(39, 118, 223);
  width: 240px;
  margin: 20px 0px 20px 10px;
  border-radius: 4px;
  height: 30px;
  line-height: 30px;
  color: #fff;
  margin-top: 22px;
}
#answer .left .item {
  padding: 0px;
  font-size: 16px;
}
.l-bottom {
  border-radius: 4px;
  background-color: #fff;
}
.l-bottom .item p {
  margin-bottom: 15px;
  margin-top: 10px;
  color: #000;
  margin-left: 10px;
  letter-spacing: 2px;
}
.l-bottom .item li {
  width: 15%;
  margin-left: 5px;
  margin-bottom: 10px;
}
.l-bottom .item {
  display: flex;
  flex-direction: column;
}
.l-bottom .item ul {
  width: 100%;
  margin-bottom: -8px;
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
}
.l-bottom .item ul li a { 
  position: relative;
  justify-content: center;
  display: inline-flex;
  align-items: center;
  width: 30px;
  height: 30px;
  border-radius: 50%;
  background-color: #fff;
  border: 1px solid #eee;
  text-align: center;
  color: #000;
  font-size: 16px;
}
.left .l-top {
  display: flex;
  justify-content: space-around;
  padding: 16px 0px;
  border: 1px solid #eee;
  border-radius: 4px;
  margin-bottom: 10px;
  background-color: #fff;
}
.left {
  width: 260px;
  height: 100%;
  margin: 10px 10px 0px 10px;
}
.left .l-top li:nth-child(2) a {
  border: 1px solid #eee;
}
.left .l-top li:nth-child(3) a {
  background-color: #5188b8;
  border: none;
}
.left .l-top li:nth-child(4) a {
  position: relative;
  border: 1px solid #eee;
}
.left .l-top li:nth-child(4) a::before {
  width: 4px;
  height: 4px;
  content: " ";
  position: absolute;
  background-color: red;
  border-radius: 50%;
  top: 0px;
  left: 16px;
}
.left .l-top li {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}
.left .l-top li a {
  display: inline-block;
  padding: 10px;
  border-radius: 50%;
  background-color: #fff;
  border: 1px solid #FF90AA;
}
#answer1 .top {
  background-color: rgb(39, 118, 223);
}
#answer1 .item {
  color: #fff;
  display: flex;
  padding: 20px;
  font-size: 20px;
}
#answer1 .top .item li:nth-child(1) {
  margin-right: 10px;
}
#answer1 .top .item li:nth-child(3) {
  position: relative;
  margin-left: auto;
}
#answer1 {
  padding-bottom: 30px;
}
.icon20 {
  font-size: 20px;
  font-weight: bold;
}
.item .msg {
  padding: 10px 15px;
  border-radius: 4px;
  top: 47px;
  right: -30px;
  color: #6c757d;
  position: absolute;
  border: 1px solid rgba(0,0,0,.15);
  background-color: #fff;
}
.item .msg p {
  font-size: 16px;
  width: 200px;
  text-align: left;
}
</style>