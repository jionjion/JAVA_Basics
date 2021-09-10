package builder.now;

import org.junit.Test;

/**
 *  执行建造者模式
 * @author Jion
 */
public class HouseDirectorTest {

    @Test
    public void test(){
        // 指挥者
        HouseDirector houseDirector = new HouseDirector();
        // 具体建造类
        houseDirector.setAbstractHouseBuilder(new TowerHouseBuilder());
        // 建造
        House house = houseDirector.constructHouse();
        // 完成
        System.out.println("House " + house.toString());
    }
}