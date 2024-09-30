public class CleanSweep {
    private int x;
    private int y;
    private int batteryLevel;
    private int dirtCapacity;
    private final FloorPlan floorPlan;

    public CleanSweep(FloorPlan floorPlan) {
        this.x = 0;
        this.y = 0; // Start at (0,0)
        this.batteryLevel = 250; // Full battery
        this.dirtCapacity = 50;  // Maximum dirt capacity
        this.floorPlan = floorPlan;
    }

    public void move(int dx, int dy) {
        if (batteryLevel > 0) {
            Cell targetCell = floorPlan.getCell(x + dx, y + dy);
            if (targetCell != null && !targetCell.isObstacle()) {
                int movementCost = (targetCell.getSurfaceType().getChargeCost() + floorPlan.getCell(x, y).getSurfaceType().getChargeCost()) / 2;
                batteryLevel -= movementCost;

                x += dx;
                y += dy;

                System.out.println("Moved to (" + x + "," + y + "). Battery: " + batteryLevel);
            } else {
                System.out.println("Obstacle or out of bounds. Can't move.");
            }
        } else {
            System.out.println("Battery low. Returning to charging station.");
            returnToBase();
        }
    }

    public void clean() {
        Cell currentCell = floorPlan.getCell(x, y);
        if (currentCell != null && currentCell.hasDirt() && dirtCapacity > 0) {
            currentCell.clean();
            dirtCapacity--;
            batteryLevel -= currentCell.getSurfaceType().getChargeCost();
            System.out.println("Cleaned cell (" + x + "," + y + "). Dirt left: " + currentCell.hasDirt());
        } else if (dirtCapacity == 0) {
            System.out.println("Dirt capacity full. Returning to charging station.");
            returnToBase();
        }
    }

    public void returnToBase() {
        System.out.println("Returning to charging station at (0,0).");
        // Assume the Clean Sweep always knows the location of the base at (0,0)
        this.x = 0;
        this.y = 0;
        this.batteryLevel = 250; // Recharge to full
        this.dirtCapacity = 50;  // Empty dirt
    }

    public void run() {
        // Example navigation
        move(1, 0);  // Move right
        clean();     // Clean the current position
        move(0, 1);  // Move down
        clean();     // Clean the current position
        move(-1, 0); // Move left
        clean();     // Clean the current position
    }
}
