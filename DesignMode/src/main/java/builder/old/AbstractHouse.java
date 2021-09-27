package builder.old;

/**
 * 抽象类, 造房子
 *
 * @author Jion
 */
public abstract class AbstractHouse {

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

    public void build() {
        buildBasic();
        buildWalls();
        buildRoofed();
    }
}
