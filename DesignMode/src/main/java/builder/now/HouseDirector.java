package builder.now;

/**
 * 指挥者,限定建造顺序
 *
 * @author Jion
 */
public class HouseDirector {

    private AbstractHouseBuilder abstractHouseBuilder;

    public AbstractHouseBuilder getAbstractHouseBuilder() {
        return abstractHouseBuilder;
    }

    public void setAbstractHouseBuilder(AbstractHouseBuilder abstractHouseBuilder) {
        this.abstractHouseBuilder = abstractHouseBuilder;
    }

    /** 指定具体的顺序 */
    public House constructHouse(){
        abstractHouseBuilder.buildBasic();
        abstractHouseBuilder.buildWalls();
        abstractHouseBuilder.buildRoofed();
        return abstractHouseBuilder.house;
    }
}
