package reciteWrite.simpleFactory;

/**
 * @author: wuhui
 * @time: 2019/10/5 16:22
 * @desc:
 */
public class Test {
    // 结构图：https://www.cnblogs.com/baxianhua/p/9360111.html
    public static void main(String[] args) {
        Mobile m=IMobileFactory.create("v10");
        m.call();
        Mobile mm=IMobileFactory.create("mi9");
        mm.call();
    }
}
