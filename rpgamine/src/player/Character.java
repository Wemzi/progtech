/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

/**
 *
 * @author lkcsd
 */
 public class Character {
    public String name;
    public int HP;
    public int AD;
    public boolean isDead=false;
    public int DEF;

    public Character(String name, int HP, int AD, int DEF) {
        this.name = name;
        this.HP = HP;
        this.AD = AD;
        this.DEF = DEF;
    }

    public int getDEF() {
        return DEF;
    }

    
    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getAD() {
        return AD;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
    
    
    
    public void attack (Character dfndr)
    {
        if(!this.isDead && !dfndr.isDead)
        {
          System.out.println(this + " attacks : " + dfndr );
                  
          if(dfndr instanceof Berserker) dfndr.setHP(dfndr.getHP()-2*(this.getAD()/dfndr.getDEF()));
       
          else if(dfndr instanceof BlackDragon && this.getAD() > 60)dfndr.setHP(dfndr.getHP()-(this.getAD()/dfndr.getDEF())); 
     
          else if(dfndr instanceof Tank) dfndr.setHP(dfndr.getHP()-((this.getAD())/2/dfndr.getDEF()));
          
          else if (dfndr instanceof RedDragon && this.getAD() > 20) dfndr.setHP(dfndr.getHP()-(this.getAD()/dfndr.getDEF()));
        }
        dfndr.isDead = dfndr.getHP() > 0;
        System.out.println(dfndr.toString());
          
    }
}

