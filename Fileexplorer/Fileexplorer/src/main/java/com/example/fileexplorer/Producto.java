package com.example.fileexplorer;

/**
 * Created by Luigi on 27/11/2016.
 */

public class Producto {
    private String codigoPrincipal;
    private String descripcion;
    private String cantidad;
    private float precioUnitario;
    private float descuento;
    private float precioTotalSinImpuesto;

    public Producto() {
        this.codigoPrincipal = null;
        this.descripcion = null;
        this.cantidad = null;
        this.precioUnitario = 0;
        this.descuento = 0;
        this.precioTotalSinImpuesto = 0;

    }

    public String getCodigoPrincipal() {
        return codigoPrincipal;
    }

    public void setCodigoPrincipal(String codigoPrincipal) {
        this.codigoPrincipal = codigoPrincipal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getPrecioTotalSinImpuesto() {
        return precioTotalSinImpuesto;
    }

    public void setPrecioTotalSinImpuesto(float precioTotalSinImpuesto) {
        this.precioTotalSinImpuesto = precioTotalSinImpuesto;
    }


}
