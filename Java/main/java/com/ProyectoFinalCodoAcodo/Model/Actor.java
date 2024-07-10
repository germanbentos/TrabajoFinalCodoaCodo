package com.ProyectoFinalCodoAcodo.Model;

public class Actor extends Persona {
    int cantPeliculas;

    public Actor(String nombre, String apellido, int anioNacimiento, int cantPeliculas){
        this.nombre = nombre;
        this.apellido = apellido;
        this.anioNacimiento = anioNacimiento;
        this.cantPeliculas = cantPeliculas;
    }

    public int getCantPeliculas() {
        return cantPeliculas;
    }

    public void setCantPeliculas(int cantPeliculas) {
        this.cantPeliculas = cantPeliculas;
    }

    @Override
    public String toString(){
        return "Actor[getCantPeliculas()="+ getCantPeliculas() + ",getnombre()=" + getNombre() + ",getapellido()=" + getApellido() + ",getanioNacimiento()=" + getAnioNacimiento() + "]";
    }
}
