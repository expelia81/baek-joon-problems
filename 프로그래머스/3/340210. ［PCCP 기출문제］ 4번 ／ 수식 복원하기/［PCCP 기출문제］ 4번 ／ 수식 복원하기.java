import java.util.*;

class Solution {
    private static int max = 9;
    private static int min = 0;
    private static boolean check = false;
    public String[] solution(String[] expressions) {
        /*
         1의 자릿수 최대값+1이 곧 n진수의 최소값이 된다.
        */
        Exp[] exps = new Exp[expressions.length];
        
        List<Exp> list = new ArrayList<>();
        
        for(int i=0;i<expressions.length;i++) {
            exps[i]=new Exp(expressions[i]);
            exps[i].log();
            if(exps[i].result==-1) list.add(exps[i]);
        }
        
        String[] answer = new String[list.size()];
        
        for(int i =0 ;i<list.size();i++) {
            answer[i]=list.get(i).toString();
        }
        
        
        
        return answer;
    }
    
    public static class Exp {
        int a;
        int b;
        boolean plus;
        int result;
        
        
        private boolean checkAll() {
            // 자릿수 변동이 없는 경우
            boolean temp;
            boolean temp2;
            if(plus) {
                temp = a%10+b%10==result%10;
                temp2 = a/10+b/10 == result/10;
                temp = a%10+b%10 < min;
                temp2 = a/10+b/10 < min;
            } else {
                temp = a%10-b%10==result%10;
                temp2 = a/10-b/10 == result/10;
                temp = a%10>=b%10;
                temp2 = a/10>=b/10;
            }
            return temp && temp2;
        }
        
        public String toString() {
            int ret = -1;
            if(plus) {
                if(min==9 || check) {
                    int temp = (a/10+b/10)*min + a%10+b%10;
                    ret = (temp/(min*min))*100;
                    temp %= min*min;
                    ret+= (temp/min)*10 + temp%min;
                } else {
                    if(checkAll()) {
                        ret = a/10;
                        if(plus) ret += b/10;
                        else ret -= b/10;
                        ret = ret*10 + a%10;
                        if(plus) ret += b%10;
                        else ret -= b%10;
                    }
                }
            } else {
                if(min==9 || check) {
                    int temp = (a/10-b/10)*min + a%10-b%10;
                    ret = (temp/(min*min))*100;
                    temp %= min*min;
                    ret+= (temp/min)*10 + temp%min;
                } else {
                    if(checkAll()) {
                        ret = a/10;
                        if(plus) ret += b/10;
                        else ret -= b/10;
                        ret = ret*10 + a%10;
                        if(plus) ret += b%10;
                        else ret -= b%10;
                    }
                }
            }
            return a + (plus ? " + " : " - " )+ b + " = " + (ret==-1 ? "?" : ret+"");
        }
        
        public Exp(String exp) {
            String[] temp = exp.split(" ");
            a=Integer.parseInt(temp[0]);
            b=Integer.parseInt(temp[2]);
            if(temp[4].equals("X")) {
                result=-1;
            } else {
                result = Integer.parseInt(temp[4]);
            }
            
            if(temp[1].equals("+")) plus = true;
            else plus = false;
            // (a/10+b/10)*max + a%10+b%10 = (result/100)*max*max + (result/10)*max + result%10;
            // 
            min=Math.max(a%10+1,min);
            min=Math.max(b%10+1,min);
            min=Math.max(result%10+1,min);
            if(result==-1) return;
            if(plus) {
                plus();
            } else {
                minus();
            }
        }
        public void log() {
            System.out.printf("%d %s %d = %d    (min=%s)\n",a,plus?"+":"-",b,result,check? min+" 확정" : min +" 후보");
        }
        
        public void plus() {
            int t = a%10+b%10;
            int val = result%10;
            if(t!=val) {
                check=true;
                max=t-val;
                min=t-val;
                return;
            } else {
                t = a/10+b/10;
                val = (result%100)/10;
                if(t!=val) {
                    check=true;
                    max=t-val;
                    min=t-val;
                    return;
                }
            }
        }
        public void minus() {
            int val = a%10;
            int t = result%10+b%10;
            if(t!=val) {
                check=true;
                max=t-val;
                min=t-val;
                return;
            } else {
                val = a/10;
                t = result/10+b/10;
                if(t!=val) {
                    check=true;
                    max=t-val;
                    min=t-val;
                    return;
                }
            }
        }
    }
}