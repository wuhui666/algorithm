package reciteWrite.simpleFactory;

/**
 * @author: wuhui
 * @time: 2019/10/5 16:10
 * @desc:
 */
public class IMobileFactory {
    public static Mobile create(String brand){
        switch (brand){
            case "mi9":
                return new XiaoMi9();
            case "v10":
                return new HonorV10();
            default:
                return new HonorV10();
        }

    }
}
