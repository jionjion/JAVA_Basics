package responsibility;

/**
 * 员工处理
 *
 * @author Jion
 */
public class EmployeeApprover extends AbstractApprover {

    private final static Long RMB_1B = 100L;

    /**
     * 处理过程
     */
    @Override
    protected void process(GoodOrder goodOrder) {
        if (goodOrder.getPrice() <= RMB_1B) {
            System.out.println("金额小于100, 员工审批..." + goodOrder);
        } else {
            System.out.println("员工审批不了...");
            // 否则,交给其他审批人处理
            super.setOther(new ManagerApprover());
            super.getOther().process(goodOrder);
        }
    }
}
