"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const console_1 = require("console");
const myName = "hong";
console.log(`name is ${myName}`);
const person = {
    id: "007",
    name: "hong",
    age: 29,
};
// person.id = "aaa"
console.log(`interface test result : person -> ${person}`);
const search = (keyword) => {
    return `intput is ${keyword}`;
};
console.log(`interface test function result : search -> ${search("林俊杰")}`);
// interface
// 数组定义
const a0 = [1, 2, 3];
const a1 = [1, 2, 3];
// 与 interface 组成对象数组类型
const people = [{
        id: "007",
        name: "hong",
        age: 29,
    }];
let fibonacci = [1, 1, 2, 3, 5];
//表示：只要索引的类型是数字时，那么值的类型必须是数字。
console.log(`数组定义 fibonacci is  ${fibonacci}`);
// 数组定义
// function
function findSomething(ids) {
    return ids;
}
(0, console_1.log)(`function is findSomething : ${findSomething()}`);
(0, console_1.log)(`function is findSomething : ${findSomething(1)}`);
(0, console_1.log)(`function is findSomething : ${findSomething([1, 2, 3])}`);
function fn(params, params2) {
    console.log(params);
    console.log(params2);
    if (typeof params == "number") {
        return "test 类型检查";
    }
}
// const testFn1: string = fn('123',456)
const testFn = fn(123);
(0, console_1.log)("类型检查 testFn 没问题" + testFn);
// function
