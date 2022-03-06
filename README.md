### JAVASCRIPT

javascript 是一门动态语言
没有强类型限制

#### ES6
ECMAScript 6

入门可参
[ES6 入门教程](https://es6.ruanyifeng.com/)


##### promise
基本概念: 状态 异步用法
.then .catch await async 
了解事件循环 宏任务 微任务 -> promise各部分代码的执行时机

Promise对象代表一个异步操作
有三种状态：
- pending（进行中）
- fulfilled（已成功）
- rejected（已失败）

只有异步操作的结果，可以决定当前是哪一种状态，任何其他操作都无法改变这个状态

有了Promise对象，就可以将异步操作以同步操作的流程表达出来，避免了层层嵌套的回调函数。
此外，Promise对象提供统一的接口，使得控制异步操作更加容易

await async
[async和await](https://www.jianshu.com/p/b4fd76c61dc9)

JS事件循环机制（event loop）之宏任务、微任务
[译文：JS事件循环机制（event loop）之宏任务、微任务](https://segmentfault.com/a/1190000014940904)
##### 正则
练习网站 https://regexr.com
exec test 字符串 match方法