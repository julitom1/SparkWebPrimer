package edu.escuelaing.arem.sparkprimer.service;

public class AlphaHttpStockServiceNormal extends AlphaHttpStockService{

	@Override
    public String getUrl() {
        return  url+"?function=TIME_SERIES_"+stock2+"&symbol="+stock1+"&apikey=QBFKS0D0AQB3IPK2&interval="+stock3+"min";
    }
}
