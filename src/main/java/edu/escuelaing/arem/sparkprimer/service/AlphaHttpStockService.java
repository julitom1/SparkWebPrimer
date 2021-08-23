package edu.escuelaing.arem.sparkprimer.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Timer;
import java.util.TimerTask;
public class AlphaHttpStockService extends HttpConnectionSpark {

    protected String stock1;
    protected String stock2;
    protected String stock3;
    protected final String url="https://www.alphavantage.co/query";
    
    private final ConcurrentHashMap<String,String> memoriaAlpha=new ConcurrentHashMap<>();
    private String tupla;



    public String obtenerResultadoPorMemoria(){
        String resultado= "";
        tupla=stock1+stock2+stock3;
        System.out.println(memoriaAlpha.containsKey(tupla));
        if(memoriaAlpha.containsKey(tupla)){
            resultado=memoriaAlpha.get(tupla);
        }
        return resultado;
    }

    @Override
    public void guardarEnCache(String rta) {
        memoriaAlpha.put(tupla,rta);
        iniciarCronometro();
    }
    private void iniciarCronometro(){
        String eliminar=tupla;
        Timer timer=new Timer();
        TimerTask tiempoEnCache = new TimerTask() {
            @Override
            public void run() {
        
                memoriaAlpha.remove(eliminar);
            }
        };
        timer.schedule(tiempoEnCache,300000);
    }

    @Override
    public void setStock1(String stock) {
        stock1=stock;
    }

    @Override
    public void setStock2(String stock) {
        stock2=stock;
    }

    @Override
    public void setStock3(String stock) {
        stock3=stock;
    }


    public String getUrl(){

        return url;
    }




}
