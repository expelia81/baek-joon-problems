def solution(s)
    
    index = 0;
    answer=0
    while (index < s.length)
       index = find_index(index,s)+1
        answer+=1
    end
    return answer
end

def find_index(start_index, s)
    count_equal = 0
    count_non_equal = 0
    
    origin = s[start_index]
    # puts "#{origin} : #{start_index}"
    (start_index..s.length).each do |i|
        if(origin == s[i]) 
            count_equal+=1
        else 
            count_non_equal+=1
        end
        
        if(count_equal == count_non_equal)
           # puts "equal!!!!  #{count_equal}" 
            return i;
        end
    end
    return s.length-1;
end