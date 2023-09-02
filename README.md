# demo
各种技能的demo学习


使用分支作为学习的技能 不同分支代表不同的技能
分支下若有其他分支 使用模块进行区分

## 前端

### HTML

### CSS

### JAVASCRIPT

分支 js

#### ES6


## 后端

# springboot 整合 mybatis

数据源 各种配置包括实体类/mapper xml配置/mapper 接口配置都没问题的情况下

```log
Caused by: java.lang.IllegalArgumentException: Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required
```
https://www.cnblogs.com/han-1034683568/p/16920607.html

因为升级到 springboot 3 的缘故 springboot 引用 spring 6

spring 6 这个老六直接删除了 相关的类

把 mybatis springboot starter 升级就可以了

```xml
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>3.0.2</version>
</dependency>
```