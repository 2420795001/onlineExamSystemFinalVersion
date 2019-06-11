//查询所有题库
<template>
  <div class="exam">
    <el-table :data="question" border :row-class-name="tableRowClassName">
      <el-table-column fixed="left" prop="qid" label="题目编号" width="180"></el-table-column>
      <el-table-column prop="types" label="类型" width="200"></el-table-column>
      <el-table-column prop="content" label="内容" width="200"></el-table-column>
      <el-table-column prop="right" label="答案" width="150"></el-table-column>
      <el-table-column prop="value" label="分数" width="133"></el-table-column>
      <el-table-column fixed="right" label="操作" width="300">
        <template slot-scope="scope">
          <el-button @click="del(scope.row.qid)" type="warning" size="small">删除题目</el-button>
          <el-button @click="choose(scope.row.qid)" type="info" size="small">选题</el-button>
        </template>
      </el-table-column>
    </el-table>
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
      question:[], //所有问题
      pagination: {
        //分页后的考试信息
        current: 1, //当前页
        total: null, //记录条数
        size: 6 //每页条数
      }
    };
  },
  created() {
    this.getAnswerInfo();
  },
  methods: {
    //获取所有
    getAnswerInfo() {
      //分页查询所有题目信息
      axios({
        url:'http://47.103.10.220:8008/question/listAllQuestion',
        method:'get'
      }).then(res => {
          this.question = res.data;
          // console.log(res);
        })
        .catch(error => {
          console.log(error)
        });
    },
    //删除一道题
    del(qid){
      let data=this.$qs.stringify({
        'qidStr':qid
      })
      axios({
        url:'http://47.103.10.220:8008/question/delQuestion',
        method:'post',
        data:data
      }).then(function(res){
        // console.log(res)
      }).catch(function(error){
        console.log(error)
      })
      this.getAnswerInfo()
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
    tableRowClassName({ row, rowIndex }) {
      if (rowIndex % 2 == 0) {
        return "warning-row";
      } else {
        return "success-row";
      }
    }
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
  .edit {
    margin-left: 20px;
  }
  .el-table tr {
    background-color: #DD5862 !important;
  }
}
  .el-table .warning-row {
    background: #000 !important;
    
  }

  .el-table .success-row {
    background: #DD5862;
  }

</style>
