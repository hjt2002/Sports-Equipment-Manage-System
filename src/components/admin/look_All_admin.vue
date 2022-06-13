<template>
  <div id="app">
    <el-container class="my_container">
      <el-header class="my_header">
        <div class="my_sysName">
          体育器材系统     浏览器材
          <i :class="isopen" @click="isOpen"></i>
        </div>
        <div class="my_header_right">
          <span>当前管理员：</span>
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
            <el-menu-item index="/look_All_admin">
              <i class="el-icon-setting"></i>
              <span slot="title">浏览器材</span>
            </el-menu-item>
            <el-menu-item index="/search_admin">
              <i class="el-icon-menu"></i>
              <span slot="title">器材状态</span>
            </el-menu-item>
            <el-menu-item index="/user_look">
              <i class="el-icon-menu"></i>
              <span slot="title">用户管理</span>
            </el-menu-item>
            <el-menu-item index="/in_equip">
              <i class="el-icon-menu"></i>
              <span slot="title">器材入库</span>
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
        <!--        中间那块东西-->
        <!--        <el-main class="my_main">-->
        <!--&lt;!&ndash;         // <router-view></router-view>&ndash;&gt;-->
        <!--        </el-main>-->

        <el-main class="my_main">


        <el-table :data="tableData" style="width: 100%">
          <el-table-column prop = eid label="器材ID" width="200" />
          <el-table-column prop = equipmentname  label= "器材名称" width="200" />
<!--          <el-table-column prop="estate" label="器材状态" width="200" />-->
          <el-table-column label="Operations">
            <template #default="scope"><el-button class="my_button"
                                                  size="small"
                                                  @click="handleDelete(scope.row.eid)"
            >删除</el-button
            >
            </template>
          </el-table-column>
        </el-table>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import axios from "axios";
import { getCurrentInstance } from "vue";

const handleDelete = (index) => {
  console.log(index)
}
export default {
  data(){
    return{
      tableData: [{
        eid: "",
        equipmentname: "",
        // estate: ""
      }]
    }
  },
  methods: {

    //删除器材的方法
    handleDelete(eid){

      this.$confirm('此操作将删除器材, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {

        //在这里写逻辑，eid是确定删除的器材，直接调用就行

        axios({
          method: "post",
          url: 'http://localhost:8181/equipment/deleteEquipment',
          data: {
            id: eid
          }
        }).then(function (resp){
          console.log(resp)
        })

        this.$message({
          type: 'success',
          message: eid+ '   删除成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    accountMessage: function () {
      return ref(getCurrentInstance()?.appContext.config.globalProperties.$account)
    },
    exit(){
      this.$router.push({ path:'/'  })
    }
  },

  created(){
    const _this = this
    axios({
      method: "get",
      url: 'http://localhost:8181/equipment/findAll',
    }).then(function (resp){
      _this.tableData = resp.data
      console.log(resp)
    })
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
  width: 50px;
  background-color: #b6506e;
  justify-content: center;

}
.e_button{

  color: #0a0a0a;
  width: 100px;
  background-color: #b6506e;

}

</style>