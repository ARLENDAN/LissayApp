package com.seprojects.lissayappserver;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

//�ࣺÿ��һ��
public class CTweet
{
    private String tweetID;     // ����ID
    private String content;     // ����
    private String pic;         // ͼƬ
    private String releaseDate; // ����ʱ��
    
    // ���������캯��
    public CTweet()
    {
    }
    
    // ��������ȡÿ��һ��
    public String CheckTweet()
    {
    	// ���ɷ�������
    	JsonObject json = setData("70003", null);
    			
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
    
    // ���������� Json ��������
 	// ������_op: �����, _tweetID: ����ID
 	// return: JsonObject
 	private JsonObject setData(String _op, String _tweetID)
 	{
 		// ���ɷ�������
 		JsonObject json = new JsonObject();
 		json.addProperty("op", _op);
 		JsonObject info = new JsonObject();
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
 		tweetID = jsonData.get("tweetID").getAsString();
 		content = jsonData.get("content").getAsString();
 		pic = jsonData.get("pic").getAsString();
 		releaseDate = jsonData.get("releaseDate").getAsString();
 	}
 	
 	// ���������� tweetID
 	// return: String
 	public String getTweetID()
 	{
 		return tweetID;
 	}
 	
 	// ���������� content
 	// return: String
 	public String getContent()
 	{
 		return content;
 	}
 	
 	// ���������� pic
 	// return: String
 	public String getPic()
 	{
 		return pic;
 	}
 	
 	// ���������� releaseDate
 	// return: String
 	public String getReleaseDate()
 	{
 		return releaseDate;
 	}
}
