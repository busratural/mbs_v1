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
import com.pi4j.io.gpio.GpioPinDigitalOutput;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.management.ManagementFactory;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;

public class MainClass extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private MBSPlayer player;
    private TrenBilgileri trenBilgileri;
    private GpioController gpio;
    private Serial serial;
   // private GpioPinDigitalInput kapiButonu;
   // private GpioPinDigitalInput takometre;
    private GpioPinDigitalOutput amplifikator;
    private GpioPinDigitalInput anonsBaslatma;

   private String versiyon = "v2.0.0";
    private static JLabel lblToplamMesafe;
    private JLabel lblHedefIstasyon;
    private JLabel lblGelecekIstasyon;
    private static JLabel lblKapiDurumu;
    private JLabel lblKalanMesafe;
    private JLabel lblAracDurumu;
    private JLabel lblVersion;
    private JLabel lblMevcutKonum;
    private JLabel lblGelecekKonum;
    private JLabel lblHedefKonum;
    private JLabel lblRotaHedef;
    private JLabel lblRotaBaslangic;
    private JLabel lblDetayliRotaMevcutIstasyon;
    private JLabel lblDetayliRotaHedef;
    private static JLabel lblBaslangicKonum;
    private JLabel lblTrenNoInfoLabel;
    private JLabel lblParolaBilgi;
    private JLabel trenNumarasiVal;
    private JButton btnAnonsKapat;
    private JButton btnTakometreByPass;

    private JButton btnTakometre;
    private JPanel mainIstasyonPanel;
    private JPanel gelecekIstasyonPanel;
    private JPanel ayarlarPanel;
    private JPanel uyariPanel;
    private JPanel baslangicIstasyonuPanel;
    private JPanel konumPanel;
    private JPanel istasyonAnonslariPanel;
    private JPanel anaRotaKurPanel;
    private JPanel donusYonuSecPanel;
    private JTabbedPane tTabbedPane;
    private JTabbedPane tRotaKurPanel;
    private BlinkLabel lblRotaSecimUyari;
    private BlinkLabel lblRotaUyari;
    private int rotaSecilenIstasyon = 0;
    private int detayliRotaSecilenIstasyon = 0;
    private JGradientButton btnMescid;
    private JGradientButton btnTopkapý;
    
    private JGradientButton btnTopkapý1;

    private JGradientButton btnOnay;
    private JGradientButton btnIptal;
    private JGradientButton btnDetayliRotaOnay;
    private JGradientButton btnDetayliRotaIptal;
    private JTextField trenNoField;
    private JPasswordField passField;
    private JButton[] mevcutIstasyonButonlari;
    static Image image = Toolkit.getDefaultToolkit().getImage("images/tray.gif");
    static TrayIcon trayIcon;
    private Rotalar mevcutRota;
    private String mevcutHedefIstasyon;
    private String startDir;
    private String imageDir;
    private ImageIcon iconOnay;
    private ImageIcon iconIptal;
    private Font fontDefault;
   // private Font fontDetayliRota;
    //private Font fontAnaDetayliRota;

    //private Font fontOzelAnonslar;
    //private Font fontKonumLabel;
    private JLabel lblMevcutSesSeviyesi;
    private boolean isCursorVisible;
    String sesSeviyesi;
    private JTabbedPane tRotaPane;
    private Tema seciliTema;
    private EPostaYolla ePostaYolla;
    private JSONOku jsonOku;
    private static JSONYaz jsonYaz;
    SimpleDateFormat sekil = new SimpleDateFormat();
    static Date çalýþtýrmaTarihi = new Date();	
    public Boolean takometrePasifEt =false;
    public Boolean anonsYapma=false;

 //   private static BrightnessManager brightnessmanager;
    ActionListener listenerTabelaKur;
    ActionListener listenerAnaRotaKur;

    ActionListener listenerDetayliRota;
    ActionListener listenerDetayliAnaRota;
    ActionListener listenerDetayliRotaOnay;
    ActionListener listenerDetayliAnaRotaOnay;

    ActionListener listenerDetayliRotaIptal;
    ActionListener listenerDetayliAnaRotaIptal;
    ActionListener listenerDonusYonu;
    ActionListener listenerOzelAnonslar;
    ActionListener sesAzalt;
    ActionListener sesArttir;

    static {
        trayIcon = new TrayIcon(image, "Tester2");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

               
                try {
                //brightnessmanager=new BrightnessManager();
                
                	//brightnessmanager.setBrightness(100);
                    JFrame testFrame = new JFrame();
                    testFrame.setBounds(0, 0, 800, 600);
                    testFrame.setUndecorated(true);
                    testFrame.setBackground(new Color(255, 255, 255));
                    testFrame.setVisible(true);
                    JLabel label = new JLabel();
                    String startDir = System.getProperty("user.dir");
                    String imageDir = "/img";
                    ImageIcon iconUlasim = new ImageIcon(startDir + imageDir + "/istanbul_ulasism.png");
                    label.setIcon(iconUlasim);
                    label.setBounds(0, 0, 800, 600);
                    label.setHorizontalAlignment(0);
                    label.setVerticalAlignment(0);
                    JPanel testContentPane = new JPanel();
                    testContentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
                    testFrame.setContentPane(testContentPane);
                    testContentPane.setLayout((LayoutManager)null);
                    testContentPane.setBackground(Color.DARK_GRAY.brighter().brighter());
                    testContentPane.setBounds(0, 0, 800, 600);
                    testContentPane.add(label);
                    MainClass frame = new MainClass();
                    frame.setUndecorated(true);
                    frame.setExtendedState(6);
                    BufferedImage cursorImg = new BufferedImage(16, 16, 2);
                    Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
                    if (!OSValidator.isWindows()) {
                        frame.getContentPane().setCursor(blankCursor);
                    }

                    frame.getContentPane().setCursor(blankCursor);
                    testFrame.setVisible(false);
                    frame.setVisible(true);
                    jsonYaz =new JSONYaz();

               	  /* Timer myTimer=new Timer();
                    TimerTask gorev =new TimerTask() {   
                           @Override
                           public void run() {
                                  System.out.println(çalýþtýrmaTarihi+lblKapiDurumu.getText()+lblToplamMesafe.getText()+ lblBaslangicKonum.getText());      

                                  jsonYaz.parametrik(çalýþtýrmaTarihi,lblKapiDurumu.getText(),lblToplamMesafe.getText(), lblBaslangicKonum.getText());
                           }
                    };
        
                    myTimer.schedule(gorev,0,3000);
               	*/
                    jsonYaz.sabit();
                } catch (Exception var10) {
                    var10.printStackTrace();
                }

            }
        });
    }

    public MainClass() {
        this.mevcutRota = Rotalar.SECILMEDI;
        this.mevcutHedefIstasyon = "";
        this.isCursorVisible = false;
        this.sesSeviyesi = "??";
        this.listenerTabelaKur = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("LED:" + e.getActionCommand());
                if (!OSValidator.isWindows()) {
    	        	Timer myTimer1=new Timer();
    	            TimerTask gorev1 =new TimerTask() {   
    	                   @Override
    	                   public void run() {  
    	                       MainClass.this.writeToSP("10MY010015"+IstasyonLedAdiGetir(e.getActionCommand()));    	                	   
    	        }
    	    };       
    	    myTimer1.schedule(gorev1,0,30000);	      
    	    }else {
                MainClass.this.writeToSP("10MY010015"+IstasyonLedAdiGetir(e.getActionCommand()));    	                	   

    	    }                MainClass.this.tTabbedPane.setSelectedIndex(0);
                
            }
        };
        this.listenerAnaRotaKur = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("LED:" + e.getActionCommand());
                btnMescid.setActionCommand(e.getActionCommand());
                if (!OSValidator.isWindows()) {
    	        	Timer myTimer1=new Timer();
    	            TimerTask gorev1 =new TimerTask() {   
    	                   @Override
    	                   public void run() {  
    	                       MainClass.this.writeToSP("10MY010015"+IstasyonLedAdiGetir(e.getActionCommand()));    	                	                 	   
    	        }
    	    };       
    	    myTimer1.schedule(gorev1,0,30000);	      
    	    }else {
                MainClass.this.writeToSP("10MY010015"+IstasyonLedAdiGetir(e.getActionCommand()));    	                	    	                	   

    	    }
                MainClass.this.tTabbedPane.setSelectedIndex(0);

            }                                              	
        };
        this.listenerDetayliRota = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton srcButton = (JButton)e.getSource();
                MainClass var10000;
                if (MainClass.this.detayliRotaSecilenIstasyon == 0) {
                    srcButton.setEnabled(false);
                    MainClass.this.lblDetayliRotaMevcutIstasyon.setText(e.getActionCommand());
                    var10000 = MainClass.this;
                    var10000.detayliRotaSecilenIstasyon = var10000.detayliRotaSecilenIstasyon + 1;
                } else if (MainClass.this.detayliRotaSecilenIstasyon == 1) {
                    srcButton.setEnabled(false);
                    MainClass.this.lblDetayliRotaHedef.setText(e.getActionCommand());
                    var10000 = MainClass.this;
                    var10000.detayliRotaSecilenIstasyon = var10000.detayliRotaSecilenIstasyon + 1;
                    MainClass.this.btnDetayliRotaOnay.setEnabled(true);
                }

            }
        };
        this.listenerDetayliAnaRota = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton srcButton = (JButton)e.getSource();
                MainClass var10000;
                if (MainClass.this.detayliRotaSecilenIstasyon == 0) {
                    srcButton.setEnabled(false);
                    MainClass.this.btnMescid.setText(e.getActionCommand());
                    var10000 = MainClass.this;
                    var10000.detayliRotaSecilenIstasyon = var10000.detayliRotaSecilenIstasyon + 1;
                }
               
                else if (MainClass.this.detayliRotaSecilenIstasyon == 1) {
                    srcButton.setEnabled(false);
                    MainClass.this.btnTopkapý.setText(e.getActionCommand());
                    var10000 = MainClass.this;
                    var10000.detayliRotaSecilenIstasyon = var10000.detayliRotaSecilenIstasyon + 1;
                    MainClass.this.btnDetayliRotaOnay.setEnabled(true);
                }
               

            }
        };
        this.listenerDetayliRotaOnay = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String baslangicIstasyonu = RotaBilgileri.BaslangicIstasyonuBul(MainClass.this.lblDetayliRotaMevcutIstasyon.getText(), MainClass.this.lblDetayliRotaHedef.getText(),MainClass.this.takometrePasifEt);
                MainClass.this.trenBilgileri.setRotaBilgileri(MainClass.this.lblDetayliRotaMevcutIstasyon.getText(), baslangicIstasyonu, MainClass.this.lblDetayliRotaHedef.getText(),MainClass.this.takometrePasifEt);
                MainClass.this.lblDetayliRotaMevcutIstasyon.setText("-");
                MainClass.this.lblDetayliRotaHedef.setText("-");
                MainClass.this.detayliRotaSecilenIstasyon = 0;

                for(int i = 0; i < MainClass.this.istasyonAnonslariPanel.getComponentCount(); ++i) {
                    try {
                        JButton btn = (JButton)MainClass.this.istasyonAnonslariPanel.getComponent(i);
                        btn.setEnabled(true);
                    } catch (Exception var5) {
                    }
                }

                MainClass.this.btnDetayliRotaOnay.setEnabled(false);
                MainClass.this.tTabbedPane.setSelectedIndex(0);
                if (!MainClass.this.mevcutRota.equals(Rotalar.GECERSÝZ)) {
                    MainClass.this.mevcutRota.equals(Rotalar.SECILMEDI);
                }

                MainClass.this.MevcutIstasyonButonKontrol();
            }
        };
        this.listenerDetayliAnaRotaOnay = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	   
                 MainClass.this.btnTopkapý.setActionCommand("sdsdsdsdsdsda");
                 MainClass.this.btnTopkapý.setText("sdsdsdsdsdsda");

            }
        };
        this.listenerDetayliRotaIptal = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainClass.this.lblDetayliRotaMevcutIstasyon.setText("-");
                MainClass.this.lblDetayliRotaHedef.setText("-");
                MainClass.this.detayliRotaSecilenIstasyon = 0;
                MainClass.this.btnDetayliRotaOnay.setEnabled(false);

                for(int i = 0; i < MainClass.this.istasyonAnonslariPanel.getComponentCount(); ++i) {
                    try {
                        JButton btn = (JButton)MainClass.this.istasyonAnonslariPanel.getComponent(i);
                        btn.setEnabled(true);
                    } catch (Exception var4) {
                    }
                }

            }
        };
        
        this.listenerDetayliAnaRotaIptal = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainClass.this.btnMescid.setText(" ");
               MainClass.this.btnTopkapý.setText(" ");

                MainClass.this.detayliRotaSecilenIstasyon = 0;
                MainClass.this.btnDetayliRotaOnay.setEnabled(false);
                System.out.println("Konsola basýlacak ilk yazý");

                for(int i = 0; i < MainClass.this.istasyonAnonslariPanel.getComponentCount(); ++i) {
                    try {
                    	JGradientButton btn = (JGradientButton)MainClass.this.istasyonAnonslariPanel.getComponent(i);
                        btn.setEnabled(true);
                    } catch (Exception var4) {
                    }
                }

            }
        };
        this.listenerDonusYonu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String istasyon = e.getActionCommand();
                if (!OSValidator.isWindows()) {
    	        	Timer myTimer1=new Timer();
    	            TimerTask gorev1 =new TimerTask() {   
    	                   @Override
    	                   public void run() {  
    	                       MainClass.this.writeToSP("10MY010015"+IstasyonLedAdiGetir(istasyon));
    	                	   
    	        }
    	    };       
    	    myTimer1.schedule(gorev1,0,30000);	      
    	    }else {
                MainClass.this.writeToSP("10MY010015"+IstasyonLedAdiGetir(istasyon));

    	    }
                MainClass.this.lblKalanMesafe.setText(String.valueOf(MainClass.this.trenBilgileri.getKalanMesafe()));
                MainClass.this.donusYonuSecPanel.setVisible(false);
            }
        };
        this.listenerOzelAnonslar = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String path = e.getActionCommand();
                System.out.println("Path:" + path);
                MainClass.this.tTabbedPane.requestFocus();
                MainClass.this.tTabbedPane.setSelectedIndex(0);
                if(MainClass.this.anonsYapma==false) {
                    MainClass.this.player.Play(path);
                }
                MainClass.this.contentPane.requestFocus();
                if (path.contains("DEPO ")) {
                    MainClass.this.writeToSP("DEPO");
                } else if (path.contains("ARAÇ AKSARAY")) {
                    MainClass.this.writeToSP("AKSARAY");
                } else if (path.contains("ARAÇ ATATÜRK")) {
                    MainClass.this.writeToSP("ATAKÖY - ÞÝRÝNEVLER");
                } else if (path.contains("ARAÇ KÝRAZLI")) {
                    MainClass.this.writeToSP("KÝRAZLI");
                } else if (path.contains("ARAÇ OTOGAR")) {
                    MainClass.this.writeToSP("OTOGAR");
                } else if (path.contains("ARAÇ YENÝKAPI")) {
                    MainClass.this.writeToSP("YENÝKAPI");
                }

            }
        };
        this.sesAzalt = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!OSValidator.isWindows()) {
                    try {
                        String[] co = new String[]{"/bin/sh", "-c", "sudo amixer set PCM 1060-"};
                        Runtime.getRuntime().exec(co);
                        MainClass.this.sesSeviyesi = MainClass.this.SesSeviyesiGetir();
                        System.out.println("Ses seviyesi: " + MainClass.this.sesSeviyesi);
                        if (MainClass.this.lblMevcutSesSeviyesi != null) {
                            MainClass.this.lblMevcutSesSeviyesi.setText(MainClass.this.sesSeviyesi);
                        }
                    } catch (IOException var3) {
                        var3.printStackTrace();
                    }

                }
            }
        };
        this.sesArttir = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!OSValidator.isWindows()) {
                    try {
                        String[] co = new String[]{"/bin/sh", "-c", "sudo amixer set PCM 1060+"};
                        Runtime.getRuntime().exec(co);
                        MainClass.this.sesSeviyesi = MainClass.this.SesSeviyesiGetir();
                        System.out.println("Ses seviyesi: " + MainClass.this.sesSeviyesi);
                        if (MainClass.this.lblMevcutSesSeviyesi != null) {
                            MainClass.this.lblMevcutSesSeviyesi.setText(MainClass.this.sesSeviyesi);
                        }
                    } catch (IOException var3) {
                        var3.printStackTrace();
                    }

                }
            }
        };
        this.seciliTema = new Tema(this.getBackground());
        this.startDir = System.getProperty("user.dir");
        this.imageDir = "/img";
        this.iconOnay = new ImageIcon(this.startDir + this.imageDir + "/onay.png");
        this.iconIptal = new ImageIcon(this.startDir + this.imageDir + "/iptal.png");
        
        this.fontDefault = new Font(this.seciliTema.fontName, this.seciliTema.fontStyle, this.seciliTema.fontSize);

      //  this.fontOzelAnonslar = this.fontDefault;//.deriveFont(13.0F);
        //this.fontKonumLabel = this.fontDefault;//.deriveFont(14.0F);
        UIManager.put("TabbedPane.selected", this.seciliTema.selectedTabBackground);
        UIManager.put("TabbedPane.selectedForeground", this.seciliTema.selectedTabForeground);
        UIManager.put("TabbedPane.foreground", this.seciliTema.selectedTabForeground);
        this.setDefaultCloseOperation(3);
        this.setBounds(0, 0, 800, 600);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout((LayoutManager)null);
        this.contentPane.setBackground(this.seciliTema.contentPaneBackground);
        this.contentPane.setFont(fontDefault);
        this.tTabbedPane = new JTabbedPane();
        this.tTabbedPane.setBackground(this.seciliTema.tabbedPaneBackground);
        
        this.tTabbedPane.setTabLayoutPolicy(1);
        this.tTabbedPane.setForeground(this.seciliTema.tabcolor);
        this.tTabbedPane.setFont(fontDefault);

        JPanel trenBilgileriPanel = this.TrenBilgileriPaneliGetir();
        this.tTabbedPane.addTab("<html><center><br><br>TREN BÝLGÝLERÝ<br><br><br></center></html>", (Icon)null, trenBilgileriPanel);
        this.tTabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                MainClass.this.tRotaKurPanel.setSelectedIndex(0);
            }
        });
        JPanel rotaKurPanel = new JPanel();
        rotaKurPanel.setLayout((LayoutManager)null);
        rotaKurPanel.setBounds(0, 0, 800, 600);
        rotaKurPanel.setBackground(this.seciliTema.rotaKurPanelBackground);
        this.tRotaKurPanel = this.RotaPaneliGetir();
        this.tRotaKurPanel.setBounds(5, 5, 775, 490);
        rotaKurPanel.add(this.tRotaKurPanel);
        this.tTabbedPane.addTab("<html><center><br>&nbsp;&nbsp;&nbsp;&nbsp;ROTA KUR&nbsp;&nbsp;&nbsp;&nbsp;<br><br></center></html>", (Icon)null, rotaKurPanel);
        this.baslangicIstasyonuPanel = this.BaslangicAnonlariPaneliniGetir();
        this.tTabbedPane.addTab("<html><center><br>&nbsp;&nbsp;&nbsp;BAÞLANGIÇ&nbsp;&nbsp;&nbsp;<br>ANONSLARI<br><br></center></html>", (Icon)null, this.baslangicIstasyonuPanel);
        JPanel ozelAnonsPanel = new JPanel();
        ozelAnonsPanel.setLayout((LayoutManager)null);
        ozelAnonsPanel.setBounds(0, 0, 800, 600);
        ozelAnonsPanel.setBackground(this.seciliTema.ozelAnonsPanelBackground);
        JTabbedPane ozelAnonsTabPanel = this.OzelAnonlarPaneliniGetir();
        ozelAnonsPanel.add(ozelAnonsTabPanel);
        this.tTabbedPane.addTab("<html><center><br><br>ÖZEL ANONSLAR<br><br><br></center></html>", (Icon)null, ozelAnonsPanel);
        this.mainIstasyonPanel = new JPanel();
        this.mainIstasyonPanel.setLayout((LayoutManager)null);
        this.mainIstasyonPanel.setBounds(0, 0, 800, 500);
        JPanel istasyonlarPanel = this.IstasyonlarPaneliniGetir();
        this.mainIstasyonPanel.add(istasyonlarPanel);
        this.tTabbedPane.addTab("<html><center><br>&nbsp;&nbsp;&nbsp;&nbsp;ÝSTASYON&nbsp;&nbsp;&nbsp;&nbsp;<br>ANONSLARI<br><br></center></html>", (Icon)null, this.mainIstasyonPanel);
        this.ayarlarPanel = this.ParolaPanel();
        ozelAnonsPanel.setBackground(this.seciliTema.ayarlarPanelBackground);
        this.tTabbedPane.addTab("<html><center><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AYARLAR&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br><br></center></html>", (Icon)null, this.ayarlarPanel);
        
        this.contentPane.add(this.tTabbedPane);
        this.player = new MBSPlayer();
        this.player.addMyEventListener(new MyEventListener() {
            public void myEventOccurred(BasicPlayerEvent evt) {
            	 if (evt.getCode() == 3) { //STOPPED = 3;
            		    if (MainClass.this.amplifikator != null) {
                        MainClass.this.amplifikator.setState(PinState.LOW);
                        System.out.println("amplifikator"+1);
                    }

                    MainClass.this.btnAnonsKapat.setBackground(new Color(70, 0, 0));
                    MainClass.this.btnAnonsKapat.setForeground(new Color(255, 255, 255));
                    MainClass.this.btnAnonsKapat.setEnabled(false);
                    System.out.println("amplifikator"+2);
                } else if (evt.getCode() == 2) { //PLAYING=2
                    if (MainClass.this.amplifikator != null) {
                        MainClass.this.amplifikator.setState(PinState.HIGH);
                        System.out.println("amplifikator"+3);
                    }

                    MainClass.this.btnAnonsKapat.setBackground(Color.red);
                    MainClass.this.btnAnonsKapat.setForeground(new Color(255, 255, 255));
                    MainClass.this.btnAnonsKapat.setEnabled(true);                        
                    System.out.println("amplifikator"+4	);

                }

            }
        });
        this.trenBilgileri = new TrenBilgileri();
        this.trenBilgileri.addListener(new TrenBilgisiListener() {
            public void Guncelle(TrenBilgisiEvent evt) {
                MainClass.this.TrenBilgileriArayuzunuGuncelle(evt);
                MainClass.this.RotaKontrol(evt.rota);
            }

            public void YaklasimAnonsu(TrenBilgisiEvent evt) {
                MainClass.this.YaklasimAnonsuYap(MainClass.this.trenBilgileri.getBaslangicIstasyonu(), evt.gelecekIstasyon, evt.hedefIstasyon);
                if (evt.gelecekIstasyon.equals(evt.hedefIstasyon)) {
                    if (!evt.gelecekIstasyon.equals("TOPKAPI")) {
                        MainClass.this.donusYonuSecPanel.setVisible(true);
                    } else {
                        MainClass.this.writeToSP("10MY010015MESCIDISELAM");
                    }
                }

                MainClass.this.contentPane.requestFocus();
            }

            public void VarisAnonsu(TrenBilgisiEvent evt) {
                if (MainClass.this.mevcutRota != Rotalar.GECERSÝZ && MainClass.this.mevcutRota != Rotalar.SECILMEDI) {
                   // Rotalar var10000 = Rotalar.DEPO;
                }

                MainClass.this.VarisAnonsuYap(MainClass.this.trenBilgileri.getBaslangicIstasyonu(), evt.gelecekIstasyon, evt.hedefIstasyon);
                MainClass.this.donusYonuSecPanel.setVisible(false);
                MainClass.this.contentPane.requestFocus();
            }

            public void MevcutIstasyonDegisti(String mevcutIstasyon) {
                for(int i = 0; i < MainClass.this.mevcutIstasyonButonlari.length; ++i) {
                    MainClass.this.mevcutIstasyonButonlari[i].setEnabled(false);
                }

            }
        });
        if (!OSValidator.isWindows()) {
            this.InitializeIO();
        }

        this.contentPane.getInputMap().put(KeyStroke.getKeyStroke('x'), "forward");
        this.contentPane.getInputMap().put(KeyStroke.getKeyStroke('X'), "forward");
        this.contentPane.getActionMap().put("forward", new AbstractAction() {
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                if (!MainClass.this.isCursorVisible) {
                    MainClass.this.getContentPane().setCursor(Cursor.getDefaultCursor());
                    MainClass.this.isCursorVisible = true;
                } else {
                    BufferedImage cursorImg = new BufferedImage(16, 16, 2);
                    Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
                    MainClass.this.getContentPane().setCursor(blankCursor);
                    MainClass.this.isCursorVisible = false;
                }

            }
        });
        this.contentPane.getInputMap().put(KeyStroke.getKeyStroke('t'), "takometre");
        this.contentPane.getInputMap().put(KeyStroke.getKeyStroke('T'), "takometre");
        this.contentPane.getActionMap().put("takometre", new AbstractAction() {
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                if (OSValidator.isWindows()) {
                    MainClass.this.trenBilgileri.TakometreVerisiGuncelle();
                }

            }
        });
        this.contentPane.getInputMap().put(KeyStroke.getKeyStroke('k'), "kapi");
        this.contentPane.getInputMap().put(KeyStroke.getKeyStroke('K'), "kapi");
        this.contentPane.getActionMap().put("kapi", new AbstractAction() {
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                if (OSValidator.isWindows()) {
                    if (MainClass.this.trenBilgileri.getKapiDurumu()) {
                        MainClass.this.KapiDurumuDegistir(false);
                    } else {
                        MainClass.this.KapiDurumuDegistir(true);
                    }
                }

            }
        });
        LogManager.getLogManager().reset();
        Logger globalLogger = Logger.getLogger("global");
        globalLogger.setLevel(Level.OFF);
        TimerTask task = new MainClass.EkranKoruyucuEngelleTask();
        Timer timer = new Timer();
        timer.schedule(task, 8000L, 50000L);
    }

    public void TrenBilgileriArayuzunuGuncelle(TrenBilgisiEvent evt) {
        this.lblAracDurumu.setText(this.TextCenter(evt.istasyonDurumu));
        if (!this.donusYonuSecPanel.isVisible()) {
            this.lblKalanMesafe.setText(this.TextCenter(evt.kalanMesafe));
        }

        this.lblKapiDurumu.setText(this.TextCenter(evt.kapiDurumu));
        this.lblToplamMesafe.setText(this.TextCenter(evt.toplamMesafe));
        this.lblBaslangicKonum.setText(this.TextCenter(this.trenBilgileri.getBaslangicIstasyonu()));
        this.lblMevcutKonum.setText(this.TextCenter(evt.gelecekIstasyon));//mevcut konumu deðiþtirdim
        this.lblGelecekKonum.setText(this.TextCenter(evt.sonrakiIstasyon));
        this.lblHedefKonum.setText(this.TextCenter(evt.hedefIstasyon));
        
        this.lblHedefIstasyon.setText(this.TextCenter(evt.hedefIstasyon));
        this.lblGelecekIstasyon.setText(this.TextCenter(evt.gelecekIstasyon));
       
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

    private File[] Sirala(File[] dosyalar) {
        for(int i = 0; i < dosyalar.length - 1; ++i) {
            int index = this.getIstasyonIndex(dosyalar[i].getName());
            if (index >= 0 && index < dosyalar.length && index != i) {
                File temp = new File(dosyalar[i].getAbsolutePath());
                dosyalar[i] = new File(dosyalar[index].getAbsolutePath());
                dosyalar[index] = new File(temp.getAbsolutePath());
                i = 0;
            }
        }

        return dosyalar;
    }

    private int getIstasyonIndex(String istasyon) {
        if (istasyon.toUpperCase().equals("TOPKAPI")) {
            return 0;
        } else if (istasyon.toUpperCase().equals("FETIHKAPI")) {
            return 1;
        } else if (istasyon.toUpperCase().equals("VATAN")) {
            return 2;
        } else if (istasyon.toUpperCase().equals("EDIRNEKAPI")) {
            return 3;
        } else if (istasyon.toUpperCase().equals("SEHITLIK")) {
            return 4;
        } else if (istasyon.toUpperCase().equals("DEMIRKAPI")) {
            return 5;
        } else if (istasyon.toUpperCase().equals("TOPCULAR")) {
            return 6;
        } else if (istasyon.toUpperCase().equals("RAMI")) {
            return 7;
        } else if (istasyon.toUpperCase().equals("ULUYOL")) {
            return 8;
        } else if (istasyon.toUpperCase().equals("SAGMALCILAR")) {
            return 9;
        } else if (istasyon.toUpperCase().equals("CUKURCESME")) {
            return 10;
        } else if (istasyon.toUpperCase().equals("A. FUAT BAÞ.")) {
            return 11;
        } else if (istasyon.toUpperCase().equals("TASKOPRU")) {
            return 12;
        } else if (istasyon.toUpperCase().equals("KARADENIZ")) {
            return 13;
        } else if (istasyon.toUpperCase().equals("KIPTAS-VEN.")) {
            return 14;
        } else if (istasyon.toUpperCase().equals("CUMHURIYET")) {
            return 15;
        } else if (istasyon.toUpperCase().equals("50.YIL")) {
            return 16;
        } else if (istasyon.toUpperCase().equals("HACI SUKRU")) {
            return 17;
        } else if (istasyon.toUpperCase().equals("YENIMAHALLE")) {
            return 18;
        } else if (istasyon.toUpperCase().equals("SULTANCIFTLIGI")) {
            return 19;
        } else if (istasyon.toUpperCase().equals("CEBECI")) {
            return 20;
        } else if (istasyon.toUpperCase().equals("MESCIDI SELAM")) {
            return 21;
        }  else {
            return -1;
        }
    }

    private void PowerManagerKapat() {
        if (!OSValidator.isWindows()) {
            try {
                String[] co = new String[]{"/bin/sh", "-c", "sudo pkill -f mate-power"};
                Process p = Runtime.getRuntime().exec(co);
                p.waitFor();
                p.destroy();
            } catch (Exception var3) {
                System.out.println(var3.toString());
            }

        }
    }

    private void ScreenSaverKapat() {
        if (!OSValidator.isWindows()) {
            try {
                String[] co = new String[]{"/bin/sh", "-c", "sudo pkill -f mate-screens"};
                Process p = Runtime.getRuntime().exec(co);
                p.waitFor();
                p.destroy();
            } catch (Exception var3) {
                System.out.println(var3.toString());
            }

        }
    }

    private void EkranKoruyucuyuIptalEt() {
        this.PowerManagerKapat();
        this.ScreenSaverKapat();
    }

    private void KalibrasyonuAyarla(String min_x, String max_x, String min_y, String max_y) {
        try {
            boolean isOptionEnable = false;
            String input = "";
            String newLine = "\t\tOption \"Calibration\" \"" + min_x + " " + max_x + " " + min_y + " " + max_y + "\"";
            String path = "/usr/share/X11/xorg.conf.d/10-evdev.conf";
            BufferedReader file = new BufferedReader(new FileReader(path));

            while(true) {
                String line;
                while((line = file.readLine()) != null) {
                    if (line.contains("Option") && line.contains("Calibration")) {
                        input = input + newLine + '\n';
                        isOptionEnable = true;
                    } else {
                        input = input + line + '\n';
                    }
                }

                file.close();
                if (!isOptionEnable) {
                    file = new BufferedReader(new FileReader(path));

                    while((line = file.readLine()) != null) {
                        input = input + line + '\n';
                        if (line.contains("Identifier") && line.contains("evdev touchscreen catchall")) {
                            input = input + newLine + '\n';
                        }
                    }

                    file.close();
                }

                FileOutputStream fileOut = new FileOutputStream(path);
                fileOut.write(input.getBytes());
                fileOut.close();
                break;
            }
        } catch (Exception var12) {
            System.out.println("Problem reading file.\n" + var12.toString());
        }

    }

    private void KalibrasyonuSifirla() {
        try {
            String input = "";
            String path = "/usr/share/X11/xorg.conf.d/10-evdev.conf";
            BufferedReader file = new BufferedReader(new FileReader(path));

            while(true) {
                String line;
                do {
                    if ((line = file.readLine()) == null) {
                        file.close();
                        FileOutputStream fileOut = new FileOutputStream(path);
                        fileOut.write(input.getBytes());
                        fileOut.close();
                        return;
                    }
                } while(line.contains("Option") && line.contains("Calibration"));

                input = input + line + '\n';
            }
        } catch (Exception var6) {
            System.out.println("Problem reading file.\n" + var6.toString());
        }
    }

    private String[] EthernetAyarMetniOlustur(int trenNo) {
        int num = trenNo - 400;
        String[] texts = new String[]{"#interfaces(5) file used by ifup(8) and ifdown(8)", "#Include files from /etc/network/interfaces.d:", "source-directory /etc/network/interfaces.d", "", "auto eth2", "iface eth2 inet loopback", "iface eth2 inet static", null, null};
        if (trenNo == 571) {
            texts[7] = "        address 10.2.149.24";
            texts[8] = "        netmask 255.255.255.0";
        } else {
            texts[7] = "        address 172.22.110." + num;
            texts[8] = "        netmask 255.255.255.0";
        }

        return texts;
    }

    private void EthernetAyariYap(String[] text) {
        if (!OSValidator.isWindows()) {
            String[] co;
            try {
                Throwable var2 = null;
                co = null;

                try {
                    PrintStream out = new PrintStream(new FileOutputStream("/etc/network/interfaces"));

                    try {
                        for(int i = 0; i < text.length; ++i) {
                            out.println(text[i]);
                        }
                    } finally {
                        if (out != null) {
                            out.close();
                        }

                    }
                } catch (Throwable var16) {
                    if (var2 == null) {
                        var2 = var16;
                    } else if (var2 != var16) {
                        var2.addSuppressed(var16);
                    }

                    throw var2;
                }
            } catch (FileNotFoundException var17) {
                var17.printStackTrace();
            }

            try {
                co = new String[]{"/bin/sh", "-c", "sudo ifdown eth2; sudo ifup eth2 "};
                Process p = Runtime.getRuntime().exec(co);
                p.waitFor();
                p.destroy();
            } catch (Exception var14) {
            }

        }
    }

    private void TrenNoKaydet(String trenNo) {
        if (!OSValidator.isWindows()) {
            String[] co = new String[]{"/bin/sh", "-c", "echo " + trenNo + " > '/home/ybspi/trenno.txt' "};

            try {
                Runtime.getRuntime().exec(co);
            } catch (IOException var4) {
                var4.printStackTrace();
            }

        }
    }

    private String TrenNoGetir() {
        if (OSValidator.isWindows()) {
            return "000";
        } else {
            String tNo = "";

            try {
                String[] co = new String[]{"/bin/sh", "-c", "sudo cat '/home/ybspi/trenno.txt' "};
                Process p = Runtime.getRuntime().exec(co);
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

                while((tNo = br.readLine()) != null) {
                    if (tNo != "") {
                        System.out.println("TrenNo: " + tNo);
                        break;
                    }
                }

                p.waitFor();
                System.out.println("exit: " + p.exitValue());
                p.destroy();
            } catch (Exception var5) {
                var5.printStackTrace();
            }

            return tNo;
        }
    }

    private void MevcutIstasyonButonKontrol() {
        for(int i = 0; i < this.mevcutIstasyonButonlari.length; ++i) {
            boolean isEnable = RotaBilgileri.IstasyonRotadaMi(this.mevcutRota, this.mevcutIstasyonButonlari[i].getActionCommand(), this.trenBilgileri.getBaslangicIstasyonu(), this.trenBilgileri.getHedefIstasyon());
            if (!isEnable) {
                this.mevcutIstasyonButonlari[i].setEnabled(false);
            } else {
                this.mevcutIstasyonButonlari[i].setEnabled(true);
            }
        }

    }

    public void RotaKontrol(Rotalar rota) {
         if (rota.equals(Rotalar.GECERSÝZ)) {
            System.out.println("Rota GECERSÝZ");
            this.lblRotaSecimUyari.setText(this.TextCenter("SEÇÝLEN ROTA GEÇERLÝ DEÐÝL"));
            this.uyariPanel.setVisible(true);
        } else if (rota.equals(Rotalar.SECILMEDI)) {
            this.lblRotaSecimUyari.setText(this.TextCenter("LÜTFEN ROTA SEÇÝNÝZ"));
            this.uyariPanel.setVisible(true);
        } else if (rota.equals(Rotalar.T4TopkapýMescidiselam)) {
            this.uyariPanel.setVisible(false);
        } else if (rota.equals(Rotalar.T4MescidiselamTopkapý)) {
            this.uyariPanel.setVisible(false);
        } 

        if ((!rota.equals(this.mevcutRota) || !this.trenBilgileri.getHedefIstasyon().equals(this.mevcutHedefIstasyon)) && !rota.equals(Rotalar.SECILMEDI) && !rota.equals(Rotalar.GECERSÝZ)) {       	
 	        String hedef=this.trenBilgileri.getHedefIstasyon();
        	Timer myTimer1=new Timer();
 	            TimerTask gorev1 =new TimerTask() {   
					@Override
 	                   public void run() {  
 	                      writeToSP("10MY010015"+hedef);
 	        }

 	    };       
 	    myTimer1.schedule(gorev1,0,30000);	      
 	    
           // this.writeToSP("10MY010015"+this.trenBilgileri.getHedefIstasyon());
        } else if (rota.equals(Rotalar.SECILMEDI) || rota.equals(Rotalar.GECERSÝZ)) {
            for(int i = 0; i < this.mevcutIstasyonButonlari.length; ++i) {
                this.mevcutIstasyonButonlari[i].setEnabled(false);
            }
        }

        this.mevcutHedefIstasyon = this.trenBilgileri.getHedefIstasyon();
        this.mevcutRota = rota;
    }

    public void SetTrenBilgileriStyle(JLabel label, String text, int x, int y, int w, int h) {
        Color color = this.seciliTema.trenBilgileriForeground;
        //Font font = new Font(label.getFont().getFamily(), 1, 15);
        label.setFont(this.fontDefault);

        int horizontalAlignment = 0;
        int verticalAlignment = 0;
        label.setForeground(color);
        label.setHorizontalAlignment(horizontalAlignment);
        label.setVerticalAlignment(verticalAlignment);
        label.setText("<html><center>" + text + "</center></html>");
        label.setBounds(x, y, w, h);
    }

    public void SetTrenBilgileriStyle(JPanel panel, String text, int x, int y, int w, int h) {
        Color color = this.seciliTema.trenBilgileriBackground;
        panel.setLayout((LayoutManager)null);
        panel.setFont(this.fontDefault);

        TitledBorder titledBorder = BorderFactory.createTitledBorder(text);
        titledBorder.setTitleFont(fontDefault);
        panel.setBorder(titledBorder);
        titledBorder.setTitleColor(this.seciliTema.titledBorderTextColor);
        panel.setBounds(x, y, w, h);
        panel.setBackground(color);

    }

    public String TextCenter(String text) {
        return "<html><center>" + text + "</center></html>";
    }

    public String SesSeviyesiGetir() {
        if (OSValidator.isWindows()) {
            return "???%";
        } else {
            String s = "";

            try {
                String[] co = new String[]{"/bin/sh", "-c", "sudo amixer get PCM | egrep -o '[0-9]+%' "};
                Process p = Runtime.getRuntime().exec(co);
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

                while((s = br.readLine()) != null) {
                    if (s != "") {
                        System.out.println("line:: " + s);
                        break;
                    }
                }

                p.waitFor();
                System.out.println("exit: " + p.exitValue());
                p.destroy();
            } catch (Exception var5) {
                var5.printStackTrace();
            }

            return s;
        }
    }

    public JPanel DonusSeferiUyariPaneliGetir() {
        JPanel panel = new JPanel();
        panel.setLayout((LayoutManager)null);
        panel.setBackground(this.seciliTema.donusSeferiPanelBackground);
        BlinkLabel lblMesaj = new BlinkLabel("<html><center>DÖNÜÞ YÖNÜ ÝÇÝN TABELA KUR</center></html>");
        lblMesaj.setBounds(50, 50, 600, 60);
        lblMesaj.setHorizontalAlignment(0);
        lblMesaj.setVerticalAlignment(0);
        lblMesaj.setForeground(this.seciliTema.donusSeferiUyariForeground);
        lblMesaj.setBackground(this.seciliTema.donusSeferiUyariBackground);
        //Font fontMevcut = lblMesaj.getFont().deriveFont(30.0F);
        lblMesaj.setFont(this.fontDefault);
       
        JGradientButton btnTopkapý = new JGradientButton("MESCIDI SELAM", true, "MESCIDI SELAM", false, this.fontDefault, this.listenerDonusYonu);
        btnTopkapý.setPreferredSize(new Dimension(120, 100));
        btnTopkapý.setBounds(198, 150, 150, 100);
        JGradientButton btnMescid = new JGradientButton("TOPKAPI", true, "TOPKAPI", false, this.fontDefault, this.listenerDonusYonu);
        btnMescid.setPreferredSize(new Dimension(120, 100));
        btnMescid.setBounds(372, 150, 150, 100);
        btnMescid.setVisible(false);
      /*  btnDepo.setPreferredSize(new Dimension(120, 100));
        btnDepo.setBounds(372, 150, 150, 100);*/
        JGradientButton btnBos = new JGradientButton("BOÞ", true, " ", false, this.fontDefault, this.listenerDonusYonu);
        btnBos.setPreferredSize(new Dimension(120, 100));
        btnBos.setBounds(546, 150, 150, 100);
        JLabel lblNot = new JLabel();
        lblNot.setText("NOT: Sadece trenin bu baþtaki tabelasýný ayarlar.");
        lblNot.setFont(this.fontDefault);
        lblNot.setBounds(100, 270, 500, 50);
        lblNot.setForeground(this.seciliTema.donusSeferiUyariAciklamaForeground);
        lblNot.setHorizontalAlignment(0);
        lblNot.setVerticalAlignment(1);
        panel.add(lblNot);
        panel.add(lblMesaj);

        panel.add(btnTopkapý);
        panel.add(btnMescid);
       // panel.add(btnDepo);
        panel.add(btnBos);
        return panel;
    }

    public JPanel TabelaPaneliniGetir() {
    	jsonOku = new JSONOku();
        jsonOku.main("/tabela");
        JPanel tabelaKurPanel = new JPanel();
        tabelaKurPanel.setLayout(new FlowLayout(0, 5, 5));
        tabelaKurPanel.setBackground(this.seciliTema.tabelaPaneliBackground);
        tabelaKurPanel.setBounds(0, 0, 800, 500);
        //String istasyonlarPath = this.startDir + "/Anons/ISTASYON/";
        //File istasyonlarFolder = new File(istasyonlarPath);
        //File[] istasyonAnonsDosyalari = istasyonlarFolder.listFiles();
        //istasyonAnonsDosyalari = this.Sirala(istasyonAnonsDosyalari);
        if (jsonOku.tabelaSayisi != 0) {
            JButton[] jButtonsOzel = new JButton[jsonOku.tabelaList.size()];

            for(int i = 0; i < jButtonsOzel.length; ++i) {
                JGradientButton btnNewButton = new JGradientButton(jsonOku.tabelaList.get(i), true, jsonOku.tabelaList.get(i), false, this.fontDefault, this.listenerTabelaKur);
                btnNewButton.setPreferredSize(new Dimension(122, 73));
                tabelaKurPanel.add(btnNewButton);
            }
        } else {
            System.out.println("Tabela bulunamadý" );
        }

        return tabelaKurPanel;
    }

    public JPanel OzelAnonlarPaneli1() {
        JPanel ozelAnonsPanel = new JPanel();
        ozelAnonsPanel.setLayout(new FlowLayout(0, 5, 5));
        ozelAnonsPanel.setBackground(this.seciliTema.ozelAnonsPanel1Background);
        String path = this.startDir + "/Anons/Ozel/ANONS 1/";
        File folder = new File(path);
        File[] ozelAnonsDosyalari = folder.listFiles();
        Arrays.sort(ozelAnonsDosyalari, new Comparator<File>() {
            public int compare(File f1, File f2) {
                String aName = f1.getName();
                String bName = f2.getName();
                return aName.compareTo(bName);
            }
        });
        if (ozelAnonsDosyalari != null) {
            JButton[] jButtonsOzel = new JButton[ozelAnonsDosyalari.length];

            for(int i = 0; i < jButtonsOzel.length; ++i) {
                String name = ozelAnonsDosyalari[i].getName().replace(".mp3", "");
                String anonsPath = ozelAnonsDosyalari[i].getPath();
                JGradientButton btnNewButton = new JGradientButton(name, true, anonsPath, false, this.fontDefault, this.listenerOzelAnonslar);
                btnNewButton.setPreferredSize(new Dimension(175, 100));
                Font font = this.fontDefault;
                btnNewButton.setFont(font);
                ozelAnonsPanel.add(btnNewButton);
            }
        } else {
            System.out.println(path + " not found!");
        }

        return ozelAnonsPanel;
    }

    public JPanel OzelAnonlarPaneli2() {
        JPanel ozelAnonsPanel = new JPanel();
        ozelAnonsPanel.setLayout(new FlowLayout(0, 5, 5));
        ozelAnonsPanel.setBackground(this.seciliTema.ozelAnonsPanel2Background);
        String path = this.startDir + "/Anons/Ozel/ANONS 2/";
        File folder = new File(path);
        File[] ozelAnonsDosyalari = folder.listFiles();
        Arrays.sort(ozelAnonsDosyalari, new Comparator<File>() {
            public int compare(File f1, File f2) {
                String aName = f1.getName();
                String bName = f2.getName();
                return aName.compareTo(bName);
            }
        });
        if (ozelAnonsDosyalari != null) {
            JButton[] jButtonsOzel = new JButton[ozelAnonsDosyalari.length];

            for(int i = 0; i < jButtonsOzel.length; ++i) {
                String name = ozelAnonsDosyalari[i].getName().replace(".mp3", "");
                String anonsPath = ozelAnonsDosyalari[i].getPath();
                JGradientButton btnNewButton = new JGradientButton(name, true, anonsPath, false, this.fontDefault, this.listenerOzelAnonslar);
                btnNewButton.setPreferredSize(new Dimension(175, 100));
                Font font = this.fontDefault;
                btnNewButton.setFont(font);
                ozelAnonsPanel.add(btnNewButton);
            }
        } else {
            System.out.println(path + " not found!");
        }

        return ozelAnonsPanel;
    }

    public JPanel OzelAnonlarPaneli3() {
        JPanel ozelAnonsPanel = new JPanel();
        ozelAnonsPanel.setLayout(new FlowLayout(0, 5, 5));
        ozelAnonsPanel.setBackground(this.seciliTema.ozelAnonsPanel3Background);
        String path = this.startDir + "/Anons/Ozel/ANONS 3/";
        File folder = new File(path);
        File[] ozelAnonsDosyalari = folder.listFiles();
        Arrays.sort(ozelAnonsDosyalari, new Comparator<File>() {
            public int compare(File f1, File f2) {
                String aName = f1.getName();
                String bName = f2.getName();
                return aName.compareTo(bName);
            }
        });
        if (ozelAnonsDosyalari != null) {
            JButton[] jButtonsOzel = new JButton[ozelAnonsDosyalari.length];

            for(int i = 0; i < jButtonsOzel.length; ++i) {
                String name = ozelAnonsDosyalari[i].getName().replace(".mp3", "");
                String anonsPath = ozelAnonsDosyalari[i].getPath();
                JGradientButton btnNewButton = new JGradientButton(name, true, anonsPath, false, this.fontDefault, this.listenerOzelAnonslar);
                btnNewButton.setPreferredSize(new Dimension(175, 100));
                Font font = this.fontDefault;
                btnNewButton.setFont(font);
                ozelAnonsPanel.add(btnNewButton);
            }
        } else {
            System.out.println(path + " not found!");
        }

        return ozelAnonsPanel;
    }

    public JTabbedPane OzelAnonlarPaneliniGetir() {
        JTabbedPane ozelAnonsPanel = new JTabbedPane();
        ozelAnonsPanel.setForeground(this.seciliTema.tabcolor);
        ozelAnonsPanel.setBackground(this.seciliTema.ozelAnonslarPanelBackground);
        ozelAnonsPanel.setFont(this.fontDefault);
        ozelAnonsPanel.setBounds(5, 5, 790, 590);
        JPanel ozelAnons1 = this.OzelAnonlarPaneli1();
        JPanel ozelAnons2 = this.OzelAnonlarPaneli2();
        JPanel ozelAnons3 = this.OzelAnonlarPaneli3();
        ozelAnonsPanel.addTab("<html><center><br>SAYFA 1<br><br></center></html>", (Icon)null, ozelAnons1, "Sayfa1");
        ozelAnonsPanel.addTab("<html><center><br>SAYFA 2<br><br></center></html>", (Icon)null, ozelAnons2, "Sayfa2");
        ozelAnonsPanel.addTab("<html><center><br>SAYFA 3<br><br></center></html>", (Icon)null, ozelAnons3, "Sayfa3");
        return ozelAnonsPanel;	
    }

    public JPanel BaslangicAnonlariPaneliniGetir() {
        JPanel baslangicAnonslariPanel = new JPanel();
        baslangicAnonslariPanel.setLayout(new FlowLayout(0, 5, 5));
        baslangicAnonslariPanel.setBackground(this.seciliTema.baslangicAnonslariPanelBackground);
        String path = this.startDir + "/Anons/BASLANGIC/";
        baslangicAnonslariPanel.setBounds(20, 20, 700, 500);
        File folder = new File(path);
        File[] baslangicAnonsDosyalari = folder.listFiles();
        if (baslangicAnonsDosyalari != null) {
            for(int i = 0; i < baslangicAnonsDosyalari.length; ++i) {
                String name = baslangicAnonsDosyalari[i].getName().replace(".mp3", "");
                String anonsPath = baslangicAnonsDosyalari[i].getPath();
                JGradientButton btnNewButton = new JGradientButton(name, true, anonsPath, false, this.fontDefault, this.listenerOzelAnonslar);
                btnNewButton.setPreferredSize(new Dimension(150, 80));
                baslangicAnonslariPanel.add(btnNewButton);
            }
        } else {
            System.out.println(path + " not found!");
        }

        return baslangicAnonslariPanel;
    }
    public void restartApplication() throws URISyntaxException, IOException
    {
      final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
      //final String dd = MainClass.class.getProtectionDomain().getCodeSource().getLocation().toURI());
     // String current = new java.io.File( "." ).getCanonicalPath();
      final String currentJar =new java.io.File( "." ).getCanonicalPath()+"/MBS1.jar";


      /* is it a jar file? */
    /*  if(!currentJar.getName().endsWith(".jar")) {
          System.out.println("1"+currentJar);

          return;

      }*/

      /* Build command: java -jar application.jar */
      final ArrayList<String> command = new ArrayList<String>();
      command.add(javaBin);
      command.add("-jar");
      command.add(currentJar);
      System.out.println(command);
      final ProcessBuilder builder = new ProcessBuilder(command);
      builder.start();
      System.exit(0);
    }
   
   
    public JPanel TrenBilgileriPaneliGetir() {
        int line1Y = 20;
        int line2Y = 350;
        JPanel trenBilgileriPanel = new JPanel();
        this.SetTrenBilgileriStyle((JPanel)trenBilgileriPanel, "", 25, 5, 500, 500);
        JLabel label = new JLabel();
        ImageIcon iconUlasim = new ImageIcon(this.startDir + this.imageDir + "/istanbul_ulasim_mini.png");
        label.setIcon(iconUlasim);
        label.setBounds(330, 443, 157, 60);
        label.setHorizontalAlignment(0);
        label.setVerticalAlignment(0);
        trenBilgileriPanel.add(label);
        JPanel gelecekIstasyonPanel = new JPanel();
        this.SetTrenBilgileriStyle((JPanel)gelecekIstasyonPanel, "Gelecek Ýstasyon", 40, line2Y, 175, 100);
        this.lblGelecekIstasyon = new JLabel();
        this.SetTrenBilgileriStyle((JLabel)this.lblGelecekIstasyon, "", 0, 0, 175, 100);
        gelecekIstasyonPanel.setFont(this.fontDefault);

        gelecekIstasyonPanel.add(this.lblGelecekIstasyon);
        JPanel hedefIstasyonPanel = new JPanel();
        this.SetTrenBilgileriStyle((JPanel)hedefIstasyonPanel, "Hedef Ýstasyon", 220, line2Y, 175, 100);
        this.lblHedefIstasyon = new JLabel();
        this.SetTrenBilgileriStyle((JLabel)this.lblHedefIstasyon, "", 0, 0, 175, 100);

        hedefIstasyonPanel.add(this.lblHedefIstasyon);
        JPanel kalanMesafePanel = new JPanel();
        this.SetTrenBilgileriStyle((JPanel)kalanMesafePanel, "Kalan Mesafe (m)", 400, line2Y, 175, 100);
        this.lblKalanMesafe = new JLabel();
        this.SetTrenBilgileriStyle((JLabel)this.lblKalanMesafe, "", 0, 0, 175, 100);
        kalanMesafePanel.add(this.lblKalanMesafe);
        
        JPanel toplamMesafePanel = new JPanel();
        this.SetTrenBilgileriStyle((JPanel)toplamMesafePanel, "Toplam Mesafe (m)", 580, line2Y, 175, 100);
        this.lblToplamMesafe = new JLabel();
        this.SetTrenBilgileriStyle((JLabel)this.lblToplamMesafe, "", 0, 0, 175, 100);
        toplamMesafePanel.add(this.lblToplamMesafe);
        
        JPanel kapiPanel = new JPanel();
        this.SetTrenBilgileriStyle((JPanel)kapiPanel, "Kapý Durumu", 40, line1Y, 175, 100);
        this.lblKapiDurumu = new JLabel();
        this.lblKapiDurumu.setFont(fontDefault);
        this.SetTrenBilgileriStyle((JLabel)this.lblKapiDurumu, "", 0, 0, 175, 100);
        kapiPanel.add(this.lblKapiDurumu);      
        JPanel aracDurumuPanel = new JPanel();
        this.SetTrenBilgileriStyle((JPanel)aracDurumuPanel, "Araç Durumu", 220, line1Y, 175, 100);
        this.lblAracDurumu = new JLabel();
        this.SetTrenBilgileriStyle((JLabel)this.lblAracDurumu, "", 0, 0, 175, 100);

        aracDurumuPanel.add(this.lblAracDurumu);
        
        JPanel sesSeviyesiPanel = new JPanel();
        this.SetTrenBilgileriStyle((JPanel)sesSeviyesiPanel, "Ses Seviyesi Ayarý", 400, line1Y, 175, 100);
        this.lblVersion = new JLabel();
       // this.SetTrenBilgileriStyle((JLabel)this.lblVersion, this.versiyon, 0, 0, 175, 100);
        //sesSeviyesiPanel.add(this.lblVersion);

        JGradientButton sesAzaltButonu = new JGradientButton("<html><center> - </center></html>");
        sesAzaltButonu.setColors(this.seciliTema.sesAyarButonColor1, this.seciliTema.sesAyarButonColor2);
        sesAzaltButonu.setBounds(10, 25, 55, 60);
        sesAzaltButonu.setActionCommand("-");
        sesAzaltButonu.setFocusable(false);
        sesAzaltButonu.addActionListener(this.sesAzalt);
        sesSeviyesiPanel.setFont(this.fontDefault);

        sesSeviyesiPanel.add(sesAzaltButonu);
        this.lblMevcutSesSeviyesi = new JLabel("", 0);
        this.lblMevcutSesSeviyesi.setHorizontalTextPosition(0);
        this.lblMevcutSesSeviyesi.setText("%100");
        //Font f = new Font("ARIAL", 1, 14);
        this.lblMevcutSesSeviyesi.setFont(this.fontDefault);
        this.lblMevcutSesSeviyesi.setBounds(60, 25, 55, 60);
        this.lblMevcutSesSeviyesi.setForeground(this.seciliTema.sesSeviyesiForeground);
        lblMevcutSesSeviyesi.setFont(this.fontDefault);

        sesSeviyesiPanel.add(this.lblMevcutSesSeviyesi);
        JGradientButton sesArttirButonu = new JGradientButton("<html><center> + </center></html>");
        sesArttirButonu.setColors(this.seciliTema.sesAyarButonColor1, this.seciliTema.sesAyarButonColor2);
        sesArttirButonu.setBounds(110, 25, 55, 60);
        sesArttirButonu.setActionCommand("+");
        sesArttirButonu.setFocusable(false);
        sesArttirButonu.addActionListener(this.sesArttir);
        sesArttirButonu.setFont(this.fontDefault);

        sesSeviyesiPanel.add(sesArttirButonu);
       /* JPanel versiyonPanel = new JPanel();
        this.SetTrenBilgileriStyle((JPanel)versiyonPanel, "Versiyon", 400, line1Y, 175, 100);
        this.lblVersion = new JLabel();
        this.SetTrenBilgileriStyle((JLabel)this.lblVersion, this.versiyon, 0, 0, 175, 100);
        versiyonPanel.add(this.lblVersion);*/
        this.konumPanel = this.KonumPaneliGetir(40, line2Y - (line1Y + 160) - 5, 720, 160);
        this.uyariPanel = new JPanel();
        this.SetTrenBilgileriStyle((JPanel)this.uyariPanel, "BÝLGÝLENDÝRME PANOSU", 40, line2Y - (line1Y + 160) - 5, 720, 160);
        this.donusYonuSecPanel = this.DonusSeferiUyariPaneliGetir();
        this.SetTrenBilgileriStyle((JPanel)this.donusYonuSecPanel, "", 40, 150, 720, 310);
        this.donusYonuSecPanel.setVisible(false);
        this.btnAnonsKapat = new JButton("<html><center> ANONSU KAPAT </center></html>");
        this.btnAnonsKapat.setActionCommand("ANONSU KAPAT");
        this.btnAnonsKapat.setBounds(580, line1Y + 6, 175, 46);
        this.btnAnonsKapat.setBackground(this.seciliTema.anonsuKapatButonBackground);
        this.btnAnonsKapat.setForeground(this.seciliTema.anonsuKapatButonForeground);
        this.btnAnonsKapat.setFocusable(false);
        this.btnAnonsKapat.setEnabled(false);
        this.btnAnonsKapat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainClass.this.player.Stop();
            }
        });
        
      
        this.btnTakometreByPass = new JButton("<html><center> Takometre ByPass </center></html>");
        this.btnTakometreByPass.setActionCommand("Takometre ByPass");
        this.btnTakometreByPass.setBounds(580, line1Y + 52, 175, 46);
        this.btnTakometreByPass.setBackground(this.seciliTema.anonsuKapatButonBackground);
        this.btnTakometreByPass.setForeground(this.seciliTema.anonsuKapatButonForeground);
        this.btnTakometreByPass.setFocusable(false);
        this.btnTakometreByPass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	takometrePasifEt =true;
            }
        });
        this.btnTakometre = new JButton("<html><center>T</center></html>");
        this.btnTakometre.setBounds(330, 470, 40, 22);
        this.btnTakometre.setFocusable(false);
        this.btnTakometre.setBackground(Color.gray);
        this.btnTakometre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainClass.this.trenBilgileri.TakometreVerisiGuncelle();
            }
        });
        if (!OSValidator.isWindows()) {
            this.btnTakometre.setVisible(false);
        }

        this.btnTakometre.setVisible(false);
        JButton btnKapiAcKapa = new JButton("<html><center>K</center></html>");
        btnKapiAcKapa.setBounds(370, 470, 40, 22);
        btnKapiAcKapa.setBackground(Color.gray);
        btnKapiAcKapa.setFocusable(false);
        btnKapiAcKapa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (MainClass.this.trenBilgileri.getKapiDurumu()) {
                    MainClass.this.KapiDurumuDegistir(false);
                } else {
                    MainClass.this.KapiDurumuDegistir(true);
                }

            }
        });
        if (!OSValidator.isWindows()) {
            btnKapiAcKapa.setVisible(false);
        }

        btnKapiAcKapa.setVisible(false);
        JButton btnCikis = new JButton("<html><center>Ç</center></html>");
        btnCikis.setBounds(410, 470, 40, 22);
        btnCikis.setBackground(Color.gray);
        btnCikis.setFocusable(false);
        btnCikis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        if (!OSValidator.isWindows()) {
            btnCikis.setVisible(false);
        }

        btnCikis.setVisible(false);
        this.lblRotaSecimUyari = new BlinkLabel("<html><center>LÜTFEN ROTA SEÇÝNÝZ</center></html>");
        this.lblRotaSecimUyari.setBounds(0, 0, 700, 160);
        this.lblRotaSecimUyari.setHorizontalAlignment(0);
        this.lblRotaSecimUyari.setVerticalAlignment(0);
        this.lblRotaSecimUyari.setForeground(this.seciliTema.rotaSecimiUyariForeground);
        this.lblRotaSecimUyari.setBackground(this.seciliTema.rotaKurulumuPanelBackground);
        //Font fontMevcut = this.lblRotaSecimUyari.getFont().deriveFont(25.0F);
        this.lblRotaSecimUyari.setFont(this.fontDefault);
        this.lblRotaSecimUyari.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                MainClass.this.tTabbedPane.setSelectedIndex(1);
            }
        });
        this.uyariPanel.add(this.lblRotaSecimUyari);
        if (OSValidator.isWindows()) {
            this.uyariPanel.setVisible(false);
        }

        trenBilgileriPanel.add(this.donusYonuSecPanel);
        trenBilgileriPanel.add(btnCikis);
        trenBilgileriPanel.add(this.btnTakometre);
        trenBilgileriPanel.add(btnKapiAcKapa);
        trenBilgileriPanel.add(this.uyariPanel);
        trenBilgileriPanel.add(this.uyariPanel);
        trenBilgileriPanel.add(this.konumPanel);
        trenBilgileriPanel.add(this.btnAnonsKapat);
        trenBilgileriPanel.add(this.btnTakometreByPass);

        trenBilgileriPanel.add(sesSeviyesiPanel);
        trenBilgileriPanel.add(aracDurumuPanel);
        trenBilgileriPanel.add(kapiPanel);
        trenBilgileriPanel.add(toplamMesafePanel);
        trenBilgileriPanel.add(kalanMesafePanel);
        trenBilgileriPanel.add(hedefIstasyonPanel);
        trenBilgileriPanel.add(gelecekIstasyonPanel);
        return trenBilgileriPanel;
    }

    public JTabbedPane RotaPaneliGetir() {
        this.tRotaPane = new JTabbedPane();
        this.tRotaPane.setBackground(this.seciliTema.rotaPaneliBackground);
        this.tTabbedPane.setBounds(5, 5, 790, 590);
        this.tRotaPane.setFont(this.fontDefault);
        JPanel rotaKurPanel = this.RotaKurulumuPaneliniGetir();
        this.tRotaPane.setForeground(this.seciliTema.tabcolor);

        this.tRotaPane.addTab("<html><center><br>ROTA KURULUMU<br><br></center></html>", (Icon)null, rotaKurPanel, "Rota Kurulumu");
        
        this.gelecekIstasyonPanel = this.DetayliRotaPaneliniGetir();
        this.tRotaPane.addTab("<html><center><br>ARA ÝSTASYON ROTA KURULUMU<br><br></center></html>", (Icon)null, this.gelecekIstasyonPanel, "Detayli Rota");
        
        JPanel mevcutIstasyonPanel = this.MevcutIstasyonPaneliGetir();
        this.tRotaPane.addTab("<html><center><br>MEVCUT ÝSTASYON SEÇ<br><br></center></html>", (Icon)null, mevcutIstasyonPanel, "Mevcut Ýstasyonu");
        JPanel tabelaPanel = this.TabelaPaneliniGetir();
        this.tRotaPane.addTab("<html><center><br>TABELA KUR<br><br></center></html>", (Icon)null, tabelaPanel, "Tabela Kur");
       return this.tRotaPane;

    }

    public JPanel IstasyonlarPaneliniGetir() {
        JPanel istasyonAnonslariPanel = new JPanel();
        istasyonAnonslariPanel.setLayout(new FlowLayout(0, 5, 5));
        istasyonAnonslariPanel.setBackground(this.seciliTema.istasyonlarPanelBackground);
        String startDir = System.getProperty("user.dir");
        System.out.print(startDir);
        String istasyonlarPath = startDir + "/Anons/ISTASYON/";
        istasyonAnonslariPanel.setBounds(0, 0, 800, 500);
        File istasyonlarFolder = new File(istasyonlarPath);
        File[] istasyonAnonsDosyalari = istasyonlarFolder.listFiles();
        istasyonAnonsDosyalari = this.Sirala(istasyonAnonsDosyalari);
        if (jsonOku.T4_Istasyonlar_MescidiselamTopkapý.size() != 0) {
            JButton[] jButtonsOzel = new JButton[jsonOku.T4_Istasyonlar_MescidiselamTopkapý.size()];

            for(int i = 0; i < jButtonsOzel.length; ++i) {

                JGradientButton btnNewButton = new JGradientButton("<html><center>" + jsonOku.T4_Istasyonlar_MescidiselamTopkapý.get(i)+ "</center></html>");
                if(istasyonlarFolder.exists()) {                	
                }else {
                    btnNewButton.setActionCommand(istasyonAnonsDosyalari[i].getPath());
                }
                btnNewButton.setFocusable(false);
                btnNewButton.setPreferredSize(new Dimension(150, 80));
                //Font font = btnNewButton.getFont().deriveFont(13.0F);
                btnNewButton.setFont(this.fontDefault);
                btnNewButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Path:" + e.getActionCommand());
                        MainClass.this.mainIstasyonPanel.remove(0);
                        MainClass.this.mainIstasyonPanel.repaint();
                        JPanel panel = MainClass.this.IstasyonAnonslariPaneliniGetir(e.getActionCommand() + "/", ((JGradientButton)e.getSource()).getText());
                        MainClass.this.mainIstasyonPanel.add(panel);
                        MainClass.this.mainIstasyonPanel.repaint();
                    }
                });
                istasyonAnonslariPanel.add(btnNewButton);

            }
        } else {
            System.out.println(istasyonlarPath + " not found!");
        }

        return istasyonAnonslariPanel;
    }

    public JPanel IstasyonAnonslariPaneliniGetir(String path, String name) {
        JPanel anaPanel = new JPanel();
        anaPanel.setLayout((LayoutManager)null);
        anaPanel.setBackground(this.seciliTema.istasyonAnonslariPanelBackground);
        anaPanel.setBounds(0, 0, 800, 500);
        JLabel lblIstasyonAdi = new JLabel();
        lblIstasyonAdi.setText(name);
        //Font fontIsim = new Font("ARIAL", 1, 25);
        lblIstasyonAdi.setFont(this.fontDefault);
        lblIstasyonAdi.setBounds(0, 0, 800, 50);
        lblIstasyonAdi.setForeground(this.seciliTema.istasyonAnonslariIstasyonAdiForeground);
        lblIstasyonAdi.setHorizontalAlignment(0);
        lblIstasyonAdi.setVerticalAlignment(0);
        anaPanel.add(lblIstasyonAdi);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(0, 5, 5));
        panel.setBackground(this.seciliTema.istasyonAnonslariPanelBackground);
        panel.setBounds(0, 50, 800, 400);
        File istasyonlarFolder = new File(path);
        File[] istasyonAnonsDosyalari = istasyonlarFolder.listFiles();
        JGradientButton geriButonu = new JGradientButton("<html><center>GERÝ</center></html>");
        geriButonu.setFocusable(false);
        geriButonu.setActionCommand("GERÝ");
        geriButonu.setPreferredSize(new Dimension(140, 80));
        geriButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainClass.this.mainIstasyonPanel.remove(0);
                MainClass.this.mainIstasyonPanel.repaint();
                JPanel panel = MainClass.this.IstasyonlarPaneliniGetir();
                MainClass.this.mainIstasyonPanel.add(panel);
                MainClass.this.mainIstasyonPanel.repaint();
            }
        });
        ImageIcon icon = new ImageIcon(this.startDir + this.imageDir + "/backward.png");
        geriButonu.setIcon(icon);
        panel.add(geriButonu);
        if (istasyonAnonsDosyalari != null) {
            JButton[] jButtonsOzel = new JButton[istasyonAnonsDosyalari.length];
            
            for(int i = 0; i < jButtonsOzel.length; ++i) {
                JGradientButton btnNewButton = new JGradientButton("<html><center>" + istasyonAnonsDosyalari[i].getName() + "</center></html>");
                btnNewButton.setActionCommand(istasyonAnonsDosyalari[i].getPath());
                btnNewButton.setPreferredSize(new Dimension(140, 80));
                btnNewButton.setFocusable(false);
                //Font font = btnNewButton.getFont().deriveFont(13.0F);
                btnNewButton.setFont(this.fontDefault);
                btnNewButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String path = e.getActionCommand();
                        System.out.println("Path:" + path);
                        MainClass.this.tTabbedPane.requestFocus();
                        if(MainClass.this.anonsYapma==false) {
                            MainClass.this.player.Play(path);
                        }
                        MainClass.this.contentPane.requestFocus();
                        MainClass.this.tTabbedPane.setSelectedIndex(0);
                        MainClass.this.mainIstasyonPanel.remove(0);
                        MainClass.this.mainIstasyonPanel.repaint();
                        JPanel panel = MainClass.this.IstasyonlarPaneliniGetir();
                        MainClass.this.mainIstasyonPanel.add(panel);
                        MainClass.this.mainIstasyonPanel.repaint();
                    }
                });
                panel.add(btnNewButton);
            	System.out.println(btnNewButton+"111111");

            }
        } else {
            System.out.println("Path not found:" + path);
        }

        anaPanel.add(panel);
        return anaPanel;
    }

   
    
//BU KISIMDA OLACAK
    private JPanel MevcutIstasyonPaneliGetir() {
        JPanel mevcutIstasyonPanel = new JPanel();
        mevcutIstasyonPanel.setLayout(new FlowLayout(0, 5, 5));
        mevcutIstasyonPanel.setBackground(this.seciliTema.mevcutIstasyonPanelBackground);
        String startDir = System.getProperty("user.dir");
        String istasyonlarPath = startDir + "/Anons/ISTASYON/";
        mevcutIstasyonPanel.setBounds(0, 100, 800, 400);
        
        jsonOku = new JSONOku();
        jsonOku.main("/anonsName");
       // jsonYaz=new JSONYaz();
       // jsonYaz.main("/param");

       //File istasyonlarFolder = new File(istasyonlarPath);
        //File[] istasyonAnonsDosyalari = istasyonlarFolder.listFiles();
       // istasyonAnonsDosyalari = this.Sirala(istasyonAnonsDosyalari);
        if (jsonOku.istasyonSayisi != 0) {
            this.mevcutIstasyonButonlari = new JButton[jsonOku.T4_Istasyonlar_MescidiselamTopkapý.size()];
            for(int i = 0; i < this.mevcutIstasyonButonlari.length; ++i) {
                this.mevcutIstasyonButonlari[i] = new JGradientButton("<html><center>" + jsonOku.T4_Istasyonlar_MescidiselamTopkapý.get(i) + "</center></html>");
                this.mevcutIstasyonButonlari[i].setEnabled(false);
                this.mevcutIstasyonButonlari[i].setActionCommand(jsonOku.T4_Istasyonlar_MescidiselamTopkapý.get(i));
                this.mevcutIstasyonButonlari[i].setFocusable(false);
                this.mevcutIstasyonButonlari[i].setPreferredSize(new Dimension(122, 73));
                //Font font = new Font("ARIAL", 1, 12);
                this.mevcutIstasyonButonlari[i].setFont(this.fontDefault);
                this.mevcutIstasyonButonlari[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        MainClass.this.trenBilgileri.setMevcutIstasyon(e.getActionCommand());
                        //MainClass.this.trenBilgileri.setSonrakiIstasyon(e.getActionCommand());

                        MainClass.this.tTabbedPane.setSelectedIndex(0);
                    }
                });
                mevcutIstasyonPanel.add(this.mevcutIstasyonButonlari[i]);
            }
        } else {
            System.out.println(istasyonlarPath + " not found!");
        }

        return mevcutIstasyonPanel;
    }    
    
    private JPanel AyarlarPanel() {
        JPanel panel = new JPanel();
        panel.setLayout((LayoutManager)null);
        panel.setBounds(0, 0, 800, 600);
        panel.setBackground(this.seciliTema.ayarlarPaneliBackground);
        JGradientButton cikisButonu = new JGradientButton("<html><center> AYARLAR ÇIKIÞ </center></html>");
        cikisButonu.setBounds(390, 10, 180, 110);
        cikisButonu.setActionCommand("ÇIKIÞ");
        cikisButonu.setFocusable(false);
        cikisButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainClass.this.passField.setText("");
                MainClass.this.ayarlarPanel.removeAll();
                MainClass.this.ayarlarPanel.repaint();
                MainClass.this.ayarlarPanel = MainClass.this.ParolaPanel();
                MainClass.this.ayarlarPanel.repaint();
                MainClass.this.ayarlarPanel.setBackground(MainClass.this.seciliTema.ayarlarPaneliBackground);
                MainClass.this.tTabbedPane.setComponentAt(5, MainClass.this.ayarlarPanel);
            }
        });
        
        panel.add(cikisButonu);
     
        JLabel lblParlaklik = new JLabel();
        this.SetTrenBilgileriStyle((JLabel)lblParlaklik, "Ekran Parlaklýðý Ayarla", 600, 0, 180, 50);
        panel.add(lblParlaklik);

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("JSlider setting examples");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - frame.getWidth();
        int y = (int) rect.getMaxY() - frame.getHeight();;
        JPanel panelx = new JPanel();   
         JSlider slider = new JSlider(JSlider.VERTICAL,0,100,100);

         slider.setPreferredSize(new Dimension(50,340));
  
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
         
        slider.setPaintLabels(true);
        Hashtable position = new Hashtable<Integer, JLabel>();
        position.put(0, new JLabel("0"));
        position.put(10, new JLabel("10"));
        position.put(20, new JLabel("20"));
        position.put(30, new JLabel("30"));
        position.put(40, new JLabel("40"));
        position.put(50, new JLabel("50"));
        position.put(60, new JLabel("60"));
        position.put(70, new JLabel("70"));
        position.put(80, new JLabel("80"));
        position.put(90, new JLabel("90"));
        position.put(100, new JLabel("100"));
         
        slider.setLabelTable(position);

        slider.setBackground(MainClass.this.seciliTema.ayarlarPaneliBackground);
                
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int level = ((JSlider)e.getSource()).getValue();
                               
                /*try {
                	
                //	brightnessmanager.setBrightness(level);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
                
            }
        });
         
        panelx.add(slider);     
        
        // Set the window to be visible as the default to be false
        frame.add(panelx);
        frame.pack();
        
        Dimension d = panelx.getSize();
        slider.setLocation(670,50);
        frame.setVisible(false);
        panel.add(slider);
     
        JGradientButton programiKapatButonu = new JGradientButton("<html><center> PROGRAMI YENÝDEN BAÞLAT </center></html>");
        programiKapatButonu.setColors(this.seciliTema.programiKapatButonColor1, this.seciliTema.programiKapatButonColor2);
        programiKapatButonu.setBounds(390, 150, 180, 110);


        programiKapatButonu.setActionCommand("Programi Yeniden Baþlat");
        programiKapatButonu.setFocusable(false);
        programiKapatButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
           	try {                 
				restartApplication();
				} catch (URISyntaxException | IOException e1) {
					// TODO Auto-generated catch block
                    System.out.println("catch");
					e1.printStackTrace();
				}      	
            }
        });
        panel.add(programiKapatButonu);
        
        JGradientButton kalibrasyonButonu = new JGradientButton("<html><center> EKRAN KALÝBRASYONU </center></html>");
        kalibrasyonButonu.setBounds(10, 10, 180, 110);
        kalibrasyonButonu.setActionCommand("KALÝBRASYON");
        kalibrasyonButonu.setFocusable(false);
        kalibrasyonButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ProcessBuilder builder = new ProcessBuilder(new String[]{"xinput_calibrator"});
                    builder.redirectErrorStream(true);
                    Process process = builder.start();
                    InputStream is = process.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String line = null;
                    System.out.println("MBS Calibration Output:");

                    while((line = reader.readLine()) != null) {
                        if (line.contains("Option") && line.contains("Calibration")) {
                            String newStr = line.replace("Option", "");
                            newStr = newStr.replace("Calibration", "");
                            newStr = newStr.replace("\"", "");
                            newStr = newStr.trim();
                            System.out.println("New String: " + newStr);
                            String[] splitted = newStr.split(" ");
                            System.out.println("Length: " + splitted.length);
                            if (splitted.length == 4) {
                                System.out.println("min_x: " + splitted[0]);
                                System.out.println("max_x: " + splitted[1]);
                                System.out.println("min_y: " + splitted[2]);
                                System.out.println("max_y: " + splitted[3]);
                                MainClass.this.KalibrasyonuAyarla(splitted[0], splitted[1], splitted[2], splitted[3]);
                            }
                        }
                    }
                } catch (Exception var9) {
                    var9.printStackTrace();
                }

            }
        });
        panel.add(kalibrasyonButonu);
        JGradientButton kalibrasyonSifirlaButonu = new JGradientButton("<html><center> KALÝBRASYON RESET </center></html>");
        kalibrasyonSifirlaButonu.setBounds(200, 10, 180, 110);
        kalibrasyonSifirlaButonu.setActionCommand("KALÝBRASYON");
        kalibrasyonSifirlaButonu.setFocusable(false);
        kalibrasyonSifirlaButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!OSValidator.isWindows()) {
                        MainClass.this.KalibrasyonuSifirla();
                        String[] co = new String[]{"/bin/sh", "-c", "sudo reboot"};
                        Runtime.getRuntime().exec(co);
                    }
                } catch (Exception var3) {
                    var3.printStackTrace();
                }

            }
        });
        panel.add(kalibrasyonSifirlaButonu);
        JGradientButton trenNumaraAyarButonu = new JGradientButton("<html><center> TREN NUMARASI AYARI </center></html>");
        trenNumaraAyarButonu.setBounds(10, 150, 180, 110);
        trenNumaraAyarButonu.setActionCommand("TREN NO AYAR");
        trenNumaraAyarButonu.setFocusable(false);
        trenNumaraAyarButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainClass.this.ayarlarPanel.repaint();
                MainClass.this.ayarlarPanel = MainClass.this.TrenNoAyarPaneli();
                MainClass.this.ayarlarPanel.repaint();
                MainClass.this.ayarlarPanel.setBackground(MainClass.this.seciliTema.ayarlarPaneliBackground);
                MainClass.this.tTabbedPane.setComponentAt(5, MainClass.this.ayarlarPanel);
            }
        });
        panel.add(trenNumaraAyarButonu);
        JLabel lblTrenNumarasi = new JLabel();
        this.SetTrenBilgileriStyle((JLabel)lblTrenNumarasi, "Tren No:", 640, 440, 100, 50);
        panel.add(lblTrenNumarasi);
        this.trenNumarasiVal = new JLabel();
        String trenNo = this.TrenNoGetir();
        this.SetTrenBilgileriStyle((JLabel)this.trenNumarasiVal, trenNo, 710, 440, 60, 50);
        panel.add(this.trenNumarasiVal);
        //JPanel sesPanel = this.SesSeviyesiPaneli();
        //panel.add(sesPanel);
        JPanel versiyonPanel = this.VersiyonPanelPaneli();
        panel.add(versiyonPanel);
        
        JGradientButton anonsArýzaButonu = new JGradientButton("<html><center> Arýza Bildir  </center></html>");
        anonsArýzaButonu.setColors(this.seciliTema.programiKapatButonColor1, this.seciliTema.arizaAnonsButonColor1);

        anonsArýzaButonu.setBounds(200, 150, 180, 110);
        anonsArýzaButonu.setActionCommand("Arýza Anons");
        anonsArýzaButonu.setFocusable(false);
        anonsArýzaButonu.addActionListener(new ActionListener() {
        	  public void actionPerformed(ActionEvent e) {  
        	        ePostaYolla = new EPostaYolla();
        	        ePostaYolla.EPostaYolla();
      				
                  }
        });
        panel.add(anonsArýzaButonu);
        return panel;
    }
    
    private JPanel VersiyonPanelPaneli() {
    	 JPanel versiyonPanel = new JPanel();
         this.SetTrenBilgileriStyle((JPanel)versiyonPanel, "Versiyon", 10, 380, 175, 100);
         this.lblVersion = new JLabel();
         this.SetTrenBilgileriStyle((JLabel)this.lblVersion, this.versiyon, 0, 0, 175, 100);
         versiyonPanel.add(this.lblVersion);
         return versiyonPanel;

    }

    private JPanel SesSeviyesiPaneli() {
        JPanel sesSeviyesiPanel = new JPanel();
        this.SetTrenBilgileriStyle((JPanel)sesSeviyesiPanel, "SES SEVÝYESÝ AYARI", 280, 380, 220, 100);
        JGradientButton sesAzaltButonu = new JGradientButton("<html><center> - </center></html>");
        sesAzaltButonu.setColors(this.seciliTema.sesAyarButonColor1, this.seciliTema.sesAyarButonColor2);
        sesAzaltButonu.setBounds(20, 30, 60, 60);
        sesAzaltButonu.setActionCommand("-");
        sesAzaltButonu.setFocusable(false);
        sesAzaltButonu.addActionListener(this.sesAzalt);
        sesAzaltButonu.setFont(fontDefault);
        sesSeviyesiPanel.add(sesAzaltButonu);
        
        this.lblMevcutSesSeviyesi = new JLabel("", 0);
        this.lblMevcutSesSeviyesi.setHorizontalTextPosition(0);
        this.lblMevcutSesSeviyesi.setText("%100");
        Font f = new Font("ARIAL", 1, 14);
        this.lblMevcutSesSeviyesi.setFont(f);
        this.lblMevcutSesSeviyesi.setBounds(80, 30, 60, 60);
        this.lblMevcutSesSeviyesi.setForeground(this.seciliTema.sesSeviyesiForeground);
        sesSeviyesiPanel.add(this.lblMevcutSesSeviyesi);
        JGradientButton sesArttirButonu = new JGradientButton("<html><center> + </center></html>");
        sesArttirButonu.setColors(this.seciliTema.sesAyarButonColor1, this.seciliTema.sesAyarButonColor2);
        sesArttirButonu.setBounds(140, 30, 60, 60);
        sesArttirButonu.setActionCommand("+");
        sesArttirButonu.setFocusable(false);
        sesArttirButonu.addActionListener(this.sesArttir);
        sesSeviyesiPanel.add(sesArttirButonu);
        return sesSeviyesiPanel;
    }

    private JPanel ParolaPanel() {
        JPanel panel = new JPanel();
        panel.setLayout((LayoutManager)null);
        panel.setBounds(0, 0, 800, 600);
        panel.setBackground(this.seciliTema.ayarlarPaneliBackground);
        //Font font = new Font("ARIAL", 1, 16);
        //Font fontHata = new Font("ARIAL", 1, 25);
        this.lblParolaBilgi = new JLabel();
        this.lblParolaBilgi.setBounds(550, 180, 250, 50);
        this.lblParolaBilgi.setText("Parola Yanlýþ!");
        this.lblParolaBilgi.setVisible(false);
        this.lblParolaBilgi.setFont(this.fontDefault);
        panel.add(this.lblParolaBilgi);
        this.passField = new JPasswordField();
        this.passField.setBounds(250, 10, 240, 50);
        this.passField.setFont(this.fontDefault);
        panel.add(this.passField);
        JGradientButton[] btnNumpad = new JGradientButton[13];

        for(int i = 0; i < btnNumpad.length; ++i) {
            String text = "";
            if (i < 9) {
                text = String.valueOf(i + 1);
            } else if (i == 9) {
                text = "Sil";
            } else if (i == 10) {
                text = "0";
            } else if (i == 11) {
                text = "Ýptal";
            } else if (i == 12) {
                text = "ONAY";
            }

            btnNumpad[i] = new JGradientButton("<html><center>" + text + "</center></html>");
            if (i == 12) {
                btnNumpad[i].setBounds(250, 395, 240, 80);
            } else {
                btnNumpad[i].setBounds(250 + i % 3 * 80, 70 + i / 3 * 80, 80, 80);
            }

            btnNumpad[i].setFocusable(false);
            btnNumpad[i].setFont(this.fontDefault);
            btnNumpad[i].setActionCommand(text);
            btnNumpad[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String passText = MainClass.this.passField.getText();
                    if (e.getActionCommand().equals("Ýptal")) {
                        MainClass.this.passField.setText("");
                    } else if (e.getActionCommand().equals("Sil")) {
                        if (passText.length() > 0) {
                            MainClass.this.passField.setText(passText.substring(0, passText.length() - 1));
                        }
                    } else if (e.getActionCommand().equals("ONAY")) {
                        if (MainClass.this.passField.getText().equals("5357")) {
                            MainClass.this.sesSeviyesi = MainClass.this.SesSeviyesiGetir();
                            System.out.println("GÝRÝÞ ONAYLANDI");
                            MainClass.this.lblParolaBilgi.setVisible(false);
                            MainClass.this.ayarlarPanel.removeAll();
                            MainClass.this.ayarlarPanel.repaint();
                            MainClass.this.ayarlarPanel = MainClass.this.AyarlarPanel();
                            MainClass.this.ayarlarPanel.repaint();
                            MainClass.this.tTabbedPane.setComponentAt(5, MainClass.this.ayarlarPanel);
                            if (MainClass.this.lblMevcutSesSeviyesi != null) {
                                System.out.println("Ses seviyesi: " + MainClass.this.sesSeviyesi);
                                MainClass.this.lblMevcutSesSeviyesi.setText(MainClass.this.sesSeviyesi);
                            }
                        } else {
                            MainClass.this.lblParolaBilgi.setVisible(true);
                        }
                    } else {
                        MainClass.this.passField.setText(MainClass.this.passField.getText() + e.getActionCommand());
                    }

                }
            });
            panel.add(btnNumpad[i]);
        }

        return panel;
    }

    private JPanel TrenNoAyarPaneli() {
        JPanel panel = new JPanel();
        panel.setLayout((LayoutManager)null);
        panel.setBounds(0, 0, 800, 600);
        //Font font = new Font("ARIAL", 1, 16);
        JLabel lblTrenNoLabel = new JLabel();
        lblTrenNoLabel.setBounds(140, 10, 120, 50);
        lblTrenNoLabel.setText("TREN NUMARASI:");
        lblTrenNoLabel.setForeground(this.seciliTema.sesSeviyesiForeground);
        panel.add(lblTrenNoLabel);
        this.lblTrenNoInfoLabel = new JLabel();
        this.lblTrenNoInfoLabel.setBounds(500, 10, 250, 50);
        this.lblTrenNoInfoLabel.setText("Tren numarasý geçersiz!");
        this.lblTrenNoInfoLabel.setVisible(false);
        panel.add(this.lblTrenNoInfoLabel);
        this.trenNoField = new JTextField();
        this.trenNoField.setBounds(250, 10, 240, 50);
        this.trenNoField.setFont(this.fontDefault);
        panel.add(this.trenNoField);
        JGradientButton[] btnNumpad = new JGradientButton[14];

        for(int i = 0; i < btnNumpad.length; ++i) {
            String text = "";
            if (i < 9) {
                text = String.valueOf(i + 1);
            } else if (i == 9) {
                text = "Sil";
            } else if (i == 10) {
                text = "0";
            } else if (i == 11) {
                text = "Ýptal";
            } else if (i == 12) {
                text = "ONAY";
            } else if (i == 13) {
                text = "ÇIKIÞ";
            }

            btnNumpad[i] = new JGradientButton("<html><center>" + text + "</center></html>");
            if (i == 12) {
                btnNumpad[i].setBounds(250, 395, 118, 80);
            } else if (i == 13) {
                btnNumpad[i].setBounds(372, 395, 118, 80);
            } else {
                btnNumpad[i].setBounds(250 + i % 3 * 80, 70 + i / 3 * 80, 80, 80);
            }

            btnNumpad[i].setFocusable(false);
            btnNumpad[i].setFont(this.fontDefault);
            btnNumpad[i].setActionCommand(text);
            btnNumpad[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String trenNoText = MainClass.this.trenNoField.getText();
                    if (e.getActionCommand().equals("Ýptal")) {
                        MainClass.this.trenNoField.setText("");
                    } else if (e.getActionCommand().equals("Sil")) {
                        if (trenNoText.length() > 0) {
                            MainClass.this.trenNoField.setText(trenNoText.substring(0, trenNoText.length() - 1));
                        }
                    } else if (e.getActionCommand().equals("ONAY")) {
                        String strTrenNo = MainClass.this.trenNoField.getText();
                        int trenNo = -1;
                        if (strTrenNo != "") {
                            trenNo = Integer.parseInt(strTrenNo);
                        }

                        if (trenNo >= 499 && trenNo <= 575) {
                            String[] texts = MainClass.this.EthernetAyarMetniOlustur(trenNo);
                            MainClass.this.EthernetAyariYap(texts);
                            MainClass.this.TrenNoKaydet(String.valueOf(trenNo));
                            MainClass.this.lblTrenNoInfoLabel.setVisible(false);
                            MainClass.this.ayarlarPanel.removeAll();
                            MainClass.this.ayarlarPanel.repaint();
                            MainClass.this.ayarlarPanel = MainClass.this.AyarlarPanel();
                            MainClass.this.ayarlarPanel.repaint();
                            if (MainClass.this.lblMevcutSesSeviyesi != null) {
                                System.out.println("Ses seviyesi: " + MainClass.this.sesSeviyesi);
                                MainClass.this.lblMevcutSesSeviyesi.setText(MainClass.this.sesSeviyesi);
                            }

                            MainClass.this.tTabbedPane.setComponentAt(5, MainClass.this.ayarlarPanel);
                        } else {
                            MainClass.this.lblTrenNoInfoLabel.setVisible(true);
                        }
                    } else if (e.getActionCommand().equals("ÇIKIÞ")) {
                        MainClass.this.trenNoField.setText("");
                        MainClass.this.ayarlarPanel.removeAll();
                        MainClass.this.ayarlarPanel.repaint();
                        MainClass.this.ayarlarPanel = MainClass.this.AyarlarPanel();
                        MainClass.this.ayarlarPanel.repaint();
                        if (MainClass.this.lblMevcutSesSeviyesi != null) {
                            System.out.println("Ses seviyesi: " + MainClass.this.sesSeviyesi);
                            MainClass.this.lblMevcutSesSeviyesi.setText(MainClass.this.sesSeviyesi);
                        }

                        MainClass.this.tTabbedPane.setComponentAt(5, MainClass.this.ayarlarPanel);
                    } else if (trenNoText.length() < 3) {
                        MainClass.this.trenNoField.setText(MainClass.this.trenNoField.getText() + e.getActionCommand());
                    }

                }
            });
            panel.add(btnNumpad[i]);
        }

        return panel;
    }

    public JPanel KonumPaneliGetir(int x, int y, int w, int h) {
        JPanel kPanel = new JPanel();
        kPanel.setLayout((LayoutManager)null);
        kPanel.setBounds(x, y, w, h);
        TitledBorder titledBorder = BorderFactory.createTitledBorder("KONUM");
        kPanel.setBorder(titledBorder);
        titledBorder.setTitleColor(this.seciliTema.titledBorderTextColor);
        kPanel.setBackground(this.seciliTema.konumPanelBackground);
        String startDir = System.getProperty("user.dir");
        JLabel lblBaslangic = new JLabel();
        String picPath = startDir + this.imageDir + "/ppoint.png";
        lblBaslangic.setIcon(new ImageIcon(picPath));
        lblBaslangic.setBounds(25, 20, 50, 100);
        lblBaslangic.setHorizontalAlignment(4);
        lblBaslangic.setVerticalAlignment(1);
        this.lblBaslangicKonum = new JLabel();
        this.lblBaslangicKonum.setText("BASLANGIC");
        this.lblBaslangicKonum.setFont(this.fontDefault);
        this.lblBaslangicKonum.setBounds(5, 95, 100, 100);
        this.lblBaslangicKonum.setForeground(this.seciliTema.konumPanelForeground);
        this.lblBaslangicKonum.setHorizontalAlignment(0);
        this.lblBaslangicKonum.setVerticalAlignment(1);
        JLabel lblMevcut = new JLabel();
        picPath = startDir + this.imageDir + "/ppoint.png";
        lblMevcut.setIcon(new ImageIcon(picPath));
        lblMevcut.setBounds(220, 20, 50, 100);
        lblMevcut.setHorizontalAlignment(0);
        lblMevcut.setVerticalAlignment(1);
        this.lblMevcutKonum = new JLabel();
        this.lblMevcutKonum.setText("MEVCUT");
        this.lblMevcutKonum.setFont(this.fontDefault);
        this.lblMevcutKonum.setBounds(195, 95, 100, 100);
        this.lblMevcutKonum.setForeground(this.seciliTema.konumPanelForeground);
        this.lblMevcutKonum.setHorizontalAlignment(0);
        this.lblMevcutKonum.setVerticalAlignment(1);
        JLabel lblGelecek = new JLabel();
        picPath = startDir + this.imageDir + "/ppoint.png";
        lblGelecek.setIcon(new ImageIcon(picPath));
        lblGelecek.setBounds(430, 20, 50, 100);
        lblGelecek.setHorizontalAlignment(0);
        lblGelecek.setVerticalAlignment(1);
        this.lblGelecekKonum = new JLabel();
        this.lblGelecekKonum.setText("GELECEK");
        this.lblGelecekKonum.setFont(this.fontDefault);
        this.lblGelecekKonum.setBounds(410, 95, 100, 100);
        this.lblGelecekKonum.setForeground(this.seciliTema.konumPanelForeground);
        this.lblGelecekKonum.setHorizontalAlignment(0);
        this.lblGelecekKonum.setVerticalAlignment(1);
        JLabel lblHedef = new JLabel();
        picPath = startDir + this.imageDir + "/ppoint.png";
        lblHedef.setIcon(new ImageIcon(picPath));
        lblHedef.setBounds(630, 20, 50, 100);
        lblHedef.setHorizontalAlignment(4);
        lblHedef.setVerticalAlignment(1);
        this.lblHedefKonum = new JLabel();
        this.lblHedefKonum.setText("HEDEF");
        this.lblHedefKonum.setFont(this.fontDefault);
        this.lblHedefKonum.setBounds(605, 95, 100, 100);
        this.lblHedefKonum.setForeground(this.seciliTema.konumPanelForeground);
        this.lblHedefKonum.setHorizontalAlignment(0);
        this.lblHedefKonum.setVerticalAlignment(1);
        JLabel lblLine = new JLabel();
        picPath = startDir + this.imageDir + "/line1.png";
        lblLine.setIcon(new ImageIcon(picPath));
        lblLine.setBounds(40, 68, 620, 50);
        lblLine.setHorizontalAlignment(0);
        lblLine.setVerticalAlignment(0);
        kPanel.add(lblBaslangic);
        kPanel.add(this.lblBaslangicKonum);
        kPanel.add(lblMevcut);
        kPanel.add(this.lblMevcutKonum);
        kPanel.add(lblGelecek);
        kPanel.add(this.lblGelecekKonum);
        kPanel.add(lblHedef);
        kPanel.add(this.lblHedefKonum);
        kPanel.add(lblLine);
        return kPanel;
    }

    private JPanel RotaKurulumuPaneliniGetir() {
        int startX = 0;
        int startY = 35;
        JPanel panel = new JPanel();
        panel.setLayout((LayoutManager)null);
        panel.setBounds(0, 0, 800, 600);
        panel.setBackground(this.seciliTema.rotaKurulumuPanelBackground);
        //Font font = new Font("ARIAL", 1, 13);
        //Font fontLabel = new Font("ARIAL", 1, 16);
        String duzCizgiKonum = this.startDir + this.imageDir + "/duzCizgi.png";
        this.btnMescid = new JGradientButton("<html><center>MESCIDI SELAM</center></html>");
        this.btnMescid.setBounds(startX + 30, startY + 130, 130, 70);
        this.btnMescid.setActionCommand("MESCIDI SELAM");
        this.btnMescid.setFocusable(false);
        this.btnMescid.setPreferredSize(new Dimension(150, 80));
        this.btnMescid.setFont(this.fontDefault);
        this.btnMescid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton srcButton = (JButton)e.getSource();
                MainClass var10000;
                if (MainClass.this.rotaSecilenIstasyon == 0) {
                    srcButton.setEnabled(false);
                    MainClass.this.lblRotaBaslangic.setText(e.getActionCommand());
                    var10000 = MainClass.this;
                    var10000.rotaSecilenIstasyon = var10000.rotaSecilenIstasyon + 1;
                    MainClass.this.lblRotaUyari.setText("HEDEF ÝSTASYONU SEÇÝNÝZ");
                } else if (MainClass.this.rotaSecilenIstasyon == 1) {
                    srcButton.setEnabled(false);
                    MainClass.this.lblRotaHedef.setText(e.getActionCommand());
                    var10000 = MainClass.this;
                    var10000.rotaSecilenIstasyon = var10000.rotaSecilenIstasyon + 1;
                    MainClass.this.lblRotaUyari.setText("");
                    MainClass.this.btnOnay.setEnabled(true);
                }

            }
        });
        panel.add(this.btnMescid);
      
        this.btnTopkapý = new JGradientButton("<html><center> TOPKAPI </center></html>");
        this.btnTopkapý.setBounds(startX + 600, startY + 130, 130, 70);
        this.btnTopkapý.setActionCommand("TOPKAPI");
        this.btnTopkapý.setFocusable(false);
        this.btnTopkapý.setPreferredSize(new Dimension(150, 80));
        this.btnTopkapý.setFont(this.fontDefault);
        this.btnTopkapý.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton srcButton = (JButton)e.getSource();
                MainClass var10000;
                if (MainClass.this.rotaSecilenIstasyon == 0) {
                    srcButton.setEnabled(false);
                    MainClass.this.lblRotaBaslangic.setText(e.getActionCommand());
                    var10000 = MainClass.this;
                    var10000.rotaSecilenIstasyon = var10000.rotaSecilenIstasyon + 1;
                    MainClass.this.lblRotaUyari.setText("HEDEF ÝSTASYONU SEÇÝNÝZ");
                } else if (MainClass.this.rotaSecilenIstasyon == 1) {
                    srcButton.setEnabled(false);
                    MainClass.this.lblRotaHedef.setText(e.getActionCommand());
                    var10000 = MainClass.this;
                    var10000.rotaSecilenIstasyon = var10000.rotaSecilenIstasyon + 1;
                    MainClass.this.lblRotaUyari.setText("");
                    MainClass.this.btnOnay.setEnabled(true);
                }

            }
        });
        panel.add(this.btnTopkapý);
      
        JGradientButton btnMevcutRotaIptal = new JGradientButton("<html><center> MEVCUT ROTAYI SÝL </center></html>");
        btnMevcutRotaIptal.setColors(this.seciliTema.mevcutRotaIptalButtonColor1, this.seciliTema.mevcutRotaIptalButtonColor2);
        btnMevcutRotaIptal.setBounds(startX + 30, startY + 330, 180, 50);
        btnMevcutRotaIptal.setActionCommand("MEVCUT ROTAYI SÝL");
        btnMevcutRotaIptal.setFocusable(false);
        btnMevcutRotaIptal.setPreferredSize(new Dimension(150, 80));
        btnMevcutRotaIptal.setFont(this.fontDefault);
        btnMevcutRotaIptal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainClass.this.trenBilgileri.setRotaBilgileri("", "", "", MainClass.this.takometrePasifEt);
                MainClass.this.tTabbedPane.setSelectedIndex(0);
                MainClass.this.contentPane.requestFocus();
            }
        });
        panel.add(btnMevcutRotaIptal);
        JLabel lblDuzCizgi1 = new JLabel();
        lblDuzCizgi1.setIcon(new ImageIcon(duzCizgiKonum));
        lblDuzCizgi1.setBounds(startX + 100, startY + 120 + 40, 220, 10);
        lblDuzCizgi1.setHorizontalAlignment(0);
        lblDuzCizgi1.setVerticalAlignment(1);
        panel.add(lblDuzCizgi1);
        JLabel lblDuzCizgi2 = new JLabel();
        lblDuzCizgi2.setIcon(new ImageIcon(duzCizgiKonum));
        lblDuzCizgi2.setBounds(startX + 250, startY + 120 + 40, 220, 10);
        lblDuzCizgi2.setHorizontalAlignment(0);
        lblDuzCizgi2.setVerticalAlignment(1);
        panel.add(lblDuzCizgi2);
        JLabel lblDuzCizgi3 = new JLabel();
        lblDuzCizgi3.setIcon(new ImageIcon(duzCizgiKonum));
        lblDuzCizgi3.setBounds(startX + 380, startY + 120 + 40, 220, 10);
        lblDuzCizgi3.setHorizontalAlignment(0);
        lblDuzCizgi3.setVerticalAlignment(1);
        panel.add(lblDuzCizgi3);
        JPanel rotaBilgiPanel = new JPanel();
        rotaBilgiPanel.setLayout((LayoutManager)null);
        rotaBilgiPanel.setBorder(BorderFactory.createTitledBorder(""));
        rotaBilgiPanel.setBackground(this.seciliTema.rotaBilgiPaneliBackground);
        rotaBilgiPanel.setBounds(75, 10, 590, 75);
        panel.add(rotaBilgiPanel);
        this.lblRotaUyari = new BlinkLabel("BAÞLANGIÇ ÝSTASYONU SEÇÝNÝZ");
        this.lblRotaUyari.setFont(this.fontDefault);
        this.lblRotaUyari.setFont(this.lblRotaUyari.getFont().deriveFont(16).deriveFont(1));
        this.lblRotaUyari.setBounds(5, 135, 275, 20);
        this.lblRotaUyari.setHorizontalAlignment(0);
        JLabel lblBaslangic = new JLabel();
        lblBaslangic.setText("Baþlangýç Ýstasyonu:");
        lblBaslangic.setBounds(10, 2, 200, 40);
        lblBaslangic.setForeground(this.seciliTema.rotaBilgiPaneliForegound);
        rotaBilgiPanel.add(lblBaslangic);
        this.lblRotaBaslangic = new JLabel();
        this.lblRotaBaslangic.setText("-");
        this.lblRotaBaslangic.setBounds(170, 2, 200, 40);
        this.lblRotaBaslangic.setHorizontalAlignment(2);
        this.lblRotaBaslangic.setForeground(this.seciliTema.rotaBilgiPaneliForegound);
        rotaBilgiPanel.add(this.lblRotaBaslangic);
        JLabel lblHedef = new JLabel();
        lblHedef.setText("Hedef Ýstasyonu:");
        lblHedef.setBounds(10, 30, 200, 40);
        lblHedef.setForeground(this.seciliTema.rotaBilgiPaneliForegound);
        rotaBilgiPanel.add(lblHedef);
        this.lblRotaHedef = new JLabel();
        this.lblRotaHedef.setText("-");
        this.lblRotaHedef.setBounds(170, 30, 200, 40);
        this.lblRotaHedef.setHorizontalAlignment(2);
        this.lblRotaHedef.setForeground(this.seciliTema.rotaBilgiPaneliForegound);
        rotaBilgiPanel.add(this.lblRotaHedef);
        this.btnOnay = new JGradientButton("<html><center> ONAY </center></html>");
        this.btnOnay.setBounds(345, 10, 115, 50);
        this.btnOnay.setActionCommand("ONAY");
        this.btnOnay.setFocusable(false);
        this.btnOnay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainClass.this.trenBilgileri.setRotaBilgileri(MainClass.this.lblRotaBaslangic.getText(), MainClass.this.lblRotaBaslangic.getText(), MainClass.this.lblRotaHedef.getText(),MainClass.this.takometrePasifEt);
                MainClass.this.lblRotaBaslangic.setText("-");
                MainClass.this.lblRotaHedef.setText("-");
                MainClass.this.rotaSecilenIstasyon = 0;
                MainClass.this.btnMescid.setEnabled(true);
                MainClass.this.btnTopkapý.setEnabled(true);
                MainClass.this.btnOnay.setEnabled(false);
                MainClass.this.lblRotaUyari.setText("BAÞLANGIÇ ÝSTASYONU SEÇÝNÝZ");
                MainClass.this.tTabbedPane.setSelectedIndex(0);
                if (!MainClass.this.mevcutRota.equals(Rotalar.GECERSÝZ)) {
                    MainClass.this.mevcutRota.equals(Rotalar.SECILMEDI);
                }

                MainClass.this.BaslangicAnonsuYap(MainClass.this.trenBilgileri.getHedefIstasyon(), MainClass.this.trenBilgileri.getMevcutIstasyon());
                MainClass.this.MevcutIstasyonButonKontrol();
            }
        });
        ImageIcon iconOnay = new ImageIcon(this.startDir + this.imageDir + "/onay.png");
        this.btnOnay.setIcon(iconOnay);
        this.btnOnay.setEnabled(false);
        rotaBilgiPanel.add(this.btnOnay);
        this.btnIptal = new JGradientButton("<html><center> ÝPTAL </center></html>");
        this.btnIptal.setBounds(465, 10, 115, 50);
        this.btnIptal.setActionCommand("ÝPTAL");
        this.btnIptal.setFocusable(false);
        this.btnIptal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainClass.this.lblRotaBaslangic.setText("-");
                MainClass.this.lblRotaHedef.setText("-");
                MainClass.this.rotaSecilenIstasyon = 0;
                MainClass.this.btnMescid.setEnabled(true);
                MainClass.this.btnTopkapý.setEnabled(true);
                MainClass.this.btnOnay.setEnabled(false);
                MainClass.this.lblRotaUyari.setText("BAÞLANGIÇ ÝSTASYONU SEÇÝNÝZ");
            }
        });
        ImageIcon iconIptal = new ImageIcon(this.startDir + this.imageDir + "/iptal.png");
        this.btnIptal.setIcon(iconIptal);
        rotaBilgiPanel.add(this.btnIptal);
        return panel;
    }

    public JPanel DetayliRotaPaneliniGetir() {
        JPanel istasyonAnonslariAnaPanel = new JPanel();
        istasyonAnonslariAnaPanel.setLayout((LayoutManager)null);
        istasyonAnonslariAnaPanel.setBackground(this.seciliTema.detayliRotaAnaPanelBackground);
        istasyonAnonslariAnaPanel.setBounds(0, 0, 800, 500);
        this.istasyonAnonslariPanel = new JPanel();
        this.istasyonAnonslariPanel.setLayout(new FlowLayout(0, 5, 5));
        this.istasyonAnonslariPanel.setBackground(this.seciliTema.detayliRotaIstasyonPanelBackground);
        String istasyonlarPath = this.startDir + "/Anons/ISTASYON/";
        

        this.istasyonAnonslariPanel.setBounds(0, 100, 800, 400);
        File istasyonlarFolder = new File(istasyonlarPath);
        File[] istasyonAnonsDosyalari = istasyonlarFolder.listFiles();
        istasyonAnonsDosyalari = this.Sirala(istasyonAnonsDosyalari);
        if (istasyonAnonsDosyalari != null) {
            JButton[] jButtonsOzel = new JButton[istasyonAnonsDosyalari.length];

            for(int i = 0; i < jButtonsOzel.length; ++i) {
                JGradientButton btnNewButton = new JGradientButton(istasyonAnonsDosyalari[i].getName(), true, istasyonAnonsDosyalari[i].getName(), false, this.fontDefault, this.listenerDetayliRota);
                btnNewButton.setPreferredSize(new Dimension(122, 73));
                this.istasyonAnonslariPanel.add(btnNewButton);
            }
        } else {
            System.out.println(istasyonlarPath + " not found!");
        }

        JPanel rotaBilgiPanel = new JPanel();
        rotaBilgiPanel.setLayout((LayoutManager)null);
        rotaBilgiPanel.setBorder(BorderFactory.createTitledBorder(""));
        rotaBilgiPanel.setBackground(this.seciliTema.rotaBilgiPaneliBackground);
        rotaBilgiPanel.setBounds(75, 10, 590, 75);
        istasyonAnonslariAnaPanel.add(rotaBilgiPanel);
        JLabel lblBaslangic = new JLabel();
        lblBaslangic.setText("Mevcut Ýstasyonu:");
        lblBaslangic.setBounds(10, 2, 200, 40);
        lblBaslangic.setForeground(this.seciliTema.rotaBilgiPaneliForegound);
        this.lblDetayliRotaMevcutIstasyon = new JLabel();
        this.lblDetayliRotaMevcutIstasyon.setText("-");
        this.lblDetayliRotaMevcutIstasyon.setBounds(170, 2, 200, 40);
        this.lblDetayliRotaMevcutIstasyon.setHorizontalAlignment(2);
        this.lblDetayliRotaMevcutIstasyon.setForeground(this.seciliTema.rotaBilgiPaneliForegound);
        JLabel lblHedef = new JLabel();
        lblHedef.setText("Hedef Ýstasyonu:");
        lblHedef.setBounds(10, 30, 200, 40);
        lblHedef.setForeground(this.seciliTema.rotaBilgiPaneliForegound);
        this.lblDetayliRotaHedef = new JLabel();
        this.lblDetayliRotaHedef.setText("-");
        this.lblDetayliRotaHedef.setBounds(170, 30, 200, 40);
        this.lblDetayliRotaHedef.setHorizontalAlignment(2);
        this.lblDetayliRotaHedef.setForeground(this.seciliTema.rotaBilgiPaneliForegound);
        this.btnDetayliRotaOnay = new JGradientButton("ONAY", true, "ONAY", false, this.fontDefault, this.listenerDetayliRotaOnay, this.iconOnay, 345, 10, 115, 50);
        this.btnDetayliRotaOnay.setEnabled(false);
        this.btnDetayliRotaIptal = new JGradientButton("ÝPTAL", true, "ÝPTAL", false, this.fontDefault, this.listenerDetayliRotaIptal, this.iconIptal, 465, 10, 115, 50);
        rotaBilgiPanel.add(lblBaslangic);
        rotaBilgiPanel.add(this.lblDetayliRotaMevcutIstasyon);
        rotaBilgiPanel.add(lblHedef);
        rotaBilgiPanel.add(this.lblDetayliRotaHedef);
        rotaBilgiPanel.add(this.btnDetayliRotaOnay);
        rotaBilgiPanel.add(this.btnDetayliRotaIptal);
        istasyonAnonslariAnaPanel.add(this.istasyonAnonslariPanel);
        return istasyonAnonslariAnaPanel;
    }

    public void InitializeIO() {
        //this.kapiButonu = this.gpio.provisionDigitalInputPin(RaspiPin.GPIO_29, PinPullResistance.PULL_UP);
        //this.takometre = this.gpio.provisionDigitalInputPin(RaspiPin.GPIO_28, PinPullResistance.PULL_UP);
   	 //  GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
      // this.gpio = GpioFactory.getInstance();
       //GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
  	    this.gpio = GpioFactory.getInstance();
      //  this.amplifikator = this.gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_26, PinState.LOW);
       // this.amplifikator=this.gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_26, PinState.LOW);
        this.amplifikator = this.gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, PinState.LOW);

        //this.amplifikator = this.gpio.provisionDigitalOutputPin(RaspiPin.GPIO_19, PinState.LOW);
//GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, "name", PinState.LOW);

      //  this.anonsBaslatma = this.gpio.provisionDigitalInputPin(RaspiPin.GPIO_05, PinPullResistance.PULL_UP);
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

       // this.writeToSP(" ");
        /*this.kapiButonu.addListener(new GpioPinListener[]{new GpioPinListenerDigital() {
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println(" --> KAPI BUTONU: " + event.getPin() + " = " + event.getState());
                if (event.getState() == PinState.HIGH) {
                    MainClass.this.KapiDurumuDegistir(false);
                } else {
                    MainClass.this.KapiDurumuDegistir(true);
                }

            }
        }});*/
       /* this.takometre.addListener(new GpioPinListener[]{new GpioPinListenerDigital() {
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println(" --> TAKOMETRE: " + event.getPin() + " = " + event.getState());
                if (event.getState() == PinState.HIGH) {
                    MainClass.this.TakometreArttýr();
                }

            }
        }});*/
      /*  this.anonsBaslatma.addListener(new GpioPinListener[]{new GpioPinListenerDigital() {
           public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                if (event.getState() == PinState.HIGH) {
                   System.out.println(" --> Anons Baþlatma: " + event.getPin() + " = " + event.getState());

                	MainClass.this.anonsYapma=true;
                    MainClass.this.player.Stop();
                }
            }
        }});*/
  
        if (this.serial != null && this.serial.isClosed()) {
            try {
				this.serial.open("/dev/ttyAMA0", 4800);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

    }

    /*public void writeToSP(String data) {
    	
        try {
            if (this.serial != null &&   this.serial.isClosed()) {
                this.serial.open("/dev/ttyAMA0", 4800);
            }

            if (this.serial != null && this.serial.isOpen()) {
                data = data.toUpperCase();

                try {
                    this.serial.flush();
                    String kisaString = this.IstasyonLedAdiGetir(data);
                    byte[] iso = kisaString.getBytes("ISO-8859-9");
                    byte[] ledFormat = this.ConvertToLedFormat(iso);
                    this.serial.write(ledFormat);
                    System.out.println(kisaString + " gönderildi. Data length: " + iso.length);
                } catch (UnsupportedEncodingException var5) {
                    var5.printStackTrace();
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

    } */
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


    private void KapiDurumuDegistir(final boolean durum) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainClass.this.trenBilgileri.KapiDurumuGuncelle(durum);
            }
        });
    }

    private void BaslangicAnonsuYap(String hedefIstasyon, String mevcutIstasyon) {
        String path = this.startDir + "/Anons/BASLANGIC/";
        String anonsAdi = "";
		if (mevcutIstasyon.equals("TOPKAPI")) {
			if (hedefIstasyon.equals("MESCIDI SELAM")) {
				anonsAdi = "TOPKAPI-MESCIDI SELAM.mp3";
			}
			else if (hedefIstasyon.equals("50.YIL")) {
				anonsAdi = "TOPKAPI-50.YIL.mp3";
			} 
			else if (hedefIstasyon.equals("HABÝBLER")) {
				anonsAdi = "TOPKAPI-HABÝBLER.mp3";
			} 
        } else if (mevcutIstasyon.equals("MESCIDI SELAM")) {
            if (hedefIstasyon.equals("TOPKAPI")) { 
                anonsAdi = "MESCIDI SELAM-TOPKAPI.mp3";  
            }     
        }
        else if (mevcutIstasyon.equals("50.YIL")) {
            if (hedefIstasyon.equals("EDIRNEKAPI")) { 
                anonsAdi = "50.YIL-EDÝRNEKAPI.mp3"; 
            }   
            else if (hedefIstasyon.equals("SEHITLIK")) { 
                anonsAdi = "50.YIL-SEHITLIK.mp3";  
            }
            else if (hedefIstasyon.equals("TOPKAPI")) { 
                anonsAdi = "50.YIL-TOPKAPI.mp3";  
            }
        }

        if (!anonsAdi.equals("")) {
            this.player.Play(path + anonsAdi);
            System.out.println(path + anonsAdi);
            this.contentPane.requestFocus();
        }

    }

    private void YaklasimAnonsuYap(String baslangicIstasyonu, String gelecekIstasyon, String hedefIstasyon) {
        String istasyonlarPath = this.startDir + "/Anons/ISTASYON/";
        String path = istasyonlarPath + gelecekIstasyon + "/";
        String anonsAdi = "YAKLASIM.mp3";
        File f;
        if (hedefIstasyon.equals("TOPKAPI")) 
        {
            if (gelecekIstasyon.equals("VATAN")) 
            {
                f = new File(istasyonlarPath + gelecekIstasyon + "/" + "AKTARMA.mp3");
                if (f.exists() && !f.isDirectory()) {
                    anonsAdi = "AKTARMA.mp3";
                }
            } 
            else if(gelecekIstasyon.equals("SEHITLIK"))
            {
                f = new File(istasyonlarPath + gelecekIstasyon + "/" + "AKTARMA.mp3");
                if (f.exists() && !f.isDirectory()) 
                {
                    anonsAdi = "AKTARMA.mp3";
                }
            }
            else if(gelecekIstasyon.equals("KÝPTAÞ-VEN."))
            {
                f = new File(istasyonlarPath + gelecekIstasyon + "/" + "AKTARMA.mp3");
                if (f.exists() && !f.isDirectory()) 
                {
                    anonsAdi = "AKTARMA.mp3";
                }
            }
        } 
        else if (hedefIstasyon.equals("MESCIDI SELAM")) 
        {
        	 if (gelecekIstasyon.equals("VATAN")) 
             {
                 f = new File(istasyonlarPath + gelecekIstasyon + "/" + "AKTARMA.mp3");
                 if (f.exists() && !f.isDirectory()) {
                     anonsAdi = "AKTARMA.mp3";
                 }
             } 
             else if(gelecekIstasyon.equals("SEHITLIK"))
             {
                 f = new File(istasyonlarPath + gelecekIstasyon + "/" + "AKTARMA.mp3");
                 if (f.exists() && !f.isDirectory()) 
                 {
                     anonsAdi = "AKTARMA.mp3";
                 }
             }
             else if(gelecekIstasyon.equals("KÝPTAÞ-VEN"))
             {
                 f = new File(istasyonlarPath + gelecekIstasyon + "/" + "AKTARMA.mp3");
                 if (f.exists() && !f.isDirectory()) 
                 {
                     anonsAdi = "AKTARMA.mp3";
                 }
             }
             else if(gelecekIstasyon.equals("MESCIDI SELAM"))
             {
                 f = new File(istasyonlarPath + gelecekIstasyon + "/" + "SON.mp3");
                 if (f.exists() && !f.isDirectory()) 
                 {
                     anonsAdi = "SON.mp3";
                 }
             }
        } 
        this.tTabbedPane.requestFocus();
        this.player.Play(path + anonsAdi);
        System.out.println(path + anonsAdi);
        System.out.println(anonsAdi +" yaklaþým anonsu yapýldý.");

        this.contentPane.requestFocus();
    }

    private void VarisAnonsuYap(String baslangicIstasyonu, String gelecekIstasyon, String hedefIstasyon) {
        String istasyonlarPath = this.startDir + "/Anons/ISTASYON/";
        String path = istasyonlarPath + gelecekIstasyon + "/";
        String anonsAdi = "VARIS.mp3";
        File f;
        /*if (hedefIstasyon.equals("KÝRAZLI")) {
            if (gelecekIstasyon.equals("OTOGAR")) {
                f = new File(istasyonlarPath + gelecekIstasyon + "/" + "VARIS YENÝKAPIDAN KÝRAZLIYA GÝDER.mp3");
                if (f.exists() && !f.isDirectory()) {
                    anonsAdi = "VARIS YENÝKAPIDAN KÝRAZLIYA GÝDER.mp3";
                }
            } else {
                f = new File(istasyonlarPath + gelecekIstasyon + "/" + "VARIS KÝRAZLIYA GÝDER.mp3");
                if (f.exists() && !f.isDirectory()) {
                    anonsAdi = "VARIS KÝRAZLIYA GÝDER.mp3";
                }
            }
        } else if (hedefIstasyon.equals("SEHITLIK")) {
            f = new File(istasyonlarPath + gelecekIstasyon + "/" + "VARIS OTOGARA GÝDER.mp3");
            if (f.exists() && !f.isDirectory()) {
                anonsAdi = "VARIS OTOGARA GÝDER.mp3";
            }
        } else if (hedefIstasyon.equals("ATAKÖY - ÞÝRÝNEVLER")) {
        	//deðiþ
            if (gelecekIstasyon.equals("OTOGAR")) {
                f = new File(istasyonlarPath + gelecekIstasyon + "/" + "VARIS YENÝKAPIDAN ATAKÖYE GÝDER.mp3");
                if (f.exists() && !f.isDirectory()) {
                    anonsAdi = "VARIS YENÝKAPIDAN ATAKÖYE GÝDER.mp3";
                }
            } else {
                f = new File(istasyonlarPath + gelecekIstasyon + "/" + "VARIS ATAKÖYE GÝDER.mp3");
                if (f.exists() && !f.isDirectory()) {
                    anonsAdi = "VARIS ATAKÖYE GÝDER.mp3";
                }
            }
        } else if (hedefIstasyon.equals("YENÝKAPI")) {
            if (gelecekIstasyon.equals("OTOGAR")) {
                if (baslangicIstasyonu.equals("ATAKÖY - ÞÝRÝNEVLER")) {
                	//deðiþ
                    f = new File(istasyonlarPath + gelecekIstasyon + "/" + "VARIS ATAKÖYDEN YENÝKAPIYA GÝDER.mp3");
                    if (f.exists() && !f.isDirectory()) {
                        anonsAdi = "VARIS ATAKÖYDEN YENÝKAPIYA GÝDER.mp3";
                    }
                } else if (baslangicIstasyonu.equals("KÝRAZLI")) {
                    f = new File(istasyonlarPath + gelecekIstasyon + "/" + "VARIS KÝRAZLIDAN YENÝKAPIYA GÝDER.mp3");
                    if (f.exists() && !f.isDirectory()) {
                        anonsAdi = "VARIS KÝRAZLIDAN YENÝKAPIYA GÝDER.mp3";
                    }
                }
            } else {
                f = new File(istasyonlarPath + gelecekIstasyon + "/" + "VARIS YENÝKAPIYA GÝDER.mp3");
                if (f.exists() && !f.isDirectory()) {
                    anonsAdi = "VARIS YENÝKAPIYA GÝDER.mp3";
                }
            }
        }*/

        this.tTabbedPane.requestFocus();
        if (!anonsAdi.equals("") && !gelecekIstasyon.isEmpty()) {
            this.player.Play(path + anonsAdi);
            System.out.println(path + anonsAdi);

            System.out.println(anonsAdi +" varýþ anonsu yapýldý.");
            this.contentPane.requestFocus();
        }

    }

    public class EkranKoruyucuEngelleTask extends TimerTask {
        public EkranKoruyucuEngelleTask() {
        }

        public void run() {
            try {
                Robot robot = new Robot();
                robot.keyPress(16);

                try {
                    Thread.sleep(50L);
                } catch (InterruptedException var3) {
                    var3.printStackTrace();
                }

                robot.keyRelease(16);
            } catch (AWTException var4) {
                var4.printStackTrace();
            }

        }
    }

}
