        /**
        * @file RevealAlgorithm.java
        * @author Ifan
        * @date  02/12/2015.
        * @see Player.java
        * @see Counter.java
        * @see Board.java
        * @see Tile.java
        * @see Square.java
        * Reveals all tiles and will perform recursivly on tiles adjacent to mines and will reveal
        all mines upon hitting a mine.
        */
public class RevealAlgorithm {
            /**
             * takes two arguments and returns
             * @param x where x is the x coordinate
             * @param y where y is the y coordinate
             * @see getBOARD_SIZE()
             * @see getTile()
             * @see incrementRevealedTileCount()
             * @see setTileRemainingCount()
             * @see getReveleadTileCount()
             * @see repaint()
             * @see revealCheckTwo()
             * @see floodFill()
             * @return when clicked on a 0
            it will make the surrounding 0 tiles disappear.
             */

    public static void floodFill(int x, int y) {
        if (0 <= x && x <= Board.getBOARD_SIZE() - 1
                && 0 <= y && y <= Board.getBOARD_SIZE() - 1)   {
            if (Board.getTile(x, y) != null)  {
                if (revealCheckOne(x, y)) {
                    Board.getTile(x, y).setIsHidden(false);
                    Board.getTile(x, y).setEnabled(false);
                    Counter.incrementRevealedTileCount();
                    Counter.decrementTilesRemainingCount();
                    if (revealCheckTwo(x, y)) {
                        floodFill(x, y + 1);
                        floodFill(x + 1, y);
                        floodFill(x, y - 1);
                        floodFill(x - 1, y);
                    }
                }
            } else {
                return;
            }
            return;
        }
    }
            /**
             * takes two arguments and returns
             * @param x where x is the x coordinate
             * @param y where y is the y coordinate
             * @see getTile()
             * @see getIsHidden()
             * @see getIsMine()
             * @see getIsDiffused()
             * @return makes sure the tile is hidden before running and is not a mine and is not diffused
             */

    public static Boolean revealCheckOne(int x, int y)   {
        return (Board.getTile(x, y).getIsHidden() && !Board.getTile(x, y).getIsMine()
                && !Board.getTile(x, y).getIsDiffused());
    }
            /**
             * takes two arguments and returns
             * @param x where x is the x coordinate
             * @param y where y is the y coordinate
             * @see getTile()
             * @see getNumOfMinesAdjacent()
             * @return checks whether adjacent tiles is 0
             */

    public static Boolean revealCheckTwo(int x, int y)  {
        Square square = (Square) Board.getTile(x, y);
        return (square.getNumOfMinesAdjacent() == 0);
    }

            /**
             * takes two arguments and returns
             * @param x where x is the x coordinate
             * @param y where y is the y coordinate
             * @see getTile()
             * @see getIsDiffused()
             * @see setIsHidden()
             * @see getBOARD_SIZE()
             * @see getIsMine()
             * @see setIsHidden()
             * @see setEnabled()
             * @see repaint()
             * @return reveals a mine then reveals all the mines on the board
             */

    public void ifMine(int x, int y) {
    	if(!Board.getTile(x, y).getIsDiffused()){
    		Board.getTile(x, y).setIsHidden(false);
    		for (int i = 0; i < Board.getBOARD_SIZE(); i++) {
    			for (int j = 0; j < Board.getBOARD_SIZE(); j++)  {
    				if (Board.getTile(i, j).getIsMine())    {
    					Board.getTile(i, j).setIsHidden(false);
    					Board.getTile(i, j).setEnabled(false);
    					GameResult.setGameLoss(true);
    				}
    			}
    		}
    	}
    }
}
