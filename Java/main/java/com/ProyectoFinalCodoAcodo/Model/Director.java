package com.ProyectoFinalCodoAcodo.Model;

public class Director extends Persona{
    private int cantPelisDirigidas;

    public Director(String nombre, String apellido, int anioNacimiento, int cantPelisDirigidas){
        this.nombre = nombre;
        this.apellido = apellido;
        this.anioNacimiento = anioNacimiento;
        this.cantPelisDirigidas = cantPelisDirigidas;

    }

    public int getCantPelisDirigidas() {
        return cantPelisDirigidas;
    }

    public void setCantPelisDirigidas(int cantPelisDirigidas) {
        this.cantPelisDirigidas = cantPelisDirigidas;
    }
}
