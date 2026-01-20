def solution(my_string, overwrite_string, s)
    answer = ''
    (0..s-1).each do |i| 
        answer << my_string[i]
    end
    size = overwrite_string.size-1
    (0..size).each do |i|
        answer << overwrite_string[i] 
    end
    (s+size+1..my_string.size-1).each do |i|
        answer << my_string[i] 
    end
    return answer
end