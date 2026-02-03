/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

import java.util.List;
import java.util.Scanner;
import java.lang.Runtime;

/**
 *
 * @author hcadavid
 */
public class Main {

    public static void main(String a[]) throws InterruptedException{
        HostBlackListsValidator hblv=new HostBlackListsValidator();

        Scanner sc = new Scanner(System.in);

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Proccesing cores:" + availableProcessors);

        System.out.print("Enter the number of threads: ");
        int threadsNumber = sc.nextInt();

        List<Integer> blackListOcurrences=hblv.checkHost("200.24.34.55", threadsNumber);

        System.out.println("The host was found in the following blacklists:"+blackListOcurrences);

        sc.close();
    }
    
}
