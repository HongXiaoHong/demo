# 反向代理

改完记得重启下nginx
```shell script
D:\app\code\nginx-1.20.2>nginx.exe -s reload
```

例子1
直接转发到 http://nginx.org;

```conf
listen       18880;
        server_name  localhost;

        #charset koi8-r;

        #access_log  logs/host.access.log  main;

        location / {
        	proxy_pass http://nginx.org;
            root   html;
            index  index.html index.htm;
        }
```

例子2 根据路径不同转发到不同的服务器

