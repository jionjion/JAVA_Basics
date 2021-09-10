package responsibility;

/**
 *  经理处理
 * @author Jion
 */
public class ManagerApprover extends Approver {

    /**
     * 处理过程
     */
    @Override
    protected void process(GoodOrder goodOrder) {
        if(goodOrder.getPrice() <= 10000){
            System.out.println("金额小于1万, 经理审批..." + goodOrder);
        }else{
            System.out.println("经理审批不了...");
            // 否则,交给其他审批人处理
            super.setOther(new BossApprover());
            super.getOther().process(goodOrder);
        }
    }
}
