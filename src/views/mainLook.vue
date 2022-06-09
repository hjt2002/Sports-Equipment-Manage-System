<template>
  <div id="app">
    <el-container class="my_container">
      <el-header class="my_header">
        <div class="my_sysName">
          体育器材系统 (用户界面)
          <i :class="isopen" @click="isOpen"></i>
        </div>
        <div class="my_header_right">
          <span>当前用户：</span>
          <span >退出登录</span>
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
          </el-menu>
        </el-aside>
        <el-main class="my_main">

          {{  msg}}
        </el-main>


      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  data(){
    return{

      msg:'Welcome.............'

    }
  }
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
  width: 200px;
}
.my_aside{
  background: #545c64;
  transition: width .3s;
}
.my_main{
  background: #E4E7ED;
}

</style>