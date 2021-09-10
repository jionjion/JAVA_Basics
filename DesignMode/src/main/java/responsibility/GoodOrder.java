package responsibility;

/**
 *  商品订单
 * @author Jion
 */
public class GoodOrder {

    /** 商品 */
    private final String name;

    /** 价格 */
    private final Integer price;

    public GoodOrder(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "GoodOrder{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
