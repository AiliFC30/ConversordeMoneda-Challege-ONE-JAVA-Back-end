package com.aluracursos.consumoApis.principal;

import java.io.IOException;
import java.util.Scanner;
import com.aluracursos.consumoApis.modelos.ConsultaMoneda;
import com.aluracursos.consumoApis.modelos.Moneda;


public class Principal {
     public static void main(String[] args) throws IOException {
        System.out.println("¡Bienvenidos!\n");
        System.out.println("Conversor de Monedas\n");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        Menu();
        try (Scanner lectura = new Scanner(System.in)) {
            ConsultaMoneda consulta = new ConsultaMoneda();
    
            while (true) {
                System.out.println("Escriba el número deseado del menú para conocer el cambio de moneda que desea consultar:");
                var numeroDeConsultaMoneda = Integer.valueOf(lectura.nextLine());
                try {
                    if (numeroDeConsultaMoneda >= 1 && numeroDeConsultaMoneda <= 7) {
                        if (numeroDeConsultaMoneda == 7) {
                            System.out.println("Saliendo");
                            break;
                        }
                        Moneda moneda = consulta.buscaMoneda(numeroDeConsultaMoneda);
                        System.out.println("Escriba la cantidad para el cambio de moneda:");
                        // var cantidad = lectura.nextDouble();
                        var cantidad = Integer.valueOf(lectura.nextLine());
                        var cambio = moneda.conversion_rate();
                        var base_code = moneda.base_code();
                        var target_code = moneda.target_code();

                        Calculo(cantidad, cambio, base_code, target_code);
                        
                        
                    }else{
                        System.out.println("Número de menu elegido incorrectamente");
                    }
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Finalizando la aplicación.");
                }

            }
              

            
        }
        
    }

    private static void Menu() {
        System.out.println("Menu: \n");
        System.out.println("1- Dolar => Peso Argentino \n");
        System.out.println("2- Peso Argentino => Dolar \n");
        System.out.println("3- Dolar => Real Brasileño \n");
        System.out.println("4- Real Brasileño => Dolar \n");
        System.out.println("5- Dolar => Peso Colombiano \n");
        System.out.println("6- Peso Colombiano => Dolar \n");
        System.out.println("7- Salir \n");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------ \n");
    }

    private static void Calculo(int cantidad, double cambio, String base_code, String target_code) {
        System.out.println("El valor " + cantidad+ " ["+ base_code + "]" 
        + " corresponde al valor final de ==> "
        + (cantidad * cambio) + " ["+ target_code + "]");
   System.out.println();
   System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

}
