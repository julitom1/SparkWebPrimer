package edu.escuelaing.arem.sparkprimer;


import edu.escuelaing.arem.sparkprimer.service.HttpConnectionSpark;
import spark.Request;
import spark.Response;

import java.io.IOException;

import static spark.Spark.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku World");
		get("/Facadea", (req, res) -> facadeAlpha(req,res));
		get("/Cloud",(req,res) -> getCloud(req,res));

    }

    private static String getCloud(Request req, Response res) {
        res.type("application/json");
        String response="None";
        HttpConnectionSpark stockService=CurrentServiceInstance.getInstance().getServiceCloud();

        return response(stockService);

    }


    private static String facadeAlpha(Request req, Response res) {
        res.type("application/json");
        String stock=req.queryParams("simbolo");
        String period=req.queryParams("periodo");
        String interval=req.queryParams("intervalo");
        HttpConnectionSpark stockService;
        if(interval!="" && interval!=null){
            stockService=CurrentServiceInstance.getInstance().getServiceWithInterval();
            stockService.setStock3(interval);
        }else {
            stockService = CurrentServiceInstance.getInstance().getService();
        }

        if(stock!="" && stock!=null) {stockService.setStock1(stock);}
        if(period!="" && period!=null){stockService.setStock2(period);}

        return response(stockService);
    }
    private static String response(HttpConnectionSpark stockService){
        String response="None";
        try {
            response= stockService.getFBData();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;

    }

    public static int getPort(){
        if(System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
