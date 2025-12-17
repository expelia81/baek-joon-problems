def solution(n, lost, reserve)
    
    lost.each do |i|
        if reserve.include?(i)
            reserve.delete(i) 
            lost.delete(i)
        end
    end
    answer = n-lost.length
    
    lost.sort!
    reserve.sort!
    
    one = 0
    two = 0
    
    while (!lost.empty? && !reserve.empty?) do
        i = lost.first
        p = reserve.first
        
        if(i==p-1 || i==p || i==p+1) 
            answer+=1
            lost.shift
            reserve.shift
        else 
            if(i>p) 
                reserve.shift
            else 
                lost.shift
            end
        end
    end
    
    
    answer
end