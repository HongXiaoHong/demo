# 数组

### 扩展运算符
详见 [三点运算符](../operator/three_point.md)
### Array.from()
将类似数组的对象以及可遍历对象(iterable)转换为数组

> 所谓类似数组的对象，本质特征只有一点，即必须有length属性
#### 类似数组的对象
```ecmascript 6
Array.from({ length: 3 });
// [ undefined, undefined, undefined ]
```
#### 实现iteable的接口
```ecmascript 6
Array.from('hello')
// ['h', 'e', 'l', 'l', 'o']

let namesSet = new Set(['a', 'b'])
Array.from(namesSet) // ['a', 'b']
```

### Array.of()
将一组值转换为数组
```ecmascript 6
Array.of(3, 11, 8) // [3,11,8]
```

作用: Array.of()基本上可以用来替代Array()或new Array()
构造器参数个数不同 行为不统一
```ecmascript 6
Array() // []
Array(3) // [, , ,]
Array(3, 11, 8) // [3, 11, 8]
```
### 实例方法：copyWithin()
数组实例的copyWithin()方法，在当前数组内部，将指定位置的成员复制到其他位置（会覆盖原有成员），然后返回当前数组。也就是说，使用这个方法，会修改当前数组

```ecmascript 6
[1, 2, 3, 4, 5].copyWithin(0, 3)
// [4, 5, 3, 4, 5]
```
### 实例方法：find() 和 findIndex()
接受回调函数 找到满足函数条件的元素/索引
```ecmascript 6
[1, 4, -5, 10].find((n) => n < 0)
// -5
```
### 实例方法：fill()
使用给定值填充数组 原值会被覆盖
```ecmascript 6
['a', 'b', 'c'].fill(7)
// [7, 7, 7]

new Array(3).fill(7)
// [7, 7, 7]

// fill方法还可以接受第二个和第三个参数，用于指定填充的起始位置和结束位置
    ['a', 'b', 'c'].fill(7, 1, 2)
// ['a', 7, 'c']
```
### 实例方法：entries()，keys() 和 values()
皆为 遍历器对象
```ecmascript 6
// keys()是对键名的遍历、
for (let index of ['a', 'b'].keys()) {
  console.log(index);
}
// 0
// 1

// values()是对键值的遍历，
for (let elem of ['a', 'b'].values()) {
  console.log(elem);
}
// 'a'
// 'b'

// entries()是对键值对的遍历
for (let [index, elem] of ['a', 'b'].entries()) {
  console.log(index, elem);
}
// 0 "a"
// 1 "b"
```
### 实例方法：includes()
数组是否包含给定的值 包括 NaN 都可以判断
```ecmascript 6
[1, 2, 3].includes(2)     // true
[1, 2, 3].includes(4)     // false
[1, 2, NaN].includes(NaN) // true
```
### 实例方法：flat()，flatMap()
将嵌套的数组“拉平”
想要拉平的层数
如果不管有多少层嵌套，都要转成一维数组，可以用Infinity关键字作为参数
```ecmascript 6
[1, 2, [3, 4]].flat()
// [1, 2, 3, 4]
```

flatMap
原数组的每个成员执行一个函数
只支持一层
```ecmascript 6
// 相当于 [[2, 4], [3, 6], [4, 8]].flat()
[2, 3, 4].flatMap((x) => [x, x * 2])
// [2, 4, 3, 6, 4, 8]
```
### 实例方法：at()
访问数组元素
支持数组的负索引
```ecmascript 6
const arr = [5, 12, 8, 130, 44];
arr.at(2) // 8
arr.at(-2) // 130****
```
### 数组的空位
数组的空位指的是，数组的某一个位置没有任何值，比如Array()构造函数返回的数组都是空位
ES6 则是明确将空位转为undefined
### Array.prototype.sort() 的排序稳定性