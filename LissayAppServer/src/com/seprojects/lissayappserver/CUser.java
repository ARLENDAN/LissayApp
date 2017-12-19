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
		JsonObject json = setData("10001", null, _phoneNum, _passwd, null, _phoneModel);
		
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

	// ������ע��
	// ������_phoneNum: �ֻ����� ,_passwd: ����, _photo: ͼƬ����, _phoneModel: �ֻ��ͺ�
	// return: null(ע��ɹ�) String(ע��ʧ����Ϣ)
	public String registered(String _phoneNum, String _passwd, String _photo, String _phoneModel)
	{
		// ���ɷ�������
		JsonObject json = setData("10003", null, _phoneNum,  _passwd, _photo, _phoneModel);
		
		// ���ݷ���
		JsonParser parser = new JsonParser();
		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
		
		if (json.get("state").isJsonNull() == true)	// ע��ɹ�
		{
			return null;
		}
		else
		{
			return json.get("state").getAsString(); // ע��ʧ�ܷ���״̬��ʶ(�˴�����д���������ڲ��� return "")
		}
		
	}
	
	// �������˳���¼
	// return: null(�˳���¼�ɹ�) String(�˳���¼ʧ����Ϣ)
	public String leave(String _userID)
	{
		// ���ɷ�������
				JsonObject json = setData("10002", _userID, null, null, null, null);
				
				// ���ݷ���
				JsonParser parser = new JsonParser();
				json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
				
				if (json.get("state").isJsonNull() == true)	// ��¼�˳��ɹ�
				{
					return null;
				}
				else
				{
					return json.get("state").getAsString(); // ��¼�˳�ʧ�ܷ���״̬��ʶ(�˴�����д���������ڲ��� return "")
				}
				
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
	
	// ���������� Json ��������
	// ������_op: �����, _phoneNum: �ֻ����� ,_passwd: ����, _photo: ͼƬ����, _phoneModel: �ֻ��ͺ�
	// return: JsonObject
	private JsonObject setData(String _op, String _userID, String _phoneNum, String _passwd, String _photo, String _phoneModel)
	{
		// ���ɷ�������
		JsonObject json = new JsonObject();
		json.addProperty("op", _op);
		JsonObject info = new JsonObject();
		info.addProperty("userID", _userID);
		info.addProperty("phoneNum", _phoneNum);
		info.addProperty("passwd", _passwd);
		info.addProperty("photo", _photo);
		info.addProperty("phoneModel", _phoneModel);
		json.add("info", info);
		
		return json;
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
