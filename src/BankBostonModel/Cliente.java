/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankBostonModel;

import BankBostonModel.CuentaCorriente;
import java.util.Random;

/**
 *
 * @author Cristian
 */
public class Cliente {

    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private int telefono;
    private CuentaCorriente cuentaCorriente;
    private CuentaAhorro cuentaAhorro;
    private CuentaCredito cuentaCredito;

    public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno,
            String domicilio, String comuna, int telefono) {
        String cuenta = generarNumeroCuenta();
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuentaCorriente = new CuentaCorriente(cuenta, 0);
        this.cuentaAhorro = new CuentaAhorro(cuenta, 0);
        this.cuentaCredito = new CuentaCredito(cuenta, 0);

        System.out.println("¡Registro Exitoso! Su numero de cuenta es: " + cuenta);
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public CuentaCorriente getCuenta() {
        return cuentaCorriente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "Nombre: " + nombre + '\'' + 
                "Rut: " + rut + '\'' + 
                "Nombre: " + nombre + '\'' +
                "Apellido paterno: " + apellidoPaterno + '\'' +
                "Apellido materno: " + apellidoMaterno + '\'' +
                "Domicilio: " + domicilio + '\'' +
                "Comuna: " + comuna + '\'' +
                "Teléfono: " + telefono + '\'' +
                
                '}';
    }

    private String generarNumeroCuenta() {
        Random random = new Random();
        int numero = 100000000 + random.nextInt(900000000); // 9 dígitos
        return String.valueOf(numero);
    }
}
