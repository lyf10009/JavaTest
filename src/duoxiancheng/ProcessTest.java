package duoxiancheng;

import java.io.IOException;

public class ProcessTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime runtime=Runtime.getRuntime();                      //��ȡ������ض���
		System.out.println(runtime.totalMemory());                  //�����������ڴ�����
		System.out.println(runtime.freeMemory());                   //���������Ŀ����ڴ���
		System.out.println(runtime.maxMemory());                    //���������Ŀɷ�������ڴ���
		System.out.println(runtime.availableProcessors());          //���CPU����
		try
		{
			Process process=runtime.exec("c:\\windows\\NOTEPAD.EXE");       //���ý���
		}
		catch(IOException e)
		{
			System.out.println("�쳣");
		}

	}

}
