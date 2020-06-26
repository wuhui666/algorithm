package reciteWrite.abstractFactory;

import reciteWrite.simpleFactory.HonorV10;
import reciteWrite.simpleFactory.Mobile;

/**
 * @author: wuhui
 * @time: 2019/10/5 16:42
 * @desc:
 */
public class HuaWeiFactory implements IProductFactory{
    @Override
    public Mobile createMoblie() {
        return new HonorV10();
    }

    @Override
    public Televison createTelevison() {
        return new HuaWeiTV();
    }
}
