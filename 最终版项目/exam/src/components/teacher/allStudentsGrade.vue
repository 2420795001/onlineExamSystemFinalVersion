// 所有学生
<template>
  <div class="all">
    <el-table :data="paper" border>
      <el-table-column fixed="left" prop="pid" label="试卷编号" width="180"></el-table-column>
      <el-table-column fixed="left" prop="pname" label="试卷名称" width="180"></el-table-column>
      <el-table-column prop="duration" label="持续时间" width="180"></el-table-column>
      <el-table-column fixed="right" label="查看成绩" width="400">
        <template slot-scope="scope">
          <el-button @click="aboveSixty(scope.row.pid)" type="info" size="small">及格</el-button>
          <el-button @click="underSixty(scope.row.pid)" type="info" size="small">不及格</el-button>
          <el-button @click="all(scope.row.pid)" type="info" size="small">全部成绩</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 编辑对话框-->
    <el-dialog
      title="学生信息"
      :visible.sync="dialogVisible"
      width="30%"
      >
      <el-table :sixty="sixty">
        <el-table-column  fixed="left" prop="pid" label="试卷编号" width="130"></el-table-column>
        <el-table-column  prop="username" label="用户名" width="130"></el-table-column>
        <el-table-column  prop="mark" label="成绩" width="130"></el-table-column>
      </el-table>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
      </span>
    </el-dialog>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagination.current"
      :page-sizes="[6, 10]"
      :page-size="pagination.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pagination.total"
      class="page"
    ></el-pagination>
  </div>
</template>

<script>
import axios from 'axios'
import qs from 'qs'
export default {
  data() {
    return {
      // 全部试卷
      paper:[],
      // 遮罩层数据
      sixty:[], 
      pagination: {
        //分页后的考试信息
        current: 1, //当前页
        total: null, //记录条数
        size: 6 //每页条数
      },
      dialogVisible: false
    };
  },
  created() {
    this.getAnswerInfo();
  },
  methods: {
    getAnswerInfo() {
      //分页查询所有试卷信息
      axios({
          url:'http://47.103.10.220:8008/paper/listAllPaper',
          method:'get',
        }).then(res => {
        this.paper = res.data
        this.pagination.total=res.data.length
        console.log(this.res)
      }).catch(error => {
        console.log(error)
      })
    },
    //及格
    aboveSixty(pid){
      this.dialogVisible = true
      let data=this.$qs.stringify({
        "pid":pid
      })
      axios({
        url:'http://47.103.10.220:8008/score/listScoreByMark2',
        method:'post',
        data:data
      }).then((res)=>{
        console.log(res.data)
        this.sixty=res.data
      }).catch((error)=>{
        console.log(error)
      })
    },
    // 不及格
    underSixty(pid){
      this.dialogVisible = true
      let data=this.$qs.stringify({
        "pid":pid
      })
      axios({
        url:'http://47.103.10.220:8008/score/listScoreByMark1',
        method:'post',
        data:data
      }).then((res)=>{
        console.log(res)
        this.sixty=res.data
      }).catch((error)=>{
        console.log(error)
      })
    },
    //全部成绩
    all(pid){
      this.dialogVisible = true
      let data=this.$qs.stringify({
        "pid":pid
      })
      axios({
        url:'http://47.103.10.220:8008/score/listScoreByPaper',
        method:'post',
        data:data
      }).then((res)=>{
        console.log(res)
        this.sixty=res.data
      }).catch((error)=>{
        console.log(error)
      })
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val;
      this.getAnswerInfo();
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val;
      this.getAnswerInfo();
    },
    checkGrade(studentId) {
      this.$router.push({ path: "/grade", query: { studentId: studentId } });
    }
  }
};
</script>
<style lang="scss" scoped>
.all {
  padding: 0px 40px;
  .page {
    margin-top: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .edit {
    margin-left: 20px;
  }
  .el-table tr {
    background-color: #dd5862 !important;
  }
}
.el-table .warning-row {
  background: #000 !important;
}

.el-table .success-row {
  background: #dd5862;
}
</style>
