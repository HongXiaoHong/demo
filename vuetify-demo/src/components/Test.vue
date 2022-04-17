<template>
  <div class="start">
    <h1>This is an start page</h1>
    <v-file-input
        @change="upload"
        truncate-length="15"
    ></v-file-input>

    <v-btn link @click="download">下载</v-btn>
  </div>
</template>

<script lang="ts">
  import Vue from 'vue'
  import axios from "axios";

  export default Vue.extend({
    name: 'TestApp',
    methods: {
      upload: function (e: any) {
        let file = e
        let param = new FormData()       // 创建form对象
        param.append('file', file)       // 通过append向form对象添加数据
        let config = {
          headers: {'Content-Type': 'multipart/form-data'}
        }
        axios.post("apis/upload",param, config).then((res)=>{
          console.log(res)
        }).catch((err)=>{
          console.error("图片上传失败，请重新上传!", err)
        })

        return false;
      },
      download: function () {
        // https://www.csdn.net/tags/NtDakg4sNTAwNDYtYmxvZwO0O0OO0O0O.html
        // Vue实现下载文件功能（通过a标签、点击按钮、二维码下载文件功能）
        window.open("apis/download?id=1","_blank");
      }
    }
  })
</script>
