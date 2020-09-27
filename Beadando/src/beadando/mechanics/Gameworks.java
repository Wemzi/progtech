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
import java.io.FileNotFoundException;
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
    
    /** A pályageneráló metódus, amin később meccseket lehet játszani. Tulajdonképpen egy fájlbeolvasás. */
    public Gameworks(String filename,String filename2)
    {
        players=new ArrayList<>();
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
    
    
    /** Egy olyan meccset játszik le, ahol a dobókocka számai véletlenszerűek. 
     * ForEach ciklussal megyünk végig a játékosokon körönként, amely ciklust addig iteráljuk, míg csak egy ember marad a gyűjteményben.*/
    public void playMatch()
    {
        Random rand= new Random();
        int rollingDice;
        while(players.size()>1)
        {
            players.removeIf( x -> x.money < 0 );
            for(Player actual : players)
            {
            int idx=players.indexOf(actual);
            rollingDice = (rand.nextInt(6)+1);
            actual.step(rollingDice,field.size());
            Zone factual = field.get(players.get(idx).position);
            playRound(actual,factual);
            }
        }
         System.out.println(players.get(0).toStringWinner());
    }
    
    
    /**ez a metódus szolgál arra, hogy a szövegfájlból beolvasott számoknak megfelelően történjenek a mezőlépések.
     * Tulajdonképpen ugyanaz, mint a playMatch, csak Random osztály használata nélkül. */
    public int playMatchnoDice(String filename) throws FileNotFoundException
    {
        File input = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(input));
        int rollingDice;
        while(players.size()>1 )
        {
            players.removeIf( x -> x.money < 0 );
            for(Player actual : players)
            {
            try{
            int idx=players.indexOf(actual);
            rollingDice=Integer.parseInt(br.readLine());
            actual.step(rollingDice,field.size());
            Zone factual = field.get(players.get(idx).position);
            playRound(actual,factual);
            }
            catch(IOException e)
            {
                System.out.println("no dice numbers found, game ending, unable to determine winner");
                return 1;
            } 
            catch(NumberFormatException e)
            {
                System.out.println("no more dice numbers found, game ending, unable to determine winner");
                return 2;
            } 
            }
        }
         System.out.println(players.get(0).toStringWinner());
         return 0;
    }
    
    

    public ArrayList<Zone> getField() {
        return field;
    }
    
    public ArrayList<Player> getPlayers()
    {
        return players;
    }
    
    
    /** StringBuilder használatával kiiratjuk az összes mezőt, amelyet létrehoztunk, tehát tkp a pályát. */
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

    
    /** a játék veleje,itt van a fő szabályzat, a pénzmozgás, a stratégiák működésének leprogramozása, a házterület megvétele, a házépítés, majd akár más játékos által történő rálépés is. */
    public void playRound(Player actual, Zone factual)
    {
        if(factual instanceof Property)
            {
                if(actual instanceof Strict)
                {
                    if(!((Property) factual).isIsSold()  && actual.getMoney() > 1000 )
                    {
                        actual.buyArea((Property)factual);
                        ((Strict) actual).money-=1000;
                        //System.out.println(actual + " bought area on field:" + actual.position);
                    }
                    else if(!((Property) factual).isHasHouse() && ((Property) factual).isIsSold() && actual==((Property) factual).getOwner() &&  actual.getMoney() > 4000)
                    {
                        actual.buyHouse((Property)factual);
                        actual.money-=4000;
                        //System.out.println(actual + " bought house on field:" + actual.position );
                    }
                    else if(((Property) factual).isIsSold())
                    {
                        if(((Property) factual).isHasHouse())
                        {
                            ((Strict) actual).money -= 500;
                            ((Property) factual).getOwner().money+=500;
                            //System.out.println(actual + " paid for area of someone else on field:" + actual.position);
                        
                        }
                        else
                        {
                            ((Strict) actual).money -= 2000;
                                ((Property) factual).getOwner().money+=2000;
                                //System.out.println(actual + " paid for house of someone else on field:" + actual.position);
                        }
                    }
                }
                if(actual instanceof Careful)
                {
                     if(!((Property) factual).isIsSold()  && actual.getMoney() > 2000  )
                    {
                        actual.buyArea((Property)factual);
                        ((Careful) actual).money-=1000;
                        //System.out.println(actual + " bought area on field:" + actual.position);
                    }
                    else if(!((Property) factual).isHasHouse() && actual==((Property) factual).getOwner() &&  actual.getMoney() > 8000)
                    {
                        actual.buyHouse((Property)factual);
                        ((Careful) actual).money-=4000;
                        //System.out.println(actual + " bought house on field:" + actual.position);
                        
                    }
                    else if(((Property) factual).isIsSold())
                    {
                        if(((Property) factual).isHasHouse())
                        {
                            ((Careful) actual).money -= 500;
                            ((Property) factual).getOwner().money+=500;
                             //System.out.println(actual + " paid for area of someone else on field:" + actual.position);
                        }
                        else
                        {
                            ((Careful) actual).money -= 2000;
                            ((Property) factual).getOwner().money+=2000;
                             //System.out.println(actual + " paid for house of someone else on field: " + actual.position);
                        }
                    
                   }   
                }
                if(actual instanceof Tactical)
                {
                    if(!((Property) factual).isIsSold()  && actual.getMoney() > 1000 && !((Tactical) actual).isBoughtBefore() )
                    {
                        actual.buyArea((Property)factual);
                        ((Tactical) actual).setBoughtBefore(true);
                        ((Tactical) actual).money-=1000;
                        //System.out.println(actual + " bought area on field:" + actual.position);
                    }
                    else if(!((Property) factual).isHasHouse() && actual==((Property) factual).getOwner() &&  actual.getMoney() > 4000 && !((Tactical) actual).isBoughtBefore() )
                    {
                        actual.buyHouse((Property)factual);
                        ((Tactical) actual).setBoughtBefore(true);
                        ((Tactical) actual).money-=4000;
                        //System.out.println(actual + " bought house on field:" + actual.position);
                    }
                    else if(((Property) factual).isIsSold())
                    {
                        ((Tactical) actual).setBoughtBefore(false);
                        if(((Property) factual).isHasHouse())
                        {
                            ((Tactical) actual).money -= 500;
                            ((Property) factual).getOwner().money+=500;
                             //System.out.println(actual + " paid for area of someone else on field:" + actual.position);
                        }
                        else
                        {
                            ((Tactical) actual).money -= 2000;
                            ((Property) factual).getOwner().money+=2000;
                            //System.out.println(actual + " paid for house of someone else on field:" + actual.position);
                        }
                    }
                }
            }
            else if (factual instanceof Lucky)
            {
                if(actual instanceof Tactical)
                {
                    ((Tactical) actual).setBoughtBefore(false);
                }
                actual.money+=factual.getCost();
                //System.out.println(actual + " got lucky on field:" + actual.position);
            }
            else if(factual instanceof Service)
            {
                if(actual instanceof Tactical)
                {
                    ((Tactical) actual).setBoughtBefore(false);
                }
                actual.money-=factual.getCost();
                //System.out.println(actual + " got unlucky on field:" + actual.position);
            }
    }
}
