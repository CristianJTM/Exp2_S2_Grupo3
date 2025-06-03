/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankBostonModel;

import BankBostonModel.CuentaCorriente;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

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
    private static final Set<String> cuentasGeneradas = new HashSet<>();

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
        this.cuentaCorriente = new CuentaCorriente(cuenta);
        this.cuentaAhorro = new CuentaAhorro(cuenta);
        this.cuentaCredito = new CuentaCredito(cuenta);

        System.out.println("¡Registro Exitoso! Su numero de cuenta es: " + cuenta);
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public CuentaAhorro getCuentaAhorro() {
        return cuentaAhorro;
    }

    public CuentaCredito getCuentaCredito() {
        return cuentaCredito;
    }

    @Override
    public String toString() {
        return "Cliente{" + "Nombre: " + nombre + '\n'
                + "Rut: " + rut + '\n'
                + "Apellido paterno: " + apellidoPaterno + '\n'
                + "Apellido materno: " + apellidoMaterno + '\n'
                + "Domicilio: " + domicilio + '\n'
                + "Comuna: " + comuna + '\n'
                + "Teléfono: " + telefono + '\n'
                + '}';
    }
    
    //Genera Numero de Cuenta Aleatorio de 9 digitos y valida que no se repita revisando el set de numeros de cuenta.
    private String generarNumeroCuenta() {
        Random random = new Random();
        String numeroCuenta;
        do {
            int numero = 100000000 + random.nextInt(900000000);
            numeroCuenta = String.valueOf(numero);
        } while (cuentasGeneradas.contains(numeroCuenta));

        cuentasGeneradas.add(numeroCuenta);
        return numeroCuenta;
    }
}
