package com.aluracursos.consumoApis.modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ConsultaMoneda {
   public Moneda buscaMoneda ( int numeroDeConsultaMoneda){
    String moneda1="", moneda2="";
   if (numeroDeConsultaMoneda == 1) {
        moneda1 = "USD";
        moneda2 = "ARS";
   }if (numeroDeConsultaMoneda == 2) {
        moneda1 = "ARS";
        moneda2 = "USD";
   }if (numeroDeConsultaMoneda == 3) {
        moneda1 = "USD";
        moneda2 = "BRL";
   }if (numeroDeConsultaMoneda == 4) {
        moneda1 = "BRL";
        moneda2 = "USD";
   }if (numeroDeConsultaMoneda == 5) {
        moneda1 = "USD";
        moneda2 = "COP";
    }if (numeroDeConsultaMoneda == 6) {
        moneda1 = "COP";
        moneda2 = "USD";
    }
    
     URI direccion = URI.create("https://v6.exchangerate-api.com/v6/a20ac36ea9e84dd6547b2849/pair/"+ moneda1 +"/"+ moneda2 );
     HttpClient client = HttpClient.newHttpClient();
     
     HttpRequest request = HttpRequest.newBuilder()
               .uri(direccion)
               .build();
     HttpResponse<String> response = null;
     try {
          response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

          String json = response.body();
          // System.out.println(json);
     } catch (IOException | InterruptedException e) {
          throw new RuntimeException(e);
     } 

     return new Gson().fromJson(response.body(), Moneda.class);

   }
}
