//查询所有考试
<template>
  <div class="exam">
    <el-table :data="papers" border>
      <el-table-column fixed="left" prop="pid" label="试卷编号" width="180"></el-table-column>
      <el-table-column fixed="left" prop="pname" label="试卷名称" width="180"></el-table-column>
      <!-- <el-table-column prop="description" label="介绍" width="200"></el-table-column> -->
      <!-- <el-table-column prop="institute" label="所属学院" width="120"></el-table-column> -->
      <!-- <el-table-column prop="major" label="所属专业" width="200"></el-table-column> -->
      <!-- <el-table-column prop="grade" label="年级" width="100"></el-table-column> -->
      <!-- <el-table-column prop="examDate" label="考试日期" width="120"></el-table-column> -->
      <el-table-column prop="duration" label="持续时间" width="320"></el-table-column>
      <!-- <el-table-column prop="totalScore" label="总分" width="120"></el-table-column> -->
      <!-- <el-table-column prop="type" label="试卷类型" width="120"></el-table-column> -->
      <!-- <el-table-column prop="tips" label="考生提示" width="400"></el-table-column> -->
      <el-table-column fixed="right" label="操作" width="450">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row.pid)" type="primary" size="small">编辑试卷</el-button>
          <el-button @click="deleteRecord(scope.row.pid)" type="danger" size="small">删除试卷</el-button>
          <el-button @click="detail(scope.row.pid)" type="info" size="small">试卷题目</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagination.current"
      :page-sizes="[4, 8, 10, 20]"
      :page-size="pagination.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pagination.total" class="page">
    </el-pagination>
    <!-- 编辑题目-->
    <el-dialog
      title="编辑试卷信息"
      :visible.sync="dialogVisible2"
      width="50%"
      :before-close="handleClose">
        <el-table :data="question" border>
          <el-table-column fixed="left" prop="pdid" label="题目编号" width="80"></el-table-column>
          <el-table-column prop="types" label="类型" width="100"></el-table-column>
          <el-table-column prop="content" label="内容" width="200"></el-table-column>
          <el-table-column prop="right" label="答案" width="100"></el-table-column>
          <el-table-column prop="value" label="分数" width="80"></el-table-column>
          <el-table-column fixed="right" label="操作" width="150">
            <template slot-scope="scope">
              <el-button @click="del(scope.row.pdid,scope.row.pid)" type="warning" size="small">删除题目</el-button>
            </template>
          </el-table-column>
      </el-table>
    </el-dialog>
    <el-dialog
      title="编辑试卷信息"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose">
      <section class="update">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="试卷编号">
            <el-input v-model="form.pid"></el-input>
          </el-form-item>
          <el-form-item label="试卷名称">
            <el-input v-model="form.pname"></el-input>
          </el-form-item>
          <!-- <el-form-item label="考试日期">
            <el-col :span="11">
              <el-date-picker type="date" placeholder="选择日期" v-model="form.examDate" style="width: 100%;"></el-date-picker>
            </el-col>
          </el-form-item> -->
          <el-form-item label="持续时间">
            <el-input v-model="form.duration"></el-input>
          </el-form-item>
          <!-- <el-form-item label="考生提示">
            <el-input type="textarea" v-model="form.tips"></el-input>
          </el-form-item> -->
        </el-form>
      </section>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submit()">确 定</el-button>
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
      papers:[],  //所有试卷
      question:[], //该试卷所有问题
      form: {},   //保存点击以后当前试卷的信息
      pagination: { //分页后的考试信息
        current: 1, //当前页
        total: null, //记录条数
        size: 4 //每页条数
      },
      dialogVisible: false,
      dialogVisible2:false,
    }
  },
  created() {
    this.getExamInfo()
  },
  methods: {
    //删除考试题目
    del(pdid,pid){
      let data=this.$qs.stringify({
        'pdidStr':pdid
      })
      axios({
        url:'http://47.103.10.220:8008/paperDetail/delPaperDetail',
        method:'post',
        data:data
      }).then((res)=>{
        console.log(res)
        this.detail(pid)
      }).catch((error)=>{
        console.log(error)
      })
    },
    //删除考试
    detail(pid){
      this.dialogVisible2=true
      let data=this.$qs.stringify({
        'pidStr':pid
      })
      axios({
        url:'http://47.103.10.220:8008/paperDetail/listPaperDetail',
        method:'post',
        data:data
      }).then((res) => {
          this.question = res.data;
          console.log(res);
        })
        .catch((error) => {
          console.log(error)
        });
    },


    edit(pid) { //编辑试卷
      this.dialogVisible = true
      // this.$axios(`/api/exam/${examCode}`).then(res => { //根据试卷id请求后台
      //   if(res.data.code == 200) {
      //     this.form = res.data.data
      //   }
      // })
    },
    handleClose(done) { //关闭提醒
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        }).catch(_ => {});
    },
    submit() { //提交修改后的试卷信息
      this.dialogVisible = false
      let data=this.$qs.stringify({
        'pidStr':this.form.pid,
        'pname':this.form.pname,
        'duration':this.form.duration
      })
      axios({
        url: 'http://47.103.10.220:8008/paper/updatePaper',
        method: 'post',
        data: data
      }).then(res => {
        if(res.data.code == 200) {
          this.$message({ //成功修改提示
            message: '更新成功',
            type: 'success'
          })
        }
        this.getExamInfo()
      })
    },


    deleteRecord(pid) {
      this.$confirm("确定删除该记录吗,该操作不可逆！！！","删除提示",{
        confirmButtonText: '确定删除',
        cancelButtonText: '算了,留着',
        type: 'danger'
      }).then(()=> { //确认删除
        let data=this.$qs.stringify({
          'pidStr':pid
        })
        axios({
          url: 'http://47.103.10.220:8008/paper/delPaper',
          method: 'post',
          data:data
        }).then(res => {
          this.getExamInfo()
        })
      }).catch(() => {

      })
    },
    getExamInfo() { //所有试卷信息
      // this.$axios(`/api/exams/${this.pagination.current}/${this.pagination.size}`).then(res => {
      //   this.pagination = res.data.data
      // }).catch(error => {
      // })
      axios({
          url:'http://47.103.10.220:8008/paper/listAllPaper',
          method:'get',
        }).then(res => {
        this.papers = res.data
        this.pagination.total=res.data.length
        console.log(this.res)
      }).catch(error => {
        console.log(error)
      })
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val
      this.getExamInfo()
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val
      this.getExamInfo()
    },
  }
};
</script>
<style lang="scss" scoped>
.exam {
  padding: 0px 40px;
  .page {
    margin-top: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .edit{
    margin-left: 20px;
  }
}
</style>
