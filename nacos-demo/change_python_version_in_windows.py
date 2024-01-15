import os

# 获取环境变量的所有key
keys = os.environ.keys()  #
values = os.environ.values()
print(type(keys))  # <class 'collections.abc.KeysView'>
print(list(keys))
print(list(values))

python_path_list = []

for key in list(keys):
    if "PYTHON" in key:
        python_path_list.append(key)
        print(f"{key} -> {os.environ.get(key)}")

print(f"python path list is {python_path_list}")

if len(python_path_list) > 0:
    python_version_index = int(input("请选择你要设置的 python 版本"))
    python_version = python_path_list[python_version_index]
    python_home = os.environ.get(python_version)
    print(f"选择的 python 版本是 {python_version}, 对应的路径是: {python_home}")
    command = r"setx PYTHON_HOME %s /m" % python_home
    os.system(command)
    print("成功设置环境变量")
