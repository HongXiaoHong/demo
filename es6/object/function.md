# 函数

### 函数参数的默认值
允许为函数的参数设置默认值，即直接写在参数定义的后面

参数默认值可以与解构赋值的默认值，结合起来使用
```ecmascript 6
function foo({x, y = 5}) {
  console.log(x, y);
}

foo({}) // undefined 5
foo({x: 1}) // 1 5
foo({x: 1, y: 2}) // 1 2
foo() // TypeError: Cannot read property 'x' of undefined

```
### rest 参数

 rest 参数（形式为...变量名）
 
 就是一个真正的数组，数组特有的方法都可以使用
 注意，rest 参数之后不能再有其他参数（即只能是最后一个参数），否则会报错 
 
 
 ````ecmascript 6
function push(array, ...items) {
  items.forEach(function(item) {
    array.push(item);
    console.log(item);
  });
}

var a = [];
push(a, 1, 2, 3)
````
### 严格模式
### name 属性
函数的name属性，返回该函数的函数名

### 箭头函数
ES6 允许使用“箭头”（=>）定义函数
```ecmascript 6

var f = v => v;

// 等同于
var f = function (v) {
  return v;
};
```


不适用场合
由于箭头函数使得this从“动态”变成“静态”，下面两个场合不应该使用箭头函数。

第一个场合是定义对象的方法，且该方法内部包括this

````ecmascript 6
const cat = {
  lives: 9,
  jumps: () => {
    this.lives--;
  }
}
````

第二个场合是需要动态this的时候，也不应使用箭头函数

```ecmascript 6
var button = document.getElementById('press');
button.addEventListener('click', () => {
  this.classList.toggle('on');
});

```
### 尾调用优化
### 函数参数的尾逗号
### Function.prototype.toString()


返回一模一样的原始代码
包括注释

```ecmascript 6
function /* foo comment */ foo () {}

foo.toString()
// "function /* foo comment */ foo () {}"
```
### catch 命令的参数省略


允许catch语句省略参数
```ecmascript 6
try {
  // ...
} catch {
  // ...
}
```