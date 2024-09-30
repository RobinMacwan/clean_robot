public enum SurfaceType {
    BARE_FLOOR(1),
    LOW_PILE_CARPET(2),
    HIGH_PILE_CARPET(3);

    private final int chargeCost;

    SurfaceType(int chargeCost) {
        this.chargeCost = chargeCost;
    }

    public int getChargeCost() {
        return chargeCost;
    }
}
