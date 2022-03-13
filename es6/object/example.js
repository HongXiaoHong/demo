const json = '"\u2028"';
let jsonObject = JSON.parse(json); // 可能报错
console.log(`jsonObject: ${jsonObject}`)

const TOKEN_Y = /\s*(\+|[0-9]+)\s*/y;
const TOKEN_G  = /\s*(\+|[0-9]+)\s*/g;

tokenize(TOKEN_Y, '3 + 4')
// [ '3', '+', '4' ]
tokenize(TOKEN_G, '3 + 4')
// [ '3', '+', '4' ]

function tokenize(TOKEN_REGEX, str) {
    let result = [];
    let match;
    while (match = TOKEN_REGEX.exec(str)) {
        result.push(match[1]);// 只获取 $1
    }
    console.log(`result: ${result}`)
    return result;
}