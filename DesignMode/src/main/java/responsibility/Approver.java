package responsibility;

/**
 *  抽象处理者
 * @author Jion
 */
public abstract class Approver {

    /** 处理过程 */
    protected abstract void process(GoodOrder goodOrder);

    /** 关联其他处理者 */
    private Approver other;

    /** 如果处理不了,交由其他审批人处理.环状结构调用 */
    public void setOther(Approver approver){
        this.other = approver;
    }

    /** 获取其他请求处理人 */
    public Approver getOther() {
        return other;
    }
}
