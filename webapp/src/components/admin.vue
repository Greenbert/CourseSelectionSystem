<template>
  <div>
    <!-- <el-page-header @back="goBack" content="详情页面"> </el-page-header> -->
    <el-card class="plain">
      <h1>课程信息</h1>
      <el-button
        @click="
          dialogFormVisible = true;
          op = 1;
          diatitle = '添加课程';
        "
        type="text"
        size="small"
        style="margin-left: 90%"
        >添加课程</el-button
      >
      <el-table :data="tableData" height="450" border style="width: 100%">
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
              >编辑</el-button
            >
            <el-button
              @click="handleClickDelete(scope.row)"
              type="text"
              size="small"
              >删除</el-button
            >
            <!-- <el-button type="text" size="small">详情</el-button> -->
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <el-dialog :title="diatitle" :visible.sync="dialogFormVisible" @close="closeBtn()">
      <el-form :model="form">
        <el-form-item label="课程id" :label-width="formLabelWidth">
          <el-input
            v-model="form.couid"
            autocomplete="off"
            style="width: 80%"
          ></el-input>
        </el-form-item>

        <el-form-item label="课程名" :label-width="formLabelWidth">
          <el-input
            v-model="form.name"
            autocomplete="off"
            style="width: 80%"
          ></el-input>
        </el-form-item>

        <el-form-item label="学分" :label-width="formLabelWidth">
          <el-input
            v-model="form.xf"
            autocomplete="off"
            style="width: 80%"
          ></el-input>
        </el-form-item>

        <el-form-item label="学时" :label-width="formLabelWidth">
          <el-input
            v-model="form.xs"
            autocomplete="off"
            style="width: 80%"
          ></el-input>
        </el-form-item>

        <el-form-item label="名额" :label-width="formLabelWidth">
          <el-input
            v-model="form.capacity"
            autocomplete="off"
            style="width: 80%"
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="checkOp()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import axios from "axios";
import { Message } from "element-ui";

export default {
  mounted() {
    this.loadData();
  },
  data() {
    return {
      diatitle: "",
      op: 0,
      dialogFormVisible: false,
      form: {
        couid: "",
        name: "",
        xf: "",
        xs: "",
        capacity:"",
        left:""
      },
      formLabelWidth: "120px",
      tableData: [
        // {
        //   couid: "2016-05-03",
        //   name: "王小虎",
        //   xf: "上海市普陀区金沙江路 1518 弄",
        //   xs: "上海市普陀区金沙江路 1518 弄",
        // },
        // {
        //   couid: "2016-05-03",
        //   name: "王小虎",
        //   xf: "上海市普陀区金沙江路 1518 弄",
        //   xs: "上海市普陀区金沙江路 1518 弄",
        // },
        // {
        //   couid: "2016-05-03",
        //   name: "王小虎",
        //   xf: "上海市普陀区金沙江路 1518 弄",
        //   xs: "上海市普陀区金沙江路 1518 弄",
        // },
        // {
        //   couid: "2016-05-03",
        //   name: "王小虎",
        //   xf: "上海市普陀区金沙江路 1518 弄",
        //   xs: "上海市普陀区金沙江路 1518 弄",
        // },
        // {
        //   couid: "2016-05-03",
        //   name: "王小虎",
        //   xf: "上海市普陀区金沙江路 1518 弄",
        //   xs: "上海市普陀区金沙江路 1518 弄",
        // },
        // {
        //   couid: "2016-05-03",
        //   name: "王小虎",
        //   xf: "上海市普陀区金沙江路 1518 弄",
        //   xs: "上海市普陀区金沙江路 1518 弄",
        // },
        // {
        //   couid: "2016-05-03",
        //   name: "王小虎",
        //   xf: "上海市普陀区金沙江路 1518 弄",
        //   xs: "上海市普陀区金沙江路 1518 弄",
        // },
      ],
    };
  },

  methods: {
    closeBtn(){
      this.form = {
        couid: "",
        name: "",
        xf: "",
        xs: "",
        capacity:"",
        left: ""
      }
      this.loadData();
    },
    checkOp() {
      if (this.op == 1) {
        this.addcourse();
        this.op = 0;
      } else {
        this.updatecourse();
      }
      this.loadData();
    },
    addcourse() {
      this.form.left = this.form.capacity;
      let _this = this;
      axios({
        method: "post",
        params: _this.form,
        url: "http://localhost:80/course/insertcourse",
      }).then(function (res) {
        console.log(res);
        Message({
          message: "添加成功！",
          type: "success",
        });
      });
    },
    updatecourse() {
      let _this = this;
      axios({
        method: "post",
        params: _this.form,
        url: "http://localhost:80/course/updatecourse",
      }).then(function (res) {
        console.log(res);
        Message({
          message: "修改成功！",
          type: "success",
        });
      });
    },
    handleClick(row) {
      this.dialogFormVisible = true;
      this.diatitle = '修改课程';
      this.form.couid = row.couid;
      this.form.name = row.name;
      this.form.xf = row.xf;
      this.form.xs = row.xs;
      this.form.capacity = row.capacity;
      
      console.log(row.couid);
    },
    handleClickDelete(row) {
      console.log(row);
      let params = {
        couid: row.couid,
      }
      let _this = this;
      axios({
        method: "post",
        params: params,
        url: "http://localhost:80/course/deletecourse",
      }).then(function (res) {
        console.log(res);
        _this.loadData();
        Message({
          message: "删除成功！",
          type: "success",
        });
      });
    },
    loadData() {
      this.tableData = []
      let _this = this;
      axios({
        method: "post",
        data: {},
        url: "http://localhost:80/course/findAll",
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
</style>