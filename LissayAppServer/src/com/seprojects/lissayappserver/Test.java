package com.seprojects.lissayappserver;

// ÿ�����ܶ��в���һ��123
// �û� ʹ��      userID U00000001	  �ֻ�12345678901	  ����123ASD@01 �ͺ�123564

public class Test
{

	public static void main(String[] args)
	{
		// TODO �Զ����ɵķ������
		// Ҫ���ĵ���Ϣ������
		CUser c = new CUser();	// ���贴��
		String str = c.login("12345678901", "123ASD", "123564");
		if (str == null)
		{
			System.out.println("success");
		}
		else
		{
			System.out.println(str);
		}
		
	}

}
