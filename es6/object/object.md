# 对象
## 对象的扩展
### 属性的简洁表示法
在大括号里面，直接写入变量和函数，作为对象的属性和方法
```ecmascript 6
const foo = 'bar';
const baz = {foo};
baz // {foo: "bar"}

// 等同于
const baz = {foo: foo};
// 简写方法
const o = {
    method() {
        return "Hello!";
    }
};

// 等同于

const o = {
    method: function() {
        return "Hello!";
    }
};
```
### 属性名表达式
定义对象的属性可使用表达式
```ecmascript 6
// 方法一
obj.foo = true;

// 方法二
obj['a' + 'bc'] = 123;
```
### 方法的 name 属性
函数的name属性，返回函数名

```ecmascript 6
const person = {
  sayName() {
    console.log('hello!');
  },
};

person.sayName.name   // "sayName"
```
### 属性的可枚举性和遍历
对象的每个属性都有一个描述对象（Descriptor），用来控制该属性的行为。

Object.getOwnPropertyDescriptor方法可以获取该属性的描述对象

```ecmascript 6
let obj = { foo: 123 };
Object.getOwnPropertyDescriptor(obj, 'foo')
//  {
//    value: 123,
//    writable: true,
//    enumerable: true,
//    configurable: true
//  }
```


目前，有四个操作会忽略enumerable为false的属性

- for...in循环：只遍历对象自身的和继承的可枚举的属性
- Object.keys()：返回对象自身的所有可枚举的属性的键名
- JSON.stringify()：只串行化对象自身的可枚举的属性
- Object.assign()： 忽略enumerable为false的属性，只拷贝对象自身的可枚举的属性


有 5 种方法可以遍历对象的属性。

（1）for...in

for...in循环遍历对象自身的和继承的可枚举属性（不含 Symbol 属性）。

（2）Object.keys(obj)

Object.keys返回一个数组，包括对象自身的（不含继承的）所有可枚举属性（不含 Symbol 属性）的键名。

（3）Object.getOwnPropertyNames(obj)

Object.getOwnPropertyNames返回一个数组，包含对象自身的所有属性（不含 Symbol 属性，但是包括不可枚举属性）的键名。

（4）Object.getOwnPropertySymbols(obj)

Object.getOwnPropertySymbols返回一个数组，包含对象自身的所有 Symbol 属性的键名。

（5）Reflect.ownKeys(obj)

Reflect.ownKeys返回一个数组，包含对象自身的（不含继承的）所有键名，不管键名是 Symbol 或字符串，也不管是否可枚举。

以上的 5 种方法遍历对象的键名，都遵守同样的属性遍历的次序规则。

首先遍历所有数值键，按照数值升序排列。
其次遍历所有字符串键，按照加入时间升序排列。
最后遍历所有 Symbol 键，按照加入时间升序排列。

```ecmascript 6
Reflect.ownKeys({ [Symbol()]:0, b:0, 10:0, 2:0, a:0 })
// ['2', '10', 'b', 'a', Symbol()]
```
### super 关键字
super，指向当前对象的原型对象
```ecmascript 6
const proto = {
  foo: 'hello'
};

const obj = {
  foo: 'world',
  find() {
    return super.foo;
  }
};

Object.setPrototypeOf(obj, proto);
obj.find() // "hello"
```
### 对象的扩展运算符
对象的解构赋值用于从一个对象取值，相当于将目标对象自身的所有可遍历的（enumerable）、但尚未被读取的属性，分配到指定的对象上面。所有的键和它们的值，都会拷贝到新对象上面

```ecmascript 6
let { x, y, ...z } = { x: 1, y: 2, a: 3, b: 4 };
x // 1
y // 2
z // { a: 3, b: 4 }****
```

浅拷贝
只读取对象自身的属性
解构赋值的一个用处，是扩展某个函数的参数，引入其他操作。

```ecmascript 6
function baseFunction({ a, b }) {
// ...
}
function wrapperFunction({ x, y, ...restConfig }) {
// 使用 x 和 y 参数进行操作
// 其余参数传给原始函数
return baseFunction(restConfig);
}
```

对象的扩展运算符（...）用于取出参数对象的所有可遍历属性，拷贝到当前对象之中
```ecmascript 6
let z = { a: 3, b: 4 };
let n = { ...z };
n // { a: 3, b: 4 }
```
上面代码中，原始函数baseFunction接受a和b作为参数，函数wrapperFunction在baseFunction的基础上进行了扩展，能够接受多余的参数，并且保留原始函数的行为

完整克隆一个对象，还拷贝对象原型的属性，可以采用下面的写法

```ecmascript 6
// 写法一
const clone1 = {
__proto__: Object.getPrototypeOf(obj),
...obj
};

// 写法二
const clone2 = Object.assign(
Object.create(Object.getPrototypeOf(obj)),
obj
);

// 写法三
const clone3 = Object.create(
Object.getPrototypeOf(obj),
Object.getOwnPropertyDescriptors(obj)
)
```
上面代码中，写法一的__proto__属性在非浏览器的环境不一定部署，因此推荐使用写法二和写法三

合并俩对象
```ecmascript 6
let ab = { ...a, ...b };
```
### AggregateError 错误对象
为了配合新增的Promise.any()方法

还引入一个新的错误对象AggregateError
```ecmascript 6
// AggregateError 本身是一个构造函数，用来生成 AggregateError 实例对象
const error = new AggregateError([
    new Error('ERROR_11112'),
    new TypeError('First name must be a string'),
    new RangeError('Transaction value must be at least 1'),
    new URIError('User profile link must be https'),
], 'Transaction cannot be processed')

/**
 * errors：数组，它的每个成员都是一个错误对象。该参数是必须的。
 * message：字符串，表示 AggregateError 抛出时的提示信息。该参数是可选的
 */
AggregateError(errors[, message])
```