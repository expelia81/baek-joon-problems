import java.util.*;
class Solution {
    
    static Set<Integer> checker = new HashSet<>();
    static Set<Integer> counter = new HashSet<>();
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        // 시간복잡도 계산
        // 한 로봇이 이동할 수 있는 최대 거리 * 루트 갯수 * 로봇 갯수
        Queue<Robot> queue = new LinkedList<>();
        Queue<Robot> subQueue = new LinkedList<>();
        for(int i =0;i<routes.length;i++){
            Robot robot = new Robot(i+1, points[routes[i][0]-1][0], points[routes[i][0]-1][1], routes[i]);
            queue.add(robot);
            int now = robot.getPoint();
            if(checker.contains(now)){
                counter.add(now);
            } else {
                checker.add(now);
            }
        }
        int time = 0;
        answer = counter.size();
        while(true) {
            time++;
                checker.clear();
                counter.clear();
            while(!queue.isEmpty()) {
                Robot robot = queue.poll();


                int now = robot.move(points);
                if(checker.contains(now)){
                    counter.add(now);
                } else {
                    checker.add(now);
                }
                // System.out.println("robot : " + robot.no + "  now : " +now);

                if(robot.turn < robot.route.length) {
                    subQueue.add(robot);
                }

            }
                answer+=counter.size();
            if(subQueue.isEmpty()) {
                break;
            } else {
                queue.addAll(subQueue);
                subQueue.clear();
            }
        }
        
        return answer;
    }
    public static class Robot {
        int no;
        int x;
        int y;
        int[] route;
        int turn = 1; //현재 찾아갈 라우팅 목적지. 다음 목적지에 도착할때마다 1씩 올리다가, 목적지가 route.length와 같아지면 정지.
        public Robot(int no,int x,int y,int[] route) {
            this.no = no;
            this.x = x;
            this.y = y;
            this.route = route;
        }
        public int move(int[][] points) {
            int[] point = points[route[turn]-1];
            
            if(x>point[0]) {
                x--;
                return getPoint(point);
            }
            if(x<point[0]) {
                x++;
                return getPoint(point);
            }
            if(y<point[1]) {
                y++;
                return getPoint(point);
            }
            if(y>point[1]) {
                y--;
                return getPoint(point);
            }
            return Integer.MIN_VALUE;
        }
        public int getPoint() {
            return x*1000+y;
        }
        private int getPoint(int[] point) {
            if(x==point[0] && y==point[1]) {
                turn++;
            }
            return x*1000+y;
        }
    }
}