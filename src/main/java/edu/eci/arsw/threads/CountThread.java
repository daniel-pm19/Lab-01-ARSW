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

public class CountThread extends Thread{

    private int a;
    private int b;

    CountThread(int a, int b){
        this.a=a;
        this.b=b;
    }


    @Override
    public void run(){
        countInterval(a,b);
    }


    public void countInterval(int a , int b){
        for(int c = a; c <= b; c++ ){
            System.out.println(c);
        }
    }


    
}
