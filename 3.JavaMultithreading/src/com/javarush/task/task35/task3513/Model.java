package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];    // Квадратное поле 4*4
    int score;
    int maxTile;                                                        // Значение мах плитки

    // Возврат ходов
    Stack<Tile[][]> previousStates = new Stack<>();
    Stack<Integer> previousScores = new Stack<>();
    boolean isSaveNeeded = true;

    private void saveState (Tile[][] state){
        Tile[][] tmpTileArr = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int j = 0; j < FIELD_WIDTH; j++)
                tmpTileArr[i][j] = new Tile(state[i][j].value);
        previousStates.push(tmpTileArr);
        int score2save = score;
        previousScores.push(score2save);
        isSaveNeeded = false;
    }

    // откат на один ход назад
    public void rollback() {
        if (!previousStates.isEmpty() & !previousScores.isEmpty()) {
            this.score = previousScores.pop();
            this.gameTiles = previousStates.pop();
        }
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public Model() {
        score = 0;
        maxTile = 2;
        resetGameTiles();
    }

    protected void resetGameTiles(){
        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int j = 0; j < FIELD_WIDTH; j++)
                gameTiles[i][j] = new Tile();
        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> list = getEmptyTiles();
        if (list != null && list.size() != 0) {
            list.get( (int)( list.size() * Math.random() ) ).setValue(Math.random() < 0.9 ? 2 : 4);
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> result = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) result.add(gameTiles[i][j]);
            }
        }
        return result;
    }

    private boolean compressTiles(Tile[] tiles){
        Tile tmp;
        boolean result = false;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (tiles[j].getValue() == 0 && tiles[j + 1].getValue() != 0) {
                    tmp = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = tmp;
                    result = true;
                }
                return result;
    }

    private boolean mergeTiles(Tile[] tiles){
        //if (!compressTiles(tiles)) return false;
        boolean result = false;
        for (int j = 0; j < 3; j++)
            if (tiles[j].getValue() != 0 && tiles[j].getValue() == tiles[j + 1].getValue()) {
                tiles[j].setValue(tiles[j].getValue() * 2);
                tiles[j + 1].setValue(0);
                if (tiles[j].getValue() > maxTile) maxTile = tiles[j].getValue();
                score += tiles[j].getValue();
                compressTiles(tiles);
                result = true;
                j = 0;
            }
            return result;
    }

    // Сдвиг влево
    public void left() {
        if (isSaveNeeded) saveState(getGameTiles());

        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++)
            if ( compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i]) ) isChanged = true;

        if (isChanged) {
            addTile();
            isSaveNeeded = true;
        }
        //isSaveNeeded = true;
    }

    public void up() {
        saveState(this.gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    public void right() {
        saveState(this.gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void down() {
        saveState(this.gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    private void rotate() {
        Tile[][] tmpTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int j = 0; j < FIELD_WIDTH; j++)
                tmpTiles[FIELD_WIDTH-j-1][i] = (gameTiles[i][j]);
        gameTiles = tmpTiles;
    }

    // Проверка возможности хода
    public boolean canMove() {
        if (!getEmptyTiles().isEmpty())
            return true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
                    return true;
            }
        }
        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 1; i < gameTiles.length; i++) {
                if (gameTiles[i][j].value == gameTiles[i - 1][j].value)
                    return true;
            }
        }
        return false;
    }

    // Делает ход в случайном направлении
    public void randomMove() {
        switch (((int) (Math.random() * 100)) % 4) {
            case 0:
                left();
                break;
            case 1:
                up();
                break;
            case 2:
                right();
                break;
            case 3:
                down();
                break;
        }
    }

    // Проверка изменения поля
    private boolean hasBoardChanged() {
        int sum = 0;
        int sumPrevious = 0;
        Tile[][] tmpTile = previousStates.peek();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                sum += gameTiles[i][j].getValue();
                sumPrevious += tmpTile[i][j].getValue();
            }
        }
        return sum != sumPrevious;
    }

    // проверка эффективности хода
    private MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        move.move();
        if (hasBoardChanged()) moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move); else
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        rollback();
        return moveEfficiency;
    }

    // реализация выбора эффективного хода из возможных
    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue(4, Collections.reverseOrder());
        queue.add(getMoveEfficiency(this::left));
        queue.add(getMoveEfficiency(this::right));
        queue.add(getMoveEfficiency(this::up));
        queue.add(getMoveEfficiency(this::down));
        Move move = queue.peek().getMove();
        move.move();
    }

}
