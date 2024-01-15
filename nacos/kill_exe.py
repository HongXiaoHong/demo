import subprocess
import os


def cmd_run_exe(exe_path):
    """
    功能：打开一个exe程序
    参数： exe_path:exe程序的全局路径，
    注意：需要输入的是exe的全局路径，路径中不能有空格，也不能仅仅是exe软件名
    """
    subprocess.run(exe_path)


def cmd_kill_exe(exe_name):
    """
    功能：关闭一个已经打开的exe软件程序
    参数：
        exe_name:已经打开的exe程序的名称，是名称，不能是路径
    """
    os.system("taskkill /f /t /im {}".format(exe_name))
    print("killed process {}".format(exe_name))


if __name__ == "__main__":
    cmd_kill_exe("baidunetdisk.exe")
    exe_path = "D:/app/tool/file/baidupan/BaiduNetdisk/baidunetdisk.exe"

    # 打开百度网盘软件
    cmd_run_exe(exe_path)
