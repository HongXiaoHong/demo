# 数值

## 二进制和八进制表示法
二进制和八进制数值的新的写法，分别用前缀0b（或0B）和0o（或0O）表示

如果要将0b和0o前缀的字符串数值转为十进制，要使用Number方法
```ecmascript 6
Number('0b111')  // 7
Number('0o10')  // 8
```
## 数值分隔符

使用下划线（_）作为分隔符
```ecmascript 6
let budget = 1_000_000_000_000;
budget === 10 ** 12 // true
```
## Number.isFinite(), Number.isNaN()

Number.isFinite()用来检查一个数值是否为有限的（finite），即不是Infinity。

Number.isNaN()用来检查一个值是否为NaN。


## Number.parseInt(), Number.parseFloat()
全局方法parseInt()和parseFloat()，移植到Number对象上面，行为完全保持不变
## Number.isInteger()
Number.isInteger()用来判断一个数值是否为整数
如果对数据精度的要求较高，不建议使用Number.isInteger()判断一个数值是否为整数
## Number.EPSILON

Number对象上面，新增一个极小的常量Number.EPSILON
它表示 1 与大于 1 的最小浮点数之间的差

引入一个这么小的量的目的，在于为浮点数计算，设置一个误差范围。我们知道浮点数计算是不精确的

Number.EPSILON可以用来设置“能够接受的误差范围”。比如，误差范围设为 2 的-50 次方（即Number.EPSILON * Math.pow(2, 2)），即如果两个浮点数的差小于这个值，我们就认为这两个浮点数相等
```ecmascript 6

function withinErrorMargin (left, right) {
  return Math.abs(left - right) < Number.EPSILON * Math.pow(2, 2);
}

0.1 + 0.2 === 0.3 // false
withinErrorMargin(0.1 + 0.2, 0.3) // true

1.1 + 1.3 === 2.4 // false
withinErrorMargin(1.1 + 1.3, 2.4) // true
```
## 安全整数和 Number.isSafeInteger()

能够准确表示的整数范围在-2^53到2^53之间（不含两个端点
Number.MAX_SAFE_INTEGER和Number.MIN_SAFE_INTEGER这两个常量，用来表示这个范围的上下限。

Number.isSafeInteger()则是用来判断一个整数是否落在这个范围之内
## Math 对象的扩展
### Math.trunc()
Math.trunc方法用于去除一个数的小数部分，返回整数部分

### Math.sign()
Math.sign方法用来判断一个数到底是正数、负数、还是零。对于非数值，会先将其转换为数值

### Math.cbrt()
Math.cbrt()方法用于计算一个数的立方根

### Math.hypot()
Math.hypot方法返回所有参数的平方和的平方根。

## BigInt 数据类型

BigInt 类型的数据必须添加后缀n
```ecmascript 6
1234 // 普通整数
1234n // BigInt

// BigInt 的运算
1n + 2n // 3n
```

### 转换规则
可以使用Boolean()、Number()和String()这三个方法，将 BigInt 可以转为布尔值、数值和字符串类型

```ecmascript 6
Boolean(0n) // false
Boolean(1n) // true
Number(1n)  // 1
String(1n)  // "1"
```