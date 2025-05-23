import java.util.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int[] video = {Integer.parseInt(video_len.split(":")[0]), Integer.parseInt(video_len.split(":")[1])};
        int[] start = {Integer.parseInt(op_start.split(":")[0]), Integer.parseInt(op_start.split(":")[1])};
        int[] end = {Integer.parseInt(op_end.split(":")[0]), Integer.parseInt(op_end.split(":")[1])};
        
        int min = Integer.parseInt(pos.split(":")[0]);
        int sec = Integer.parseInt(pos.split(":")[1]);
        
        System.out.print("start : ");
        log(start[0],start[1]);
        System.out.print("end : ");
        log(end[0],end[1]);
        System.out.print("pos : ");
        log(min,sec);
        int startSec = start[0]*60+start[1];
        int endSec = end[0]*60 + end[1];
        int nowSec = min*60 + sec;
        int videoSec = video[0]*60 + video[1];
        if(startSec <= nowSec && endSec >= nowSec) {
            min = end[0];
            sec = end[1];
        }
        for(String command :  commands) {
            if(command.equals("prev")) {
                if (sec >= 10) {
                    sec-=10;
                } else if(sec < 10) {
                    if(min==0) {
                        sec=0;
                    } else {
                        min--;
                        sec+=50;
                    } 
                }
            } else {
                if(sec<50) {
                    sec+=10;
                } else {
                    sec-=50;
                    min++;
                }
                nowSec = min*60 + sec;
                if(videoSec <= nowSec) {
                    min = video[0];
                    sec = video[1];
                }
            }
            nowSec = min*60 + sec;
            if(startSec <= nowSec && endSec >= nowSec) {
                min = end[0];
                sec = end[1];
            }
        }
        
        
        if (min<10) {
            answer ="0"+min;
        } else {
            answer += min;
        }
        if (sec <10) {
            answer += ":0"+sec;
        } else {
            answer += ":"+sec;
        }
        
        return answer;
    }
    
    void log(int min, int sec) {
        System.out.println(min+":"+sec);
    }
}