package reciteWrite.normalFactory;

import reciteWrite.simpleFactory.HonorV10;
import reciteWrite.simpleFactory.Mobile;

/**
 * @author: wuhui
 * @time: 2019/10/5 16:27
 * @desc:
 */
public class HuaWeiFactory implements IMobileFactory{
    @Override
    public Mobile create() {
        return new HonorV10();
    }
}
