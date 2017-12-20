package com.seprojects.lissayappserver;

import com.google.gson.JsonObject;

//�ࣺ�ռ�
public class CDiary
{
	private String diaryID;     // �ռ�ID
    private String userID;      // �ռǱ�д��ID
    private String tags;        // ��ǩ
    private String groupID;     // ����ID
    private String content;     // �ռ�����
    private int state;         	// �ռ�Ȩ��
    private String releaseDate; // ��������ʱ��
    
    // ���������캯��
    public CDiary()
    {
    }
    
    // ����������ռ�
    // ������_userID: �û�ID, _tags: ��ǩ, _groupID: ����ID, _content: ����, _state: �ռ�Ȩ�ޣ�1������ 2�ɹ�����
    public String addDiary(String _userID, String _tags, String _groupID, String _content, int _state)
    {
    	return "111";
    }
    
    // ���������� Json ��������
 	// ������_op: �����, _userID: �û�ID, _tags: ��ǩ, _groupID: ����ID, _content: ����, _state: �ռ�Ȩ��
 	// return: JsonObject
 	private JsonObject setData(String _op, String _userID, String _tags, String _groupID, String _content, int _state)
 	{
 		// ���ɷ�������
 		JsonObject json = new JsonObject();
 		json.addProperty("op", _op);
 		JsonObject info = new JsonObject();
 		info.addProperty("userID", _userID);
 		info.addProperty("tags", _tags);
 		info.addProperty("groupID", _groupID);
 		info.addProperty("content", _content);
 		info.addProperty("state", _state);
 		json.add("info", info);
 		
 		return json;
 	}
}
