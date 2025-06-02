/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankBostonModel;


import java.util.Random;

/**
 *
 * @author Cristian
 */
public abstract class CuentaBancaria {

    // Clase abstracta base
    protected String numeroCuenta;
    protected double saldo;

    public CuentaBancaria(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public CuentaBancaria(String numeroCuenta) {
        this(numeroCuenta, 0.0);
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }


    public abstract void depositar(double monto);

    public abstract void girar(double monto);

   

}
