package com.seprojects.lissayappserver;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

// �ࣺ�û�
// ˵���������û�������ʹ��
public class CUser
{
	private String userID; 		// �û�ID
	private String passwd; 		// ��¼����
	private String phoneNum; 	// �ֻ�����
	private String photo; 		// ͷ�����õ���Ƭ����������
	private String lastLogin; 	// �ϴε�¼ʱ��
	private String phoneModel; 	// ���õ�¼�ֻ����ͺ�
	private int diaryNum; 		// ���Բ鿴���˵��ռ���Ŀ

	// ���������캯��
	public CUser()
	{
	}

	// ��������¼
	// ������_phoneNum: �ֻ����� ,_passwd: ����, _phoneModel: �ֻ��ͺ�
	// return: null(��¼�ɹ�) String(��¼ʧ����Ϣ)
	public String login(String _phoneNum, String _passwd, String _phoneModel)
	{
		// ���ɷ�������
		JsonObject json = new JsonObject();
		json.addProperty("op", "10001");
		JsonObject info = new JsonObject();
		info.addProperty("phoneNum", _phoneNum);
		info.addProperty("passwd", _passwd);
		info.addProperty("phoneModel", _phoneModel);
		json.add("info", info);

		// ���ݷ���
		JsonParser parser = new JsonParser();
		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));

		if (json.get("state").isJsonNull() == true)	// ��¼�ɹ�
		{
			putInfo(json); 							// �Ը�����ֵ���и�ֵ
			return null;
		}
		else
		{
			return json.get("state").getAsString(); // ��¼ʧ�ܷ���״̬��ʶ(�˴�����д���������ڲ��� return "")
		}
	}

	// ��������¼
	// ������_phoneNum: �ֻ����� ,_passwd: ����, _photo: ͼƬ����, _phoneModel: �ֻ��ͺ�
	// return: null(ע��ɹ�) String(ע��ʧ����Ϣ)
	public String registered(String _phoneNum, String _passwd, String _photo, String _phoneModel)
	{
		return "111";
	}
	
	// �������˳���¼
	// return: null(�˳���¼�ɹ�) String(�˳���¼ʧ����Ϣ)
	public String leave()
	{
		return "111";
	}
	
	// ����������/��������
	// ������_passwd: ����
	// return: null(���óɹ�) String(����ʧ����Ϣ)
	public String setPasswd(String _passwd)
	{
		return "111";
	}
	
	// ����������ͷ��
	// ������_photo: ͼƬ����
	// return: null(���ĳɹ�) String(����ʧ����Ϣ)
	public String setPhoto(String _photo)
	{
		return "111";
	}
	
	// ��������������Ը�ֵ
	// ������jsonData: jsonData����
	private void putInfo(JsonObject jsonData)
	{
		JsonArray array = jsonData.get("info").getAsJsonArray(); 	// �õ�jsonData��info������
		jsonData = array.get(0).getAsJsonObject();					// ��array[0]ת��ΪJsonObject
		
		// �����ֵ
		userID = jsonData.get("userID").getAsString();
		phoneNum = jsonData.get("phoneNum").getAsString();
		photo = jsonData.get("photo").getAsString();
		lastLogin = jsonData.get("lastLogin").getAsString();
		phoneModel = jsonData.get("phoneModel").getAsString();
		diaryNum = jsonData.get("diaryNum").getAsInt();
	}
	
	// ���������� userID
	// return: String
	public String getUserID()
	{
		return userID;
	}
	
	// ���������� passwd
	// return: String
	public String getPasswd()
	{
		return passwd;
	}
	
	// ���������� phoneNum
	// return: String
	public String getPhoneNum()
	{
		return phoneNum;
	}
	
	// ���������� photo
	// return: String
	public String getPhoto()
	{
		return photo;
	}
	
	// ���������� lastLogin
	// return: String
	public String getLastLogin()
	{
		return lastLogin;
	}
	
	// ���������� phoneModel
	// return: String
	public String getPhoneModel()
	{
		return phoneModel;
	}
	
	// ���������� diaryNum
	// return: int
	public int getDiaryNum()
	{
		return diaryNum;
	}
}
