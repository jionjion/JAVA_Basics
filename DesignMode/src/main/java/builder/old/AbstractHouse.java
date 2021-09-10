package builder.old;

/**
 *  抽象类, 造房子
 * @author Jion
 */
public abstract class AbstractHouse {

    public abstract void buildBasic();

    public abstract void buildWalls();

    public abstract void buildRoofed();

    public void build(){
        buildBasic();
        buildWalls();
        buildRoofed();
    }
}
