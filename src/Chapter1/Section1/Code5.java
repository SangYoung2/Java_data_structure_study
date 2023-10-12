package Chapter1.Section1;

public class Code5 {
    public static void main(String[] args) {

        // declare the array
        int[] grades = new int[5]; // 배열의 크기는 5 (0~4)

        // assign some values to the array
        grades[0] = 100;
        grades[1] = 76;
        grades[2] = 92;
        grades[3] = 95;
        grades[4] = 14;

        // print out each value
        for (int i = 0; i < grades.length; i++) {
            System.out.println("Grade" + (i+1) + " : " + grades[i]);
        }

        // while문
//        int i = 0;
//
//        while (i < grades.length) {
//            System.out.println("Grade" + (i+1) + " : " + grades[i]);
//            i++;
//        }
    }
}
