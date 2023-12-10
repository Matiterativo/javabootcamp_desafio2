package com.javabootcamp_desafio2;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio_1 {

	public static void main(String[] args) {
		
        	final int HORAS_EN_DIA = 24;
        	final int HORAS_EN_SEMANA = 168; // 24 * 7
        
        	final String TEXTO_INICIO_PROGRAMA = " =========================================================== \n" +
                				     " \u001B[1mCONVERSOR DE HORAS A SEMANAS, DIAS y HORAS\u001B[0m \n" +
                        	                     " \u001B[1mV.1.0 \u001B[0m\n\n" +
                				     " \u001B[1mInstrucciones:\u001B[0m ingrese un número entero de horas.\n"+
                                        	     " Las mismas serán convertidas a semanas, días y horas.\n" +
                			     	     " Ingrese 0 para finalizar el programa.\n" +
                                             	     " =========================================================== \n";
        
        	final String MENSAJE_INGRESO_HORAS = "Ingrese la cantidad de horas a convertir: ";
        	final String MENSAJE_CONVERSION_CORRECTA = "Semanas: %d\nDías: %d\nHoras: %d \n";        
        	final String MENSAJE_ERROR_ENTEROS_NEGATIVOS = "Error: para la conversión debe ingresar un número mayor a 0, o 0 para finalizar.";
        	final String MENSAJE_ERROR_TIPO_INVALIDO = "Error: debe ingresar un número entero.";
        	final String MENSAJE_FIN_PROGRAMA = "\nUsted a finalizado el programa. Hasta luego!! \u263A";
        	final String TEXTO_LINEA_DIVISORIA = "-------------------------------------------------------------";
        
        	int cantidadHoras=-1;		
        	Scanner scanner = new Scanner(System.in);
        
		System.out.println(TEXTO_INICIO_PROGRAMA);
		
		do {
			
			try {
			
				System.out.print(MENSAJE_INGRESO_HORAS);
				cantidadHoras = scanner.nextInt();
				
				if (cantidadHoras > 0) {
			
					int cantidadSemanas = cantidadHoras / HORAS_EN_SEMANA;
					
					//A partir de las horas indivisibles por semanas, calculo la cantidad de días
					int cantidadDias = cantidadHoras % HORAS_EN_SEMANA / HORAS_EN_DIA;
					
					//Calculo las horas que son indivisibles por semanas y por días
					int cantidadHorasRestantes = cantidadHoras % HORAS_EN_SEMANA % HORAS_EN_DIA;
					
					System.out.printf(MENSAJE_CONVERSION_CORRECTA, cantidadSemanas, cantidadDias, cantidadHorasRestantes);
					
				} else if (cantidadHoras < 0) { 
					System.out.println(MENSAJE_ERROR_ENTEROS_NEGATIVOS);
				}
				
			} catch (InputMismatchException e) {
	            		System.out.println(MENSAJE_ERROR_TIPO_INVALIDO);
	            		scanner.next(); //Consumo entrada no numérica para permitir leer un nuevo ingreso
			}
			
			System.out.println(TEXTO_LINEA_DIVISORIA);
			
		} while (cantidadHoras != 0);
		
		System.out.println(MENSAJE_FIN_PROGRAMA);
		
		scanner.close();
	}
}
