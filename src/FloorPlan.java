import java.util.*;

public class FloorPlan {
    private final int width;
    private final int height;
    private final Cell[][] grid;

    public FloorPlan(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Cell[width][height];

        // Initialize the grid with default cells
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = new Cell(i, j, SurfaceType.BARE_FLOOR);
            }
        }
    }

    public void setCell(int x, int y, SurfaceType surfaceType, boolean isObstacle, int dirtAmount) {
        grid[x][y] = new Cell(x, y, surfaceType, isObstacle, dirtAmount);
    }

    public Cell getCell(int x, int y) {
        if (x >= 0 && y >= 0 && x < width && y < height) {
            return grid[x][y];
        } else {
            return null; // Return null if coordinates are out of bounds
        }
    }

    public void printFloorPlan() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
