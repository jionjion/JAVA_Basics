package builder.now;

/**
 * 抽象建造者
 *
 * @author Jion
 */
public abstract class AbstractHouseBuilder {

    protected House house = new House();

    /**
     * 造地基
     */
    public abstract void buildBasic();

    /**
     * 造墙
     */
    public abstract void buildWalls();

    /**
     * 造屋顶
     */
    public abstract void buildRoofed();

    /**
     * 建造完成后,返回产品
     */
    public House build() {
        return house;
    }
}
