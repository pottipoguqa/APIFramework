//Helper class to return an Array

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Courses {

    String names;
    int modules;

    public Courses(String n, int m) {
        this.names = n;
        this.modules = m;
    }

}

//Main class

class JavaTest {

    public static Courses[] returnArray() {

        Courses[] courses = new Courses[4];

        courses[0] = new Courses("Java", 10);
        courses[1] = new Courses("Selenium", 24);
        courses[2] = new Courses("API Testing", 15);
        courses[3] = new Courses("Mobile Testing", 20);

        return courses;
    }

    public static void main(String[] args) {

        Courses[] sample = returnArray();

        for (int i = 0; i < sample.length; i++) {

            System.out.print(sample[i].names + " - " + sample[i].modules + " modules \n");

        }

        String str="1234";
        //int i=Integer.parseInt(str);
        int i=Integer.valueOf(str);
        System.out.println(i);

        char[]c={ 'g', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'g', 'e', 'e', 'k', 's' };

//System.out.println(charArrayToString(c));

        String str1= Stream.of(c)
                .map(arr1->new String(arr1))
                .collect(Collectors.joining());

        System.out.println(str1);

//        List<Character> chars=str1.chars()
//                 .mapToObj(e->(char)e)
//                .collect(Collectors.toList());
//        System.out.println(chars);

        Arrays.stream(str1.split(""))
                .map(s->s.charAt(0))
                .collect(Collectors.toList());


    }
}

