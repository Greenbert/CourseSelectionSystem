<template>
  <div>
    <!-- <el-page-header @back="goBack" content="详情页面"> </el-page-header> -->
    <el-card class="plain">
      <h1>待选课程</h1>
      <el-table :data="tableDataini" height="250" border style="width: 100%">
        <el-table-column prop="couid" label="课程id" width="180">
        </el-table-column>
        <el-table-column prop="name" label="课程名" width="180">
        </el-table-column>
        <el-table-column prop="xf" label="学分"> </el-table-column>
        <el-table-column prop="xs" label="学时"> </el-table-column>
        <el-table-column prop="capacity" label="总名额"> </el-table-column>
        <el-table-column prop="left" label="剩余名额"> </el-table-column>
        <el-table-column label="操作" width="100">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small"
              >选课</el-button
            >
            <!-- <el-button type="text" size="small">详情</el-button> -->
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <el-card class="plaindown">
      <h1>已选课程</h1>
      <el-table :data="tableData" height="250" border style="width: 100%">
        <el-table-column prop="couid" label="课程id" width="180">
        </el-table-column>
        <el-table-column prop="name" label="课程名" width="180">
        </el-table-column>
        <el-table-column prop="xf" label="学分"> </el-table-column>
        <el-table-column prop="xs" label="学时"> </el-table-column>
        <el-table-column prop="capacity" label="总名额"> </el-table-column>
        <el-table-column prop="left" label="剩余名额"> </el-table-column>
        <el-table-column label="操作" width="100">
          <template slot-scope="scope">
            <el-button @click="handleClickdelete(scope.row)" type="text" size="small"
              >退课</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
import axios from "axios";
import { Message } from "element-ui";

export default {
  created() {
    let stuid = JSON.parse(window.localStorage.getItem("uid"));
    this.stuid = stuid;
  },
  mounted() {
    this.initData();
  },
  data() {
    return {
      leftcapacity: [],
      stuid: "",
      tableDataini: [],
      tableData: [
        {
          couid: "2016-05-03",
          name: "王小虎",
          xf: "上海市普陀区金沙江路 1518 弄",
          xs: "上海市普陀区金沙江路 1518 弄",
        },
        {
          couid: "2016-05-03",
          name: "王小虎",
          xf: "上海市普陀区金沙江路 1518 弄",
          xs: "上海市普陀区金沙江路 1518 弄",
        },
        {
          couid: "2016-05-03",
          name: "王小虎",
          xf: "上海市普陀区金沙江路 1518 弄",
          xs: "上海市普陀区金沙江路 1518 弄",
        },
        {
          couid: "2016-05-03",
          name: "王小虎",
          xf: "上海市普陀区金沙江路 1518 弄",
          xs: "上海市普陀区金沙江路 1518 弄",
        },
        {
          couid: "2016-05-03",
          name: "王小虎",
          xf: "上海市普陀区金沙江路 1518 弄",
          xs: "上海市普陀区金沙江路 1518 弄",
        },
        {
          couid: "2016-05-03",
          name: "王小虎",
          xf: "上海市普陀区金沙江路 1518 弄",
          xs: "上海市普陀区金沙江路 1518 弄",
        },
        {
          couid: "2016-05-03",
          name: "王小虎",
          xf: "上海市普陀区金沙江路 1518 弄",
          xs: "上海市普陀区金沙江路 1518 弄",
        },
      ],
    };
  },

  methods: {
    initData() {
      this.loadDataWait();
      this.loadDataChosen();
    },
    handleClick(row) {
      console.log(row);
      let params = {
        stuid: this.stuid,
        couid: row.couid,
        left: row.left
      };
      this.tableDataini = [];
      let _this = this;
      axios({
        method: "post",
        params: params,
        url: "http://localhost:80/select/insertT",
      }).then(function (res) {
        console.log(res);
        Message({
            message: "选课成功",
            type: "success",
          });
          _this.initData();
      });
    },
    handleClickdelete(row) {
     console.log(row);
      let params = {
        stuid: this.stuid,
        couid: row.couid,
        left: row.left
      };
      this.tableDataini = [];
      let _this = this;
      axios({
        method: "post",
        params: params,
        url: "http://localhost:80/select/deleteById",
      }).then(function (res) {
        console.log(res);
        Message({
            message: "退课成功",
            type: "success",
          });
          _this.initData();
      });
    },
    loadDataWait() {
      let params = {
        id: this.stuid,
      };
      this.tableDataini = [];
      let _this = this;
      axios({
        method: "post",
        params: params,
        url: "http://localhost:80/course/getnocourse",
      }).then(function (res) {
        console.log(res);
        if (res.data != "") {
          for (let i = 0; i < res.data.length; i++) {
            _this.tableDataini.push(res.data[i]);
          }
        } else {
          Message({
            message: "错误",
            type: "warning",
          });
        }
      });
    },
    loadDataChosen() {
      let params = {
        id: this.stuid,
      };
      this.tableData = [];
      let _this = this;
      axios({
        method: "post",
        params: params,
        url: "http://localhost:80/course/getcourse",
      }).then(function (res) {
        console.log(res);
        if (res.data != "") {
          for (let i = 0; i < res.data.length; i++) {
            _this.tableData.push(res.data[i]);
          }
        } else {
          Message({
            message: "错误",
            type: "warning",
          });
        }
      });
    },
  },
  components: {},
};
</script>


<style scoped>
.plain {
  width: 80%;
  margin: 0 auto;
  margin-top: 5%;
}
.plaindown {
  width: 80%;
  margin: 0 auto;
  margin-top: 3%;
}
</style>