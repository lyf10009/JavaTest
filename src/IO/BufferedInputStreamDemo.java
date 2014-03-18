package IO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class BufferedInputStreamDemo {
    public static void main(String[] args) {
        try {
            File file = new File("E://EclipseWorkSpace//word.txt"); // 创建文件对象
            FileInputStream fis = new FileInputStream(file); // 创建FileInputStream对象
            BufferedInputStream bip = new BufferedInputStream(fis); // 创建BufferedInputStream对象
            int count = 0;
            bip.mark(50); // 在输入流中定义标记位置
            for (int i = 0; i < 10; i++) { // 在循环中读取文件内容
                count++;
                int read = bip.read(); // 读取文件内容
                if (count % 5 == 0)
                    bip.reset(); // 将流定位到最后一次调用mark()方法事的位置
                System.out.println((char) read); // 将读取的内容输出
            }
            bip.close(); // 关闭流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
