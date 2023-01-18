package homeworks.homework1.task1;
import java.util.ArrayList;
import java.util.Objects;
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
        int age = user.nextInt();
        child.age = age;
        System.out.println("Заполнить данные о маме? (Введите Y/n): ");

        answer = user.nextLine();
        if (answer.equals("Y")){
            mother = addMother();
            child.mother = mother;
        } else if (answer.equals("n")) {
            System.out.println("Заполните данные об отце: ");
            father = addFather();
            child.father = father;
        }else
        if (mother != null) {
            System.out.println("Заполнить данные об отце (Введите Y/n): ");
            answer = user.nextLine();
            if (answer.equals("Y")){
                father = addFather();
                child.father = father;
            }
        }

        childrenAll.add(child);
        mother.children.add(child);
        return child;
    }

    public static Mother addMother() {
        Scanner user = new Scanner(System.in);
        Mother mother = new Mother();
        Mother grandmother = null;
        Father grandfather = null;

        System.out.println("Введите ФИО: ");
        String name = user.nextLine();
        mother.name = name;
        System.out.println("Введите возраст: ");
        int age = user.nextInt();
        mother.age = age;
        System.out.println("Заполнить данные о бабушке? (Введите Y/n): ");
        String answer = user.nextLine();
        if (answer.equals("Y")){
            grandmother = addMother();
            mother.mother = grandmother;
        }
        System.out.println("Заполнить данные о дедушке? (Введите Y/n): ");
        answer = user.nextLine();
        if (answer.equals("Y")){
            grandfather = addFather();
            mother.father = grandfather;
        }

        System.out.println("Если у данного человека более одного ребенка, укажите кол-во, в противном случае укажите '1': ");
        int num = user.nextInt();
        if (num > 1){
            for (int i = 1; i < num; i++) {
                Child nextChild = addNextChild();
                nextChild.mother = mother;
                mother.children.add(nextChild);
            }
        }
        mothers.add(mother);
        return mother;
    }

    public static Father addFather(){
        Scanner user = new Scanner(System.in);
        Father father = new Father();
        Mother grandmother = null;
        Father grandfather = null;

        System.out.println("Введите ФИО: ");
        String name = user.nextLine();
        father.name = name;
        System.out.println("Введите возраст: ");
        int age = user.nextInt();
        father.age = age;
        System.out.println("Заполнить данные о бабушке? (Введите Y/n): ");
        String answer = user.nextLine();
        if (answer.equals("Y")){
            grandmother = addMother();
            father.mother = grandmother;
        }
        System.out.println("Заполнить данные о дедушке? (Введите Y/n): ");
        answer = user.nextLine();
        if (answer.equals("Y")){
            grandfather = addFather();
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
        int age = user.nextInt();
        Child nextChild = new Child(name, age);
        return nextChild;
    }
}
