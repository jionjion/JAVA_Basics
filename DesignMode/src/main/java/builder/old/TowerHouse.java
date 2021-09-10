package builder.old;

/**
 * @author Jion
 */
public class TowerHouse extends AbstractHouse {

    @Override
    public void buildBasic() {
        System.out.println("高楼打地基...");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼砌墙...");
    }

    @Override
    public void buildRoofed() {
        System.out.println("高楼封顶...");
    }
}
