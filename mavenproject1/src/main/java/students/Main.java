/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lkcsd
 */
public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        Scanner sc = new Scanner(System.in);
        ArrayList<Hallgato> database = new ArrayList<>();
        for(int idx=0; idx<1;idx++)
        {
            String tmp1= sc.nextLine();
            String tmp2= sc.nextLine();
            Double tmp3= sc.nextDouble();
            database.add(new Hallgato(tmp1,tmp2,tmp3));
        }
    
    database.add(new Hallgato("Joska","magyar",3.25));
    database.add(new Hallgato("Matyas","ukran",4.2));
    database.add(new Hallgato("David","idegen",5.33));
    database.add(new Hallgato("Kelemen","nemet",3.33));
    
    
    StringBuilder sb = new StringBuilder("Students getting money: ");
    
    for(int idx=0; idx<database.size(); idx++)
    {
                if(database.get(idx).getMaverage()<=4.00) {
        } else {
                    sb.append(database.get(idx).getName());
                    sb.append(" ");
        }
    }
    System.out.println(sb.toString());
    
   // Collections.min(database, compare)
    }
}
