package edu.escuelaing.arem.sparkprimer.persistencia.impl;

import edu.escuelaing.arem.sparkprimer.persistencia.SparkPrimerPersistence;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class InMemorySparkPrimerPersistence implements SparkPrimerPersistence {

    private final ConcurrentHashMap<String,StringBuffer> sparkPrimers=new ConcurrentHashMap<>();

    @Override
    public  StringBuffer getDatesSparkPrimer(String identificador) {
        if(!sparkPrimers.contains(identificador)){
            try {
                sparkPrimers.put(identificador,HttpConnectionSpark.conectionAPI(identificador));
                return sparkPrimers.get(identificador);
            } catch (IOException e) {
                return null;
            }

        }
        return sparkPrimers.get(identificador);
    }
    
}
