package com.jbapps.twenty48;

import java.util.Random;

// -------------------------------------------------------------------------
/**
 * A model to handle all data manipulation
 *
 * @author Jeremy Banks
 * @version March 31, 2014
 */
public class Model
{
    private Tile[][] database;
    private int      totalCount;
    private int      score;


    // ----------------------------------------------------------
    /**
     * Create a new Model object.
     *
     */
    public Model()
    {
        database = new Tile[4][4];
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                database[i][j] = new Tile();
            }
        }
        totalCount = 0;
        newGame();
        linkTiles();
    }


    private void newGame()
    {
        score = 0;
        addNewTile();
        addNewTile();
    }


    /**
     * Link all the tiles together
     */
    private void linkTiles()
    {
        for (int i = 0; i < 4; i++)

        {
            for (int j = 0; j < 4; j++)
            {
                if (j != 0)
                {
                    database[i][j].setLeft(database[i][j - 1]);
                }
                if (j != 3)
                {
                    database[i][j].setRight(database[i][j + 1]);
                }
                if (i != 0)
                {
                    database[i][j].setAbove(database[i - 1][j]);
                }
                if (i != 3)
                {
                    database[i][j].setBelow(database[i + 1][j]);
                }
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * @return the database
     */
    public Tile[][] getDatabase()
    {
        return database;
    }


    // ----------------------------------------------------------
    /**
     * Action taken upon a down swipe
     *
     * @return whether or not tiles were moved
     */
    public boolean downSwipe()
    {
        boolean moved = false;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 3; j > 0; j--)
            {
                if (!database[j][i].isEmpty())
                {
                    Tile nextAbove = database[j][i].getAbove();
                    while (nextAbove.getAbove() != null && nextAbove.isEmpty())
                    {
                        nextAbove = nextAbove.getAbove();
                    }
                    if (!nextAbove.isEmpty()
                        && database[j][i].getCurrentValue() == nextAbove
                            .getCurrentValue())
                    {
                        combine(database[j][i], nextAbove);
                        moved = true;
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++)
        {
            for (int j = 3; j > 0; j--)
            {
                Tile nextAbove = database[j][i].getAbove();
                while (nextAbove.getAbove() != null && nextAbove.isEmpty())
                {
                    nextAbove = nextAbove.getAbove();
                }
                if (database[j][i].isEmpty())
                {
                    if (!nextAbove.isEmpty())
                    {
                        database[j][i].setCurrentValue(nextAbove
                            .getCurrentValue());
                        database[j][i].setEmpty(false);
                        nextAbove.setCurrentValue(0);
                        nextAbove.setEmpty(true);
                        moved = true;
                    }
                }
            }
        }
        if (moved)
        {
            addNewTile();
        }
        return moved;
    }


    // ----------------------------------------------------------
    /**
     * Action taken upon an up swipe
     *
     * @return whether or not tiles were moved
     */
    public boolean upSwipe()
    {
        boolean moved = false;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (!database[j][i].isEmpty())
                {
                    Tile nextBelow = database[j][i].getBelow();
                    while (nextBelow.getBelow() != null && nextBelow.isEmpty())
                    {
                        nextBelow = nextBelow.getBelow();
                    }
                    if (!nextBelow.isEmpty()
                        && database[j][i].getCurrentValue() == nextBelow
                            .getCurrentValue())
                    {
                        combine(database[j][i], nextBelow);
                        moved = true;
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                Tile nextBelow = database[j][i].getBelow();
                while (nextBelow.getBelow() != null && nextBelow.isEmpty())
                {
                    nextBelow = nextBelow.getBelow();
                }
                if (database[j][i].isEmpty())
                {
                    if (!nextBelow.isEmpty())
                    {
                        database[j][i].setCurrentValue(nextBelow
                            .getCurrentValue());
                        database[j][i].setEmpty(false);
                        nextBelow.setCurrentValue(0);
                        nextBelow.setEmpty(true);
                        moved = true;
                    }
                }
            }
        }
        if (moved)
        {
            addNewTile();
        }
        return moved;
    }


    // ----------------------------------------------------------
    /**
     * Action taken upon a left swipe
     *
     * @return whether or not tiles were moved
     */
    public boolean leftSwipe()
    {
        boolean moved = false;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (!database[i][j].isEmpty())
                {
                    Tile nextRight = database[i][j].getRight();
                    while (nextRight.getRight() != null && nextRight.isEmpty())
                    {
                        nextRight = nextRight.getRight();
                    }
                    if (!nextRight.isEmpty()
                        && database[i][j].getCurrentValue() == nextRight
                            .getCurrentValue())
                    {
                        combine(database[i][j], nextRight);
                        moved = true;
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                Tile nextRight = database[i][j].getRight();
                while (nextRight.getRight() != null && nextRight.isEmpty())
                {
                    nextRight = nextRight.getRight();
                }
                if (database[i][j].isEmpty())
                {
                    if (!nextRight.isEmpty())
                    {
                        // Move a tile
                        database[i][j].setCurrentValue(nextRight
                            .getCurrentValue());
                        database[i][j].setEmpty(false);
                        nextRight.setCurrentValue(0);
                        nextRight.setEmpty(true);
                        moved = true;
                    }
                }
            }
        }
        if (moved)
        {
            addNewTile();
        }
        return moved;
    }


    // ----------------------------------------------------------
    /**
     * Action taken upon a right swipe
     *
     * @return whether or not tiles were moved
     */
    public boolean rightSwipe()
    {
        boolean moved = false;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 3; j > 0; j--)
            {
                if (!database[i][j].isEmpty())
                {
                    Tile nextLeft = database[i][j].getLeft();
                    while (nextLeft.getLeft() != null && nextLeft.isEmpty())
                    {
                        nextLeft = nextLeft.getLeft();
                    }
                    if (!nextLeft.isEmpty()
                        && database[i][j].getCurrentValue() == nextLeft
                            .getCurrentValue())
                    {
                        combine(database[i][j], nextLeft);
                        moved = true;
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++)
        {
            for (int j = 3; j > 0; j--)
            {
                Tile nextLeft = database[i][j].getLeft();
                while (nextLeft.getLeft() != null && nextLeft.isEmpty())
                {
                    nextLeft = nextLeft.getLeft();
                }
                if (database[i][j].isEmpty())
                {
                    if (!nextLeft.isEmpty())
                    {
                        // Move a tile
                        database[i][j].setCurrentValue(nextLeft
                            .getCurrentValue());
                        database[i][j].setEmpty(false);
                        nextLeft.setCurrentValue(0);
                        nextLeft.setEmpty(true);
                        moved = true;
                    }
                }
            }
        }
        if (moved)
        {
            addNewTile();
        }
        return moved;
    }


    // ----------------------------------------------------------
    /**
     * Combine two tiles
     *
     * @param staying
     *            the tile that's staying on the board
     * @param goingAway
     *            the tile that's getting removed
     */
    public void combine(Tile staying, Tile goingAway)
    {
        staying.setCurrentValue(staying.getCurrentValue() * 2);
        goingAway.setCurrentValue(0);
        goingAway.setEmpty(true);
        totalCount--;
        score += staying.getCurrentValue();
    }


    // ----------------------------------------------------------
    /**
     * @return true if no possible moves exist, false otherwise
     */
    public boolean checkForGameOver()
    {
        if (database[0][0].getCurrentValue() == database[0][1]
            .getCurrentValue()
            || database[0][0].getCurrentValue() == database[1][0]
                .getCurrentValue()
            || database[0][1].getCurrentValue() == database[0][2]
                .getCurrentValue()
            || database[0][1].getCurrentValue() == database[1][1]
                .getCurrentValue()
            || database[0][2].getCurrentValue() == database[0][3]
                .getCurrentValue()
            || database[0][2].getCurrentValue() == database[1][2]
                .getCurrentValue()
            || database[0][3].getCurrentValue() == database[1][3]
                .getCurrentValue()
            || database[1][0].getCurrentValue() == database[1][1]
                .getCurrentValue()
            || database[1][0].getCurrentValue() == database[2][0]
                .getCurrentValue()
            || database[1][1].getCurrentValue() == database[1][2]
                .getCurrentValue()
            || database[1][1].getCurrentValue() == database[2][1]
                .getCurrentValue()
            || database[1][2].getCurrentValue() == database[1][3]
                .getCurrentValue()
            || database[1][2].getCurrentValue() == database[2][2]
                .getCurrentValue()
            || database[1][3].getCurrentValue() == database[2][3]
                .getCurrentValue()
            || database[2][0].getCurrentValue() == database[2][1]
                .getCurrentValue()
            || database[2][0].getCurrentValue() == database[3][0]
                .getCurrentValue()
            || database[2][1].getCurrentValue() == database[2][2]
                .getCurrentValue()
            || database[2][1].getCurrentValue() == database[3][1]
                .getCurrentValue()
            || database[2][2].getCurrentValue() == database[2][3]
                .getCurrentValue()
            || database[2][2].getCurrentValue() == database[3][2]
                .getCurrentValue()
            || database[2][3].getCurrentValue() == database[3][3]
                .getCurrentValue()
            || database[3][0].getCurrentValue() == database[3][1]
                .getCurrentValue()
            || database[3][1].getCurrentValue() == database[3][2]
                .getCurrentValue()
            || database[3][2].getCurrentValue() == database[3][3]
                .getCurrentValue())
        {
            return false;
        }
        return true;
    }


    // ----------------------------------------------------------
    /**
     * Add a new tile to the game board
     */
    public void addNewTile()
    {
        Random random = new Random();
        boolean added = false;
        int x = -1, y = -1;
        while (added == false)
        {
            x = random.nextInt(4);
            y = random.nextInt(4);
            if (database[x][y].isEmpty())
            {
                added = true;
            }
        }
        boolean twoOrFour = random.nextBoolean();
        int newValue;
        if (twoOrFour)
        {
            newValue = 2;
        }
        else
        {
            newValue = 4;
        }
        database[x][y].setCurrentValue(newValue);
        database[x][y].setEmpty(false);
        totalCount++;
    }


    // ----------------------------------------------------------
    /**
     * Modify a tile for testing purposes
     *
     * @param x
     *            the x coordinate of the tile
     * @param y
     *            the y coordinate of the tile
     * @param newValue
     *            the new value of the tile
     */
    public void modifyTile(int x, int y, int newValue)
    {
        boolean previouslyEmpty = database[x][y].isEmpty();
        database[x][y].setCurrentValue(newValue);
        if (newValue == 0)
        {
            database[x][y].setEmpty(true);
            if (!previouslyEmpty)
            {
                totalCount--;
            }
        }
        else
        {
            database[x][y].setEmpty(false);
            if (previouslyEmpty)
            {
                totalCount++;
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * @return the number of tiles currently in play. For testing.
     */
    public int getTotalCount()
    {
        return totalCount;
    }


    // ----------------------------------------------------------
    /**
     * @return the score of the game
     */
    public int getScore()
    {
        return score;
    }
}
