package com.example.fileexplorer;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Luigi on 27/11/2016.
 */

public class Factura {
    private String estado;
    private String autorizacion;
    private String numeroAutorizacion;
    private String fechaAutorizacion;
    private String ambiente;
    private String razonSocial;
    private String ruc;
    private String claveAcceso;
    private String codDoc;
    private String estab;
    private String ptoEmi;
    private String dirMatriz;
    private String fechaEmision;
    private String dirEstablecimiento;
    private String contribuyenteEspecial;
    private String obligadoContabilidad;
    private String razonSocialComprador;
    private String identificacionComprador;
    private float  totalSinImpuestos; //El valor de la compra antes de agregar los impuestos
    private float totalDescuento; // El descuento que se va a restar a el valor de la compra
    private HashMap <String,Float> totalConImpuestos; // Aqui van los valores de los impuestos (0%,12%,14%) (tarifa0-tarifa12)
    private float importeTotal; //Valor total a pagar.
    private float propina; // La propina , de haber dejado.
    private LinkedList<Producto> productos; // Un linked list de productos

    public Factura() {
        this.autorizacion = null;
        this.numeroAutorizacion = null;
        this.fechaAutorizacion = null;
        this.ambiente = null;
        this.razonSocial = null;
        this.ruc = null;
        this.claveAcceso = null;
        this.codDoc = null;
        this.estab = null;
        this.ptoEmi = null;
        this.dirMatriz = null;
        this.fechaEmision = null;
        this.dirEstablecimiento = null;
        this.contribuyenteEspecial = null;
        this.obligadoContabilidad = null;
        this.razonSocialComprador = null;
        this.identificacionComprador = null;
        this.totalSinImpuestos = 0;
        this.totalDescuento = 0;
        this.totalConImpuestos = new HashMap <String,Float>();
        this.importeTotal = 0;
        this.propina = 0;
        this.productos = new LinkedList<Producto>();
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public String getNumeroAutorizacion() {
        return numeroAutorizacion;
    }

    public void setNumeroAutorizacion(String numeroAutorizacion) {
        this.numeroAutorizacion = numeroAutorizacion;
    }

    public String getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(String fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public String getCodDoc() {
        return codDoc;
    }

    public void setCodDoc(String codDoc) {
        this.codDoc = codDoc;
    }

    public String getEstab() {
        return estab;
    }

    public void setEstab(String estab) {
        this.estab = estab;
    }

    public String getPtoEmi() {
        return ptoEmi;
    }

    public void setPtoEmi(String ptoEmi) {
        this.ptoEmi = ptoEmi;
    }

    public String getDirMatriz() {
        return dirMatriz;
    }

    public void setDirMatriz(String dirMatriz) {
        this.dirMatriz = dirMatriz;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getDirEstablecimiento() {
        return dirEstablecimiento;
    }

    public void setDirEstablecimiento(String dirEstablecimiento) {
        this.dirEstablecimiento = dirEstablecimiento;
    }

    public String getContribuyenteEspecial() {
        return contribuyenteEspecial;
    }

    public void setContribuyenteEspecial(String contribuyenteEspecial) {
        this.contribuyenteEspecial = contribuyenteEspecial;
    }

    public String getObligadoContabilidad() {
        return obligadoContabilidad;
    }

    public void setObligadoContabilidad(String obligadoContabilidad) {
        this.obligadoContabilidad = obligadoContabilidad;
    }

    public String getRazonSocialComprador() {
        return razonSocialComprador;
    }

    public void setRazonSocialComprador(String razonSocialComprador) {
        this.razonSocialComprador = razonSocialComprador;
    }

    public String getIdentificacionComprador() {
        return identificacionComprador;
    }

    public void setIdentificacionComprador(String identificacionComprador) {
        this.identificacionComprador = identificacionComprador;
    }

    public float getTotalSinImpuestos() {
        return totalSinImpuestos;
    }

    public void setTotalSinImpuestos(float totalSinImpuestos) {
        this.totalSinImpuestos = totalSinImpuestos;
    }

    public float getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(float totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public HashMap<String, Float> getTotalConImpuestos() {
        return totalConImpuestos;
    }

    public void setTotalConImpuestos(String tarifa,float valor) {
        this.totalConImpuestos.put(tarifa,valor);
    }

    public float getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(float importeTotal) {
        this.importeTotal = importeTotal;
    }

    public float getPropina() {
        return propina;
    }

    public void setPropina(float propina) {
        this.propina = propina;
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Producto productos) {
        this.productos.addLast(productos);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
