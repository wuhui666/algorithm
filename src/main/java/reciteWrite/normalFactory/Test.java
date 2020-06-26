package reciteWrite.normalFactory;

import reciteWrite.simpleFactory.Mobile;

/**
 * @author: wuhui
 * @time: 2019/10/5 16:28
 * @desc:
 */
public class Test {
    // 结构图：https://www.cnblogs.com/baxianhua/p/9360111.html
    public static void main(String[] args) {
        IMobileFactory factory=new XiaoMiFactory();
        Mobile mobile = factory.create();
        mobile.call();
        factory=new HuaWeiFactory();
        Mobile mobile1 = factory.create();
        mobile1.call();
    }
}
