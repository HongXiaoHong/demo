# 局部变量之let

声明局部变量 只在作用域内有限
let 必须存在在大括号中 有大括号 块作用域才成立
```javascript
// if (true) let a = 1
// SyntaxError: Lexical declaration cannot appear in a single-statement context

```
不会像var 一样抬升作用域
不可以在声明之前使用 <==> 存在暂时性死区 typeof 使用同样报错
不可在同一作用域同名