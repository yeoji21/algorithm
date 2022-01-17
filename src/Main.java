import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int n, f;
    static int[] checked, select;
    static int[][] sum = new int[11][11];
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        checked = new int[n+1];
        select = new int[n];

        new Main().solution(0);
    }

    public void solution(int L) {
        if(flag) return;
        if (L == n) {
            if (calculateSum() == f){
                Arrays.stream(select).forEach(x -> System.out.print(x + " "));
                flag = true;
                return;
            }
        }
        else{
            for (int i = 1; i <= n; i++) {
                if (checked[i] == 0) {
                    checked[i] = 1;
                    select[L] = i;
                    solution(L+1);
                    checked[i] = 0;
                }
            }
        }
    }

    private int calculateSum(){
        List<Integer> selectList = Arrays.stream(select).boxed().collect(Collectors.toList());

//        while(selectList.size() > 1) {
//            int size = selectList.size();
//            for (int i = 1; i < size; i++) {
//                int re = selectList.get(i - 1) + selectList.get(i);
//                selectList.add(re);
//            }
//            selectList = selectList.subList(size, selectList.size());
//        }
//        return selectList.get(0);

        int size = selectList.size();
        for (int i = 1; i < size; i++) {
            int re = selectList.get(i - 1) + selectList.get(i);
            selectList.add(re);
        }
        selectList = selectList.subList(size, selectList.size());
//        selectList.forEach(x -> System.out.print(x + " "));
        int result = 0;
        result += selectList.get(0) + selectList.get(selectList.size()-1);
        selectList.remove(selectList.size()-1);
        selectList.remove(0);
//        selectList.forEach(x -> System.out.print(x + " "));
        result += selectList.stream().mapToInt(x -> x).sum() * (selectList.size() + 1);

//        System.out.println(result);

        return result;
    }
}