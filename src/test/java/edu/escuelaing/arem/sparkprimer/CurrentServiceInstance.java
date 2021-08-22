package edu.escuelaing.arem.sparkprimer;

import edu.escuelaing.arem.sparkprimer.service.AlphaHttpStockService;
import edu.escuelaing.arem.sparkprimer.service.HttpConnectionSpark;

public class CurrentServiceInstance {
    private static CurrentServiceInstance iceInstance=new CurrentServiceInstance() ;
    private HttpConnectionSpark service;
    private CurrentServiceInstance(){
        service = new AlphaHttpStockService();
    }
    
    public static CurrentServiceInstance getInstance(){
        return iceInstance;
    }
    public HttpConnectionSpark getService(){
        return service;
    }
}
