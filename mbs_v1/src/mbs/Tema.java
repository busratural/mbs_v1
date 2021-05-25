//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package mbs;

import java.awt.Color;

public class Tema {
    public Color contentPaneBackground;
    public Color tabbedPaneBackground;
    public Color rotaKurPanelBackground;
    public Color ozelAnonsPanelBackground;
    public Color ayarlarPanelBackground;
    public Color trenBilgileriForeground;
    public Color trenBilgileriBackground;
    public Color donusSeferiUyariBackground;
    public Color donusSeferiUyariForeground;
    public Color donusSeferiUyariAciklamaForeground;
    public Color konumPanelBackground;
    public Color konumPanelForeground;
    public Color rotaKurulumuPanelBackground;
    public Color mevcutRotaIptalButtonColor1;
    public Color mevcutRotaIptalButtonColor2;
    public Color tabelaPaneliBackground;
    public Color ozelAnonsPanel1Background;
    public Color ozelAnonsPanel2Background;
    public Color ozelAnonsPanel3Background;
    public Color ozelAnonslarPanelBackground;
    public Color baslangicAnonslariPanelBackground;
    public Color anonsuKapatButonBackground;
    public Color anonsuKapatButonForeground;
    public Color rotaSecimiUyariBackground;
    public Color rotaSecimiUyariForeground;
    public Color rotaPaneliBackground;
    public Color istasyonlarPanelBackground;
    public Color istasyonAnonslariPanelBackground;
    public Color mevcutIstasyonPanelBackground;
    public Color ayarlarPaneliBackground;
    public Color ayarlarCikisButonColor1;
    public Color ayarlarCikisButonColor2;
    public Color programiKapatButonColor1;
    public Color programiKapatButonColor2;
    public Color arizaAnonsButonColor1;
    public Color kalibrasyonButonColor1;
    public Color kalibrasyonButonColor2;
    public Color kalibrasyonuSifirlaButonColor1;
    public Color kalibrasyonuSifirlaButonColor2;
    public Color trenNumaraAyarButonColor1;
    public Color trenNumaraAyarButonColor2;
    public Color sesAyarButonColor1;
    public Color sesAyarButonColor2;
    public Color rotaBilgiPaneliBackground;
    public Color rotaBilgiPaneliForegound;
    public Color detayliRotaAnaPanelBackground;
    public Color detayliRotaIstasyonPanelBackground;
    public Color istasyonAnonslariIstasyonAdiForeground;
    public Color titledBorderTextColor;
    public Color selectedTabBackground;
    public Color selectedTabForeground;
    public Color tabForeground;
    public Color gradientButtonBackground1;
    public Color gradientButtonBackground2;
    public Color gradientButtonForeground;
    public Color donusSeferiPanelBackground;
    public Color sesSeviyesiForeground;
    public Color textcolor;
    public Color labelcolor;
    public Color tabcolor;
    public int fontSize;
    public int fontStyle;
    public String fontName;
    private JSONOku jsonOku;

    public Tema(Color background) {
        this.DarkTema(background);
        
    }

    public void VarsayilanTema(Color background) {
        this.contentPaneBackground = Color.DARK_GRAY.brighter().brighter();
        this.tabbedPaneBackground = Color.DARK_GRAY.brighter().brighter().brighter();
        this.rotaKurPanelBackground = Color.DARK_GRAY.brighter().brighter();
        this.ozelAnonsPanelBackground = Color.DARK_GRAY.brighter().brighter();
        this.ayarlarPanelBackground = Color.DARK_GRAY.brighter().brighter().brighter();
        this.trenBilgileriForeground =this.textcolor; 
        this.trenBilgileriBackground = background.darker();
        this.donusSeferiUyariBackground = Color.red;
        this.donusSeferiUyariForeground =this.textcolor; 
        this.donusSeferiUyariAciklamaForeground =this.textcolor; 
        this.konumPanelBackground = background.darker();
        this.konumPanelForeground =this.textcolor; 
        this.rotaKurulumuPanelBackground = background.darker();
        this.mevcutRotaIptalButtonColor1 = Color.RED.brighter();
        this.mevcutRotaIptalButtonColor2 = Color.GRAY.brighter().brighter();
        this.tabelaPaneliBackground = background.darker();
        this.ozelAnonsPanel1Background = background.darker();
        this.ozelAnonsPanel2Background = background.darker();
        this.ozelAnonsPanel3Background = background.darker();
        this.ozelAnonslarPanelBackground = Color.DARK_GRAY.brighter().brighter().brighter();
        this.baslangicAnonslariPanelBackground = background.darker();
        this.anonsuKapatButonBackground = new Color(70, 0, 0);
        this.anonsuKapatButonForeground =this.textcolor;
        this.rotaSecimiUyariBackground = Color.red;
        this.rotaSecimiUyariForeground =this.textcolor; 
        this.rotaPaneliBackground = Color.DARK_GRAY.brighter().brighter().brighter();
        this.rotaBilgiPaneliBackground = background.darker().darker();
        this.rotaBilgiPaneliForegound = this.textcolor;
        this.istasyonlarPanelBackground = background.darker();
        this.istasyonAnonslariPanelBackground = background.darker();
        this.istasyonAnonslariIstasyonAdiForeground =this.textcolor; 
        this.mevcutIstasyonPanelBackground = background.darker();
        this.ayarlarPaneliBackground = background.darker();
        this.ayarlarCikisButonColor1 = Color.GRAY.brighter();
        this.ayarlarCikisButonColor2 = Color.GRAY.brighter().brighter();
        this.programiKapatButonColor1 = Color.RED.brighter();
        this.programiKapatButonColor2 = Color.GRAY.brighter().brighter();
        this.arizaAnonsButonColor1= Color.ORANGE.darker();
        this.kalibrasyonButonColor1 = Color.GRAY.brighter();
        this.kalibrasyonButonColor2 = Color.GRAY.brighter().brighter();
        this.kalibrasyonuSifirlaButonColor1 = Color.GRAY.brighter();
        this.kalibrasyonuSifirlaButonColor2 = Color.GRAY.brighter().brighter();
        this.trenNumaraAyarButonColor1 = Color.GRAY.brighter();
        this.trenNumaraAyarButonColor2 = Color.GRAY.brighter().brighter();
        this.sesAyarButonColor1 = Color.RED;
        this.sesAyarButonColor2 = Color.RED;
        this.detayliRotaAnaPanelBackground = background.darker();
        this.detayliRotaIstasyonPanelBackground = background.darker();
        this.titledBorderTextColor = Color.GRAY;
    }

    public void DarkTema(Color background) {
    	jsonOku = new JSONOku();
        jsonOku.main("/turkishWord");
        textcolor=jsonOku.textcolor;
        labelcolor=jsonOku.labelcolor;
        tabcolor=jsonOku.tabcolor;
        fontSize=jsonOku.fontSize;
        fontStyle=jsonOku.fontStyle;
        fontName=jsonOku.fontName;
        this.contentPaneBackground = new Color(64, 64, 64);
        this.tabbedPaneBackground = new Color(64, 64, 64);
        this.rotaKurPanelBackground = new Color(64, 64, 64);
        this.ozelAnonsPanelBackground = new Color(64, 64, 64);
        this.ayarlarPanelBackground = new Color(64, 64, 64);

        this.trenBilgileriForeground =this.textcolor; 
        this.trenBilgileriBackground = new Color(64, 64, 64);
        this.donusSeferiUyariBackground = Color.red;
        this.donusSeferiUyariForeground =this.textcolor; 
        this.donusSeferiUyariAciklamaForeground =this.textcolor; 
        this.konumPanelBackground = new Color(64, 64, 64);
        this.konumPanelForeground =this.textcolor; 
        this.rotaKurulumuPanelBackground = new Color(64, 64, 64);
        this.mevcutRotaIptalButtonColor2 = Color.RED.darker();
        this.mevcutRotaIptalButtonColor1 = Color.RED.darker().darker();
        this.tabelaPaneliBackground = new Color(64, 64, 64);
        this.ozelAnonsPanel1Background = new Color(64, 64, 64);
        this.ozelAnonsPanel2Background = new Color(64, 64, 64);
        this.ozelAnonsPanel3Background = new Color(64, 64, 64);
        this.ozelAnonslarPanelBackground = new Color(64, 64, 64);
        this.baslangicAnonslariPanelBackground = new Color(64, 64, 64);
        this.anonsuKapatButonBackground = new Color(70, 0, 0);
        this.anonsuKapatButonForeground =this.textcolor; 
        this.rotaSecimiUyariBackground = Color.red;
        this.rotaSecimiUyariForeground =this.textcolor; 
        this.rotaPaneliBackground = new Color(64, 64, 64);
        this.rotaBilgiPaneliBackground = new Color(64, 64, 64);
        this.rotaBilgiPaneliForegound = this.textcolor;
        this.istasyonlarPanelBackground = new Color(64, 64, 64);
        this.istasyonAnonslariPanelBackground = new Color(64, 64, 64);
        this.istasyonAnonslariIstasyonAdiForeground =this.textcolor; 
        this.mevcutIstasyonPanelBackground = new Color(64, 64, 64);
        this.ayarlarPaneliBackground = new Color(64, 64, 64);
        this.programiKapatButonColor2 = Color.RED.darker();
        this.programiKapatButonColor1 = Color.RED.darker().darker();
        this.arizaAnonsButonColor1= Color.ORANGE.darker().darker();
        this.trenNumaraAyarButonColor1 = Color.GRAY.brighter();
        this.trenNumaraAyarButonColor2 = Color.GRAY.brighter().brighter();
        this.sesAyarButonColor2 = (new Color(80, 00, 00)).darker();
        this.sesAyarButonColor1 = this.sesAyarButonColor2.darker().darker();
        this.detayliRotaAnaPanelBackground = new Color(64, 64, 64);
        this.detayliRotaIstasyonPanelBackground = new Color(64, 64, 64);
        this.titledBorderTextColor = this.labelcolor;
        this.selectedTabBackground = (this.labelcolor).darker();
        this.selectedTabForeground =this.textcolor; 
        this.tabForeground = this.labelcolor;
        this.gradientButtonBackground2 = (this.labelcolor).darker();
        this.gradientButtonBackground1 = this.gradientButtonBackground2.darker().darker();
        this.gradientButtonForeground =this.textcolor;  
        this.donusSeferiPanelBackground = new Color(64, 64, 64);
        this.sesSeviyesiForeground =this.textcolor;
    }
}
