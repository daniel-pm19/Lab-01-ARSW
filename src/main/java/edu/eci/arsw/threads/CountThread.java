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

    @Override
    public void run(){
        countInterval(0,99);
    }


    public void countInterval(int a , int b){
        for(int c = a; c <= b; c++ ){
            System.out.println(c);
        }
    }


    
}
