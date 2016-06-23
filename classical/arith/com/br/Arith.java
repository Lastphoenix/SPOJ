package arith.com.br;

import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
class Arith implements Runnable {
 
    Pattern p = Pattern.compile("(\\d+)(\\+|\\-|\\*)(\\d+)");
    Matcher m = null;
    StringBuffer sb;
 
    public void solve() throws IOException {
 
        Stack<String> operations = new Stack<String>();
        int testCases = nextInt();
        sb = new StringBuffer("");
        while (testCases > 0) {
            operations.push(nextToken());
            --testCases;
        }
        for (String s : operations) {
            processor(s);
            sb.append("\n");
        }
        System.out.print(sb);
    }
 
    void processor(String s) {
        BigDecimal operand1, operand2, result, resultTemp, numberTemp;
        String operator, operand2Str = "";
        int largeLine = 0, largeResult = 0;
        m = p.matcher(s);
        m.matches();
 
        operand1 = new BigDecimal(m.group(1));
        operand2 = new BigDecimal(m.group(3));
        operator = m.group(2);
 
        operand2Str = operator + operand2.toPlainString();
 
        if (!operator.equals("*")) {
            if (operator.equals("-")) {
                operand2 = operand2.negate();
            }
            result = operand1.add(operand2);
 
            largeResult = result.toPlainString().length();
            largeLine = Math.max(operand2Str.length(), largeResult);
 
            sb.append(padLeft(operand1.toPlainString(), largeLine)).append("\n");
            sb.append(padLeft(operand2Str, largeLine)).append("\n");
            sb.append(line(largeLine)).append("\n");
            sb.append(padLeft(result, largeLine)).append("\n");
        } else {
            result = operand1.multiply(operand2);
 
            largeResult = result.toPlainString().length();
            largeLine = Math.max(operand1.toPlainString().length(), operand2Str.length());
 
            sb.append(padLeft(operand1.toPlainString(), largeResult)).append("\n");
            sb.append(padLeft(operand2Str, largeResult)).append("\n");
 
            int n = operand2Str.length();
            boolean haveLine = false;
            if (n > 2) {
                int k = 0;
                for (int i = n - 1; i >= 1; i--) {
                    numberTemp = new BigDecimal(operand2Str.charAt(i) + "");
                    resultTemp = operand1.multiply(numberTemp);
                    if (!haveLine) {
                        haveLine = true;
                        largeLine = Math.max(operand2Str.length(), resultTemp.toPlainString().length());
                        sb.append(padLeft(line(largeLine), largeResult)).append("\n");
                    }
                    sb.append(padLeft(resultTemp, largeResult - (k))).append("\n");
                    k++;
                }
            }
            sb.append(line(largeResult)).append("\n");
            sb.append(result).append("\n");
        }
    }
 
    String line(int n) {
        return String.format(String.format("%%0%dd", n), 0).replace("0", "-");
    }
 
    public String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }
 
    public String padLeft(BigDecimal bd, int n) {
        return padLeft(bd.toPlainString(), n);
    }
 
    void print(Object... obj) {
        for (Object o : obj) {
            sb.append(o);
        }
    }
 
    void print(int[] a) {
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
 
    void print(int[][] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
 
    void print(boolean[][] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
 
    //-----------------------------------------------------------
    public static void main(String[] args) {
        new Arith().run();
    }
 
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            tok = null;
            solve();
            in.close();
        } catch (IOException e) {
            System.exit(0);
        }
    }
 
    public String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }
 
    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
 
    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
 
    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
    BufferedReader in;
    StringTokenizer tok;
}