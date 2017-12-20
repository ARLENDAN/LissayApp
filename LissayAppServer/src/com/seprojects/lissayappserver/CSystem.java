package com.seprojects.lissayappserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

// �ࣺϵͳ����
// ��ע���·���json��������ǵ�ɾ��
public class CSystem
{
	
	// ���캯��
	public CSystem()
	{
	}
	
	// ����: ���ݽ���  �ͻ���<-->������   �������ߣ��ͻ���
	// ����: send: �����͵�����
	// return: receive: ���յ�������
	public static String dataExchange(String send)
	{
		String ip = "192.168.191.2";	// ������IP
		int port = 8080; 				// ������Ŀ�Ķ˿ں�
		String receive = "{\r\n" + 
						 "	\"state\": \"����ʧ�ܣ�����ʱ��\"\r\n" +
						 "}";
		
		try
        {
            Socket socket = new Socket(ip, port);						  			// ����Socket����
            socket.setSoTimeout(10 * 1000);											// ����ʱ��
            
            // ��������������ͷ��������
            OutputStream outputStream = socket.getOutputStream();         			// ��ȡһ��������������˷�����Ϣ
            PrintWriter printWriter = new PrintWriter(outputStream);      			// ���������װ�ɴ�ӡ��
            printWriter.print(send);                                      			// Ҫ���͸�������������
            printWriter.flush();
            socket.shutdownOutput();                                      			// �ر������

            InputStream inputStream = socket.getInputStream();            			// ��ȡһ�������������շ���˵���Ϣ
            InputStreamReader info = new InputStreamReader(inputStream, "UTF-8");  	// ��װ���ַ��������Ч��
            BufferedReader bufferedReader = new BufferedReader(info);     			// ������
            
            receive = "";
            String temp = null;                                           			// ��ʱ����
            while ((temp = bufferedReader.readLine()) != null)            			// ����߼�Ϊ���ܵ�����Ϣ
            {
            	System.out.println(temp);//�ǵ�ɾ��
            	receive += temp;
            }

            // �ر����Ӧ����Դ
            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
        }
		catch (SocketTimeoutException e)
		{
			e.printStackTrace();
		}
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
		
		return receive;
	}
}
