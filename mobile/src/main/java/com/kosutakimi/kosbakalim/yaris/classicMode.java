package com.kosutakimi.kosbakalim.yaris;

import android.os.Vibrator;
import com.kosutakimi.kosbakalim.user.User;

import java.util.ArrayList;
import java.util.List;

public class classicMode {
    //daha cok duzeltilecek yer var kodlara bakmayın ne yapacagıma dair hic bir fikrim yok

    private boolean isclickedReady(){ //parametre buton1 buton 2 gelsin
        boolean flag1=false,flag2=false;
        long start = System.currentTimeMillis();
        long end = start + 20*1000; //  seconds * (1000) ms/sec
        while (System.currentTimeMillis() < end)
        {
            // if(button1 click) flag1=true
            //if(buton2 click) flag2=true
        }
        if(flag1 & flag2) return true;
        return false;
    }

    private void run(User a,User b){

        long startTime,endTime;
        int A_steps=0,B_steps=0;
        List<Integer> A_Passed = new ArrayList<Integer>(); //bunun için bir queue yaparım cunku
        List<Integer> B_Passed = new ArrayList<Integer>(); //array olusturunca 1024luk acıyor cok hafiza yiyo


        /*görsel arayuzdeki butonlar ready  lenmismi onu bekliycek
        maksimum 20 sn ready e basma hakkın var
        butona 1 kere clicklendikten sonra inaktif duruma geçsin

        titresim + ses

        veriler alinip ekrana yazilmaya baslancak
        ikisi readyledikten sonra ilk 10 sn alistirma durumu

        titresim + ses

        clasicmod saniyesi geriye dogru akmaya baslıycak
        **biri diğerini gectiginde sesli uyarı adam sni gecti yada sen gecince ondesin gibi

        bittiginde sure titreme + ses

        surekli veriler geldiginden her ceyrek saniyede bi kontrol edilip gecilip gecilmedigine bakılcak
        buna gore veriler tutulacak en son veriler User lar uzerinden iletilecek
        tutulan verilerden grafik olusturulacak

        sonrada yarıs bitti ekranına gidecek kagıtta resmi var

        unit testi ogren ve su lanet olasıca koco poponu kaldir artik vcs den push olmuyo lo :(
        sddfsf
        */

        /*if(isclickedReady()){

            Vibrator v = (Vibrator) this.context.getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(500);// Vibrate for 500 milliseconds  // xml den izin istegi

            startTime = System.currentTimeMillis();
            endTime = start + 10*1000;
            while (System.currentTimeMillis() < end) //alistirma kismi
            {
                //ne yapılacak????
            }

            //baslıyoruz sesi
            MediaPlayer mp = new MediaPlayer(this,R.raw...)
            mp.start();

            v.vibrate(500);

            startTime = System.currentTimeMillis();
            endTime = start + 50*1000;
            User whoisLeader;
            while (System.currentTimeMillis() < end) //alistirma kismi
            {
                A_steps= //oguzdan verileri cekecek
                B_steps=
                //titretme ekleyebiliriz birbirlerini gecince
                if(whoisLeader!=A & A nin adım>B nin adım) A_passed.add(zamanı inte çevir) whoisLeader=A
                if(whoisLeader!=B & B nin adım>A nin adım) B_passed.add(zamanı inte çevir) whoisLeader=B
            }

            //iki farklı kişiye iki farklı ekrana yönlendirilecek ogrenmek lazım
            if(A_steps>B_steps) {A kazandı ekranına}
            else if(A_steps<B_steps) {B kazandı ekranı}
            else { beraberlik ekranı}

        }

           else{eşleşme ekranına geri dön}
         */




        System.out.println("girdim içerdeyim");
    }

}
