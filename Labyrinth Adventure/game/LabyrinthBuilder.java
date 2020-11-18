package game;

import java.util.ArrayList;
import java.lang.Math;

class LabyrinthBuilder
{
    ArrayList<ArrayList<Cell>> cells = new ArrayList<>();
    Cell currentCell;


    public LabyrinthBuilder()
    {
        for (int idx = 0; idx < 10 ; idx++)
        {
            ArrayList <Cell> tmp = new ArrayList<Cell>();
            for ( int jdx=0; jdx<10; jdx++)
            {
                tmp.add(new Cell(idx,jdx));
            }
            cells.add(tmp);
        }

        currentCell = cells.get(0).get(0);
        currentCell.sethasBeenSelected();
        while(!isEndOfGeneration())
        {
            moveToAdjacentCell();
        }
    }

    private void moveToAdjacentCell()
    {
        double random = Math.random();
        currentCell.sethasBeenSelected();
        if(random < 0.25 && currentCell.getrowIdx() < cells.get(0).size()-1)
        {
            if(!cells.get(currentCell.getcolIdx()).get(currentCell.getrowIdx()+1).gethasBeenSelected())
            {
                currentCell.setedgeRight();
                cells.get(currentCell.getcolIdx()).get(currentCell.getrowIdx()+1).setedgeLeft();
                System.out.println("jobbra");
            }
            currentCell = cells.get(currentCell.getcolIdx()).get(currentCell.getrowIdx()+1);
        }
        else if(random < 0.50 && currentCell.getcolIdx() < cells.size()-1)
        {
            if(!cells.get(currentCell.getcolIdx()+1).get(currentCell.getrowIdx()).gethasBeenSelected())
            {
                System.out.println("fel");
                currentCell.setedgeUp();
                cells.get(currentCell.getcolIdx()+1).get(currentCell.getrowIdx()).setedgeDown();
            }
            currentCell = cells.get(currentCell.getcolIdx()+1).get(currentCell.getrowIdx());
        }
        else if(random < 0.75 && currentCell.getrowIdx() > 0)
        {
            if(!cells.get(currentCell.getcolIdx()).get(currentCell.getrowIdx()-1).gethasBeenSelected())
            {
                System.out.println("balra");
                currentCell.setedgeLeft();
                cells.get(currentCell.getcolIdx()).get(currentCell.getrowIdx()-1).setedgeRight();
            }
            currentCell = cells.get(currentCell.getcolIdx()).get(currentCell.getrowIdx()-1);
        }
        else if(random < 1.00 && currentCell.getcolIdx() > 0)
        {
            if(!cells.get(currentCell.getcolIdx()-1).get(currentCell.getrowIdx()).gethasBeenSelected())
            {
                System.out.println("le");
                currentCell.setedgeDown();
                cells.get(currentCell.getcolIdx()-1).get(currentCell.getrowIdx()).setedgeUp();
            }
            currentCell = cells.get(currentCell.getcolIdx()-1).get(currentCell.getrowIdx());
        }
        else return;
    }

    public boolean isEndOfGeneration()
    {
        boolean end = true;
        for(int idx=0; idx < cells.size() ; idx++)
        {
            for ( int jdx=0; jdx < cells.get(0).size() ; jdx++)
            {
                end = end && cells.get(idx).get(jdx).gethasBeenSelected();
            }
        }
        return end;
    }

    public ArrayList<ArrayList<Cell>> getCells()
    {
        return cells;
    }
}