package duoxiancheng;

import java.io.IOException;

public class ProcessTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime runtime=Runtime.getRuntime();                      //获取环境相关对象
		System.out.println(runtime.totalMemory());                  //获得虚拟机的内存总量
		System.out.println(runtime.freeMemory());                   //获得虚拟机的空闲内存量
		System.out.println(runtime.maxMemory());                    //获得虚拟机的可分配最大内存量
		System.out.println(runtime.availableProcessors());          //获得CPU个数
		try
		{
			Process process=runtime.exec("c:\\windows\\NOTEPAD.EXE");       //调用进程
		}
		catch(IOException e)
		{
			System.out.println("异常");
		}

	}

}
