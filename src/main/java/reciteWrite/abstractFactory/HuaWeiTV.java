package reciteWrite.abstractFactory;

/**
 * @author: wuhui
 * @time: 2019/10/5 16:38
 * @desc:
 */
public class HuaWeiTV extends Televison{
    @Override
    public void play() {
        System.out.println(this.getClass().getSimpleName()+" is palying!");
    }
}
