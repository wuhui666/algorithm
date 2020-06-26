package reciteWrite.simpleFactory;

/**
 * @author: wuhui
 * @time: 2019/10/5 16:14
 * @desc:
 */
public class HonorV10 extends Mobile{
    @Override
    public void call() {
        System.out.println(this.getClass().getSimpleName()+" is calling!");
    }
}
