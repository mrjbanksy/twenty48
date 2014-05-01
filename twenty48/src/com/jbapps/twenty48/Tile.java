package com.jbapps.twenty48;

// -------------------------------------------------------------------------
/**
 * A class to keep track of all data for each tile
 *
 * @author Jeremy Banks
 * @version March 31, 2014
 */
public class Tile
{
    private int     currentValue;
    private Tile    left;
    private Tile    right;
    private Tile    above;
    private Tile    below;
    private boolean isEmpty;


    // ----------------------------------------------------------
    /**
     * Create a new Tile object.
     */
    public Tile()
    {
        currentValue = 0;
        left = null;
        right = null;
        above = null;
        below = null;
        isEmpty = true;
    }


    // ----------------------------------------------------------
    /**
     * @return the currentValue
     */
    public int getCurrentValue()
    {
        return currentValue;
    }


    // ----------------------------------------------------------
    /**
     * Set the current value of the tile
     *
     * @param currentValue
     *            the new value
     */
    public void setCurrentValue(int currentValue)
    {
        this.currentValue = currentValue;
    }


    // ----------------------------------------------------------
    /**
     * @return the left tile
     */
    public Tile getLeft()
    {
        return left;
    }


    // ----------------------------------------------------------
    /**
     * Set a new left tile
     *
     * @param left
     *            the tile to set
     */
    public void setLeft(Tile left)
    {
        this.left = left;
    }


    // ----------------------------------------------------------
    /**
     * @return the right tile
     */
    public Tile getRight()
    {
        return right;
    }


    // ----------------------------------------------------------
    /**
     * Set a new right tile
     *
     * @param right
     *            the tile to set
     */
    public void setRight(Tile right)
    {
        this.right = right;
    }


    // ----------------------------------------------------------
    /**
     * @return the above tile
     */
    public Tile getAbove()
    {
        return above;
    }


    // ----------------------------------------------------------
    /**
     * Set a new above tile
     *
     * @param above
     *            the tile to set
     */
    public void setAbove(Tile above)
    {
        this.above = above;
    }


    // ----------------------------------------------------------
    /**
     * @return the below tile
     */
    public Tile getBelow()
    {
        return below;
    }


    // ----------------------------------------------------------
    /**
     * @param below
     *            the tile to set
     */
    public void setBelow(Tile below)
    {
        this.below = below;
    }


    // ----------------------------------------------------------
    /**
     * @return if the tile is empty
     */
    public boolean isEmpty()
    {
        return isEmpty;
    }


    // ----------------------------------------------------------
    /**
     * @param isEmpty
     *            whether the tile is empty
     */
    public void setEmpty(boolean isEmpty)
    {
        this.isEmpty = isEmpty;
    }

}
