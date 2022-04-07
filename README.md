# demo

各种技能的demo学习

使用分支作为学习的技能 不同分支代表不同的技能 分支下若有其他分支 使用模块进行区分

## 前端

### vuetify

![选择包](/readme/images/choose.jpg)

```bash
? Choose a version of Vue.js that you want to start the project with
  3.x
> 2.x
```

```bash
vue add vuetify
```

#### 搭建一个外壳

[预置布局](https://vuetifyjs.com/zh-Hans/getting-started/wireframes/)

用 [base](https://vuetifyjs.com/zh-Hans/examples/wireframes/base/)
跟 [inbox](https://vuetifyjs.com/zh-Hans/examples/wireframes/inbox/)
的组合组成一个外框

##### 路由配置

在 vuetify-demo/src/router/index.ts 中配置路由

在 vuetify-demo/src/App.vue 中配置

只有配置了 才能进行跳转
```vue
<v-main>
<router-view></router-view>
</v-main>
```