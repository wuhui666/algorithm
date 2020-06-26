package reciteWrite.abstractFactory;

import reciteWrite.simpleFactory.Mobile;

/**
 * @author: wuhui
 * @time: 2019/10/5 16:40
 * @desc:
 */
public interface IProductFactory {
    public Mobile createMoblie();
    public Televison createTelevison();
}
