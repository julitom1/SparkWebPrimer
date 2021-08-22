package edu.escuelaing.arem.sparkprimer.service;

import edu.escuelaing.arem.sparkprimer.service.AlphaHttpStockService;

public class AlphaHttpStockServiceWithInterval extends AlphaHttpStockService {


    @Override
    public String getUrl() {
        return  "https://www.alphavantage.co/query?function=TIME_SERIES_"+stock2+"&symbol="+stock1+"&apikey=QBFKS0D0AQB3IPK2&interval="+stock3+"min";
    }
}
