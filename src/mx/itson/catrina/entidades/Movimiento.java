/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.catrina.entidades;

import java.util.Date;

/**
 *
 * @author pedro
 */
public class Movimiento {
    
    private Date fecha;
    private String descripcion;
    private double cantidad;
    private int tipo;

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

    /**
     * @return the cantidadl
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidadl the cantidadl to set
     */
    public void setCantidad(double cantidadl) {
        this.cantidad = cantidadl;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    class date {

        public date() {
        }
    }
    
    
}
