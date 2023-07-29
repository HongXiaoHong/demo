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

可以用不同形式注册 模型到 admin 用户中

涉及模型的修改 都要使用 指令对 数据库模型就行修改

```bash
(venv) E:\github\demo\hello_django\locallibrary\locallibrary>python manage.py makemigrations
No changes detected

(venv) E:\github\demo\hello_django\locallibrary\locallibrary>python manage.py migrate
Operations to perform:
  Apply all migrations: admin, auth, catalog, contenttypes, sessions
Running migrations:
  No migrations to apply.

(venv) E:\github\demo\hello_django\locallibrary\locallibrary>python manage.py runserver

```

## 面对不同的网络请求，创建视图函数（views）取回相应的数据。并把数据用模板（templates）渲染成 HTML 展示在浏览器里。

## 创建网络分发器，将不同的 URL 模式分发给特定的视图函数（views）。

## 添加用户认证和会话（sessions）管理网站行为和进入权限。

session 会话管理 写了一个 刷新页面多少次 小栗子 用骨架创立项目的时候已经自动帮我们自动加上了 session 相关的管理

```python
INSTALLED_APPS = [
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',
    'catalog.apps.CatalogConfig',
]

MIDDLEWARE = [
    'django.middleware.security.SecurityMiddleware',
    'django.contrib.sessions.middleware.SessionMiddleware',
    'django.middleware.common.CommonMiddleware',
    'django.middleware.csrf.CsrfViewMiddleware',
    'django.contrib.auth.middleware.AuthenticationMiddleware',
    'django.contrib.messages.middleware.MessageMiddleware',
    'django.middleware.clickjacking.XFrameOptionsMiddleware',
]
```

我们只需要像操作字典一样操作 session 中的值就可以了

```python

# Get a session value by its key (e.g. 'my_car'), raising a KeyError if the key is not present
my_car = request.session['my_car']

# Get a session value, setting a default if it is not present ('mini')
my_car = request.session.get('my_car', 'mini')

# Set a session value
request.session['my_car'] = 'mini'

# Delete a session value
del request.session['my_car']

```

## 使用表单。

## 为应用编写测试。

测试的时候碰到一个错误

```bash
(venv) E:\github\demo\hello_django\locallibrary\locallibrary>python manage.py test
Traceback (most recent call last):
  File "E:\github\demo\hello_django\locallibrary\locallibrary\manage.py", line 22, in <m
odule>
    main()
  File "E:\github\demo\hello_django\locallibrary\locallibrary\manage.py", line 18, in ma
in
    execute_from_command_line(sys.argv)
  File "E:\github\demo\hello_django\venv\lib\site-packages\django\core\management\__init
__.py", line 442, in execute_from_command_line
    utility.execute()
  File "E:\github\demo\hello_django\venv\lib\site-packages\django\core\management\__init
__.py", line 436, in execute
    self.fetch_command(subcommand).run_from_argv(self.argv)
  File "E:\github\demo\hello_django\venv\lib\site-packages\django\core\management\comman
ds\test.py", line 24, in run_from_argv
    super().run_from_argv(argv)
  File "E:\github\demo\hello_django\venv\lib\site-packages\django\core\management\base.p
y", line 412, in run_from_argv
    self.execute(*args, **cmd_options)
  File "E:\github\demo\hello_django\venv\lib\site-packages\django\core\management\base.p
y", line 458, in execute
    output = self.handle(*args, **options)
  File "E:\github\demo\hello_django\venv\lib\site-packages\django\core\management\comman
ds\test.py", line 68, in handle
    failures = test_runner.run_tests(test_labels)
  File "E:\github\demo\hello_django\venv\lib\site-packages\django\test\runner.py", line
1048, in run_tests
    suite = self.build_suite(test_labels, extra_tests)
  File "E:\github\demo\hello_django\venv\lib\site-packages\django\test\runner.py", line
898, in build_suite
    tests = self.load_tests_for_label(label, discover_kwargs)
  File "E:\github\demo\hello_django\venv\lib\site-packages\django\test\runner.py", line
872, in load_tests_for_label
    tests = self.test_loader.discover(start_dir=label, **kwargs)
  File "D:\app\code\python\python-3.9.5\lib\unittest\loader.py", line 349, in discover
    tests = list(self._find_tests(start_dir, pattern))
  File "D:\app\code\python\python-3.9.5\lib\unittest\loader.py", line 414, in _find_test
s
    yield from self._find_tests(full_path, pattern, namespace)
  File "D:\app\code\python\python-3.9.5\lib\unittest\loader.py", line 405, in _find_test
s
    tests, should_recurse = self._find_test_path(
  File "D:\app\code\python\python-3.9.5\lib\unittest\loader.py", line 458, in _find_test
_path
    raise ImportError(
ImportError: 'tests' module incorrectly imported from 'E:\\github\\demo\\hello_django\\l
ocallibrary\\locallibrary\\catalog\\tests'. Expected 'E:\\github\\demo\\hello_django\\lo
callibrary\\locallibrary\\catalog'. Is this module globally installed?

(venv) E:\github\demo\hello_django\locallibrary\locallibrary>python manage.py test
Found 3 test(s).
Creating test database for alias 'default'...
System check identified no issues (0 silenced).
setUpTestData: Run once to set up non-modified data for all class methods.
setUp: Run once for every test method to setup clean data.
Method: test_false_is_false.
.setUp: Run once for every test method to setup clean data.
Method: test_false_is_true.
FsetUp: Run once for every test method to setup clean data.
Method: test_one_plus_one_equals_two.
.
======================================================================
FAIL: test_false_is_true (catalog.tests.test_models.YourTestClass)
----------------------------------------------------------------------
Traceback (most recent call last):
  File "E:\github\demo\hello_django\locallibrary\locallibrary\catalog\tests\test_models.
py", line 22, in test_false_is_true
    self.assertTrue(False)
AssertionError: False is not true

----------------------------------------------------------------------
Ran 3 tests in 0.003s

FAILED (failures=1)
Destroying test database for alias 'default'...

```


https://stackoverflow.com/questions/55973614/importerror-module-incorrectly-imported

其实就是因为同一级目录下
有一个  tests 目录跟有一个 tests.py 文件

![同级目录下存在两个 tests](https://raw.githubusercontent.com/HongXiaoHong/images/main/picture/20230729165632.png)

## 有效运用 Django 的安全系统。

## 把应用布置到生产环境中。
