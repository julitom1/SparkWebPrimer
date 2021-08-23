package edu.escuelaing.arem.sparkprimer;


import edu.escuelaing.arem.sparkprimer.service.HttpConnectionSpark;
import spark.Request;
import spark.Response;
import spark.Filter;
import java.io.IOException;

import static spark.Spark.*;

/**
 * 
 * @author yarit
 *
 */

public class sparkWeb {
	private static final CurrentServiceInstance instance = CurrentServiceInstance.getInstance();
	
	/**
	 * Inicio y preparaci�n de la aplicaci�n
	 * @param args
	 */
    public static void main( String[] args )
    {
        port(getPort());
        after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
        });
        
		get("/Facadea", (req, res) -> facadeAlpha(req,res));
		get("/Cloud",(req,res) -> getCloud(req,res));

    }

    /**
     * Trabaja con la clase iexCloudHttpStockService
     * @param req contendr� informaci�n de la petici�n
     * @param res contendr� informaci�n sobre la respuesta del server
     * @return Devuelve un Json de la url solicitada
     */
    private static String getCloud(Request req, Response res) {
        res.type("application/json");
        String response="None";
        HttpConnectionSpark stockService=instance.getServiceCloud();

        return response(stockService);

    }

    /**
     * Trabaja con la clase AlphaHttpStockService
     * @param req contendr� informaci�n de la petici�n
     * @param res contendr� informaci�n sobre la respuesta del server
     * @return Devuelve un Json de la url solicitada
     */ 
    
    private static String facadeAlpha(Request req, Response res) {
        res.type("application/json");
        String stock=req.queryParams("simbolo");
        String period=req.queryParams("periodo");
        String interval=req.queryParams("intervalo");
        HttpConnectionSpark stockService;
        if(interval!="" && interval!=null){
            stockService=instance.getServiceWithInterval();
            stockService.setStock3(interval);
        }else {
            stockService = CurrentServiceInstance.getInstance().getService();
        }

        if(stock!="" && stock!=null) {stockService.setStock1(stock);}
        if(period!="" && period!=null){stockService.setStock2(period);}

        return response(stockService);
    }
    
    /**
     *  Hace la conexi�n con la clase abstracta HttpConectionSpark
     * @param stockService Es el tipo de servicio que se va a manejar
     * @return Devuelve los datos de la url solicitada
     */
    private static String response(HttpConnectionSpark stockService){
        String response="None";
        try {
            response= stockService.getFBData();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;

    }

    /**
     * Obtener un puerto
     * @return Devuelve un puerto
     */
    public static int getPort(){
        if(System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
