/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beadando.mechanics;

import beadando.players.*;
import beadando.zones.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lkcsd
 */
public class Gameworks {

    public ArrayList<Zone> field;
    public ArrayList<Player> players;
    public Gameworks(String filename, ArrayList<Player> players)
    {
        this.players=players;
        field = new ArrayList<>();
        File input = new File(filename);
        
        String[] data;
        try (BufferedReader bf = new BufferedReader(new FileReader(input))) {
            String line=null;
            int lineNumber = Integer.parseInt(bf.readLine());
            for(int idx=0; idx<lineNumber;idx++)
            {
                line=bf.readLine();
            data = line.split(" ");
            if(data[0].equals("P"))
            {
             field.add(new Property());
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
    }
    
    public void playMatch()
    {
        Random rand= new Random();
        int rollingDice;
        int actualPlayer=0;
        while(players.size()>1)
        {
            rollingDice = (rand.nextInt(6)+1);
            Player actual = players.get(actualPlayer);
            actual.step(rollingDice);
            Zone factual = field.get(players.get(actualPlayer).position);
            if(factual instanceof Property)
            {
                if(actual instanceof Strict)
                {
                    if(!((Property) factual).isIsSold()  && actual.getMoney() > 1000 )
                    {
                        actual.buyArea((Property)factual);
                    }
                    else if(((Property) factual).isIsSold())
                    {
                        if(((Property) factual).isHasHouse())
                        {
                            ((Tactical) actual).money -= 500;
                        }
                        else
                        {
                            ((Tactical) actual).money -= 2000;
                        }
                }
                if(actual instanceof Careful)
                {
                     if(!((Property) factual).isIsSold()  && actual.getMoney() > 2000 )
                    {
                        actual.buyArea((Property)factual);
                    }
                    else if(((Property) factual).isIsSold())
                    {
                        if(((Property) factual).isHasHouse())
                        {
                            ((Tactical) actual).money -= 500;
                        }
                        else
                        {
                            ((Tactical) actual).money -= 2000;
                        }
                }
                
                 if(actual instanceof Tactical)
                {
                    if(!((Property) factual).isIsSold()  && actual.getMoney() > 1000 && ((Tactical) actual).isBoughtBefore() )
                    {
                        actual.buyArea((Property)factual);
                        ((Tactical) actual).setBoughtBefore(true);
                    }
                    else if(((Property) factual).isIsSold())
                    {
                        if(((Property) factual).isHasHouse())
                        {
                            ((Tactical) actual).money -= 500;
                        }
                        else
                        {
                            ((Tactical) actual).money -= 2000;
                        }
                    }
                }
                
            }
            
           
        }
    }
        }
    }
    

    public ArrayList<Zone> getField() {
        return field;
    }
    
    public ArrayList<Player> getPlayers()
    {
        return players;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(players.toString());
        for(int idx=0; idx<field.size();idx++)
        {
         sb.append(field.get(idx).toString());
         sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
    
}
