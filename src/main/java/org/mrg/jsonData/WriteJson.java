package org.mrg.jsonData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.j2objc.annotations.J2ObjCIncompatible;
import oracle.net.jdbc.TNSAddress.Address;
import org.checkerframework.checker.units.qual.K;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class WriteJson {
	private static Gson gson;
	public static JSONObject writeJson(){
		JSONObject json = new JSONObject();
		JSONObject jsonAddress = new JSONObject();

		json.put("FirstName", "Ahmed");
		json.put("LastName", "Shafi");
		jsonAddress.put("Street", "2325 27th Street");
		jsonAddress.put("Apt", "D5");
		jsonAddress.put("City", "Astoria");
		jsonAddress.put("State", "New York");
		jsonAddress.put("Country", "United States");
		json.put("Address", jsonAddress);
		return json;
	}

	public static JSONObject writeJson2(){
		JSONObject json = new JSONObject();
		JSONObject jsonAddress = new JSONObject();
		JSONArray serviceArray = new JSONArray();
		JSONObject keyAgent = new JSONObject();
		JSONObject keyReference = new JSONObject();
		JSONObject details = new JSONObject();
		json.put("FirstName", "Ahmed");
		json.put("LastName", "Shafi");
		jsonAddress.put("Street", "2325 27th Street");
		jsonAddress.put("Apt", "D5");
		jsonAddress.put("City", "Astoria");
		jsonAddress.put("State", "New York");
		jsonAddress.put("Country", "United States");
		details.put("NumberOfUse", 10);
		details.put("UsedType", "Personal");
		keyReference.put("KeyReference", details);
		keyAgent.put("KeyAgent", keyReference);
		serviceArray.put(keyAgent);
		json.put("ServiceStatus", serviceArray);
		return json;
	}
	public static String prittyPrintJson(JSONObject json){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonOutput = gson.toJson(json);
		return jsonOutput;
	}
	public static JsonObject jsonToGson(JSONObject jsonObject){
		JSONParser parser = new JSONParser();
		try {
			JsonObject object = (JsonObject) parser.parse(jsonObject.toString());
			return object;
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

	}

	@Test
	public static void executeWork(){
		JSONObject jsonObject = writeJson2();
		System.out.println(jsonToGson(jsonObject));
	}
}
