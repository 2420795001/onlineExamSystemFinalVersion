//显示学生成绩
<template>
  <div class="table">
    <p class="title">我的分数</p>
    <section class="content">
      <el-table ref="filterTable" :data="score" v-loading="loading">
        <el-table-column
          prop="pid"
          label="考试编号"
          width="300"
          filter-placement="bottom-end">
          <template slot-scope="scope">
            <el-tag>{{scope.row.pid}}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="mark" label="考试分数" width="200"></el-table-column>
        <el-table-column label="是否及格" width="100">
          <template slot-scope="scope">
            <el-tag :type="scope.row.mark>= 60 ? 'success' : 'danger'">{{scope.row.mark >= 60 ? "是" : "否"}}</el-tag>
          </template>
        </el-table-column>
      </el-table>
    </section>
  </div>
</template>

<script>
export default {
  data() {
    return {
      loading: false, //加载标识符
      score: [], //学生成绩
      filter: null //过滤参数
    }
  },
  created() {
    this.getScore()
    this.loading = true //数据加载则遮罩表格
  },
  methods: {
    getScore() {
      // let studentId = this.$cookies.get("cid")
      let data=this.$qs.stringify({
        'uidStr':1
      })
      this.$axios({
        url:'http://47.103.10.220:8008/score/listUserScore',
        method:'post',
        data:data
      }).then(res => {
        if(res.status == 200) {
          this.loading = false //数据加载完成去掉遮罩
          console.log(res)
          this.score = res.data
        }
      })
    },
  }
};
</script>

<style lang="scss" scoped>
.table {
  width: 680px;
  margin: 0 auto;
  .title {
    margin: 20px;
  }
  .content {
    background-color: #fff;
    padding: 20px;
  }
}
</style>
