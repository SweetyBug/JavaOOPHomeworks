package homeworks.homework1.task1;

import java.util.ArrayList;

public class Mother extends Human{
    ArrayList<Child> children;

    static ArrayList<Mother> mothers = new ArrayList<>();

    Mother(String name, String age, Mother mother, Father father, ArrayList<Child> children) {
        super.name = name;
        super.age = age;
        super.mother = mother;
        super.father = father;
        this.children = children;
    }
    Mother(String name, String age, Father father, ArrayList<Child> children) {
        super.name = name;
        super.age = age;
        super.father = father;
        this.children = children;
    }
    Mother(String name, String age, Mother mother, ArrayList<Child> children) {
        super.name = name;
        super.age = age;
        super.mother = mother;
        this.children = children;
    }

    Mother(String name, String age, ArrayList<Child> children) {
        super.name = name;
        super.age = age;
        this.children = children;
    }

    Mother(String name, String age) {
        super.name = name;
        super.age = age;
    }

    Mother() {

    }

}
