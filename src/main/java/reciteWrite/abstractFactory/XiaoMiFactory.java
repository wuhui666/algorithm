package reciteWrite.abstractFactory;

import reciteWrite.simpleFactory.Mobile;
import reciteWrite.simpleFactory.XiaoMi9;

/**
 * @author: wuhui
 * @time: 2019/10/5 16:41
 * @desc:
 */
public class XiaoMiFactory implements IProductFactory{
    @Override
    public Mobile createMoblie() {
        return new XiaoMi9();
    }

    @Override
    public Televison createTelevison() {
        return new XiaoMiTV();
    }
}
