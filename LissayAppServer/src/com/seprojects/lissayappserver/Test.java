package com.seprojects.lissayappserver;

// ÿ�����ܶ��в���һ��
// �û� ʹ��      userID U00000001	  �ֻ�12345678901	  ����123ASD@01 �ͺ�123564
// IPIPIPIPIPIPIPIPIPIPIPIPIPIPIPIP

public class Test
{

	public static void main(String[] args)
	{
		// TODO �Զ����ɵķ������
		// Ҫ���ĵ���Ϣ������
		CTweet c = new CTweet();	// ���贴��
		String str = c.CheckTweet();
		if (str == null)
		{
			System.out.println("success");
		}
		else
		{
			System.out.println(str);
		}
		
//		CUser c = new CUser();
//		String str = c.aaa("12", null);
//		System.out.println(str);
		
	}

}
