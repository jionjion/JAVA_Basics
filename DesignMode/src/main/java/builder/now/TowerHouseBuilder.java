package builder.now;

/**
 * 具体建造者
 *
 * @author Jion
 */
public class TowerHouseBuilder extends AbstractHouseBuilder {

    @Override
    public void buildBasic() {
        super.house.setBasic("地基");
        System.out.println("高楼打地基...");
    }

    @Override
    public void buildWalls() {
        super.house.setWalls("砌墙");
        System.out.println("高楼砌墙...");
    }

    @Override
    public void buildRoofed() {
        super.house.setRoofed("封顶");
        System.out.println("高楼封顶...");
    }
}
