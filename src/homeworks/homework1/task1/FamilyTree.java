package homeworks.homework1.task1;
import java.util.Scanner;
import static homeworks.homework1.task1.Child.childrenAll;
import static homeworks.homework1.task1.Father.fathers;
import static homeworks.homework1.task1.Mother.mothers;

public class FamilyTree {



    public static void main(String[] args) {
        addChild();
        System.out.println(childrenAll.toString());
    }

    public static Child addChild(){
        Scanner user = new Scanner(System.in);
        Child child = new Child();

        Mother mother = null;
        Father father = null;
        String answer;

        System.out.println("Введите ФИО ребенка: ");
        String name = user.nextLine();
        child.name = name;
        System.out.println("Введите возраст ребенка: ");
        String age = user.nextLine();
        child.age = age;
        System.out.println("Заполнить данные о маме? (Введите Y/n): ");

        answer = user.nextLine();
        if (answer.equals("Y")){
            mother = addMother(child);
            child.mother = mother;
        } else if (answer.equals("n")) {
            System.out.println("Заполните данные об отце: ");
            father = addFather(child);
            child.father = father;
        }else
        if (mother != null) {
            System.out.println("Заполнить данные об отце (Введите Y/n): ");
            answer = user.nextLine();
            if (answer.equals("Y")){
                father = addFather(child);
                child.father = father;
            }
        }

        childrenAll.add(child);
        mother.children.add(child);
        return child;
    }

    public static Mother addMother(Child child) {
        Scanner user = new Scanner(System.in);
        Mother mother = new Mother();
        Child child1 = new Child();
        Mother grandmother = null;
        Father grandfather = null;

        System.out.println("Введите ФИО: ");
        String name = user.nextLine();
        mother.name = name;
        child1.name = name;
        System.out.println("Введите возраст: ");
        String age = user.nextLine();
        mother.age = age;
        child1.age = age;
        System.out.println("Заполнить данные о бабушке? (Введите Y/n): ");
        String answer = user.nextLine();
        if (answer.equals("Y")){
            grandmother = addMother(child1);
            mother.mother = grandmother;
        }
        System.out.println("Заполнить данные о дедушке? (Введите Y/n): ");
        answer = user.nextLine();
        if (answer.equals("Y")){
            grandfather = addFather(child1);
            mother.father = grandfather;
        }

        System.out.println("Если у данного человека более одного ребенка, укажите кол-во, в противном случае укажите '1': ");
        String num = user.nextLine();
        if (!num.equals("n")){
            int x = Integer.parseInt(num);
            for (int i = 1; i < x; i++) {
                Child nextChild = addNextChild();
                nextChild.mother = mother;
                mother.children.add(nextChild);
            }
        }
        return mother;
    }

    public static Father addFather(Child child){
        Scanner user = new Scanner(System.in);
        Father father = new Father();
        Child child1 = new Child();
        Mother grandmother = null;
        Father grandfather = null;

        System.out.println("Введите ФИО: ");
        String name = user.nextLine();
        father.name = name;
        child1.name = name;
        System.out.println("Введите возраст: ");
        String age = user.nextLine();
        father.age = age;
        child1.age = age;
        System.out.println("Заполнить данные о бабушке? (Введите Y/n): ");
        String answer = user.nextLine();
        if (answer.equals("Y")){
            grandmother = addMother(child1);
            father.mother = grandmother;
        }
        System.out.println("Заполнить данные о дедушке? (Введите Y/n): ");
        answer = user.nextLine();
        if (answer.equals("Y")){
            grandfather = addFather(child1);
            father.father = grandfather;
        }

//        System.out.println("Если у данного человека более одного ребенка, укажите кол-во, в противном случае укажите '1': ");
//        int num = user.nextInt();
//        if (num > 1){
//            for (int i = 1; i < num; i++) {
//                Child nextChild = addNextChild();
//                nextChild.father = father;
//                father.children.add(nextChild);
//            }
//        }
        fathers.add(father);
        return father;
    }

    public static Child addNextChild(){
        Scanner user = new Scanner(System.in);
        System.out.println("Введите ФИО ребенка: ");
        String name = user.nextLine();
        System.out.println("Введите возраст ребенка: ");
        String age = user.nextLine();
        Child nextChild = new Child(name, age);
        return nextChild;
    }
}
