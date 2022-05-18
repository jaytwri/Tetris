package com.example.tetrisgame.app;



import com.example.tetrisgame.dto.BoardStateDto;

import java.util.ArrayList;
import java.util.Random;

public class TetrisGame
{

    public pair[][] board;
    public piece fallingPiece;
    public piece defaultPiece = new piece('D');
    public boolean lPress;
    public boolean rPress;
    public boolean uPress;
    private final int width = 10;
    private final int height = 20;
    public int score = 0;
    public int movedLast = 0;

    public TetrisGame(BoardStateDto boardState){
        board = new pair[10][20];
        fallingPiece = new TetrisGame.piece(boardState.getFallingType());
        pair[] pairs = new pair[4];
        int[][] p = boardState.getFallingPairs();
        for(int i = 0; i < 4; i++){
            pairs[i] = new pair(p[i][0], p[i][1]);
        }
        fallingPiece.setPairs(pairs);
        boolean[][] b = boardState.getBoard();
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){

                if (b[i][j]) board[i][j] = new pair(i, j);
            }
        }
    }

    public TetrisGame()
    {
        board = new pair[10][20];
        Random rand = new Random();

        int randPiece = rand.nextInt(7);
        switch(randPiece)
        {
            case 0:
                fallingPiece = new piece('I');

                break;
            case 1:
                fallingPiece = new piece('L');

                break;
            case 2:
                fallingPiece = new piece('J');

                break;
            case 3:
                fallingPiece = new piece('S');

                break;
            case 4:
                fallingPiece = new piece('Z');

                break;
            case 5:
                fallingPiece = new piece('T');

                break;
            case 6:
                fallingPiece = new piece('O');
        }

    }


    public void clearLines()
    {
        int highestPair = fallingPiece.pairs[0].y;
        int lowestPair = fallingPiece.pairs[0].y;
        for(int i = 1; i < fallingPiece.pairs.length; i++)
        {
            highestPair = Math.min(highestPair, fallingPiece.pairs[i].y);
            lowestPair = Math.max(lowestPair, fallingPiece.pairs[i].y);
        }

        ArrayList<Integer> clearedLines = new ArrayList<>();

        for(int i = highestPair; i <= lowestPair; i++)
        {
            boolean lineClear = true;
            for(int j = 0; j < width; j++)
            {
                if(board[j][i] == null)
                    lineClear = false;
            }
            if(lineClear)
            {
                clearedLines.add(i);

            }
        }
        if(clearedLines.size() > 0) {
            int linesCleared = 0;
            for (int i = clearedLines.size() - 1; i >= 0; i--) {

                int row = clearedLines.get(i);
                //clearing a line moves subsequent lines down by 1 which could include lines which need
                //to be cleared so clear the index of the row + how many rows we have cleared so far
                clearRow(row + linesCleared);
                linesCleared++;
            }
        }




        score += (100 * Math.pow(clearedLines.size(), 2));
    }

    private void clearRow(int rowInd)
    {
        //clear the line
        for(int col = 0; col < 10; col++)
        {
            board[col][rowInd] = null;
        }
        //move everything above down one
        for(int i = rowInd; i > 0; i--)
        {
            for(int j = 0; j < 10; j++)
            {
                board[j][i] = board[j][i-1];
                if(board[j][i] != null)
                    board[j][i].setY(i-1);
            }
        }

    }

    /*
    public void clearLines()
    {
        int highestPair = fallingPiece.pairs[0].y;
        int lowestPair = fallingPiece.pairs[0].y;
        for(int i = 1; i < fallingPiece.pairs.length; i++)
        {
            highestPair = Math.min(highestPair, fallingPiece.pairs[i].y);
            lowestPair = Math.max(lowestPair, fallingPiece.pairs[i].y);
        }

        ArrayList<Integer> clearedLines = new ArrayList<>();

        for(int i = highestPair; i <= lowestPair; i++)
        {
            boolean lineClear = true;
            for(int j = 0; j < width; j++)
            {
                if(board[j][i] == null)
                    lineClear = false;
            }
            if(lineClear)
            {
                clearedLines.add(i);
            }
        }

        for(int i = 0; i < clearedLines.size(); i++)
        {
            int row = clearedLines.get(i);
            for(int col = 0; col < 10; col++)
            {
                board[col][row] = null;
            }
        }

        //move the above pieces down to fill the space
        if(clearedLines.size() > 0) {
            for (int i = 0; i < 20 - clearedLines.size(); i++) {
                for (int j = 0; j < 10; j++) {
                    if(board[j][i] != null) {
                        board[j][i].setY(i + clearedLines.size());
                        board[j][i] = board[j][i + clearedLines.size()];
                    }
                }
            }
        }
        score += (100 * Math.pow(clearedLines.size(), 2));

    }
*/
    public void setLPress(boolean b)
    {
        lPress = b;
    }
    public void setRPress(boolean b)
    {
        rPress = b;
    }
    public void setUPress(boolean b)
    {
        uPress = b;
    }


    public void placePair(pair p)
    {
        board[p.getX()][p.getY()] = p;
    }

    public boolean canPlacePiece(piece p)
    {
        pair[] pairs = p.getPairs();
        for(int i = 0; i < pairs.length; i++)
        {
            if(pairs[i].getX() >= 0 && pairs[i].getX() < 10 && pairs[i].getY() >= 0 && pairs[i].getY() < 20)
            {
                if (board[pairs[i].getX()][pairs[i].getY()] != null)
                    return false;
            }
            else
            {
                return false;
            }
        }
        return true;
    }


//removes the given piece from the board useful for moving the falling piece around
    public void removePiece(piece p)
    {
        for(int i = 0; i < p.getPairs().length; i++)
        {
            board[p.getPairs()[i].getX()][p.getPairs()[i].getY()] = null;
        }
    }

    public boolean spawnPiece()
    {

        Random rand = new Random();

        int randPiece = rand.nextInt(7);
        switch(randPiece)
        {
            case 0:
                fallingPiece = new piece('I');

                break;
            case 1:
                fallingPiece = new piece('L');

                break;
            case 2:
                fallingPiece = new piece('J');

                break;
            case 3:
                fallingPiece = new piece('S');

                break;
            case 4:
                fallingPiece = new piece('Z');

                break;
            case 5:
                fallingPiece = new piece('T');

                break;
            case 6:
                fallingPiece = new piece('O');
        }

        if(canPlacePiece(fallingPiece))
        {
            pair[] pairs = fallingPiece.getPairs();
            for(int i = 0; i < pairs.length; i++)
            {
                placePair(pairs[i]);
            }
            return true;
        }
        else return false;
    }
//places a piece on the board takes 2 pieces p is the new p you are placing and o was the original
    //not always 2 different pieces
    public piece placePiece(piece p, piece o)
    {
        if(canPlacePiece(p))
        {
            pair[] pairs = p.getPairs();
            for(int i = 0; i < pairs.length; i++)
            {
                placePair(pairs[i]);
            }
            return p;
        }
        else {
            pair[] pairs = o.getPairs();
            for(int i = 0; i < pairs.length; i++)
            {
                placePair(pairs[i]);
            }
            return o;
        }
    }


    public class piece
    {
        private pair[] pairs = new pair[4];
        private char pieceType;
        private pair boundingBox;
        private int orientationX[][];
        private int orientationY[][];
        private int rotationState = 0;
        public piece(char type)
        {
            pieceType = type;
            switch(type)
            {
                case 'I':
                    //I
                    pairs[0] = new pair(5, 0);
                    pairs[1] = new pair(5, 1);
                    pairs[2] = new pair(5, 2);
                    pairs[3] = new pair(5, 3);
                    boundingBox = new pair(3, 0);
                    orientationX = new int[][]{{1,0,-1,-2},{-2,-1,0,1},{-1,0,1,2},{2,1,0,-1}};
                    orientationY = new int[][]{{2,1,0,-1},{1,0,-1,-2},{-2,-1,0,1},{-1,0,1,2}};
                    break;
                case 'J':
                    //J
                    pairs[0] = new pair(5, 0);
                    pairs[1] = new pair(5, 1);
                    pairs[2] = new pair(6, 1);
                    pairs[3] = new pair(7, 1);
                    boundingBox = new pair(4, 0);
                    orientationX = new int[][]{{2,1,0,-1},{0,1,0,-1},{-2,-1,0,1},{0,-1,0,1}};
                    orientationY = new int[][]{{0,-1,0,1},{2,1,0,-1},{0,1,0,-1},{-2,-1,0,1}};
                    break;
                case 'L':
                    //L
                    pairs[0] = new pair(5, 0);
                    pairs[1] = new pair(5, 1);
                    pairs[2] = new pair(4, 1);
                    pairs[3] = new pair(3, 1);
                    boundingBox = new pair(4, 0);
                    orientationX = new int[][]{{0,-1,0,1},{-2,-1,0,1},{0,1,0,-1},{2,1,0,-1}};
                    orientationY = new int[][]{{2,1,0,-1},{0,-1,0,1},{-2,-1,0,1},{0,1,0,-1}};
                    break;
                case 'O':
                    //O
                    pairs[0] = new pair(5, 0);
                    pairs[1] = new pair(5, 1);
                    pairs[2] = new pair(6, 1);
                    pairs[3] = new pair(6, 0);
                    boundingBox = new pair(4, 0);
                    break;
                case 'S':
                    //S
                    pairs[0] = new pair(6, 0);
                    pairs[1] = new pair(5, 0);
                    pairs[2] = new pair(5, 1);
                    pairs[3] = new pair(4, 1);
                    boundingBox = new pair(4, 0);
                    orientationX = new int[][]{{0,1,0,1},{-2,-1,0,1},{0,-1,0,-1},{2,1,0,-1}};
                    orientationY = new int[][]{{2,1,0,-1},{0,1,0,1},{-2,-1,0,1},{0,-1,0,-1}};
                    break;
                case 'Z':
                    //Z
                    pairs[0] = new pair(4, 0);
                    pairs[1] = new pair(5, 0);
                    pairs[2] = new pair(5, 1);
                    pairs[3] = new pair(6, 1);
                    boundingBox = new pair(4, 0);
                    orientationX = new int[][]{{2,1,0,-1},{0,-1,0,-1},{-2,-1,0,1},{0,1,0,1}};
                    orientationY = new int[][]{{0,1,0,1},{2,1,0,-1},{0,-1,0,-1},{-2,-1,0,1}};
                    break;
                case 'T':
                    //T
                    pairs[0] = new pair(5, 0);
                    pairs[1] = new pair(4, 1);
                    pairs[2] = new pair(5, 1);
                    pairs[3] = new pair(6, 1);
                    boundingBox = new pair(4, 0);
                    orientationX = new int[][]{{1,1,0,-1},{-1,1,0,-1},{-1,-1,0,1},{1,-1,0,1}};
                    orientationY = new int[][]{{1,-1,0,1},{1,1,0,-1},{-1,1,0,-1},{-1,-1,0,1}};
                    break;
                case 'D':
                    pairs[0] = new pair(0, 0);
                    pairs[1] = new pair(9, 0);
                    pairs[2] = new pair(0, 19);
                    pairs[3] = new pair(9, 19);
            }
        }


        public boolean canMoveDown()
        {
            piece p = new piece(pieceType);
            for(int i = 0; i < p.getPairs().length; i++)
            {
                p.setCord(i, pairs[i].getX(), pairs[i].getY() + 1);
            }
            p.setBoundingBox(boundingBox.x, boundingBox.y - 1);
            removePiece(this);
            if(canPlacePiece(p))
            {
                placePiece(this, this);
                return true;
            }
            else {
                placePiece(this, this);
                return false;
            }
        }

        public void setCord(int i, int x, int y)
        {
            pairs[i] = new pair(x, y);
        }
        public void setBoundingBox(int x, int y)
        {
            boundingBox.setX(x);
            boundingBox.setY(y);
        }
//goes pair by pair using the rotate pair function on each
        public piece rotatePiece()
        {
            piece p = new piece(pieceType);
            p.rotationState = rotationState;
            for(int i = 0; i < p.getPairs().length; i++)
            {
                p.setCord(i, pairs[i].getX(), pairs[i].getY());
            }
            if(pieceType != 'O')
            {

                for(int i = 0; i < pairs.length; i++)
                {
                    p.setCord(i,pairs[i].getX()+orientationX[rotationState][i],pairs[i].getY()+orientationY[rotationState][i]);
                }
                if(rotationState <3)
                {
                    rotationState++;
                    p.rotationState++;
                }
                else {
                    rotationState = 0;
                    p.rotationState = 0;
                }
            }
            removePiece(this);
            uPress = false;

            movedLast = 1;
            return placePiece(p, this);


        }

        public piece moveR()
        {
            piece p = new piece(pieceType);
            for(int i = 0; i < p.getPairs().length; i++)
            {
                p.setCord(i, pairs[i].getX() + 1, pairs[i].getY());
            }
            p.setBoundingBox(boundingBox.x + 1, boundingBox.y);
            p.rotationState = rotationState;
            removePiece(this);
            rPress = false;

            movedLast = 1;
            return placePiece(p, this);
        }
        public piece moveL()
        {
            piece p = new piece(pieceType);

            for(int i = 0; i < p.getPairs().length; i++)
            {
                p.setCord(i, pairs[i].getX() - 1, pairs[i].getY());
            }
            p.setBoundingBox(boundingBox.x - 1, boundingBox.y);
            p.rotationState = rotationState;
            removePiece(this);
            lPress = false;
            movedLast = 1;
            return placePiece(p, this);
        }
        public piece moveD()
        {
            piece p = new piece(pieceType);
            for(int i = 0; i < p.getPairs().length; i++)
            {
                p.setCord(i, pairs[i].getX(), pairs[i].getY() + 1);
            }
            p.rotationState = rotationState;
            p.setBoundingBox(boundingBox.x, boundingBox.y + 1);

            removePiece(this);
            return placePiece(p, this);
        }


        public pair[] getPairs() {
            return pairs;
        }
        public char getPieceType(){return pieceType;};

        public void setPairs(pair[] pairs) {
            this.pairs = pairs;
        }
    }

    public class pair
    {
        private int x;
        private int y;
        public pair(int xC, int yC)
        {
            x = xC;
            y = yC;
        }

        public int getX()
        {
            return x;
        }
        public int getY()
        {
            return y;
        }

        public void setX(int xC)
        {
            x = xC;
        }
        public void setY(int yC)
        {
            y = yC;
        }

    }

}
