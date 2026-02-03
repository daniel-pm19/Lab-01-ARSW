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

        Scanner sc = new Scanner(System.in);

        //System.out.print("Introduce a number A: ");
        //int a = sc.nextInt();

        //System.out.print("Introduce a number B: ");
        //int b = sc.nextInt();

        sc.close();

        CountThread t1 = new CountThread(0,99);
        CountThread t2 = new CountThread(99, 199);
        CountThread t3 = new CountThread(200, 299);

        t1.run();
        t2.run();
        t3.run();
            
        System.out.println("All threads have finished");
    }
    
}
