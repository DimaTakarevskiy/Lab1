package MainPackage;

public class Apple extends Food{

    private String size;

    public Apple(String name, int calories) {
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
