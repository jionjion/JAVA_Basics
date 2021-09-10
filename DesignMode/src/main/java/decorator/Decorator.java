package decorator;

/**
 * 装饰者.连接单体咖啡与其调料
 *
 * @author Jion
 */
public class Decorator extends Drink {
    /** 引入单体咖啡 */
    private Drink obj;

    public Decorator(Drink obj){
        this.obj = obj;
    }

    /** 计算价格,装饰者 */
    @Override
    public Double cose() {
        // 自己的价格 + 引入单体咖啡的价格
        return super.getPrice() + obj.cose();
    }

    /** 描述: 调料 + 价格 + 单体咖啡  */
    @Override
    public String getDescription() {
        return super.getDescription() + ":" + super.getPrice() + " && " + obj.getDescription();
    }
}
