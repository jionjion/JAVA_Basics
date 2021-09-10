package builder.now;

/**
 * 抽象建造者
 *
 * @author Jion
 */
public abstract class AbstractHouseBuilder {

    protected House house = new House();

    public abstract void buildBasic();

    public abstract void buildWalls();

    public abstract void buildRoofed();

    /** 建造完成后,返回产品 */
    public House build() {
        return house;
    }
}
