package com.ProyectoFinalCodoAcodo.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.springframework.orm.hibernate5.SessionFactoryUtils.getDataSource;


//Clase que se encarga de conectarse con la BD
public class Conexion {


  //public static Connection getConexion() throws SQLException {

  //bloque try catch
  //En la seccion try ejecuto el código deseado
  //En la sección catch atrapo la excepción o error si sucede.


  // try {
  //Class.forName("com.mysql.cj.jdbc.Driver");
  //agrupar excepciones en un solo catch
  //} catch (ClassNotFoundException | ArithmeticException ex) {
  // ex.printStackTrace(System.out);
  //}
  public String obtenerDatos(String url) {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
    HttpResponse<String> response = null;
    try {
      response = client
              .send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return getDataSource().toString();
  }

  private static Statement getDataSource() {
    return null;
  }
}

//  public static void close (ResultSet rs) throws SQLException {
//    rs.close();
//  }

//  public static void close (Statement st) throws SQLException {
//    st.close();
//  }

// public static void close (Connection cn) throws SQLException {
//  cn.close();
//  }

//}
