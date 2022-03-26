package thinkDataStructures.ch1;

import java.util.ArrayList;
import java.util.List;

public class Practice1 {
    private List list;

    public Practice1() {
        this.list = new ArrayList();
    }
    private List getList() {
        return list;
    }

    public static void main(String[] args) {
        Practice1 practice = new Practice1();
        List list = practice.getList();
        System.out.println(list);
    }
}
