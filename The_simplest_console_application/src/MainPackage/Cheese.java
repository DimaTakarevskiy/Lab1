package MainPackage;

public class Cheese extends Food {

    public Cheese() {
        super("Сыр", 402);
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
