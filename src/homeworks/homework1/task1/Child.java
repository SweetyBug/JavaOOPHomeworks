package homeworks.homework1.task1;

import java.util.ArrayList;

public class Child extends Human{

    static ArrayList<Child> childrenAll = new ArrayList<>();

    Child(String name, String age, Mother mother, Father father){
        super.name = name;
        super.age = age;
        super.mother = mother;
        super.father = father;
    }

    Child(String name, String age, Mother mother){
        super.name = name;
        super.age = age;
        super.mother = mother;
    }

    Child(String name, String age, Father father){
        super.name = name;
        super.age = age;
        super.father = father;
    }
    Child(String name, String age){
        super.name = name;
        super.age = age;
    }

    Child() {

    }

    @Override
    public String toString() {
        return "Child{" +
                "mother=" + mother +
                ", father=" + father +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
