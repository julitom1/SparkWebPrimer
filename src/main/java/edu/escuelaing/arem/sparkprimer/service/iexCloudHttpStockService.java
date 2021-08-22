package edu.escuelaing.arem.sparkprimer.service;

public class iexCloudHttpStockService extends HttpConnectionSpark {


    @Override
    public String getUrl() {
        return "https://cloud.iexapis.com/stable/stock/aapl/quote?token=sk_216b3bcbcbc446b29a59198672326661";
    }

    @Override
    public String obtenerResultadoPorMemoria() {
        return "";
    }

    @Override
    public void guardarEnCache(String rta) {

    }

    @Override
    public void setStock1(String stock) {

    }

    @Override
    public void setStock2(String stock) {

    }

    @Override
    public void setStock3(String stock) {

    }
}
