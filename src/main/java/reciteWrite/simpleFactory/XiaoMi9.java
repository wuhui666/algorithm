package reciteWrite.simpleFactory;

/**
 * @author: wuhui
 * @time: 2019/10/5 16:12
 * @desc:
 */
public class XiaoMi9 extends Mobile{
    @Override
    public void call() {
        System.out.println(this.getClass().getSimpleName()+" is calling!");
    }


}
