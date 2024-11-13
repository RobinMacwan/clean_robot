public class Main {
    public static void main(String[] args) {
        // Initialize the floor plan
        FloorPlan floorPlan = new FloorPlan(5, 5);
        floorPlan.setCell(1, 0, SurfaceType.BARE_FLOOR, false, 2); // Cell with dirt
        floorPlan.setCell(0, 1, SurfaceType.LOW_PILE_CARPET, false, 1);
        floorPlan.setCell(1, 1, SurfaceType.HIGH_PILE_CARPET, true, 0); // Obstacle
        floorPlan.printFloorPlan();

        // Initialize Clean Sweep with the floor plan
        //adding c1
        CleanSweep cleanSweep = new CleanSweep(floorPlan);
        cleanSweep.run();
    }
}
