import java.util.*;

public class UserSolution {
    private static Map<String, List<Student>> map;

    public void init() {
        map = new HashMap<>();
        String[] grades = new String[]{"1", "2", "3"};
        boolean[] checked = new boolean[5];
        permutation(grades, checked, "", 0);
    }

    private void permutation(String[] conditions, boolean[] checked, String selected, int L) {
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

    public int add(int mId, int mGrade, char mGender[], int mScore) {
        Student student = new Student(mId, mGrade, String.valueOf(mGender).startsWith("m") ? "M" : "F", mScore);

        for (String key : map.keySet()) {
            if (key.contains(student.gender) && key.contains(String.valueOf(student.grade))) {
                List<Student> students = map.get(key);
                students.add(student);
                Collections.sort(students, Comparator.comparing((Student s) -> s.score).thenComparing((Student s) -> s.id));
            }
        }

        List<Student> students = map.get(student.grade + student.gender);
        return students.get(students.size() - 1).id;
    }

    public int remove(int mId) {
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
            List<Student> students = map.get(remove.grade + gender);
            if(students.size() == 0) return 0;
            return students.get(0).id;
        }
        return 0;
    }

    public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
        StringBuilder key = new StringBuilder();

        for (int i = 0; i < mGradeCnt; i++) {
            key.append(mGrade[i]);
        }

        for (int i = 0; i < mGenderCnt; i++) {
            String gender = String.valueOf(mGender[i]).startsWith("m") ? "M" : "F";
            key.append(gender);
        }

        List<Student> students = map.get(key.toString());
        return binarySearch(students, mScore);
    }

    public int binarySearch(List<Student> students, int score) {
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

    private class Student {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return id == student.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
