package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main16506 {
    Map<String, String> opcodes;
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int lines = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer;
        initializeOpcodes();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < lines; i++) {
            StringBuilder machineLanguage = new StringBuilder();
            tokenizer = new StringTokenizer(br.readLine());
            String command = tokenizer.nextToken();
            if(command.charAt(command.length() - 1) == 'C') {
                machineLanguage.append(opcodes.get(command.substring(0, command.length() - 1))).append("10");
                byConstant(tokenizer, machineLanguage);
            }
            else{
                machineLanguage.append(opcodes.get(command)).append("00");
                byRegister(tokenizer, machineLanguage);
            }
            answer.append(machineLanguage).append("\n");
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void byRegister(StringTokenizer tokenizer, StringBuilder result) {
        String rd = to3BitBinary(getIntToken(tokenizer));
        String ra = to3BitBinary(getIntToken(tokenizer));
        String rb = to3BitBinary(getIntToken(tokenizer));
        result.append(rd).append(ra).append(rb).append("0");
    }

    private void byConstant(StringTokenizer tokenizer, StringBuilder result) {
        String rd = to3BitBinary(getIntToken(tokenizer));
        String ra = to3BitBinary(getIntToken(tokenizer));
        String c = to4BitBinary(getIntToken(tokenizer));
        result.append(rd).append(ra).append(c);
    }

    private String to4BitBinary(int value) {
        String bianry = Integer.toString(value, 2);
        bianry = "000" + bianry;
        return bianry.substring(bianry.length() - 4);
    }

    private String to3BitBinary(int value) {
        String bianry = Integer.toString(value, 2);
        bianry = "00" + bianry;
        return bianry.substring(bianry.length() - 3);
    }

    public static void main(String[] args) throws Exception {
        new Main16506().solv();
    }

    private void initializeOpcodes() {
        opcodes = new HashMap<>();
        opcodes.put("ADD", "0000");
        opcodes.put("SUB", "0001");
        opcodes.put("MOV", "0010");
        opcodes.put("AND", "0011");
        opcodes.put("OR", "0100");
        opcodes.put("NOT", "0101");
        opcodes.put("MULT", "0110");
        opcodes.put("LSFTL", "0111");
        opcodes.put("LSFTR", "1000");
        opcodes.put("ASFTR", "1001");
        opcodes.put("RL", "1010");
        opcodes.put("RR", "1011");
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}