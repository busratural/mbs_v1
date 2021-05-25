package mbs;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JSONYaz {
			SimpleDateFormat sekil = new SimpleDateFormat();
		    Date tarih = new Date();				   
		  public void sabit( ) 
		    {
			  JSONObject obj = new JSONObject();
			  obj.put("TrenID","zz");
			   obj.put("TrenAdý","");
			   obj.put("MAC","");        
			   JSONObject metro = new JSONObject();
			   metro.put("metro",obj);
			   JSONArray objs =new JSONArray();
			   objs.add(metro);
			   try(FileWriter fileFixed = new FileWriter("fixed"))
			   {
				   fileFixed.write(objs.toJSONString());
				   fileFixed.flush();
			   }
			   catch(IOException e){e.printStackTrace();}
		    }
		  public void parametrik(Date calistirmaTarihi, String KapiDurumu,String ToplamMesafe, String BaslangicKonum) 
		    {

			  JSONObject obj = new JSONObject();
			   obj.put("Zaman",tarih);
			   obj.put("ÇalýþmaZamanBaþlangýcý",calistirmaTarihi);
			   obj.put("MetrajBilgisi",ToplamMesafe);
			   obj.put("IstasyonIsmi",BaslangicKonum);
			   obj.put("KapiDurumu",KapiDurumu);
			   obj.put("IP","");
			   JSONObject param = new JSONObject();
			   param.put("param",obj);  
			   JSONArray objs =new JSONArray();
			   objs.add(param);
			   try(FileWriter fileParams = new FileWriter("params"))
			   {
				   fileParams.write(objs.toJSONString());
				   fileParams.flush();
			   }
			   catch(IOException e){e.printStackTrace();}
		    }
		  


}
