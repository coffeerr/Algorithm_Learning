package Interview.DesignModel.Factory;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/14 11:25 上午
 */

public class FactoryMethodTest {
}

abstract class Product {
    public void method1() {
        //公共的业务逻辑
    }

    //抽象方法
    public abstract void method2();
}

class ConcreteProduct1 extends Product {

    @Override
    public void method2() {
        //具体产品类1的业务逻辑处理
    }
}

class ConcreteProduct2 extends Product {
    @Override
    public void method2() {
        //具体产品类2的业务逻辑处理
    }

}

//定义抽象创建类
abstract class Creator {
    //创建对象的抽象方法
    public abstract <T extends Product> T createProduct(Class<T> c);
}

class ConcreteCreator extends Creator {

    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
        try {
            product = (Product) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {

        }
        return (T) product;

    }
}
