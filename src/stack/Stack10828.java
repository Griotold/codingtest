package stack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 241108 금 - 스택 - 백준 10828
 * https://www.acmicpc.net/problem/10828
 * 스택
 * */
public class Stack10828 {

    static class MyStack {
        int[] integers = new int[10_000];
        int pos = 0;
        // push
        void push(int x) {
            integers[pos++] = x;
        }

        // pop
        int pop() {
            if (empty() == 1) return -1;
            return integers[--pos];
        }

        // size
        int size() {
            return pos;
        }

        // empty
        int empty() {
            return pos == 0 ? 1 : 0;
        }

        // top
        int top() {
            if (empty() == 1) return -1;
            return integers[pos-1];
        }
    }
    /**
     * https://st-lab.tistory.com/175
     * */
    static class AnotherStack {
        int[] stack = new int[10_000];
        int size = 0;

        void push(int item) {
            stack[size] = item;	// size칸에 item을 넣고 size를 1증가
            size++;
        }

        int pop() {
            // 데이터가 한 개도 없을 경우 -1
            if(size == 0) {
                return -1;
            }

            // 인덱스는 0부터 시작하므로 최상단에 있는 요소는 항상 size-1 index에 위치한다.
            else {
                int res = stack[size - 1];
                stack[size - 1] = 0;	// 0으로 초기화 해준다.
                size--;
                return res;
            }
        }

        int size() {
            return size;	// 요소 개수를 반환
        }

        int empty() {
            // 스택이 비어있으면 1 반환
            if(size == 0) {
                return 1;
            }
            else {
                return 0;
            }
        }

        int top() {
            // 데이터가 한 개도 없을 경우 -1
            if(size == 0) {
                return -1;
            }

            // 인덱스는 0부터 시작하므로 최상단에 있는 요소는 항상 size-1 index에 위치한다.
            else {
                return stack[size - 1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        MyStack stack = new MyStack();
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
                continue;
            }
            if(command.equals("pop")) {
                sb.append(stack.pop()).append("\n");
            } else if (command.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(stack.empty()).append("\n");
            } else if (command.equals("top")) {
                sb.append(stack.top()).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
