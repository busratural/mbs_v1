//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package mbs;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingUtilities;
import javax.swing.event.EventListenerList;
import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataEventListener;
import com.pi4j.io.serial.SerialFactory;


import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiBcmPin;
import com.pi4j.io.gpio.RaspiGpioProvider;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.RaspiPinNumberingScheme;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListener;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class TrenBilgileri {
	private static final Charset utf8charset = Charset.forName("UTF-8");
	private static final Charset iso88591charset = Charset.forName("ISO-8859-1");
	private Serial serial;
	
    private String hedefIstasyon;
    private String mevcutIstasyon;
    private String gelecekIstasyon;
    private String sonrakiIstasyon;
    private Boolean takometrePasifEt;

    private String baslangicIstasyonu;
    private String oncekiHedefIstasyon;
    private int gidilenMesafe;
    private int kalanMesafe;
    private int toplamMesafe;
    private int gecilenMesafeSayac;
    private boolean kapiAcikMi;
    private boolean istasyondaMi;
    private boolean yaklasimAnonsuYapildiMi = false;
    private boolean varisAnonsuYapidiMi = false;
    private int takometreSabiti ;
    private JSONOku jsonOku;
    public static int count;
    public int counter =1;
    private GpioPinDigitalInput kapiButonu;
    private GpioPinDigitalInput takometre;
    protected EventListenerList listenerList = new EventListenerList();
    private GpioController gpio;
    public TrenBilgileri() {
        Init();
        RotaBilgileri.Init();
        jsonOku = new JSONOku();
        jsonOku.main("/param");
        jsonOku.main("/turkishWord");

        takometreSabiti= jsonOku.takomere;

    }
    private String IstasyonLedAdiGetir(String istasyonAdi) {
        if (istasyonAdi.equals("TOPKAPI")) {
            return "TOPKAPI";
        } else if (istasyonAdi.equals("FETIHKAPI")) {
            return "FETIHKAPI";
        } else if (istasyonAdi.equals("VATAN")) {
            return "VATAN";
        } else if (istasyonAdi.equals("EDIRNEKAPI")) {
            return "EDIRNEKAPI";
        } else if (istasyonAdi.equals("SEHITLIK")) {
            return "SEHITLIK";
        } else if (istasyonAdi.equals("DEMIRKAPI")) {
            return "DEMIRKAPI";
        } else if (istasyonAdi.equals("TOPCULAR")) {
            return "TOPCULAR";
        } else if (istasyonAdi.equals("RAMI")) {
            return "RAMI";
        } else if (istasyonAdi.equals("ULUYOL")) {
            return "ULUYOL";
        } else if (istasyonAdi.equals("SAGMALCILAR")) {
            return "SAGMALCILAR";
        } else if (istasyonAdi.equals("CUKURCESME")) {
            return "CUKURCESME";
        } else if (istasyonAdi.equals("A. FUAT BASGIL")) {
            return "A.FUATBASGIL.";
        } else if (istasyonAdi.equals("TASKOPRU")) {
            return "TASKOPRU";
        } else if (istasyonAdi.equals("KARADENIZ")) {
            return "KARADENIZ";
        } else if (istasyonAdi.equals("KIPTAS-VEN")) {
            return "KIPTAS-VEN";
        } else if (istasyonAdi.equals("CUMHURIYET")) {
            return "CUMHURIYET";
        } else if (istasyonAdi.equals("50.YIL")) {
            return "50.YIL";
        } else if (istasyonAdi.equals("HACISUKRU")) {
            return "HACISUKRU";
        }  else if (istasyonAdi.equals("YENIMAHALLE")) {
            return "YENIMAHALLE";
        } else if (istasyonAdi.equals("SULTANCIFTLIGI")) {
            return "SULTANCIFT.";
        } else if (istasyonAdi.equals("CEBECI")) {
            return "CEBECI";
        } else if (istasyonAdi.equals("MESCIDI SELAM")) {
            return "MESCIDISELAM";
        } else {
            return istasyonAdi.length() > 7 ? istasyonAdi.substring(0, 7) : istasyonAdi;
        }
    }
    public void TakometreVerisiGuncelle() {
        Rotalar rota = RotaBilgileri.GetRota(this.mevcutIstasyon, this.gelecekIstasyon, this.hedefIstasyon,this.takometrePasifEt);
        
        if ( (!rota.equals(Rotalar.SECILMEDI) && !rota.equals(Rotalar.GECERSÝZ))) {
            this.gidilenMesafe += takometreSabiti;

            //this.gidilenMesafe += 10;
            this.kalanMesafe = this.toplamMesafe - this.gidilenMesafe;
            TrenBilgisiEvent tEvt;
            if (this.kalanMesafe < 0) {
                this.gecilenMesafeSayac += takometreSabiti; // takometreyi 10 u 1 e cevir
             // this.gecilenMesaf"eSayac += 10; // takometreyi 10 u 1 e cevir

                if (30 <= this.gecilenMesafeSayac) {
                    this.gecilenMesafeSayac = 0;
                    this.SonrakiIstasyonaGec();
                    tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon,String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
                    if(this.takometrePasifEt==false) {
                    this.guncelle(tEvt);
                    }
                    return;
                }
              

                this.kalanMesafe = 0;
            }
            

            if (this.gidilenMesafe >= 30 && !this.kapiAcikMi && this.istasyondaMi) {
                this.istasyondaMi = false;
            }
            if(this.takometrePasifEt==false) {
            this.AnonsKontrol();
            tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
            this.guncelle(tEvt);
            }
        }
        if (this.kalanMesafe == 100) {
	           TrenBilgileri.this.writeToSP("20MY010015"+ IstasyonLedAdiGetir(this.gelecekIstasyon));
         
        	count=0;
                	Timer myTimer=new Timer();
                    TimerTask gorev =new TimerTask() {   
                           @Override
                           public void run() {  
                        	// System.out.println("butona týklandý veri göndermeye hazýr---> takometre verisi : " + gelecekIstasyon);
                        	   count++;
                        	   if(count==5) {
                       	           TrenBilgileri.this.writeToSP("20MY010015 ");
                        		 myTimer.cancel(); 
                        	   }
                }
            };       
            myTimer.schedule(gorev,0,1000);

                }
    
    }

    public void KapiDurumuGuncelle(boolean durum) {
    	if (durum) {
            TrenBilgileri.this.writeToSP("20MY010015"+IstasyonLedAdiGetir(this.gelecekIstasyon));

     	count=0;
             	Timer myTimer=new Timer();
                 TimerTask gorev =new TimerTask() {   
                        @Override
                        public void run() {     
                     	   count++;
                     	   if(count==5) {
                    	           TrenBilgileri.this.writeToSP("20MY010015 ");
                       		 myTimer.cancel(); 
                     	   }
             }
         };       
         myTimer.schedule(gorev,0,1000);
     }
        boolean kapiAcKapa = true;
        TrenBilgisiEvent tEvt;
        if (this.kalanMesafe <= 130 && durum) { //130 du
            this.istasyondaMi = true;
            tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
            if (!this.varisAnonsuYapidiMi) {
                this.varisAnonsuYap(tEvt);
                System.out.println(tEvt +" varýþ anonsu yap " + durum +this.kalanMesafe);
                this.varisAnonsuYapidiMi = true;
            }   

            this.SonrakiIstasyonaGec();
        }

        if (this.kalanMesafe < 130 && this.toplamMesafe > 0 && this.istasyondaMi && this.kapiAcikMi && !durum) {
            kapiAcKapa = false;
        }

        this.kapiAcikMi = durum;
        tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon, this.sonrakiIstasyon,String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
        tEvt.isKapiAcKapa = kapiAcKapa;
        this.guncelle(tEvt);
    }

    private void Init() {
        this.hedefIstasyon = "";
        this.oncekiHedefIstasyon = "";
        this.mevcutIstasyon = "";
        this.gelecekIstasyon = "";
        this.sonrakiIstasyon="";
        this.baslangicIstasyonu = "";
        this.gidilenMesafe = 0;
        this.kalanMesafe = 0;
        this.toplamMesafe = 0;
        this.gecilenMesafeSayac = 0;
        this.kapiAcikMi = true;
        this.istasyondaMi = true;
        this.yaklasimAnonsuYapildiMi = false;
        this.varisAnonsuYapidiMi = false;
        if(!OSValidator.isWindows()) {
        GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
   	    this.gpio = GpioFactory.getInstance();
   	  // this.kapiButonu = this.gpio.provisionDigitalInputPin(RaspiPin.GPIO_29, PinPullResistance.PULL_UP);
       // this.takometre = this.gpio.provisionDigitalInputPin(RaspiPin.GPIO_28, PinPullResistance.PULL_UP);
   	   this.kapiButonu = this.gpio.provisionDigitalInputPin(RaspiBcmPin.GPIO_20, PinPullResistance.PULL_UP);
        this.takometre = this.gpio.provisionDigitalInputPin(RaspiBcmPin.GPIO_21, PinPullResistance.PULL_UP);
           this.serial = SerialFactory.createInstance();
           if (this.serial != null) {
               try {
   				this.serial.open("/dev/ttyAMA0", 4800);
   			} catch (IOException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
           } else {
               System.out.println("Serial port null");
           }
           
           
           this.kapiButonu.addListener(new GpioPinListener[]{new GpioPinListenerDigital() {
               public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                   if (event.getState() == PinState.HIGH) {
                	   TrenBilgileri.this.KapiDurumuDegistir(false);
                    //   System.out.println(" --> KAPI BUTONU: " + event.getPin() + " = " + event.getState());

                   } else {
                   	TrenBilgileri.this.KapiDurumuDegistir(true);
                   //    System.out.println(" --> KAPI BUTONU: " + event.getPin() + " = " + event.getState());

                   }

               }
           }});
           this.takometre.addListener(new GpioPinListener[]{new GpioPinListenerDigital() {
               public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                   if (event.getState() == PinState.HIGH) {
                      // System.out.println(" --> TAKOMETRE: " + event.getPin() + " = " + event.getState());

                   	TrenBilgileri.this.TakometreArttýr();
                   }

               }
           }});
      
           /*this.writeToSP(" ");    */ 
        
        }
    }
    private void KapiDurumuDegistir(final boolean durum) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TrenBilgileri.this.KapiDurumuGuncelle(durum);
            }
        });
    }  private void TakometreArttýr() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TrenBilgileri.this.TakometreVerisiGuncelle();
            }
        });
    }

    
    private void AnonsKontrol() {
        TrenBilgisiEvent tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
        if(this.takometrePasifEt==false ) {
        if ((this.kalanMesafe < 400 && !this.yaklasimAnonsuYapildiMi)) {
            this.yaklasimAnonsuYap(tEvt);
            System.out.println(tEvt +" yaklaþým anonsu yap "+this.kalanMesafe +this.yaklasimAnonsuYapildiMi);
            this.yaklasimAnonsuYapildiMi = true;
        }
    }
    }
   /* private void ByPassAnonsKontrol() {
    	TrenBilgisiEvent tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi);
        if ((this.kapiAcikMi && this.hedefIstasyon!=null)&& this.takometrePasifEt==true) {
            this.yaklasimAnonsuYap(tEvt);
            this.yaklasimAnonsuYapildiMi = true;
        }
    	
    }*/

    private void SonrakiIstasyonaGec() {
        this.mevcutIstasyon = this.gelecekIstasyon;
        this.gidilenMesafe = 0;
        this.gelecekIstasyon = RotaBilgileri.getGelecekIstasyon(this.mevcutIstasyon, this.hedefIstasyon);
        this.sonrakiIstasyon = RotaBilgileri.getGelecekSonrakiIstasyon(this.mevcutIstasyon, this.hedefIstasyon);

        this.toplamMesafe = RotaBilgileri.getGelecekIstasyonMesafe(this.mevcutIstasyon, this.hedefIstasyon);
        this.kalanMesafe = this.toplamMesafe - this.gidilenMesafe;
        this.yaklasimAnonsuYapildiMi = false;
        this.varisAnonsuYapidiMi = false;
    }

    public String getHedefIstasyon() {
        return this.hedefIstasyon;
    }

    public String getOncekiHedefIstasyon() {
        return this.oncekiHedefIstasyon;
    }

    public String getMevcutIstasyon() {
        return this.mevcutIstasyon;
    }
    public String getSonrakiIstasyon() {
        return this.sonrakiIstasyon;
    }

    public int getKalanMesafe() {
        return this.kalanMesafe;
    }

    public boolean getKapiDurumu() {
        return this.kapiAcikMi;
    }

    public String getBaslangicIstasyonu() {
        return this.baslangicIstasyonu;
    }

    public void setMevcutIstasyon(String istasyon) {
        this.mevcutIstasyon = istasyon;
        this.gelecekIstasyon = RotaBilgileri.getGelecekIstasyon(this.mevcutIstasyon, this.hedefIstasyon);
        this.gidilenMesafe = 0;
        this.toplamMesafe = RotaBilgileri.getGelecekIstasyonMesafe(this.mevcutIstasyon, this.hedefIstasyon);
        this.kalanMesafe = this.toplamMesafe - this.gidilenMesafe;
        this.yaklasimAnonsuYapildiMi = false;
        this.varisAnonsuYapidiMi = false;
        TrenBilgisiEvent tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
        this.guncelle(tEvt);
    }
    public void setSonrakiIstasyon(String istasyon) {
        this.mevcutIstasyon = istasyon;
        this.sonrakiIstasyon = RotaBilgileri.getGelecekSonrakiIstasyon(this.mevcutIstasyon, this.hedefIstasyon);
        //System.out.println(sonrakiIstasyon +"sonraki istasyon");
        this.gidilenMesafe = 0;
        this.toplamMesafe = RotaBilgileri.getGelecekIstasyonMesafe(this.mevcutIstasyon, this.hedefIstasyon);
        this.kalanMesafe = this.toplamMesafe - this.gidilenMesafe;
        this.yaklasimAnonsuYapildiMi = false;
        this.varisAnonsuYapidiMi = false;
        TrenBilgisiEvent tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
        this.guncelle(tEvt);
    }

    public void setHedefIstasyon(String istasyon) {
        this.oncekiHedefIstasyon = this.hedefIstasyon;
        this.hedefIstasyon = istasyon;
        this.gelecekIstasyon = RotaBilgileri.getGelecekIstasyon(this.mevcutIstasyon, this.hedefIstasyon);

        this.toplamMesafe = RotaBilgileri.getGelecekIstasyonMesafe(this.mevcutIstasyon, this.hedefIstasyon);
        this.kalanMesafe = this.toplamMesafe - this.gidilenMesafe;
        this.yaklasimAnonsuYapildiMi = false;
        this.varisAnonsuYapidiMi = false;
        TrenBilgisiEvent tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
        this.guncelle(tEvt);
    }

    public void setKapiDurumu(boolean durum) {
        this.kapiAcikMi = durum;
        Rotalar rota = RotaBilgileri.GetRota(this.mevcutIstasyon, this.gelecekIstasyon, this.hedefIstasyon,this.takometrePasifEt);
        if (!rota.equals(Rotalar.SECILMEDI) && !rota.equals(Rotalar.GECERSÝZ) && durum && this.kalanMesafe < 300) {
            this.setIstasyondaMi(true);
        }

        TrenBilgisiEvent tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
        this.guncelle(tEvt);
    }

    public void setKalanMesafe(int deger) {
        this.kalanMesafe = deger;
    }

    public void setGidilenMesage(int deger) {
        this.gidilenMesafe = deger;
    }

    public void setIstasyondaMi(boolean durum) {
        this.istasyondaMi = durum;
        TrenBilgisiEvent tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
        this.guncelle(tEvt);
    }

    public void setBaslangicIstasyonu(String istasyon) {
        this.baslangicIstasyonu = istasyon;
    }

    public void setRotaBilgileri(String mevcutIstasyon, String baslangicIstasyonu, String hedefIstasyon, Boolean takometrePasifEt) {
        this.baslangicIstasyonu = baslangicIstasyonu;
        this.mevcutIstasyon = mevcutIstasyon;
        this.hedefIstasyon = hedefIstasyon;
        this.gelecekIstasyon = RotaBilgileri.getGelecekIstasyon(mevcutIstasyon, hedefIstasyon);
        this.sonrakiIstasyon = RotaBilgileri.getGelecekSonrakiIstasyon(mevcutIstasyon, hedefIstasyon);
        this.takometrePasifEt=takometrePasifEt;
        System.out.println(this.takometrePasifEt + "  this.takometrePasifEt");
        this.gidilenMesafe = 0;
        this.toplamMesafe = RotaBilgileri.getGelecekIstasyonMesafe(mevcutIstasyon, hedefIstasyon);
        this.kalanMesafe = this.toplamMesafe - this.gidilenMesafe;
        this.yaklasimAnonsuYapildiMi = false;
        this.varisAnonsuYapidiMi = false;
        TrenBilgisiEvent tEvt = new TrenBilgisiEvent(hedefIstasyon, mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon,String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,takometrePasifEt);
        this.guncelle(tEvt);
    }

    public void addListener(TrenBilgisiListener listener) {
        this.listenerList.add(TrenBilgisiListener.class, listener);
    }

    public void removeListener(TrenBilgisiListener listener) {
        this.listenerList.remove(TrenBilgisiListener.class, listener);
    }

    void guncelle(TrenBilgisiEvent evt) {
        Object[] listeners = this.listenerList.getListenerList();

        for(int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == TrenBilgisiListener.class) {
                ((TrenBilgisiListener)listeners[i + 1]).Guncelle(evt);
            }
        }

    }

    void yaklasimAnonsuYap(TrenBilgisiEvent evt) {
        Object[] listeners = this.listenerList.getListenerList();

        for(int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == TrenBilgisiListener.class) {
                ((TrenBilgisiListener)listeners[i + 1]).YaklasimAnonsu(evt);
            }
        }

    }

    void varisAnonsuYap(TrenBilgisiEvent evt) {
        Object[] listeners = this.listenerList.getListenerList();

        for(int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == TrenBilgisiListener.class) {
                ((TrenBilgisiListener)listeners[i + 1]).VarisAnonsu(evt);
            }
        }

    }

    void mevcutIstasyonDegisti(String mevcutIstasyon) {
        Object[] listeners = this.listenerList.getListenerList();

        for(int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == TrenBilgisiListener.class) {
                ((TrenBilgisiListener)listeners[i + 1]).MevcutIstasyonDegisti(mevcutIstasyon);
            }
        }

    }
    public void writeToSP(String data) {
		 int STX = 0x2;
        int ETX = 0x3;
        int ENQ = 0x5;
        int NL = 0xD;
        int LF = 0xA;
	        try {
	            if (this.serial != null && this.serial.isClosed()) {
	                this.serial.open("/dev/ttyAMA0", 4800);
	            }

	            if (this.serial != null && this.serial.isOpen()) {
	            data = data.toUpperCase();

	                try {
	                    this.serial.flush();

	       			 byte[] bytes= data.getBytes();
	       			 byte[] utf8 = new String(bytes, "UTF-8").getBytes("ISO-8859-9");
	        
	       			 String HexPaket = Integer.toHexString(xorDatas(utf8)).toUpperCase();
	       	            if (HexPaket.length() < 2)
	       	            {
	       	                HexPaket = '0' + HexPaket;
	       	            }
	       	            String CommandCall = Character.toString((char)STX) + data +  Character.toString((char)ENQ) + HexPaket +  Character.toString((char)ETX) +  Character.toString((char)NL) +  Character.toString((char)LF);	       	            
	       	            System.out.println(CommandCall);	       	            
	       	            
	                    this.serial.write(CommandCall);
	                } catch (UnsupportedEncodingException var5) {
	                    var5.printStackTrace();
	                } catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
	            } else {
	            		            	 
	                System.out.println("Seri port kapalý! Data: " + data);
	            }
	        } catch (IllegalStateException var6) {
	            var6.printStackTrace();
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }	 
	 private int xorDatas(byte[] data)
	    {
	        int temp = data[0];
	        for (int i = 1; i < data.length; i++)
	        {
	            temp = temp ^ data[i];
	        }
	        return temp;
	    }

}
