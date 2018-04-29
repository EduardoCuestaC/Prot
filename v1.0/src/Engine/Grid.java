package Engine;

import Entities.Entity;
import java.util.ArrayList;

import java.lang.Math;

public class Grid {
    private ArrayList<Entity> grid [][];
    private int cellSize, width, height;

    public Grid(int width, int height, int cellSize){
        this.width = width;
        this.height = height;
        this.cellSize = cellSize;
    }

    public ArrayList<Entity>[][] getGrid() {
        return grid;
    }

    public void setGrid(ArrayList<Entity>[][] grid) {
        this.grid = grid;
    }

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void add(Entity e){
        int startX = Math.max(0,e.getX()/cellSize);
        int startY = Math.max(0,e.getY()/cellSize);
        int endX = Math.min(width, (e.getX()+e.getW())/cellSize);
        int endY = Math.min(height, (e.getY()+e.getH())/cellSize);
        for(int i = startX; i<=endX; i++){
            for(int j = startY; j<=endY; j++){
                grid[i][j].add(e);
            }
        }
    }

    public void delete(Entity e){
        int startX = Math.max(0,e.getX()/cellSize);
        int startY = Math.max(0,e.getY()/cellSize);
        int endX = Math.min(width, (e.getX()+e.getW())/cellSize);
        int endY = Math.min(height, (e.getY()+e.getH())/cellSize);
        for(int i = startX; i<=endX; i++){
            for(int j = startY; j<=endY; j++){
                grid[i][j].remove(e);
            }
        }
    }

    public ArrayList<Entity> getEntitiesInArea(int[] bounds){
        int startX = bounds[0];
        int startY = bounds[1];
        int endX = bounds[2];
        int endY = bounds[3];
        ArrayList<Entity> collectedEntities = new ArrayList<>();
        for(int i = startX; i<=endX; i++){
            for(int j = startY; j<=endY; j++){
                collectedEntities.addAll(grid[i][j]);
            }
        }
        return collectedEntities;
    }

    public int[] getCellNumberOfEntity(Entity e){
        int startX = Math.max(0,e.getX()/cellSize);
        int startY = Math.max(0,e.getY()/cellSize);
        int endX = Math.min(width, (e.getX()+e.getW())/cellSize);
        int endY = Math.min(height, (e.getY()+e.getH())/cellSize);
        int[] f = {startX, startY, endX, endY};
        return f;
    }

}
