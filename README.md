### JAVASCRIPT

javascript 是一门动态语言
没有强类型限制

#### ES6
ECMAScript 6

测试可以先安装
nodejs
使用npm init 
npm install --save-dev mocha

mocha相当于java 的 junit框架
可参 [让mocha支持ES6模块的方法实现](https://www.jb51.net/article/178429.htm)

还有一种方式那就是直接在新建一个js文件 
然后打开 Terminal 使用命令行 node name.js


入门可参
[ES6 入门教程](https://es6.ruanyifeng.com/)

babel 可用于转换 es6 为 es5
bable只转换新语法
不支持新的全局变量如promise async等等，
可以使用babel-polyfilll来兼容
[babel-polyfill的引用和使用](https://www.cnblogs.com/princesong/p/6728250.html)

##### 声明
###### ** 变量 ** let

声明局部变量 只在作用域内有限
let 必须存在在大括号中 有大括号 块作用域才成立
```javascript
// if (true) let a = 1
// SyntaxError: Lexical declaration cannot appear in a single-statement context

```
不会像var 一样抬升作用域
不可以在声明之前使用 <==> 存在暂时性死区 typeof 使用同样报错
不可在同一作用域同名

###### ** 常量 ** const

与 let 类似
声明常量
声明之后无法改变指向
如果是对象 对象中的属性仍然可以改变

如果真的想将对象冻结，应该使用Object.freeze方法。

```ecmascript 6
const foo = Object.freeze({});

// 常规模式时，下面一行不起作用；
// 严格模式时，该行会报错
foo.prop = 123;
```

上面代码中，常量foo指向一个冻结的对象，所以添加新属性不起作用，严格模式时还会报错。

除了将对象本身冻结，对象的属性也应该冻结。下面是一个将对象彻底冻结的函数。

```ecmascript 6
var constantize = (obj) => {
  Object.freeze(obj);
  Object.keys(obj).forEach( (key, i) => {
    if ( typeof obj[key] === 'object' ) {
      constantize( obj[key] );
    }
  });
};
```


###### ** 类型 ** class
###### import

##### 作用域
###### 块状
es6之前没有块状 只有全局跟函数域
应该避免在块级作用域内声明函数
如果确实需要，也应该写成函数表达式，而不是函数声明语句

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
[async...await用法全解](https://blog.csdn.net/weixin_43586120/article/details/100536903?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1.pc_relevant_antiscanv2&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1.pc_relevant_antiscanv2&utm_relevant_index=2)

JS事件循环机制（event loop）之宏任务、微任务
[译文：JS事件循环机制（event loop）之宏任务、微任务](https://segmentfault.com/a/1190000014940904)
##### 正则
练习网站 https://regexr.com
exec test 字符串 match方法