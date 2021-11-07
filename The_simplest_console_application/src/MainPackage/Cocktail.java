package MainPackage;

class Cocktail extends Food{
    private String _drink = null;
    private String _fruit = null;

    public Cocktail(String drink, String fruit) {
        super("Cocktail", 0);
        _drink = drink;
        _fruit = fruit;
    }

    public String get_drink() {
        return _drink;
    }
    private void set_drink(String filling1) { _drink = filling1; }

    public String get_fruit() {
        return _fruit;
    }
    private void set_fruit(String filling2) { _fruit = filling2; }

    @Override
    public void consume() {
        System.out.println(get_name() + " Выпето");
    }

    @Override
    public int calculateCalories() {
        if (get_drink().equals("Молоко"))
            set_calories(get_calories() + 42);
        else if (get_drink().equals("Шампанское"))
            set_calories(get_calories() + 87);
        if (get_fruit().equals("Клубника"))
            set_calories(get_calories() + 33);
        else if (get_fruit().equals("Шоколад"))
            set_calories(get_calories() + 544);
        return get_calories();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Cocktail)) return false;
        return (_drink.equals(((Cocktail) obj)._drink) && (_fruit.equals(((Cocktail) obj)._fruit)));
    }

    @Override
    public String toString(){
        return super.toString() + " с " + get_drink() + " и " + get_fruit();
    }
}
