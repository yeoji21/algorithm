import java.util.*;

public class UserSolution2 {
    private static Map<String, List<Student>> map;

    public static void main(String[] args) {
        init();
        addAndPrint(500, 1, "male", 1250);
        addAndPrint(400, 3, "female", 2900);
        addAndPrint(900, 2, "female", 2500);
        addAndPrint(700, 2, "male", 2500);
        addAndPrint(600, 1, "female", 1750);
        addAndPrint(800, 3, "male", 1000);
        addAndPrint(300, 2, "female", 2000);

        queryAndPrint(new int[]{2, 3}, new char[][]{{'m', 'a', 'l', 'e'}, {'f', 'e', 'm', 'a', 'l', 'e'}}, 2500);
        queryAndPrint(new int[]{1, 2, 3}, new char[][]{{'m', 'a', 'l', 'e'}}, 1100);
        addAndPrint(100, 2, "female", 2500);
        queryAndPrint(new int[]{2}, new char[][]{{'m', 'a', 'l', 'e'}, {'f', 'e', 'm', 'a', 'l', 'e'}}, 2200);
        System.out.println(remove(300));
        System.out.println(remove(200));
        addAndPrint(300, 3, "female", 3000);

        queryAndPrint(new int[]{1, 3}, new char[][]{{'f', 'e', 'm', 'a', 'l', 'e'}}, 1800);
        System.out.println(remove(800));
        queryAndPrint(new int[]{1,2,3}, new char[][]{{'m', 'a', 'l', 'e'}, {'f', 'e', 'm', 'a', 'l', 'e'}}, 1000);
    }

    private static void queryAndPrint(int[] mGrade, char[][] mGender, int mScore) {
        System.out.println(query(mGrade.length, mGrade, mGender.length, mGender, mScore));
    }

    private static void addAndPrint(int id, int grade, String gender, int score) {
        System.out.println(add(id, grade, gender.toCharArray(), score));
    }

    public static void init() {
        map = new HashMap<>();
        String[] grades = new String[]{"1", "2", "3"};
        boolean[] checked = new boolean[5];
        permutation(grades, checked, "", 0);
    }

    private static void permutation(String[] conditions, boolean[] checked, String selected, int L) {
        if (!selected.equals("")) {
            String[] genders = new String[]{"M", "F", "MF"};
            for (int i = 0; i < genders.length; i++) {
                map.put(selected + genders[i], new ArrayList<>());
            }
        }
        if(L == conditions.length) return;
        for (int i = L; i < conditions.length; i++) {
            if (!checked[i]) {
                checked[i] = true;
                permutation(conditions, checked, selected + conditions[i], L + 1);
                checked[i] = false;
            }
        }

    }

    public static int add(int mId, int mGrade, char mGender[], int mScore) {
        Student student = new Student(mId, mGrade, String.valueOf(mGender).startsWith("m") ? "M" : "F", mScore);

        for (String key : map.keySet()) {
            if (key.contains(student.gender) && key.contains(String.valueOf(student.grade))) {
                List<Student> students = map.get(key);
                students.add(student);
                Collections.sort(students, Comparator.comparing((Student s) -> s.score).thenComparing((Student s) -> s.id));
            }
        }

        Student result = new Student(Integer.MIN_VALUE, 0, "", Integer.MIN_VALUE);
        for (Student s : map.get(student.grade + student.gender)) {
            if (s.score == result.score) {
                result = s.id > result.id ? s : result;
            }else{
                result = s.score > result.score ? s : result;
            }
        }
        return result.id;
    }

    public static int remove(int mId) {
        Student remove = null;
        String gender = null;
        for (String key : map.keySet()) {
            List<Student> students = map.get(key);
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).id == mId) {
                    remove = students.remove(i);
                    if(remove.gender.length() == 1) gender = remove.gender;
                    break;
                }
            }
        }

        if(remove != null){
            String key = remove.grade + gender;
            List<Student> students = map.get(key);
            if(students.size() == 0) return 0;

            Student result = new Student(Integer.MAX_VALUE, 0, "", Integer.MAX_VALUE);
            for (Student student : students) {
                if (student.score == result.score) {
                    result = student.id > result.id ? result : student;
                }else{
                    result = student.score > result.score ? result : student;
                }
            }
            return result.id;
        }
        return 0;
    }

    public static int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
        StringBuilder key = new StringBuilder();

        for (int i = 0; i < mGradeCnt; i++) {
            key.append(mGrade[i]);
        }

        for (int i = 0; i < mGenderCnt; i++) {
            String gender = String.valueOf(mGender[i]).startsWith("m") ? "M" : "F";
            key.append(gender);
        }

        Student result = new Student(Integer.MAX_VALUE, 0, "", Integer.MAX_VALUE);

        List<Student> students = map.get(key.toString());
//        return binarySearch(students, mScore);
//        System.out.println("bs = " + binarySearch(students, mScore));

        for (Student student : students) {
//            Student student = students.get(i);
            if(student.score >= mScore) {
                return student.id;
//                if (student.score == result.score) {
//                    result = student.id > result.id ? result : student;
//                }
//                else result = student.score > result.score ? result : student;
            }
        }
        return 0;
//        return result.id == Integer.MAX_VALUE ? 0 : result.id;
    }

    public static int binarySearch(List<Student> students, int score) {
        int start = 0;
        int end = students.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if(students.get(start).score >= score) {
                return students.get(start).id;
            }
            else if (students.get(mid).score < score) {
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        if(end < 0 || start >= students.size()) return 0;
        else return students.get(start).id;
    }

//    public static int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
//        StringBuilder key = new StringBuilder();
//
//        for (int i = 0; i < mGradeCnt; i++) {
//            key.append(mGrade[i]);
//        }
//
//        for (int i = 0; i < mGenderCnt; i++) {
//            String gender = String.valueOf(mGender[i]).startsWith("m") ? "M" : "F";
//            key.append(gender);
//        }
//
//        Student result = new Student(Integer.MAX_VALUE, 0, "", Integer.MAX_VALUE);
//
//        List<Student> students = map.get(key.toString());
//        for (int i = students.size() - 1; i >= 0; i--) {
//            Student student = students.get(i);
//            if(student.score >= mScore) {
//                if (student.score == result.score) {
//                    result = student.id > result.id ? result : student;
//                }
//                else result = student.score > result.score ? result : student;
//            }
//        }
//        return result.id == Integer.MAX_VALUE ? 0 : result.id;
//    }


    private static class Student {
        private int id;
        private int grade;
        private String gender;
        private int score;

        public Student(int id, int grade, String gender, int score) {
            this.id = id;
            this.grade = grade;
            this.gender = gender;
            this.score = score;
        }
    }
}
