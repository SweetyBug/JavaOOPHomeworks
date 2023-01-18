package homeworks.homework1.task1;

import java.util.ArrayList;

public class Father extends Human{
    private ArrayList<Child> children;
    static ArrayList<Father> fathers = new ArrayList<>();

    Father(String name, int age, Mother mother, Father father, ArrayList<Child> children) {
        super.name = name;
        super.age = age;
        super.mother = mother;
        super.father = father;
        this.children = children;
    }

    Father(String name, int age, Father father, ArrayList<Child> children) {
        super.name = name;
        super.age = age;
        super.father = father;
        this.children = children;
    }

    Father(String name, int age, Mother mother, ArrayList<Child> children) {
        super.name = name;
        super.age = age;
        super.mother = mother;
        this.children = children;
    }

    Father(String name, int age, ArrayList<Child> children) {
        super.name = name;
        super.age = age;
        this.children = children;
    }

    Father() {

    }

}

