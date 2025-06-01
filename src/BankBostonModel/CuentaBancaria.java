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


    public void depositar(double monto) {
        saldo += monto;
        System.out.println("Depósito realizado: $" + monto);
        System.out.println("Usted tiene un saldo actual de " + saldo + " pesos.");
    }

    public abstract void girar(double monto);

    

    public void girar(int monto) {
        if (monto > saldo) {
            System.out.println("No se puede realizar el giro. Saldo insuficiente");
        } else {
            saldo -= monto;
            System.out.println("¡Giro realizado de manera exitosa!");
            System.out.println("Usted tiene un saldo actual de " + saldo + " pesos.");
        }
    }

}
