//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package mbs;

import java.util.ArrayList;
public class RotaBilgileri {
    private static ArrayList<String> T4_Istasyonlar_MescidiselamTopkapý = new ArrayList();
    private static ArrayList<String> T4_Istasyonlar_TopkapýMescidiselam = new ArrayList();
    private static ArrayList<Integer> T4_Mesafeler_MescidiselamTopkapý = new ArrayList();
    private static ArrayList<Integer> T4_Mesafeler_TopkapýMescidiselam = new ArrayList();

    public RotaBilgileri() {
    }
    public static void Init() {
        JSONOku jsonOku;

    	jsonOku = new JSONOku();
    	jsonOku.main("/anonsName");
    	T4_Istasyonlar_MescidiselamTopkapý=jsonOku.T4_Istasyonlar_MescidiselamTopkapý;
    	T4_Mesafeler_MescidiselamTopkapý=jsonOku.T4_Mesafeler_MescidiselamTopkapý;
    	T4_Istasyonlar_TopkapýMescidiselam=jsonOku.T4_Istasyonlar_TopkapýMescidiselam;
    	T4_Mesafeler_TopkapýMescidiselam=jsonOku.T4_Mesafeler_TopkapýMescidiselam;
    	//TopkapýMescidiselam();
    	//MescidiselamTopkapý();
    }


    public static String BaslangicIstasyonuBul(String mevcutIstasyon, String hedefIstasyon,Boolean takometrePasifEt) {
    	
        String gelecekIstasyon = getGelecekIstasyon(mevcutIstasyon, hedefIstasyon);
        String gelecekSonrakiIstasyon = getGelecekSonrakiIstasyon(mevcutIstasyon, hedefIstasyon);
        Rotalar rota = GetRota(mevcutIstasyon, gelecekIstasyon, hedefIstasyon,takometrePasifEt);
        if (rota == Rotalar.T4MescidiselamTopkapý) {
            return "TOPKAPI";
        } else {
        	return "MESCIDI SELAM"; 
        }
    }

    public static boolean IstasyonRotadaMi(Rotalar rota, String istasyonAdi, String baslangic, String hedef) {
        int indexBaslangic;
        int indexHedef;
        int indexMevcut;
        if (!rota.equals(Rotalar.T4MescidiselamTopkapý) ) {
            if (rota.equals(Rotalar.T4TopkapýMescidiselam)) {
                indexBaslangic = T4_Istasyonlar_TopkapýMescidiselam.indexOf(baslangic.toUpperCase());
                indexHedef = T4_Istasyonlar_TopkapýMescidiselam.indexOf(hedef.toUpperCase());
                indexMevcut = T4_Istasyonlar_TopkapýMescidiselam.indexOf(istasyonAdi.toUpperCase());
                if (indexMevcut < indexHedef && indexMevcut >= indexBaslangic || indexMevcut > indexHedef && indexMevcut <= indexBaslangic) {
                    return true;
                }
            }
        } else if (T4_Istasyonlar_MescidiselamTopkapý.contains(istasyonAdi.toUpperCase())) {
        	
            indexBaslangic = T4_Istasyonlar_MescidiselamTopkapý.indexOf(baslangic.toUpperCase());
            indexHedef = T4_Istasyonlar_MescidiselamTopkapý.indexOf(hedef.toUpperCase());
            indexMevcut = T4_Istasyonlar_MescidiselamTopkapý.indexOf(istasyonAdi.toUpperCase());
            if (indexMevcut < indexHedef && indexMevcut >= indexBaslangic || indexMevcut > indexHedef && indexMevcut <= indexBaslangic) {
                return true;
            }
        }

        return false;
    }

    public static Rotalar GetRota(String mevcutIstasyon, String gelecekIstasyon, String hedefIstasyon, Boolean takometrePasifEt) {
    	System.out.println(mevcutIstasyon+gelecekIstasyon+hedefIstasyon);
        if (hedefIstasyon.equals("")) {
            return Rotalar.SECILMEDI;
        } else if (mevcutIstasyon.equals("")) {
            return Rotalar.SECILMEDI;
        }  else if (gelecekIstasyon.equals("")) {
            return Rotalar.GECERSÝZ;
        } else {
            HatTipi hatTipi = getHatTipi(mevcutIstasyon, hedefIstasyon);
            Yonler yon = getYon(mevcutIstasyon, hedefIstasyon);
            if (yon == Yonler.TOPKAPI) {
                return Rotalar.T4TopkapýMescidiselam;
            } else if (yon == Yonler.MESCÝDÝSELAM) {
                return Rotalar.T4MescidiselamTopkapý;
            }/* else if (yon == Yonler.YENIKAPI) {
                if (hatTipi.equals(HatTipi.TopkapýMescidiselam)) {
                    return Rotalar.T4TopkapýMescidiselam;
                } else {
                    return hatTipi.equals(HatTipi.MescidiselamTopkapý) ? Rotalar.T4MescidiselamTopkapý : Rotalar.GECERSÝZ;
                }
            } */else {
                return Rotalar.GECERSÝZ;
            }
        }
    }

    public static Yonler getYon(String mevcutIstasyon, String hedefIstasyon) {
        int indexMevcut;
        int indexHedef;
        if (T4_Istasyonlar_MescidiselamTopkapý.contains(mevcutIstasyon) && T4_Istasyonlar_MescidiselamTopkapý.contains(hedefIstasyon)) 
        {
            indexMevcut = T4_Istasyonlar_MescidiselamTopkapý.indexOf(mevcutIstasyon);
            indexHedef = T4_Istasyonlar_MescidiselamTopkapý.indexOf(hedefIstasyon);
            if (indexHedef > indexMevcut) {
                return Yonler.TOPKAPI;
            } else {

                return  Yonler.TOPKAPI;
            }
        } else if (T4_Istasyonlar_TopkapýMescidiselam.contains(mevcutIstasyon) && T4_Istasyonlar_TopkapýMescidiselam.contains(hedefIstasyon)) {
            indexMevcut = T4_Istasyonlar_TopkapýMescidiselam.indexOf(mevcutIstasyon);
            indexHedef = T4_Istasyonlar_TopkapýMescidiselam.indexOf(hedefIstasyon);
            if (indexHedef > indexMevcut) {
                return Yonler.MESCÝDÝSELAM;
            } else {

                return  Yonler.GECERSIZ;
            }
        } else {
        	
            return Yonler.GECERSIZ;
        }
    }

    public static HatTipi getHatTipi(String mevcutIstasyon, String hedefIstasyon) {
    	
        if (T4_Istasyonlar_MescidiselamTopkapý.get(0).toString().contains(mevcutIstasyon)==true) {
            return HatTipi.MescidiselamTopkapý;
        } else {
            return  HatTipi.TopkapýMescidiselam;
        }
    }

    public static int getGelecekIstasyonMesafe(String mevcutIstasyon, String hedefIstasyon) {
        HatTipi hatTipi = getHatTipi(mevcutIstasyon, hedefIstasyon);
        int mevcutIndex;
        int hedefIndex;
        int val;
        if (hatTipi == HatTipi.MescidiselamTopkapý) {
            mevcutIndex = T4_Istasyonlar_MescidiselamTopkapý.indexOf(mevcutIstasyon);

            hedefIndex = T4_Istasyonlar_MescidiselamTopkapý.indexOf(hedefIstasyon);

            if (mevcutIndex >= 0 && hedefIndex >= 0) {
                if (mevcutIndex < hedefIndex) {
                    val = (Integer)T4_Mesafeler_MescidiselamTopkapý.get(mevcutIndex + 1);
                    return val;
                } else if (mevcutIndex > hedefIndex) {
                    val = (Integer)T4_Mesafeler_MescidiselamTopkapý.get(mevcutIndex);
                    return val;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else if (hatTipi == HatTipi.TopkapýMescidiselam) {
            mevcutIndex = T4_Istasyonlar_TopkapýMescidiselam.indexOf(mevcutIstasyon);

            hedefIndex = T4_Istasyonlar_TopkapýMescidiselam.indexOf(hedefIstasyon);

            if (mevcutIndex >= 0 && hedefIndex >= 0) {
                if (mevcutIndex < hedefIndex) {
                    val = (Integer)T4_Mesafeler_TopkapýMescidiselam.get(mevcutIndex + 1);
                    return val;
                } else if (mevcutIndex > hedefIndex) {
                    val = (Integer)T4_Mesafeler_TopkapýMescidiselam.get(mevcutIndex);
                    return val;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
    public static String getGelecekSonrakiIstasyon(String mevcutIstasyon,String hedefIstasyon) {
        HatTipi hatTipi = getHatTipi(mevcutIstasyon, hedefIstasyon);
        int mevcutIndex;
        int hedefIndex;
        String val2;
        if (hatTipi == HatTipi.MescidiselamTopkapý) {

        	mevcutIndex = T4_Istasyonlar_MescidiselamTopkapý.indexOf(mevcutIstasyon);
            hedefIndex = T4_Istasyonlar_MescidiselamTopkapý.indexOf(hedefIstasyon);
            if (mevcutIndex >= 0 && hedefIndex >= 0) {
                if (mevcutIndex < hedefIndex) {
                    val2 = (String)T4_Istasyonlar_MescidiselamTopkapý.get(mevcutIndex + 2);
                    return val2 != null ? val2 : "";
                } else {

                    val2 = (String)T4_Istasyonlar_MescidiselamTopkapý.get(mevcutIndex + 2);

                    return val2 != null ? val2 : "";
                }
            } else {
                return "";
            }
        } else if (hatTipi == HatTipi.TopkapýMescidiselam)  {

        	mevcutIndex = T4_Istasyonlar_TopkapýMescidiselam.indexOf(mevcutIstasyon);
            hedefIndex = T4_Istasyonlar_TopkapýMescidiselam.indexOf(hedefIstasyon);
            if (mevcutIndex >= 0 && hedefIndex >= 0) {
                if (mevcutIndex < hedefIndex) {
                    val2 = (String)T4_Istasyonlar_TopkapýMescidiselam.get(mevcutIndex + 2);
                    return val2 != null ? val2 : "";
                } else {
                    val2 = (String)T4_Istasyonlar_TopkapýMescidiselam.get(mevcutIndex -2);

                    return val2 != null ? val2 : "";
                }
            } else {
                return "";
            }
        }  else {
            return "";
        }
    }
    

    public static String getGelecekIstasyon(String mevcutIstasyon,String hedefIstasyon) {
        HatTipi hatTipi = getHatTipi(mevcutIstasyon, hedefIstasyon);
        int mevcutIndex;
        int hedefIndex;
        String val;

        if (hatTipi == HatTipi.MescidiselamTopkapý) {
        	mevcutIndex = T4_Istasyonlar_MescidiselamTopkapý.indexOf(mevcutIstasyon);
            hedefIndex = T4_Istasyonlar_MescidiselamTopkapý.indexOf(hedefIstasyon);
            if (mevcutIndex >= 0 && hedefIndex >= 0) {
                if (mevcutIndex < hedefIndex) {
                    val = (String)T4_Istasyonlar_MescidiselamTopkapý.get(mevcutIndex + 1);

                    return val != null ? val : "";
                } else if (mevcutIndex > hedefIndex) {
                    val = (String)T4_Istasyonlar_MescidiselamTopkapý.get(mevcutIndex - 1);

                    return val != null ? val : "";
                } else {
                    return "";
                }
            } else {
                return "";
            }
        } else if (hatTipi == HatTipi.TopkapýMescidiselam) {
            mevcutIndex = T4_Istasyonlar_TopkapýMescidiselam.indexOf(mevcutIstasyon);
            hedefIndex = T4_Istasyonlar_TopkapýMescidiselam.indexOf(hedefIstasyon);
            if (mevcutIndex >= 0 && hedefIndex >= 0) {
                if (mevcutIndex < hedefIndex) {
                    val = (String)T4_Istasyonlar_TopkapýMescidiselam.get(mevcutIndex + 1);
                    return val != null ? val : "";
                } else if (mevcutIndex > hedefIndex) {
                    val = (String)T4_Istasyonlar_TopkapýMescidiselam.get(mevcutIndex - 1);
                    return val != null ? val : "";
                } else {
                    return "";
                }
            } else {
                return "";
            }
        } else {
            return "";
        }
    }
}
