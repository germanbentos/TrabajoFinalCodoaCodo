package com.ProyectoFinalCodoAcodo.Service;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ProyectoFinalCodoAcodo.Model.Pelicula;

import static jdk.internal.net.http.common.Utils.close;


public class PeliculaDAO {


  private static final String SQL_SELECT = "SELECT * FROM movie";


  public static List<Pelicula> seleccionar() {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Pelicula pelicula = null;
    List<Pelicula> peliculas = new ArrayList<>();

    try {
      conn = getConexion();
      ps = conn.prepareStatement(SQL_SELECT);
      rs = ps.executeQuery();

      //Itero los resultados del ResultSet
      while(rs.next()){
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String descripcion = rs.getString("descripcion");
        String genero = rs.getString("genero");
        int calificacion = rs.getInt("calificacion");
        int anio = rs.getInt("anio");
        byte estrellas = rs.getByte("estrellas");
        String director = rs.getString("director");

        pelicula = new Pelicula(id, nombre, descripcion, genero, calificacion, anio, estrellas, director);

        //agregar la pelicula en nuestro listado de pelis
        peliculas.add(pelicula);

      }
    } catch (Exception e) {
      e.printStackTrace(System.out);
    } finally {
      try {
        close((Closeable) rs);
        close((Closeable) ps);
        close((Closeable) conn);
      } catch(Exception e) {
        e.printStackTrace(System.out);
      }
    }
    return peliculas;
  }

  private static Connection getConexion() {
    return null;
  }

}
