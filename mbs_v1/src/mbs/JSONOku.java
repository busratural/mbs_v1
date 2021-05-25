package mbs;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JSONOku {

	public int istasyonSayisi;
	public int tabelaSayisi;
    public static ArrayList<String> tabelaList = new ArrayList<String>();
	public static ArrayList<String> T4_Istasyonlar_MescidiselamTopkapý = new ArrayList();
	public static ArrayList<String> T4_Istasyonlar_TopkapýMescidiselam = new ArrayList();
	public static ArrayList<Integer> T4_Mesafeler_MescidiselamTopkapý = new ArrayList();
	public static ArrayList<Integer> T4_Mesafeler_TopkapýMescidiselam = new ArrayList();
    public int takomere;
    public String Zaman;
    public String CalismaZamanBaslangici;
    public String MetrajBilgisi;
    public String IstasyonIsmi;
    public String KapiDurumu;
    public String IP;
    public String TrenID;
    public String TrenAdi;
    public String MAC;

    public int fontSize;
    public int fontStyle;
    public String fontName;
    public Color textcolor;
    public Color labelcolor;
    public Color tabcolor;



	  public void main(String filepath)   {
	        //JSON parser object to parse read file
	        JSONParser jsonParser = new JSONParser();
	        String startDir = System.getProperty("user.dir");

	        String path = startDir + filepath;
	        try (FileReader reader = new FileReader(path))
	        {
	            Object obj = jsonParser.parse(reader);
	 
	            JSONArray employeeList = (JSONArray) obj;
	             
	            if(filepath.contains("anons")) {
		            istasyonSayisi=employeeList.size();

	            employeeList.forEach( emp -> parseIstasyon( (JSONObject) emp ) );
	            }
	            else if(filepath.contains("param")) {
		            employeeList.forEach( emp -> parseParam( (JSONObject) emp ) );
	            }
	            else if(filepath.contains("turkishWord")) {
		            employeeList.forEach( emp -> turkishWordParam( (JSONObject) emp ) );

	            }
	            else if(filepath.contains("tabela")) {
		            tabelaSayisi=employeeList.size();

		            employeeList.forEach( emp -> tabelaParam( (JSONObject) emp ) );

	            }
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public void parseIstasyon(JSONObject object) 
	    {
	        JSONObject istasyon = (JSONObject) object.get("istasyon");

	        String mescidiselamTopkapý =  (String) istasyon.get("MescidiselamTopkapi");   

	        T4_Istasyonlar_MescidiselamTopkapý.add(mescidiselamTopkapý);
	        String mescidiselamTopkapýMesafe = (String) istasyon.get("MescidiselamTopkapiMesafe");    
	        T4_Mesafeler_MescidiselamTopkapý.add(Integer.parseInt(mescidiselamTopkapýMesafe));

	        String topkapýMescidiselam = (String) istasyon.get("TopkapiMescidiselam");    
	        T4_Istasyonlar_TopkapýMescidiselam.add(topkapýMescidiselam);
	        String topkapýMescidiselamMesafe = (String) istasyon.get("TopkapiMescidiselamMesafe");    
	        T4_Mesafeler_TopkapýMescidiselam.add(Integer.parseInt(topkapýMescidiselamMesafe));
	                
	    }
	    public void tabelaParam(JSONObject object) 
	    {
	        JSONObject tabela = (JSONObject) object.get("Tabela");
	        String tabelaAdý =  (String) tabela.get("TabelaAdi");   
	        tabelaList.add(tabelaAdý);	                
	    }
	    public void parseParam(JSONObject object) 
	    {
	        JSONObject employeeObject = (JSONObject) object.get("takoMeter");
	        String tako = (String) employeeObject.get("takoMeter");    
	        takomere = Integer.parseInt(tako);

	        /*JSONObject param = (JSONObject) object.get("param");
	         Zaman = (String) param.get("Zaman");    
	         CalismaZamanBaslangici = (String) param.get("ÇalýþmaZamanBaþlangýcý"); 
	         System.out.println(CalismaZamanBaslangici+"CalismaZamanBaslangici");
	         MetrajBilgisi = (String) param.get("MetrajBilgisi");    
	         IstasyonIsmi = (String) param.get("IstasyonIsmi");    
	         KapiDurumu = (String) param.get("KapýDurumu");    
	         IP = (String) param.get("IP");    

	        JSONObject metro = (JSONObject) object.get("metro");
	         TrenID = (String) metro.get("TrenID");    
	         TrenAdi = (String) metro.get("TrenAdý");    
	         MAC = (String) metro.get("MAC");    */
 

	    }
	    public void turkishWordParam(JSONObject object) 
	    {
	    	   JSONObject obj = (JSONObject) object.get("Style");	    	   
	    	   String textrgb= (String) obj.get("rgbText");
		       String[] color1 = textrgb.split(", ", 3);
               int r1=  Integer.parseInt(color1[0]);
               int g1=  Integer.parseInt(color1[1]);           
               int b1=  Integer.parseInt(color1[2]);
		       Color colors1 = new Color(r1,g1,b1);  
		       textcolor = colors1;
		       
	    	   String labelrgb= (String) obj.get("rgbLabel");
		       String[] color2 = labelrgb.split(", ", 3);
               int r2=  Integer.parseInt(color2[0]);
               int g2=  Integer.parseInt(color2[1]);           
               int b2=  Integer.parseInt(color2[2]);
		       Color colors2 = new Color(r2,g2,b2);  
		       labelcolor = colors2;
		       
	    	   String tabrgb= (String) obj.get("rgbTabText");
		       String[] color3 = tabrgb.split(", ", 3);
               int r3=  Integer.parseInt(color3[0]);
               int g3=  Integer.parseInt(color3[1]);           
               int b3=  Integer.parseInt(color3[2]);
		       Color colors3 = new Color(r3,g3,b3);  
		       tabcolor = colors3;
	    	   String Name= (String) obj.get("fontName");
		        fontName =Name;
	    	   String Size= (String) obj.get("fontSize");
	    	   fontSize= Integer.parseInt(Size);
	    	   String Style= (String) obj.get("fontStyle");
	    	   fontStyle=Integer.parseInt(Style);


	    }
		private char split(String a, char c) {
			// TODO Auto-generated method stub
			return 0;
		}
}