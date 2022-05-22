package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int length = answers.length;
        Student[] students = initializeStudents();

        int[] scores = Arrays.stream(students)
                .mapToInt(student -> student.getScore(length, answers))
                .toArray();
        int max = Arrays.stream(scores).max().getAsInt();

        return IntStream.range(0, 3).filter(i -> scores[i] == max)
                .map(i -> i + 1)
                .toArray();
    }

    private Student[] initializeStudents() {
        Student[] students = new Student[3];
        students[0] = new Student( 1, 2, 3, 4, 5);
        students[1] = new Student( 2, 1, 2, 3, 2, 4, 2, 5);
        students[2] = new Student( 3, 3, 1, 1, 2, 2, 4, 4, 5, 5);
        return students;
    }

    private static class Student{
        private int[] prioritySequence;

        public Student(int... prioritySequence) {
            this.prioritySequence = prioritySequence;
        }

        public int getScore(int problemCount, int[] answers) {
            int[] submitted = submitAnswer(problemCount);

            return Long.valueOf(IntStream.range(0, answers.length)
                    .filter(i -> submitted[i] == answers[i])
                    .count()).intValue();
        }

        private int[] submitAnswer(int length) {
            return IntStream.range(0, length)
                    .map(i -> prioritySequence[i % prioritySequence.length])
                    .toArray();
        }
    }
}
