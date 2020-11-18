package game;

class Player
{
    private int coordX=0;
    private int coordY=0;


    public Player()
    {
        coordX=0;
        coordY=0; 
    }

    public void move(int moveX, int moveY)
    {
        coordX+=moveX;
        coordY+=moveY;
    }

    public int getcoordX()
    {
        return coordX;
    }
    public int getcoordY()
    {
        return coordY;
    }
}