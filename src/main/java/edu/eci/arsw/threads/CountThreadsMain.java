/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */

import java.util.Scanner;

public class CountThreadsMain {

    public static void main(String[] args){

        int result = 10/3;
        System.out.println(result);

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce a number A: ");
        int a = sc.nextInt();

        System.out.print("Introduce a number B: ");
        int b = sc.nextInt();

        sc.close();

        CountThread t1 = new CountThread();

        t1.countInterval(a, b);

        t1.start();
            
        System.out.println(" Todos los hilos han terminado");
    }
    
}
