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



    /**
     * Constructor
     */
    private CurrentServiceInstance(){
        serviceNormal=new AlphaHttpStockServiceNormal();
        serviceWithInterval=new AlphaHttpStockServiceWithInterval();
        serviceCloud=new iexCloudHttpStockService();



    }
    /**
     *
     * @return Devuelve esta clase
     */
    public static CurrentServiceInstance getInstance(){
        return instance;
    }

    /**
     * 
     * @return Devuelve la clase serviceNormal con tipo HttpConnectionSpark
     */
    public HttpConnectionSpark getService(){
        return serviceNormal;
    }
    /**
     * 
     * @return Devuelve la clase serviceWithInterval con tipo HttpConnectionSpark
     */
    public HttpConnectionSpark getServiceWithInterval(){
        return serviceWithInterval;
    }
    /**
     * 
     * @return Devuelve la clase getServiceCloud con tipo HttpConnectionSpark
     */
    public HttpConnectionSpark getServiceCloud(){return serviceCloud;}
}


