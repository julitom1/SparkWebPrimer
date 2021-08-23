package edu.escuelaing.arem.sparkprimer.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class HttpConnectionSpark {

    private static final String USER_AGENT = "Mozilla/5.0";

    /**
     *  Hace conexión con la API externa que se le indico
     * @return Devuelve los datos de esa API externa
     * @throws IOException
     */
    public String getFBData() throws IOException {

    	
        String responseStr=obtenerResultadoPorMemoria();
        if(responseStr.equals("") || responseStr.equals(null)) {
            System.out.println("No Memoria");

            URL obj = new URL(getUrl());
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            //The following invocation perform the connection implicitly before getting the code
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();


                responseStr = response.toString();
                guardarEnCache(responseStr);
            } else {
                System.out.println("GET request not worked");
            }
            System.out.println("GET DONE");
        }
        return responseStr;
    }
    /**
     * 
     * @return Obtiene una url
     */
    public abstract String getUrl();

    /**
     * 
     * @return Devuelve un resultado guardada en la Cache
     */
    public abstract String obtenerResultadoPorMemoria();

    /**
     *  Guarda en la cache un dato.
     * @param rta Lo que se va a guardad como valor en la memoria
     */
    public abstract void guardarEnCache(String rta);

    
    public abstract void setStock1(String stock);
    public abstract void setStock2(String stock);
    public abstract void setStock3(String stock);





}
