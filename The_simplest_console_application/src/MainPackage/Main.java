package MainPackage;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.print("Вы хотите сортировать? (д/н) ");
        String sorted = scanner.nextLine();

        System.out.print("Вы хотите посчитать калории? (д/н) ");
        String calories = scanner.nextLine();

        ArrayList<Food> breakfast = new ArrayList<Food>();
        FillArrayList(breakfast);
        PrintArrayList(breakfast);

        if (sorted.equals("д")) {
            SortArrayList(breakfast);
            System.out.println("Отсортированный обед");
            PrintArrayList(breakfast);
        }

        Consume(breakfast);

        if (calories.equals("д"))
            System.out.println("Вы употребили " + CalculateCalories(breakfast) + " калориев");
    }

    private static void Consume(ArrayList<Food> breakfast) {
        if (breakfast == null)
            return;
        for (Food el:breakfast)
            el.consume();
    }

    public static void FillArrayList(ArrayList<Food> breakfast) throws Exception{
        String answer;
        do {
            System.out.print("Введите еду: ");
            String food = scanner.nextLine();

            if (food.equals("Яблоко"))
                breakfast.add(new Apple());
            else if (food.equals("Сыр"))
                breakfast.add(new Cheese());
            else if (food.equals("Коктель")){
                System.out.print("Введите напиток: ");
                String drink = scanner.nextLine();
                if (!(drink.equals("Молоко") || drink.equals("Шампанское")))
                    throw new Exception("Вам нельзя это есть!");
                System.out.print("Введите фрукт: ");
                String fruit = scanner.nextLine();
                if (!(fruit.equals("Клубника") || fruit.equals("Малина")))
                    throw new Exception("Вам нельзя это есть!");
                breakfast.add(new Cocktail(drink,fruit));
            }
            else throw new Exception("Вам нельзя это есть!");

            System.out.print("Хотите ещё? (д/н) ");
            answer = scanner.nextLine();
        } while(answer.equals("д"));
    }

    public static void PrintArrayList(final ArrayList<Food> breakfast) throws ClassNotFoundException, NoSuchFieldException {
        if (breakfast == null)
            System.out.println("Вы остались голодным!");
        System.out.println("Вы сегодня схавали: ");
        for (Food item : breakfast) {
            Class MyClass = item.getClass();
            System.out.println(MyClass.getSimpleName());            //System.out.print(item.toString() + ", ");
        }
        System.out.println();
    }

    public static void SortArrayList(ArrayList<Food> breakfast){
        Collections.sort(breakfast, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o1.calculateCalories() < o2.calculateCalories() ? -1 :
                        o1.calculateCalories() > o2.calculateCalories() ? 1 : 0;
            }
        });
    }

    public static int CalculateCalories(ArrayList<Food> breakfast){
        if (breakfast == null)
            return 0;
        int calories = 0;
        for (Food el : breakfast)
            calories += el.get_calories();
        return calories;
    }
}
