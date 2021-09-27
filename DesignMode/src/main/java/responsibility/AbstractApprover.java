package responsibility;

/**
 * 抽象处理者
 *
 * @author Jion
 */
public abstract class AbstractApprover {

    /**
     * 处理过程
     *
     * @param goodOrder 订单
     */
    protected abstract void process(GoodOrder goodOrder);

    /**
     * 关联其他处理者
     */
    private AbstractApprover other;

    /**
     * 如果处理不了,交由其他审批人处理.环状结构调用
     */
    public void setOther(AbstractApprover approver) {
        this.other = approver;
    }

    /**
     * 获取其他请求处理人
     */
    public AbstractApprover getOther() {
        return other;
    }
}
