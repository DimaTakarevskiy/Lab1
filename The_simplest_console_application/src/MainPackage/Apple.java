package MainPackage;

public class Apple extends Food{

    public Apple() {
        super("Яблоко", 52);
    }

    @Override
    public void consume() {System.out.println(get_name() + " съеден");}

    @Override
    public int calculateCalories() {
        return get_calories();
    }

    @Override
    public String toString(){ return super.toString(); }
}
