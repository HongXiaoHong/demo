/**
 * 第一个 ... 是可变参数
 * 第二个 ... 可以将数组解开成为用逗号分隔的序列
 *
 * @param array 数组
 * @param items 可变参数
 */
function push(array, ...items) {
    array.push(...items);
}

const arr = [1, 2]

push(arr, 4, 8, 16, 32, 64, 128);
console.log({result: arr})
/*
{ result: [
     1,  2,  4,   8,
    16, 32, 64, 128
  ] }
 */


console.log("---------------------------复制数组---------------------------------")
const srcArr = [1, 2, 3];
const srcArrCopy = [...srcArr];
console.log({isSame: srcArr === srcArrCopy})
// { isSame: false }
console.log('--------------------------合并数组----------------------------------')
const arr1 = ['a', 'b'];
const arr2 = ['c'];
console.log({arr1, arr2, mergeArray: [...arr1, ...arr2]})
// { arr1: [ 'a', 'b' ], arr2: [ 'c' ], mergeArray: [ 'a', 'b', 'c' ] }
console.log("---------------------------与解构赋值结合---------------------------------")
const [first, ...rest] = [1, 2, 3, 4, 5];
console.log({rest})
// { rest: [ 2, 3, 4, 5 ] }
console.log("---------------------------字符串---------------------------------")
console.log({charArray: [..."string"], "解析Unicode": [...'x\uD83D\uDE80y']})
//
console.log("-----------------------------实现了 Iterator 接口的对象-------------------------------")
Number.prototype[Symbol.iterator] = function*() {
    let i = 0;
    let num = this.valueOf();
    while (i < num) {
        yield i++;
    }
}

consle.log([...5]) // [0, 1, 2, 3, 4]

console.log("--------Map 和 Set 结构，Generator 函数---------")

let map = new Map([
    [1, 'one'],
    [2, 'two'],
    [3, 'three'],
]);

let mapKeys = [...map.keys()]; // [1, 2, 3]
console.log({mapArr: mapKeys})

const go = function*(){
    yield 1;
    yield 2;
    yield 3;
};

console.log({generator: [...go()]}) // [1, 2, 3]