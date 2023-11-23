public class Main {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        // This calls the MallardDuck's inherited performQuack() method, which
        // then delegates to the object's QuackBehavior (i.e., calls quack() on
        // the duck's inherited quackBehavior reference).
        mallard.perfomQuack();
        // Then we do the same thing with MallardDuck's inherited performFly()
        // method.
        mallard.performFly();

        Duck decoy = new DecoyDuck();
        decoy.performFly();
        decoy.perfomQuack();

        Duck model = new ModelDuck();
        // The first call to performFly() delegates to the flyBehavior object set
        // in the ModelDuck's constructor, which is a FlyNoWay instance.
        model.performFly();
        // This invokes the model's inherited behavior setter method, and voila!
        // The model suddenly has rocket-powered flying capability!
        model.setFlyBehavior(new FlyRocketPowered());
        // If it worked, the model duck dynamically changed its flying behavior!
        // You can't do THAT if the implementation lives inside the Duck class.
        model.performFly();
    }
}