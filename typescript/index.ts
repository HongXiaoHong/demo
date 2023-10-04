import { log } from "console"

const myName : string = "hong"
console.log(`name is ${myName}`)
// interface
interface Person {
    readonly id: string
    name: string
    age?: number
    [p:string]: any
}

const person: Person = {
    id: "007",
    name: "hong",
    age: 29,
}

// person.id = "aaa"
console.log(`interface test result : person -> ${person}`)

// 定义方法参数/返回值类型
interface Search {
    (keyword: string):string
}

const search: Search = (keyword: string) => {
    return `intput is ${keyword}`
}
console.log(`interface test function result : search -> ${search("林俊杰")}`)
// interface

// 数组定义
const a0:number[] = [1, 2, 3]
const a1:Array<number> = [1, 2, 3]
// 与 interface 组成对象数组类型
const people: Person[] = [{
    id: "007",
    name: "hong",
    age: 29,
}]
interface NumberArray {
    [index: number]: number;
}
let fibonacci: NumberArray = [1, 1, 2, 3, 5];
//表示：只要索引的类型是数字时，那么值的类型必须是数字。
console.log(`数组定义 fibonacci is  ${fibonacci}`)
// 数组定义
// function
function findSomething(ids?: number|number[]): any {
    return ids;
}

log(`function is findSomething : ${findSomething()}`)
log(`function is findSomething : ${findSomething(1)}`)
log(`function is findSomething : ${findSomething([1, 2, 3])}`)


function fn(params: number): string 
function fn(params: string, params2: number): void
function fn(params: any, params2?: any): void | string {
    console.log(params)
    console.log(params2)
    if (typeof params == "number") {
        return "test 类型检查"
    }
}
 
 
 
// const testFn1: string = fn('123',456)
const testFn: string = fn(123)
log("类型检查 testFn 没问题" + testFn)
 
// function