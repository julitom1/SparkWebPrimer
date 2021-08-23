package edu.escuelaing.arem.sparkprimer;

import edu.escuelaing.arem.sparkprimer.service.AlphaHttpStockService;
import edu.escuelaing.arem.sparkprimer.service.AlphaHttpStockServiceNormal;
import edu.escuelaing.arem.sparkprimer.service.AlphaHttpStockServiceWithInterval;
import edu.escuelaing.arem.sparkprimer.service.HttpConnectionSpark;
import edu.escuelaing.arem.sparkprimer.service.iexCloudHttpStockService;

public class CurrentServiceInstance {
    private static CurrentServiceInstance instance=new CurrentServiceInstance();
    private HttpConnectionSpark serviceNormal;
    private HttpConnectionSpark serviceWithInterval;
    private HttpConnectionSpark serviceCloud;




    private CurrentServiceInstance(){
        serviceNormal=new AlphaHttpStockServiceNormal();
        serviceWithInterval=new AlphaHttpStockServiceWithInterval();
        serviceCloud=new iexCloudHttpStockService();



    }

    public static CurrentServiceInstance getInstance(){
        return instance;
    }

    public HttpConnectionSpark getService(){
        return serviceNormal;
    }
    public HttpConnectionSpark getServiceWithInterval(){
        return serviceWithInterval;
    }
    public HttpConnectionSpark getServiceCloud(){return serviceCloud;}
}


