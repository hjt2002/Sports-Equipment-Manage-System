<template>
  <div id="app">
    <el-container class="my_container">
      <el-header class="my_header">
        <div class="my_sysName">
          体育器材系统     浏览器材
          <i :class="isopen" @click="isOpen"></i>
        </div>
        <div class="my_header_right">
          <span>当前用户：</span>
          <span>{{accountMessage}}</span>

          <span >
            <el-button class="e_button" @click="exit">退出登录</el-button>
          </span>
        </div>
      </el-header>
      <el-container>
        <el-aside class="my_aside" :width="`${asideWidth}px`">
          <el-menu

              :collapse-transition='false'
              :collapse="iscollapse"
              :default-active="defaultActive"
              class="el-menu-vertical-demo"
              @open="handleOpen"
              @close="handleClose"
              background-color="#545c64"
              text-color="#fff"
              active-text-color="#ffd04b"
              router
              style="border :0">
            <el-menu-item index="/look_All">
              <i class="el-icon-setting"></i>
              <span slot="title">浏览器材</span>
            </el-menu-item>
            <el-menu-item index="/search">
              <i class="el-icon-menu"></i>
              <span slot="title">器材状态</span>
            </el-menu-item>
            <el-menu-item index="/borrow">
              <i class="el-icon-menu"></i>
              <span slot="title">借用器材</span>
            </el-menu-item>
            <el-menu-item index="/return_e">
              <i class="el-icon-menu"></i>
              <span slot="title">归还器材</span>
            </el-menu-item>
            <el-menu-item >
              <i class="el-icon-menu"></i>
              <span slot="title">  </span>
            </el-menu-item>
            <el-menu-item >
              <i class="el-icon-menu"></i>
              <span slot="title">  </span>
            </el-menu-item>
            <el-menu-item >
              <i class="el-icon-menu"></i>
              <span slot="title">  </span>
            </el-menu-item>
            <el-menu-item >
              <i class="el-icon-menu"></i>
              <span slot="title">  </span>
            </el-menu-item>
            <el-menu-item >
              <i class="el-icon-menu"></i>
              <span slot="title">  </span>
            </el-menu-item>
            <el-menu-item >
              <i class="el-icon-menu"></i>
              <span slot="title">  </span>
            </el-menu-item>
            <el-menu-item >
              <i class="el-icon-menu"></i>
              <span slot="title">  </span>
            </el-menu-item>
            <el-menu-item >
              <i class="el-icon-menu"></i>
              <span slot="title">  </span>
            </el-menu-item>



          </el-menu>
        </el-aside>
<!--                中间那块东西-->
<!--                <el-main class="my_main">-->
<!--        &lt;!&ndash;         // <router-view></router-view>&ndash;&gt;-->
<!--                </el-main>-->
        <el-main class="my_main">

        <div class="common-layout">
          <el-container>
            <el-header  height=100px>

              <br />
              <el-form
                  ref="form"
                  :model="return_data"
                  label-width="auto"
                  :label-position="labelPosition"
                  :size="size"
              >
                <el-form-item label="search_data">
                  <el-input v-model="search_data" />
                </el-form-item>
                <el-form-item>
                  <el-button class="my_button" @click="onSubmit">搜索</el-button>
                </el-form-item>
              </el-form>

            </el-header>
            <el-main>

              <el-table :data="tableData" style="width: 100%">
                <el-table-column prop= eid label="EID" width="200" />
                <el-table-column prop= estate label="ESTATE" width="200" />
              </el-table>

            </el-main>
          </el-container>
        </div>

        </el-main>



      </el-container>
    </el-container>
  </div>
</template>

<script>
import { getCurrentInstance } from "vue";
import axios from "axios";

export default {
  data(){
    return{
      search_data:  null,
      tableData: [
        {
          EID: null,
          ESTATE:null,
        }]
    }
  },
  methods: {
    accountMessage: function () {
      return ref(getCurrentInstance()?.appContext.config.globalProperties.$account)
    },
      exit(){
        this.$router.push({ path:'/'  })
      },

    onSubmit()
    {
      this.tableData = null
      const _this = this

      axios({
        method: "post",
        url: 'http://localhost:8181/equipmentstate/stateFind',
        data:{
          id: _this.search_data
        }
      }).then(function (resp){
        _this.tableData = [resp.data]
        console.log(resp)
      })

      this.$message({
        showClose: true,
        message: "操作成功！",
        type: 'success'
      });
    }
  },
  created(){
    const _this = this
    axios({
      method: "get",
      url: 'http://localhost:8181/equipmentstate/findAll',
    }).then(function (resp){
      _this.tableData = resp.data
      console.log(resp)
    })
  },
}




</script>

<style scoped>
#app{
  height: 100%;
}
.my_container{
  height: 100%;
}
.my_header{
  background:#303133;
  color:#fff;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.my_sysName{
  font-size: 20px;
  font-weight: 500;
}
.my_header_right{
  display: flex;
  align-items: center;
  justify-content: space-around;
  width: 300px;
}
.my_aside{
  background: #545c64;
  transition: width .3s;
}
.my_main{
  background: #E4E7ED;
}

.my_button{

  color: #fff;
  width: 100px;
  background-color: #97c491;
  margin-left: 400px;

}
.e_button{

  color: #0a0a0a;
  width: 100px;
  background-color: #b6506e;

}
</style>