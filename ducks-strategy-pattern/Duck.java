interface QuackBehavior {
    void quack();
}

class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}

class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}

class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}

interface FlyBehavior {
    // The interface that all flying behavior classes implement.
    void fly();
}

class FlyWithWings implements FlyBehavior {
    // Flying behavior implementation for ducks that DO fly
    public void fly() {
        System.out.println("The duck is flying!");
    };
}

class FlyNoWay implements FlyBehavior {
    // Flying behavior implementation for ducks that do NOT fly (like rubber ducks
    // and decoy ducks).
    public void fly() {
        System.out.println("I can't fly");
    }
}

class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}

public abstract class Duck {
    // Declare two reference variables for the behavior interface types.
    // All duck subclasses (in the same package) inherit these.
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackhavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly(); // Delegate to the behavior class.
    }

    public void perfomQuack() {
        quackBehavior.quack(); // Delegate to the behavior class.
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }
}

class MallardDuck extends Duck {
    // MallardDuck inherits the quackBehavior and flyBehavior instance variables
    // from class Duck.
    public MallardDuck() {
        // A MallardDuck uses Quack class to handle its quack, so when performQuack()
        // is called, the responsibility for the quack is delegated to the Quack
        // object and we get a real quack.
        quackBehavior = new Quack();
        // And it uses FlyWithWings as its FlyBehavior type.
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}

class DecoyDuck extends Duck {
    public DecoyDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("I'm a decoy duck");
    }
}

class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        // Our model ducks begins life grounded without a way to fly.
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
