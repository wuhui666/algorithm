package reciteWrite;

/**
 * @author: wuhui
 * @time: 2019/10/2 14:34
 * @desc:
 */
public class SinglePattern {
    private static SinglePattern instance=null;
    private SinglePattern(){}
    private static SinglePattern getInstance(){
        if (instance==null){
            synchronized (SinglePattern.class){
                if (instance==null) {
                    return new SinglePattern();
                }
            }

        }
        return instance;
    }

    public static void main(String[] args) {
        SinglePattern2 singlePattern2=SinglePattern2.getInstance();
        SinglePattern2 singlePattern22=SinglePattern2.getInstance();
        System.out.println(singlePattern2.equals(singlePattern22));
    }
}
class SinglePattern2 {
    private SinglePattern2(){}
    public static SinglePattern2 getInstance(){
        return Inner.instance;
    }
    // 由于静态内部类只会被初始化一次，（保证单列）
    // 且只有在第一次使用到才会加载初始化（延迟加载）
    private static class Inner{
        private static SinglePattern2 instance=new SinglePattern2();
    };

}
