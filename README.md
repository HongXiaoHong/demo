# 工具
## gitbook
参照
[Gitbook教程（小白入坑gitbook全过程）](https://www.jianshu.com/p/0388d8bb49a7)

首先你得安装一个nodejs
 
全局安装一个gitbook-cli
```shell script
npm install -g gitbook-cli
C:\Users\hong\AppData\Roaming\npm\gitbook -> C:\Users\hong\AppData\Roaming\npm\node_modules\gitbook-cli\bin\gitbook.js
+ gitbook-cli@2.3.2
added 578 packages from 672 contributors in 15.738s
```

在 SUMMARY.md 中编写目录已经对应的文件名
再使用 gitbook init 
没有文件夹或者文件的情况下回自动帮助创建一个文件夹文件
大概就是这样
```markdown
# Summary

* [Introduction](README.md)
* [前言](readme.md)
* [第一章](part1/README.md)
    * [第一节](part1/1.md)
    * [第二节](part1/2.md)
    * [第三节](part1/3.md)
    * [第四节](part1/4.md)
* [第二章](part2/README.md)
* [第三章](part3/README.md)
* [第四章](part4/README.md)
```

最后 你可以使用 gitbook serve
在浏览器中预览你的整个电子书