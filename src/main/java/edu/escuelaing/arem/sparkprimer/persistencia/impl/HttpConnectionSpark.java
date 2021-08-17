package edu.escuelaing.arem.sparkprimer.persistencia.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpConnectionSpark {

    private static final String USER_AGENT = "Mozilla/5.0";



    public static void  main(String [] args) throws IOException {
        conectionAPI("fb");
    }
    public static StringBuffer  conectionAPI(String identificador) throws IOException {
        URL obj = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + identificador + "&apikey=QBFKS0D0AQB3IPK2");
        return conectionAPI(obj);
    }
    public static StringBuffer conectionAPI(String identificador,String timeIntraDia) throws IOException {
        URL obj = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol= " + identificador + " &interval= " + timeIntraDia + "min&apikey=QBFKS0D0AQB3IPK2");
        return conectionAPI(obj);

    }

    private static StringBuffer conectionAPI(URL obj) throws IOException {

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        StringBuffer response = new StringBuffer();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));

            String inputLine;

            System.out.println(in);
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                response.append(inputLine);
            }
            in.close();

            // print result


            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
       //JSONObject jsonObject = new JSONObject(response);
        System.out.println(response);

        return response;


    }

}

