package reciteWrite.normalFactory;

import reciteWrite.simpleFactory.Mobile;
import reciteWrite.simpleFactory.XiaoMi9;

/**
 * @author: wuhui
 * @time: 2019/10/5 16:27
 * @desc:
 */
public class XiaoMiFactory implements IMobileFactory{
    @Override
    public Mobile create() {
        return new XiaoMi9();
    }
}
