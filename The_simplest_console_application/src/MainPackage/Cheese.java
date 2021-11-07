package MainPackage;

public class Cheese extends Food {

    public Cheese(String name, int calories) {
        super(name, calories);
    }

    @Override
    public void consume() {
        System.out.println(this + " съеден");
    }

    @Override
    public int calculateCalories() {
        return 0;
    }
}
