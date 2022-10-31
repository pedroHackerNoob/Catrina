/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.catrina.entidades;

import com.google.gson.Gson;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author pedro
 */
public class CuentaBancaria {

    
     private String producto;
     private String cuenta;
     private String clabe;
     private String moneda;
     private Cliente cliente;
     private List<Movimiento> movimientos;
     
    public CuentaBancaria deserializar(String json){
        
        CuentaBancaria video = new CuentaBancaria();
        try {
            video = new Gson().fromJson(json, CuentaBancaria.class);
        } catch(Exception ex){
            System.err.print("Ocurrió un error: " + ex.getMessage());
        }
        return video;
    }
     
    public double getDepositos(List<Movimiento> movimientos){
        
        double depositos=0;
        
        for(Movimiento m : movimientos){
            if(m.getTipo() == 1){
                depositos+=m.getCantidad();
            }
        }
        return depositos;
    }
    
    public double getDepositos(List<Movimiento> movimientos, int mes){
        
        double depositos=0;
        
        for(Movimiento m : movimientos){
            
            Calendar calendar = Calendar.getInstance(); 
            calendar.setTime(m.getFecha());
            
           if(calendar.get(Calendar.MONTH)+1 == mes ){
               if(m.getTipo() == 1){
                    depositos+=m.getCantidad();
                }
           }
        }
        return depositos;
    }
    
    public double getRetiros(List<Movimiento> movimientos){
        
        double retiros=0;
        
        for(Movimiento m : movimientos){
            if(m.getTipo() == 2){
                retiros+=m.getCantidad();
            }
        }
        return retiros;
    }
  
        public double getRetiros(List<Movimiento> movimientos,int mes){
        
        double retiros=0;
        
        for(Movimiento m : movimientos){
            Calendar calendar = Calendar.getInstance(); 
            calendar.setTime(m.getFecha());
            
           if(calendar.get(Calendar.MONTH)+1 == mes ){
                if(m.getTipo() == 2){
                    retiros+=m.getCantidad();
                }
            }
        }
        return retiros;
    }
        
    public double getSaldoFinal(List<Movimiento> movimientos){
        
        double saldoActual=0;
        
        for(Movimiento m : movimientos){
            if(m.getTipo() == 1){
                saldoActual+=m.getCantidad();
            }else{
                saldoActual-=m.getCantidad();
            }
        }
        return saldoActual;
    }
    
    public double getSaldoFinal(List<Movimiento> movimientos, int mes){
            
        double saldoActual=0;

        for(Movimiento m : movimientos){

            Calendar calendar = Calendar.getInstance(); 
            calendar.setTime(m.getFecha());
            
            if(calendar.get(Calendar.MONTH)+1 < mes ){
                if(m.getTipo() == 1){
                    saldoActual+=m.getCantidad();
                }else{
                    saldoActual-=m.getCantidad();
                }
            }
        }
        
            for(Movimiento m : movimientos){
                Calendar calendar = Calendar.getInstance(); 
                calendar.setTime(m.getFecha());
                if(calendar.get(Calendar.MONTH)+1 == mes ){
                    if(m.getTipo() == 1){
                        saldoActual+=m.getCantidad();
                    }else{
                        saldoActual-=m.getCantidad();
                    }
            }
        }
        return saldoActual;
    } 
    
    
        public double getSaldoInicialPorMes(List<Movimiento> movimientos, int mes){
            
            double saldoInicial = 0;
            
            for(Movimiento m : movimientos){

                Calendar calendar = Calendar.getInstance(); 
                calendar.setTime(m.getFecha());

                if(calendar.get(Calendar.MONTH)+1 < mes ){
                    if(m.getTipo() == 1){
                        saldoInicial+=m.getCantidad();
                    }else{
                        saldoInicial-=m.getCantidad();
                    }
                }
            }
            return saldoInicial;
        }
    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @return the cuenta
     */
    public String getCuenta() {
        return cuenta;
    }


    /**
     * @return the clabe
     */
    public String getClabe() {
        return clabe;
    }

    /**
     * @return the moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @return the movimientos
     */
    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    /**
     * @param movimientos the movimientos to set
     */
    public void setMovimientos(List<Movimiento> movimientos) {
        
        this.movimientos = movimientos;
    }
    
    public List<Movimiento> bubbleSort(List<Movimiento> arr){
        
        int n = arr.size();
        Movimiento temp = null;  
        
         for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr.get(j-1).getFecha().compareTo(arr.get(j).getFecha())> 0 ){
                    temp = arr.get(j-1);
                    arr.set(j-1,arr.get(j));
                    arr.set(j,temp);
                }
            }
         }
         return arr;
    }
}
