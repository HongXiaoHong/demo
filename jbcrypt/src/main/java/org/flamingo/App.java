package org.flamingo;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        test();
    }

    public static void test() {
        String password = "123456";

        // 加密
        String encodedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(encodedPassword);

        // 使用正确密码验证密码是否正确
        boolean flag = BCrypt.checkpw(password, encodedPassword);
        System.out.println(flag);

        // 使用错误密码验证密码是否正确
        flag = BCrypt.checkpw("111222", encodedPassword);
        System.out.println(flag);

        System.out.println("-------------------------------------------");

    }

}
