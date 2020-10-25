/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author lkcsd
 */
public class Zoo {

    public Zoo(String filename)
    {
         String[] data;
        try (BufferedReader bf = new BufferedReader(new FileReader(input))) {
            String line=null;
            int lineNumber = Integer.parseInt(bf.readLine());
            for(int idx=0; idx<lineNumber;idx++)
            {
                line=bf.readLine();
            data = line.split(" ");
            if(data[0].equals("E"))
            {
                field.add(new Property(data[1],Integer.parseInt(data[2]),));
            }
            else if(data[0].equals("L"))
            {
                field.add(new Lucky(Integer.parseInt(data[1])));
            }
            else if(data[0].equals("S"))
            {
                field.add(new Service(Integer.parseInt(data[1])));
            }
            else throw new IOException("File format error");
            }
        } catch (IOException e) {
            System.out.println("IO error occured: " + e.getMessage());
        }
 
        File input2 = new File(filename2);
        String[] data2;
        try (BufferedReader bf = new BufferedReader(new FileReader(input2))) {
            String line=null;
            int lineNumber = Integer.parseInt(bf.readLine());
            for(int idx=0; idx<lineNumber;idx++)
            {
                line=bf.readLine();
            data = line.split(" ");
            if(data[1].equals("S"))
            {
                players.add(new Strict(data[0]));
            }
            else if(data[1].equals("C"))
            {
                players.add(new Careful(data[0]));
            }
            else if(data[1].equals("T"))
            {
                players.add(new Tactical(data[0]));
            }
            else throw new IOException("File format error");
            }
        } catch (IOException e) {
            System.out.println("IO error occured: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        
    }
    
}
