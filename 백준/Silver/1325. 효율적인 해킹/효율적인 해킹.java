import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      graph.get(end).add(start);
    }

    int[] results = new int[n+1];
    int max = 0;
    
    for (int i = 1; i <= n; i++) {
      boolean[] visited = new boolean[n+1];
      Queue<Integer> queue = new LinkedList<>(); // 각 시작점마다 새로운 큐 생성
      
      queue.add(i);
      visited[i] = true;
      int count = 0;
      
      while (!queue.isEmpty()) {
        int current = queue.poll();
        count++; // 해킹할 수 있는 컴퓨터 개수 증가
        
        for (int next : graph.get(current)) {
          if (!visited[next]) {
            visited[next] = true;
            queue.add(next);
          }
        }
      }
      
      results[i] = count;
      max = Math.max(max, count);
    }

    for (int i = 1; i <= n; i++) {
      if (max == results[i]) {
        bw.write(i + " ");
      }
    }

    bw.flush();
    bw.close();
    br.close();
  }
}