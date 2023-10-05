package Chapter1.Lesson1;

import java.util.Scanner;

public class Code4 {
    public static void main(String[] args) {
        String name;
        int age;
        String gender;

        Scanner input = new Scanner(System.in);

        System.out.println("Please type your name, age, gender:");
        name = input.next();
        age = input.nextInt();
        gender = input.next();

        if(name == null && age <= 0 && gender == null) {
            System.out.println("Please type your name, age, gender ");
        } else if(gender.equals("man")) {
            System.out.println(name + ", you're " + age + " years old man");
        } else {
            System.out.println(name + ", you're " + age + " years old woman");
        }
    }
}
