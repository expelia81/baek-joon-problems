import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Assignment {
        int deadline;
        int ramen;

        public Assignment(int deadline, int ramen) {
            this.deadline = deadline;
            this.ramen = ramen;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Assignment> assignments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());
            assignments.add(new Assignment(deadline, ramen));
        }

        // 마감일 기준으로 오름차순 정렬
        Collections.sort(assignments, (a, b) -> Integer.compare(a.deadline, b.deadline));

        // 컵라면 개수를 기준으로 오름차순 정렬하는 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Assignment assignment : assignments) {
            int deadline = assignment.deadline;
            int ramen = assignment.ramen;

            // 현재 과제의 컵라면 개수를 우선순위 큐에 추가
            pq.add(ramen);

            // 큐의 크기가 마감일보다 크면, 컵라면 개수가 가장 작은 과제를 제거
            if (pq.size() > deadline) {
                pq.poll();
            }
        }

        long totalRamen = 0;
        // 우선순위 큐에 남은 컵라면 개수를 모두 더함
        while (!pq.isEmpty()) {
            totalRamen += pq.poll();
        }

        bw.write(String.valueOf(totalRamen));
        bw.flush();
        bw.close();
        br.close();
    }
}