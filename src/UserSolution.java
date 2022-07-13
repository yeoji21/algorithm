import java.util.*;

public class UserSolution {
    private static Map<String, List<Student>> conditionMap;
    private static Map<String, List<String>> conditionKeyMap;
    private static Map<Integer, Student> studentMap;

    public void init() {
        conditionMap = new HashMap<>();
        conditionKeyMap = new HashMap<>();
        studentMap = new HashMap<>();

        String[] grades = new String[]{"1", "2", "3"};
        boolean[] checked = new boolean[5];
        permutation(grades, checked, "", 0);
    }

    private void permutation(String[] conditions, boolean[] checked, String selected, int L) {
        if (!selected.equals("")) {
            String[] genders = new String[]{"M", "F", "MF"};
            for (int i = 0; i < genders.length; i++) {
                conditionMap.put(selected + genders[i], new ArrayList<>());
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
        Student student = new Student(mId, mGrade, convertGender(mGender), mScore);
        studentMap.put(student.id, student);

        if (conditionKeyMap.containsKey(student.getKey())) {
            for (String key : conditionKeyMap.get(student.getKey())) {
                insertStudent(key, student);
            }
        }
        else {
            List<String> keys = new ArrayList<>();
            for (String key : conditionMap.keySet()) {
                if (key.contains(student.gender) && key.contains(String.valueOf(student.grade))) {
                    keys.add(key);
                    insertStudent(key, student);
                }
            }
            conditionKeyMap.put(student.getKey(), keys);
        }

        List<Student> students = conditionMap.get(student.getKey());
        return students.get(students.size() - 1).id;
    }

    private void insertStudent(String key, Student student) {
        List<Student> students = conditionMap.get(key);

        int index = binarySearch(students, student.score);
        if(index == -1) students.add(student);
        else {
            for (int i = index; i < students.size(); i++) {
                if (students.get(index).score == student.score) {
                    if (student.id > students.get(index).id)
                        index++;
                } else break;
            }
            students.add(index, student);
        }
    }

    public int remove(int mId) {
        Student student = studentMap.remove(mId);
        if(student == null) return 0;

        for (String key : conditionKeyMap.get(student.getKey())) {
            conditionMap.get(key).remove(student);
        }

        List<Student> students = conditionMap.get(student.getKey());
        return students.size() == 0 ? 0 : students.get(0).id;
    }

    public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
        StringBuilder key = new StringBuilder();

        for (int i = 0; i < mGradeCnt; i++) {
            key.append(mGrade[i]);
        }

        for (int i = 0; i < mGenderCnt; i++) {
            String gender = convertGender(mGender[i]);
            key.append(gender);
        }

        List<Student> students = conditionMap.get(key.toString());
        int index = binarySearch(students, mScore);
        return index == -1 ? 0 : students.get(index).id;
    }

    public int binarySearch(List<Student> students, int score) {
        int start = 0;
        int end = students.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if(students.get(start).score >= score) {
                return start;
            }
            else if (students.get(mid).score < score) {
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return (end < 0 || start >= students.size()) ? -1 : start;
    }

    private String convertGender(char[] mGender) {
        return String.valueOf(mGender).startsWith("m") ? "M" : "F";
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

        public String getKey() {
            return grade + gender;
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
