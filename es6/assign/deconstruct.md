# 解构
这种写法属于“模式匹配”，只要等号两边的模式相同，左边的变量就会被赋予对应的值
## 数组的解构赋值
数组的元素是按次序排列的，变量的取值由它的位置决定
```ecmascript 6
let [a, b, c] = [1, 2, 3];
// 如果解构不成功，变量的值就等于undefined
let [foo] = [];
// 只要某种数据结构具有 Iterator 接口，都可以采用数组形式的解构赋值

// 允许指定默认值
let [foo = true] = [];
```

## 对象的解构赋值
属性没有次序，变量必须与属性同名，才能取到正确的值
```ecmascript 6
let { foo, bar } = { foo: 'aaa', bar: 'bbb' };

// 如果变量名与属性名不一致
// foo是匹配的模式，baz才是变量。真正被赋值的是变量baz，而不是模式foo
let { foo: baz } = { foo: 'aaa', bar: 'bbb' };
// baz -> "aaa"
```
## 字符串的解构赋值
字符串也可以解构赋值。这是因为此时，字符串被转换成了一个类似数组的对象
```ecmascript 6
const [a, b, c, d, e] = 'hello';

```
## 数值和布尔值的解构赋值
解构赋值时，如果等号右边是数值和布尔值，则会先转为对象
```ecmascript 6
let {toString: s} = 123;
s === Number.prototype.toString // true

let {toString: s} = true;
s === Boolean.prototype.toString // true
```
## 函数参数的解构赋值
```ecmascript 6
function add([x, y]){
  return x + y;
}

add([1, 2]); // 3
```
## 圆括号问题
以下三种解构赋值不得使用圆括号。
```ecmascript 6

// （1）变量声明语句
let [(a)] = [1];
// （2）函数参数
function f([(z)]) { return z; }
// （3）赋值语句的模式
({ p: a }) = { p: 42 };

// 可以使用圆括号的情况只有一种：赋值语句的非模式部分，可以使用圆括号
[(b)] = [3];
({ p: (d) } = {});
[(parseInt.prop)] = [3];

```

## 用途

（1）交换变量的值

```ecmascript 6


let x = 1;
let y = 2;

[x, y] = [y, x];
```

上面代码交换变量x和y的值，这样的写法不仅简洁，而且易读，语义非常清晰。

（2）从函数返回多个值

函数只能返回一个值，如果要返回多个值，只能将它们放在数组或对象里返回。有了解构赋值，取出这些值就非常方便。
```ecmascript 6


// 返回一个数组

function example() {
  return [1, 2, 3];
}
let [a, b, c] = example();

// 返回一个对象

function example() {
  return {
    foo: 1,
    bar: 2
  };
}
let { foo, bar } = example();
```
（3）函数参数的定义

解构赋值可以方便地将一组参数与变量名对应起来。
```ecmascript 6


// 参数是一组有次序的值
function f([x, y, z]) { ... }
f([1, 2, 3]);

// 参数是一组无次序的值
function f({x, y, z}) { ... }
f({z: 3, y: 2, x: 1});
```
（4）提取 JSON 数据

解构赋值对提取 JSON 对象中的数据，尤其有用。
```ecmascript 6


let jsonData = {
  id: 42,
  status: "OK",
  data: [867, 5309]
};

let { id, status, data: number } = jsonData;

console.log(id, status, number);
// 42, "OK", [867, 5309]
```
上面代码可以快速提取 JSON 数据的值。

（5）函数参数的默认值
```ecmascript 6


jQuery.ajax = function (url, {
  async = true,
  beforeSend = function () {},
  cache = true,
  complete = function () {},
  crossDomain = false,
  global = true,
  // ... more config
} = {}) {
  // ... do stuff
};
指定参数的默认值，就避免了在函数体内部再写var foo = config.foo || 'default foo';这样的语句。
```

（6）遍历 Map 结构

任何部署了 Iterator 接口的对象，都可以用for...of循环遍历。Map 结构原生支持 Iterator 接口，配合变量的解构赋值，获取键名和键值就非常方便。
```ecmascript 6


const map = new Map();
map.set('first', 'hello');
map.set('second', 'world');

for (let [key, value] of map) {
  console.log(key + " is " + value);
}
// first is hello
// second is world
如果只想获取键名，或者只想获取键值，可以写成下面这样。

// 获取键名
for (let [key] of map) {
  // ...
}

// 获取键值
for (let [,value] of map) {
  // ...
}
```
（7）输入模块的指定方法

加载模块时，往往需要指定输入哪些方法。解构赋值使得输入语句非常清晰。
```ecmascript 6


const { SourceMapConsumer, SourceNode } = require("source-map");
```
