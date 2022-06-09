<template>
  <div>
    <div class="login-box">
      <h2>体育器材系统</h2>
      <form>
        <div class="user-box">
          <input type="text" name="" required="" v-model="username">
          <label>账号</label>
        </div>
        <div class="user-box">
          <input type="password" name="" required="" v-model="password">
          <label>密码</label>
        </div>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a @click="login">

          登录

        </a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a @click="register">注册 </a>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {

  name: "Login",
  data() {
    return {
      ruleForm: {
        username: '',
        password: '',
        msg: ''
      }
    }
  },
  methods: {

    open() {
      this.$message({
        showClose: true,
        message: this.msg,
        type: 'error'
      });
    },


    async login(){
      let temp = ""
      await
          axios({
            method: "post",
            url: 'http://localhost:8181/myuser/matchingpwd',
            data: {
              userid: this.username,
              userpassword: this.password,
            }
          }).then(function (resp){
            temp = resp.data
            console.log(resp)
          })

      if(this.username==""||this.password==""){
        //空值
        this.msg = "请输入账号密码"
        this.open()
      }else if(temp === 0){
        //登录错误
        this.msg = "账号或密码错误"
        this.open()
        //登录成功
      }else if (temp == 11){
        //admin
        this.$router.push({ path:'/admin'  })
      }else if(temp == 10){
        //user
        this.$router.push({ path:'/main'  })
      }

      // if(this.username===""||this.password===""){
      //   this.msg = "请输入账号密码"
      //   this.open()
      // }else if(this.username==="user"||this.password==="user")//这里写axios获取   用户登录
      // {
      //
      //   this.$router.push({ path:'/main'  })
      // }else if(this.username==="admin"||this.password==="admin")//这里写axios获取  管理员登录
      // {
      //
      //   this.$router.push({ path:'/admin'  })
      // }
      // else
      // {
      //   this.msg = "账号或密码错误"
      //   this.open()
      // }
    },

    register(){
      this.$router.push({ path:'/register'  })
    }
  }
  ,

  created(){

  }


}
</script>

<style>
body {
  background-image: url(https://img0.baidu.com/it/u=530426417,2082848644&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500);
  background-repeat: no-repeat;
  background-size: 100%;
  background-position: 0px -50px;
}

.login-box {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 400px;
  padding: 40px;
  transform: translate(-50%, -50%);
  background: rgba(0, 0, 0, .5);
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0, 0, 0, .6);
  border-radius: 10px;
}

.login-box h2 {
  margin: 0 0 30px;
  padding: 0;
  color: #fff;
  text-align: center;
}

.login-box .user-box {
  position: relative;
}

.login-box .user-box input {
  width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid #fff;
  outline: none;
  background: transparent;
}

.login-box .user-box label {
  position: absolute;
  top: 0;
  left: 0;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  pointer-events: none;
  transition: .5s;
}

.login-box .user-box input:focus ~ label,
.login-box .user-box input:valid ~ label {
  top: -20px;
  left: 0;
  color: #03e9f4;
  font-size: 12px;
}

.login-box form a {
  position: relative;
  display: inline-block;
  padding: 10px 20px;
  color: #03e9f4;
  font-size: 16px;
  text-decoration: none;
  text-transform: uppercase;
  overflow: hidden;
  transition: .5s;
  margin-top: 40px;
  letter-spacing: 4px
}

.login-box a:hover {
  background: #03e9f4;
  color: #fff;
  border-radius: 5px;
  box-shadow: 0 0 5px #03e9f4,
  0 0 25px #03e9f4,
  0 0 50px #03e9f4,
  0 0 100px #03e9f4;
}

.login-box a span {
  position: absolute;
  display: block;
}

.login-box a span:nth-child(1) {
  top: 0;
  left: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(90deg, transparent, #03e9f4);
  animation: btn-anim1 1s linear infinite;
}

@keyframes btn-anim1 {
  0% {
    left: -100%;
  }
  50%, 100% {
    left: 100%;
  }
}

.login-box a span:nth-child(2) {
  top: -100%;
  right: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(180deg, transparent, #03e9f4);
  animation: btn-anim2 1s linear infinite;
  animation-delay: .25s
}

@keyframes btn-anim2 {
  0% {
    top: -100%;
  }
  50%, 100% {
    top: 100%;
  }
}

.login-box a span:nth-child(3) {
  bottom: 0;
  right: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(270deg, transparent, #03e9f4);
  animation: btn-anim3 1s linear infinite;
  animation-delay: .5s
}

@keyframes btn-anim3 {
  0% {
    right: -100%;
  }
  50%, 100% {
    right: 100%;
  }
}

.login-box a span:nth-child(4) {
  bottom: -100%;
  left: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(360deg, transparent, #03e9f4);
  animation: btn-anim4 1s linear infinite;
  animation-delay: .75s
}

@keyframes btn-anim4 {
  0% {
    bottom: -100%;
  }
  50%, 100% {
    bottom: 100%;
  }
}
</style>



