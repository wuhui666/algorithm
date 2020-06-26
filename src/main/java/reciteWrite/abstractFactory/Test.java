package reciteWrite.abstractFactory;

import reciteWrite.simpleFactory.Mobile;

/**
 * @author: wuhui
 * @time: 2019/10/5 16:43
 * @desc:
 */
public class Test {
    //结构图：https://www.cnblogs.com/baxianhua/p/9360111.html
    public static void main(String[] args) {
        IProductFactory factory=new XiaoMiFactory();
        Mobile moblie = factory.createMoblie();
        Televison televison = factory.createTelevison();
        moblie.call();
        televison.play();
        factory=new HuaWeiFactory();
        Mobile moblie1 = factory.createMoblie();
        Televison televison1 = factory.createTelevison();
        moblie1.call();
        televison1.play();
    }
}
