public class Cell {
    private final int x;
    private final int y;
    private final SurfaceType surfaceType;
    private final boolean isObstacle;
    private int dirtAmount;

    public Cell(int x, int y, SurfaceType surfaceType) {
        this(x, y, surfaceType, false, 0);
    }

    public Cell(int x, int y, SurfaceType surfaceType, boolean isObstacle, int dirtAmount) {
        this.x = x;
        this.y = y;
        this.surfaceType = surfaceType;
        this.isObstacle = isObstacle;
        this.dirtAmount = dirtAmount;
    }

    public boolean isObstacle() {
        return isObstacle;
    }

    public boolean hasDirt() {
        return dirtAmount > 0;
    }

    public void clean() {
        if (dirtAmount > 0) {
            dirtAmount--;
        }
    }

    public SurfaceType getSurfaceType() {
        return surfaceType;
    }

    @Override
    public String toString() {
        return isObstacle ? "X" : dirtAmount > 0 ? "D" : ".";
    }
}
