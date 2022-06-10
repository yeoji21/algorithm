package programmers;

public class 체육복 {
    public static void main(String[] args) {
        int solution = solution(3, new int[]{3}, new int[]{1});
        System.out.println(solution);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int[] students = initializeStudents(n);
        setReserve(reserve, students);
        setLost(lost, students);

        int notBorrowed = 0;
        for (int i = 1; i < n+1; i++) {
            if (students[i] == 0) {
                if(i-1 > 0 && students[i-1] == 2){
                    students[i - 1]--;
                    students[i]++;
                }
                else if (i + 1 <= n && students[i + 1] == 2) {
                    students[i + 1]--;
                    students[i]++;
                } else notBorrowed++;
            }
        }

        return n - notBorrowed;
    }

    private static void setLost(int[] lost, int[] students) {
        for (int j : lost) students[j]--;
    }

    private static void setReserve(int[] reserve, int[] students) {
        for (int j : reserve) students[j]++;
    }

    private static int[] initializeStudents(int n) {
        int[] students = new int[n + 1];
        for (int i = 1; i < n + 1; i++) students[i] = 1;
        return students;
    }
}
