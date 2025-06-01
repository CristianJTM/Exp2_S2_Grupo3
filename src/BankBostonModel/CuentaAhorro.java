/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankBostonModel;

/**
 *
 * @author Cristian
 */

public class CuentaAhorro extends CuentaBancaria{

    public CuentaAhorro(String numeroCuenta, double saldo) {
        super(numeroCuenta, saldo);
    }

    @Override
    public void girar(double monto) {
        if(monto<=saldo){
            saldo -=monto;
            System.err.println("Giro desde Cuenta Ahorro: $"+monto);
        }else{
            System.out.println("Saldo insuficiente en Cuenta Ahorro.");
        }
    }
}