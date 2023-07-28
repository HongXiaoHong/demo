- [x] 运用 Django 的工具创建网站和应用的框架。
- [ ] 启动和停止开发用的服务器。
- [ ] 创建模型（models）用来代表应用里的数据。
- [ ] 运用 Django 的 admin 站点填充网站数据。
- [ ] 面对不同的网络请求，创建视图函数（views）取回相应的数据。并把数据用模板（templates）渲染成 HTML 展示在浏览器里。
- [ ] 创建网络分发器，将不同的 URL 模式分发给特定的视图函数（views）。
- [ ] 添加用户认证和会话（sessions）管理网站行为和进入权限。
- [ ] 使用表单。
- [ ] 为应用编写测试。
- [ ] 有效运用 Django 的安全系统。
- [ ] 把应用布置到生产环境中。

## 运用 Django 的工具创建网站和应用的框架。

虚拟环境 使用 pycharm 帮我们创建就好

创建一个 django 工程

```bash
(venv) E:\github\demo\hello_django>django-admin startproject mytestsite

(venv) E:\github\demo\hello_django>cd mytestsite

(venv) E:\github\demo\hello_django\mytestsite>python3 manage.py runserver

(venv) E:\github\demo\hello_django\mytestsite>python manage.py runserver
Watching for file changes with StatReloader
Performing system checks...

System check identified no issues (0 silenced).

You have 18 unapplied migration(s). Your project may not work properly until you apply the migrations for app(s): admin, auth, contenttypes, sessions.
Run 'python manage.py migrate' to apply them.
July 27, 2023 - 11:16:12
Django version 4.2.3, using settings 'mytestsite.settings'
Starting development server at http://127.0.0.1:8000/
Quit the server with CTRL-BREAK.

[27/Jul/2023 11:16:17] "GET / HTTP/1.1" 200 10664
Not Found: /favicon.ico
[27/Jul/2023 11:16:18] "GET /favicon.ico HTTP/1.1" 404 2114

```

初始化页面
![](https://raw.githubusercontent.com/HongXiaoHong/images/main/picture/20230727112137.png)

项目文件说明:
settings.py 包含所有的网站设置。这是可以注册所有创建的应用的地方，也是静态文件，数据库配置的地方，等等。 urls.py 定义了网站 url 到 view 的映射。虽然这里可以包含所有的 url，但是更常见的做法是把应用相关的
url 包含在相关应用中，你可以在接下来的教程里看到。 wsgi.py 帮助 Django 应用和网络服务器间的通讯。你可以把这个当作模板。 manage.py脚本可以创建应用，和数据库通讯，启动开发用网络服务器。

## 启动和停止开发用的服务器。

## 创建模型（models）用来代表应用里的数据。

jpa 定义好模型

运行指令自动创建表格

```bash
python manage.py makemigrations
python manage.py migrate

```

```python
class Genre(models.Model):
    """
    Model representing a book genre (e.g. Science Fiction, Non Fiction).
    """
    name = models.CharField(max_length=200, help_text="Enter a book genre (e.g. Science Fiction, French Poetry etc.)")

    def __str__(self):
        """
        String for representing the Model object (in Admin site etc.)
        """
        return self.name
```

## 运用 Django 的 admin 站点填充网站数据。

```bash
(venv) E:\github\demo\hello_django\locallibrary\locallibrary>python manage.py createsuperuser
Username (leave blank to use 'hong'): hong
Email address: 1908711045@qq.com
Password:
Password (again):
This password is too short. It must contain at least 8 characters.
This password is entirely numeric.
Bypass password validation and create user anyway? [y/N]: N
Password:
Password (again):
Superuser created successfully.

(venv) E:\github\demo\hello_django\locallibrary\locallibrary>python manage.py runserver
Watching for file changes with StatReloader
Performing system checks...

System check identified no issues (0 silenced).
July 28, 2023 - 08:58:50
Django version 4.2.3, using settings 'locallibrary.settings'
Starting development server at http://127.0.0.1:8000/
Quit the server with CTRL-BREAK.

```

## 面对不同的网络请求，创建视图函数（views）取回相应的数据。并把数据用模板（templates）渲染成 HTML 展示在浏览器里。

## 创建网络分发器，将不同的 URL 模式分发给特定的视图函数（views）。

## 添加用户认证和会话（sessions）管理网站行为和进入权限。

## 使用表单。

## 为应用编写测试。

## 有效运用 Django 的安全系统。

## 把应用布置到生产环境中。
