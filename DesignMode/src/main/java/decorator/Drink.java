package decorator;

/**
 * 饮料类
 *
 * @author Jion
 */
public abstract class Drink {
    /** 描述 */
    private String description;

    /** 价格 */
    private Double price;

    /** 计算价格方法 */
    protected abstract Double cose();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
