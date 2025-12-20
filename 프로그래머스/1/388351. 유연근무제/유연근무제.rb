def solution(schedules, timelogs, startday)
    
    answer = 0
    arr = find_weekend(startday)
    
    (0..schedules.length-1).each do |i|
        value= schedules[i] 
        bool = true
        timelogs[i].each_with_index do |j,index|
            if(arr.include?(index)) 
                 next
            end
            
            time = value+10;
            if(value%100 > 49) 
                time-=60
                time+=100
            end
                
        
               
            unless (time >= j) 
                bool = false
                break
            end
        end
        answer += 1 if(bool)
    end
    return answer
end

def find_weekend(startday)
    arr = []
    
    if(startday < 6) 
        arr << 6-startday
        arr << 7-startday
    end
    if(startday == 6) 
        arr << 0
        arr << 1
    end
    if(startday==7) 
        arr << 0
        arr << 6
    end
    arr
end