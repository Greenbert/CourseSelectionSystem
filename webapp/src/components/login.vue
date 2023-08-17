<template>
  <el-card class="plain">
    <p class="login">
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="登录" name="first">
          <el-form
            :model="ruleForm"
            :rules="rules"
            ref="ruleForm"
            label-width="100px"
            class="demo-ruleForm"
          >
            <el-form-item label="名称" prop="name"
              ><el-input v-model="ruleForm.name"></el-input
            ></el-form-item>

            <el-form-item label="密码" prop="pass"
              ><el-input
                type="password"
                v-model="ruleForm.pass"
                auto-complete="off"
              ></el-input
            ></el-form-item>

            <el-form-item>
              <el-button type="primary" @click="submitForm('ruleForm')"
                >登录</el-button
              >

              <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
          </el-form>
        </el-tab-pane>

        <el-tab-pane label="注册" name="second">
          <register></register>
        </el-tab-pane>
      </el-tabs>
    </p>
  </el-card>
</template>

<script>
import register from "@/components/register";
import axios from "axios";
import { Message } from 'element-ui';

export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.ruleForm.checkPass !== "") {
          this.$refs.ruleForm.validateField("checkPass");
        }

        callback();
      }
    };

    return {
      activeName: "first",
      ruleForm: {
        name: "",
        pass: "",
        checkPass: "",
      },
      rules: {
        name: [
          { required: true, message: "请输入您的名称", trigger: "blur" },
          { min: 2, max: 5, message: "长度在 2 到 5 个字符", trigger: "blur" },
        ],
        pass: [{ required: true, validator: validatePass, trigger: "blur" }],
      },
    };
  },

  methods: {
    //选项卡切换
    handleClick(tab, event) {},
    //重置表单
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    submitForm() {
      let params = {
        id: this.ruleForm.name,
        pwd: this.ruleForm.pass,
      };
      let _this = this;
      axios({
        method: "post",
        params: params,
        url: "http://localhost:80/login",
      }).then(function (res) {
        console.log(res);
        if (res.data != "") {
          if (res.data.id === 'cc'){
			localStorage.setItem("uid", JSON.stringify(res.data.id));
          	_this.$router.replace({ path: "/admin" });
		  }else{
			localStorage.setItem("uid", JSON.stringify(res.data.id));
          	_this.$router.replace({ path: "/chooseClass" });
		  }
		  Message({
            message: "登陆成功",
            type: "success",
          });
        } else {
          Message({
            message: "密码或用户名错误",
            type: "warning",
          });
        }
      });
    },
  },
  components: {
    register,
  },
};
</script>


<style scoped>
.plain {
  width: 500px;
  margin: 0 auto;
  margin-top: 13%;
}

.login {
  width: 400px;
  margin: 0 auto;
  /* margin-top: 13%; */
}

.el-tabsitem {
  text-align: center;
  width: 60px;
}
</style>