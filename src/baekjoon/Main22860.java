package baekjoon;

import java.io.*;
import java.util.*;

public class Main22860 {
    /*
    파일 이름이 같으면 동일한 파일임
    한 폴더 안에는 이름 같은 파일 존재 x
    main 아래 이름 같은 폴더 존재 x

    쿼리 순서대로 폴더 하위에 파일 종류와 파일의 총 개수 출력

    **
    컬렉션 객체 생성 파괴 비용은 매우 비싸다
    시간 초과났었는데 set을 전역으로 설정하니 깔끔하게 통과함
    **
     */
    private Set<String> set = new HashSet<>();
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = getIntToken(tokenizer);
        int m = getIntToken(tokenizer);
        Map<String, Folder> map = new HashMap<>();
        Folder main = new Folder();
        map.put("main", main);

        for (int i = 0; i < n + m; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            String parentName = tokenizer.nextToken();
            String name = tokenizer.nextToken();
            int isFolder = getIntToken(tokenizer);

            Folder parent = getParentFolder(map, parentName);
            if(isFolder == 1){
                Folder folder = getFolder(map, name);
                parent.folders.add(folder);
                map.put(name, folder);
            }else{
                parent.files.add(name);
            }
        }

        int q = getIntLine(br);
        StringBuilder answer = new StringBuilder();
        while (q-- > 0) {
            String query = br.readLine();
            String[] split = query.split("/");
            String name = split[split.length - 1];
            Folder folder = map.get(name);

            answer.append(getKind(folder) + " ");
            answer.append(getCount(folder) + "\n");
        }
        System.out.println(answer.toString());
    }

    private Folder getFolder(Map<String, Folder> map, String name) {
        if(map.containsKey(name)) return map.get(name);
        return new Folder();
    }

    private Folder getParentFolder(Map<String, Folder> map, String parentName) {
        if(map.containsKey(parentName))
            return map.get(parentName);
        Folder parent = new Folder();
        map.put(parentName, parent);
        return parent;
    }

    private int getCount(Folder folder) {
        if(folder.fileCount != null)
            return folder.fileCount;
        int count = folder.getFileCount();
        folder.fileCount = count;
        return count;
    }

    private int getKind(Folder folder) {
        if(folder.fileKind != null) {
            return folder.fileKind;
        }
        set = new HashSet<>();
        folder.getFileKind();
        int kind = set.size();
        folder.fileKind = kind;
        return kind;
    }

    class Folder{
        List<Folder> folders = new ArrayList<>();
        List<String> files = new ArrayList<>();
        Integer fileKind = null;
        Integer fileCount = null;

        public void getFileKind() {
            set.addAll(files);
            for (Folder child : folders) {
                child.getFileKind();
            }
        }

        public int getFileCount() {
            int count = files.size();
            for (Folder child : folders) {
                count += child.getFileCount();
            }
            return count;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main22860().solv();
    }

    private int getIntLine(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
