# 字符串

## 字符的 Unicode 表示法

```ecmascript 6
"\u0061"
// "a"
'\z' === 'z'  // true
'\172' === 'z' // true 八进制
'\x7A' === 'z' // true 十六进制
'\u007A' === 'z' // true Unicode UTF-8
'\u{7A}' === 'z' // true UTF-16
```
## 字符串的遍历器接口
字符串添加了遍历器接口
```ecmascript 6
for (let codePoint of 'foo') {
  console.log(codePoint)
}
// "f"
// "o"
// "o"
```
## 直接输入 U+2028 和 U+2029
JavaScript 规定有5个字符，不能在字符串里面直接使用，只能使用转义形式。

U+005C：反斜杠（reverse solidus)
U+000D：回车（carriage return）
U+2028：行分隔符（line separator）
U+2029：段分隔符（paragraph separator）
U+000A：换行符（line feed）

允许 JavaScript 字符串直接输入 U+2028（行分隔符）和 U+2029（段分隔符）
```ecmascript 6
const json = '"\u2028"';
let jsonObject = JSON.parse(json); // 可能报错
console.log(`jsonObject: ${jsonObject}`)
```
## JSON.stringify() 的改造
如果遇到0xD800到0xDFFF之间的单个码点，或者不存在的配对形式，它会返回转义字符串，留给应用自己决定下一步的处理
```ecmascript 6
JSON.stringify('\u{D834}') // ""\\uD834""
JSON.stringify('\uDF06\uD834') // ""\\udf06\\ud834""
```
## 模板字符串
模板字符串（template string）是增强版的字符串，用反引号（`）标识。它可以当作普通字符串使用，也可以用来定义多行字符串，或者在字符串中嵌入变量

```ecmascript 6
// 普通字符串
`In JavaScript '\n' is a line-feed.`

// 多行字符串
`In JavaScript this is
 not legal.`

console.log(`string text line 1
string text line 2`);

// 字符串中嵌入变量
// 大括号内部可以放入任意的 JavaScript 表达式，可以进行运算，以及引用对象属性
// 模板字符串之中还能调用函数
// 如果大括号中的值不是字符串，将按照一般的规则转为字符串。比如，大括号中是一个对象，将默认调用对象的toString方法
let name = "Bob", time = "today";
`Hello ${name}, how are you ${time}?`
// 模板字符串甚至还能嵌套
const tmpl = addrs => `
  <table>
  ${addrs.map(addr => `
    <tr><td>${addr.first}</td></tr>
    <tr><td>${addr.last}</td></tr>
  `).join('')}
  </table>
`;
```
## 实例：模板编译
## 标签模板
## 模板字符串的限制

## 新增方法
### String.fromCodePoint()
提供了String.fromCodePoint()方法，

可以识别大于0xFFFF的字符，

弥补了String.fromCharCode()方法的不足 

fromCharCode() -> 这个方法不能识别码点大于0xFFFF的字符。

在作用上，正好与下面的codePointAt()方法相反。


### String.raw()

返回一个斜杠都被转义（即斜杠前面再加一个斜杠）的字符串，往往用于模板字符串的处理方法
```ecmascript 6
String.raw`Hi\n${2+3}!`
// 实际返回 "Hi\\n5!"，显示的是转义后的结果 "Hi\n5!"

String.raw`Hi\u000A!`;
// 实际返回 "Hi\\u000A!"，显示的是转义后的结果 "Hi\u000A!"
```
### 实例方法：codePointAt()

JavaScript 内部，字符以 UTF-16 的格式储存，每个字符固定为2个字节。对于那些需要4个字节储存的字符（Unicode 码点大于0xFFFF的字符），JavaScript 会认为它们是两个字符

```ecmascript 6
var s = "𠮷";

s.length // 2
s.charAt(0) // ''
s.charAt(1) // ''
s.charCodeAt(0) // 55362
s.charCodeAt(1) // 57271
```
### 实例方法：normalize()
用来将字符的不同表示方法统一为同样的形式，这称为 Unicode 正规化

### 实例方法：includes(), startsWith(), endsWith()
includes()：返回布尔值，表示是否找到了参数字符串。
startsWith()：返回布尔值，表示参数字符串是否在原字符串的头部。
endsWith()：返回布尔值，表示参数字符串是否在原字符串的尾部。
### 实例方法：repeat()
repeat方法返回一个新字符串，表示将原字符串重复n次
### 实例方法：padStart()，padEnd()
字符串补全长度的功能。如果某个字符串不够指定长度，会在头部或尾部补全。padStart()用于头部补全，padEnd()用于尾部补全

```ecmascript 6
'x'.padStart(5, 'ab') // 'ababx'
'x'.padStart(4, 'ab') // 'abax'

'x'.padEnd(5, 'ab') // 'xabab'
'x'.padEnd(4, 'ab') // 'xaba'
```
### 实例方法：trimStart()，trimEnd()

trimStart()消除字符串头部的空格，trimEnd()消除尾部的空格。它们返回的都是新字符串，不会修改原始字符串
### 实例方法：matchAll()

返回一个正则表达式在当前字符串的所有匹配，
### 实例方法：replaceAll()


replace()只能替换第一个匹配
如果要替换所有的匹配，不得不使用正则表达式的g修饰符
```ecmascript 6
'aabbcc'.replace(/b/g, '_')
// 'aa__cc'

'aabbcc'.replaceAll('b', '_')
// 'aa__cc'
```
replaceAll()方法，可以一次性替换所有匹配
### 实例方法：at()

at()方法接受一个整数作为参数，返回参数指定位置的字符，支持负索引（即倒数的位置）