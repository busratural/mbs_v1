//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package mbs;

import java.util.ArrayList;
public class RotaBilgileri {
    private static ArrayList<String> T4_Istasyonlar_MescidiselamTopkap� = new ArrayList();
    private static ArrayList<String> T4_Istasyonlar_Topkap�Mescidiselam = new ArrayList();
    private static ArrayList<Integer> T4_Mesafeler_MescidiselamTopkap� = new ArrayList();
    private static ArrayList<Integer> T4_Mesafeler_Topkap�Mescidiselam = new ArrayList();

    public RotaBilgileri() {
    }
    public static void Init() {
        JSONOku jsonOku;

    	jsonOku = new JSONOku();
    	jsonOku.main("/anonsName");
    	T4_Istasyonlar_MescidiselamTopkap�=jsonOku.T4_Istasyonlar_MescidiselamTopkap�;
    	T4_Mesafeler_MescidiselamTopkap�=jsonOku.T4_Mesafeler_MescidiselamTopkap�;
    	T4_Istasyonlar_Topkap�Mescidiselam=jsonOku.T4_Istasyonlar_Topkap�Mescidiselam;
    	T4_Mesafeler_Topkap�Mescidiselam=jsonOku.T4_Mesafeler_Topkap�Mescidiselam;
    	//Topkap�Mescidiselam();
    	//MescidiselamTopkap�();
    }


    public static String BaslangicIstasyonuBul(String mevcutIstasyon, String hedefIstasyon,Boolean takometrePasifEt) {
    	
        String gelecekIstasyon = getGelecekIstasyon(mevcutIstasyon, hedefIstasyon);
        String gelecekSonrakiIstasyon = getGelecekSonrakiIstasyon(mevcutIstasyon, hedefIstasyon);
        Rotalar rota = GetRota(mevcutIstasyon, gelecekIstasyon, hedefIstasyon,takometrePasifEt);
        if (rota == Rotalar.T4MescidiselamTopkap�) {
            return "TOPKAPI";
        } else {
        	return "MESCIDI SELAM"; 
        }
    }

    public static boolean IstasyonRotadaMi(Rotalar rota, String istasyonAdi, String baslangic, String hedef) {
        int indexBaslangic;
        int indexHedef;
        int indexMevcut;
        if (!rota.equals(Rotalar.T4MescidiselamTopkap�) ) {
            if (rota.equals(Rotalar.T4Topkap�Mescidiselam)) {
                indexBaslangic = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(baslangic.toUpperCase());
                indexHedef = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(hedef.toUpperCase());
                indexMevcut = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(istasyonAdi.toUpperCase());
                if (indexMevcut < indexHedef && indexMevcut >= indexBaslangic || indexMevcut > indexHedef && indexMevcut <= indexBaslangic) {
                    return true;
                }
            }
        } else if (T4_Istasyonlar_MescidiselamTopkap�.contains(istasyonAdi.toUpperCase())) {
        	
            indexBaslangic = T4_Istasyonlar_MescidiselamTopkap�.indexOf(baslangic.toUpperCase());
            indexHedef = T4_Istasyonlar_MescidiselamTopkap�.indexOf(hedef.toUpperCase());
            indexMevcut = T4_Istasyonlar_MescidiselamTopkap�.indexOf(istasyonAdi.toUpperCase());
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
            return Rotalar.GECERS�Z;
        } else {
            HatTipi hatTipi = getHatTipi(mevcutIstasyon, hedefIstasyon);
            Yonler yon = getYon(mevcutIstasyon, hedefIstasyon);
            if (yon == Yonler.TOPKAPI) {
                return Rotalar.T4Topkap�Mescidiselam;
            } else if (yon == Yonler.MESC�D�SELAM) {
                return Rotalar.T4MescidiselamTopkap�;
            }/* else if (yon == Yonler.YENIKAPI) {
                if (hatTipi.equals(HatTipi.Topkap�Mescidiselam)) {
                    return Rotalar.T4Topkap�Mescidiselam;
                } else {
                    return hatTipi.equals(HatTipi.MescidiselamTopkap�) ? Rotalar.T4MescidiselamTopkap� : Rotalar.GECERS�Z;
                }
            } */else {
                return Rotalar.GECERS�Z;
            }
        }
    }

    public static Yonler getYon(String mevcutIstasyon, String hedefIstasyon) {
        int indexMevcut;
        int indexHedef;
        if (T4_Istasyonlar_MescidiselamTopkap�.contains(mevcutIstasyon) && T4_Istasyonlar_MescidiselamTopkap�.contains(hedefIstasyon)) 
        {
            indexMevcut = T4_Istasyonlar_MescidiselamTopkap�.indexOf(mevcutIstasyon);
            indexHedef = T4_Istasyonlar_MescidiselamTopkap�.indexOf(hedefIstasyon);
            if (indexHedef > indexMevcut) {
                return Yonler.TOPKAPI;
            } else {

                return  Yonler.TOPKAPI;
            }
        } else if (T4_Istasyonlar_Topkap�Mescidiselam.contains(mevcutIstasyon) && T4_Istasyonlar_Topkap�Mescidiselam.contains(hedefIstasyon)) {
            indexMevcut = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(mevcutIstasyon);
            indexHedef = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(hedefIstasyon);
            if (indexHedef > indexMevcut) {
                return Yonler.MESC�D�SELAM;
            } else {

                return  Yonler.GECERSIZ;
            }
        } else {
        	
            return Yonler.GECERSIZ;
        }
    }

    public static HatTipi getHatTipi(String mevcutIstasyon, String hedefIstasyon) {
    	
        if (T4_Istasyonlar_MescidiselamTopkap�.get(0).toString().contains(mevcutIstasyon)==true) {
            return HatTipi.MescidiselamTopkap�;
        } else {
            return  HatTipi.Topkap�Mescidiselam;
        }
    }

    public static int getGelecekIstasyonMesafe(String mevcutIstasyon, String hedefIstasyon) {
        HatTipi hatTipi = getHatTipi(mevcutIstasyon, hedefIstasyon);
        int mevcutIndex;
        int hedefIndex;
        int val;
        if (hatTipi == HatTipi.MescidiselamTopkap�) {
            mevcutIndex = T4_Istasyonlar_MescidiselamTopkap�.indexOf(mevcutIstasyon);

            hedefIndex = T4_Istasyonlar_MescidiselamTopkap�.indexOf(hedefIstasyon);

            if (mevcutIndex >= 0 && hedefIndex >= 0) {
                if (mevcutIndex < hedefIndex) {
                    val = (Integer)T4_Mesafeler_MescidiselamTopkap�.get(mevcutIndex + 1);
                    return val;
                } else if (mevcutIndex > hedefIndex) {
                    val = (Integer)T4_Mesafeler_MescidiselamTopkap�.get(mevcutIndex);
                    return val;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else if (hatTipi == HatTipi.Topkap�Mescidiselam) {
            mevcutIndex = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(mevcutIstasyon);

            hedefIndex = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(hedefIstasyon);

            if (mevcutIndex >= 0 && hedefIndex >= 0) {
                if (mevcutIndex < hedefIndex) {
                    val = (Integer)T4_Mesafeler_Topkap�Mescidiselam.get(mevcutIndex + 1);
                    return val;
                } else if (mevcutIndex > hedefIndex) {
                    val = (Integer)T4_Mesafeler_Topkap�Mescidiselam.get(mevcutIndex);
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
        if (hatTipi == HatTipi.MescidiselamTopkap�) {

        	mevcutIndex = T4_Istasyonlar_MescidiselamTopkap�.indexOf(mevcutIstasyon);
            hedefIndex = T4_Istasyonlar_MescidiselamTopkap�.indexOf(hedefIstasyon);
            if (mevcutIndex >= 0 && hedefIndex >= 0) {
                if (mevcutIndex < hedefIndex) {
                    val2 = (String)T4_Istasyonlar_MescidiselamTopkap�.get(mevcutIndex + 2);
                    return val2 != null ? val2 : "";
                } else {

                    val2 = (String)T4_Istasyonlar_MescidiselamTopkap�.get(mevcutIndex + 2);

                    return val2 != null ? val2 : "";
                }
            } else {
                return "";
            }
        } else if (hatTipi == HatTipi.Topkap�Mescidiselam)  {

        	mevcutIndex = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(mevcutIstasyon);
            hedefIndex = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(hedefIstasyon);
            if (mevcutIndex >= 0 && hedefIndex >= 0) {
                if (mevcutIndex < hedefIndex) {
                    val2 = (String)T4_Istasyonlar_Topkap�Mescidiselam.get(mevcutIndex + 2);
                    return val2 != null ? val2 : "";
                } else {
                    val2 = (String)T4_Istasyonlar_Topkap�Mescidiselam.get(mevcutIndex -2);

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

        if (hatTipi == HatTipi.MescidiselamTopkap�) {
        	mevcutIndex = T4_Istasyonlar_MescidiselamTopkap�.indexOf(mevcutIstasyon);
            hedefIndex = T4_Istasyonlar_MescidiselamTopkap�.indexOf(hedefIstasyon);
            if (mevcutIndex >= 0 && hedefIndex >= 0) {
                if (mevcutIndex < hedefIndex) {
                    val = (String)T4_Istasyonlar_MescidiselamTopkap�.get(mevcutIndex + 1);

                    return val != null ? val : "";
                } else if (mevcutIndex > hedefIndex) {
                    val = (String)T4_Istasyonlar_MescidiselamTopkap�.get(mevcutIndex - 1);

                    return val != null ? val : "";
                } else {
                    return "";
                }
            } else {
                return "";
            }
        } else if (hatTipi == HatTipi.Topkap�Mescidiselam) {
            mevcutIndex = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(mevcutIstasyon);
            hedefIndex = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(hedefIstasyon);
            if (mevcutIndex >= 0 && hedefIndex >= 0) {
                if (mevcutIndex < hedefIndex) {
                    val = (String)T4_Istasyonlar_Topkap�Mescidiselam.get(mevcutIndex + 1);
                    return val != null ? val : "";
                } else if (mevcutIndex > hedefIndex) {
                    val = (String)T4_Istasyonlar_Topkap�Mescidiselam.get(mevcutIndex - 1);
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
