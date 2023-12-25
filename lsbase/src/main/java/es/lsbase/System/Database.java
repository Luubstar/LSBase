package System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {

    static final String directorioTrabajo = System.getProperty("user.dir");
    static final String url = "jdbc:sqlite:"+directorioTrabajo+"/lsbase/base.db";

    public static void connect() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        try (Connection conn = DriverManager.getConnection(url)) {
            String sqlStarter = """
                    CREATE TABLE IF NOT EXISTS Clientes (	
                    ID integer PRIMARY KEY,
                    Nombre text,
                    Apellido	text,
                    Apellidos	text,
                    Teléfono	text,
                    Teléfonodos	text,
                    DNI	text,
                    Correo_electrónico	text,
                    Dirección_de_suministro	text,
                    Patio	text,
                    Puerta	text,
                    Dirección_de_correspondencia	text,
                    Código_posta	text,
                    Población	text,
                    Provincia	text,
                    CUPS	text,
                    Número_de_cuenta	text,
                    Anexo	text,
                    Tarifa	text,
                    Consumo	INTEGER,
                    Compañía	text,
                    Comisión	text,
                    Activación	text,
                    Persona_autorizada	text,
                    DNI_autorizado	text,
                    Teléfono_autorizado	text,
                    Anotacion text DEFAULT ' ');
                    """;
            Statement stmt = conn.createStatement();
            stmt.execute(sqlStarter);

            System.out.println("Conexión establecida.");
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    public static Cliente ClientFromResult(ResultSet resultSet) throws SQLException{
        String nombre = resultSet.getString("Nombre");
        String apellido1 = resultSet.getString("Apellido");
        String apellido2 = resultSet.getString("Apellidos");
        String telefono1 = resultSet.getString("Teléfono");
        String telefono2 = resultSet.getString("Teléfonodos");
        String dni = resultSet.getString("DNI");
        String correoElectronico = resultSet.getString("Correo_electrónico");
        String direccionSuministro = resultSet.getString("Dirección_de_suministro");
        String patio = resultSet.getString("Patio");
        String puerta = resultSet.getString("Puerta");
        String direccionCorrespondencia = resultSet.getString("Dirección_de_correspondencia");
        int codigoPostal = resultSet.getInt("Código_postal");
        String poblacion = resultSet.getString("Población");
        String provincia = resultSet.getString("Provincia");
        String cups = resultSet.getString("CUPS");
        String numeroCuenta = resultSet.getString("Número_de_cuenta");
        String anexo = resultSet.getString("Anexo");
        String tarifa = resultSet.getString("Tarifa");
        String consumo = resultSet.getString("Consumo");
        String compania = resultSet.getString("Compañía");
        String comision = resultSet.getString("Comisión");
        String activacion = resultSet.getString("Activación");
        String personaAut = resultSet.getString("Persona_autorizada");
        String dniAut = resultSet.getString("DNI_autorizado");
        String telefonoAut = resultSet.getString("Teléfono_autorizado");
        String anotacion = resultSet.getString("Anotacion");

        Cliente c = new Cliente(nombre, apellido1, apellido2, telefono1, telefono2, dni, correoElectronico,
                        direccionSuministro, patio, puerta, direccionCorrespondencia, codigoPostal,
                        poblacion, provincia, cups, numeroCuenta, anexo, tarifa, consumo, compania,
                        comision, activacion, personaAut, dniAut, telefonoAut, anotacion);
        return c;
    }

    public static ArrayList<Cliente> getAll(){
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Clientes")) {

            while (resultSet.next()) {
                lista.add(ClientFromResult(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static ArrayList<Cliente> getCoincidences(String search){
        String sql = """
            SELECT *
            FROM Clientes
            WHERE Nombre LIKE '%Ana%'
            OR Apellido LIKE '%Ana%'
            OR Apellidos LIKE '%Ana%'
            OR Teléfono LIKE '%Ana%'
            OR Teléfonodos LIKE '%Ana%'
            OR DNI LIKE '%Ana%'
            OR Correo_electrónico LIKE '%Ana%'
            OR Dirección_de_suministro LIKE '%Ana%'
            OR Patio LIKE '%Ana%'
            OR Puerta LIKE '%Ana%'
            OR Dirección_de_correspondencia LIKE '%Ana%'
            OR Código_postal LIKE '%Ana%'
            OR Población LIKE '%Ana%'
            OR Provincia LIKE '%Ana%'
            OR CUPS LIKE '%Ana%'
            OR Número_de_cuenta LIKE '%Ana%'
            OR Anexo LIKE '%Ana%'
            OR Tarifa LIKE '%Ana%'
            OR Compañía LIKE '%Ana%'
            OR Comisión LIKE '%Ana%'
            OR Activación LIKE '%Ana%'
            OR Persona_autorizada LIKE '%Ana%'
            OR DNI_autorizado LIKE '%Ana%'
            OR Teléfono_autorizado LIKE '%Ana%'
            OR Anotacion LIKE '%Ana%';
            """;
        sql = sql.replace("Ana", search);
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        try (Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                lista.add(ClientFromResult(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
