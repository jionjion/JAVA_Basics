package responsibility;

/**
 *  老板审批人,最终处理
 * @author Jion
 */
public class BossApprover extends AbstractApprover {

    /**
     * 处理过程
     */
    @Override
    protected void process(GoodOrder goodOrder) {
        System.out.println("最终Boss审批..." + goodOrder);
    }
}
