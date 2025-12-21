def solution(lottos, win_nums)
    answer = []
    
    lottos.delete(0)
    zeros = 6-lottos.length
    answer << zeros
    answer << 0
    lottos.each do |i|
        answer[1] += 1 if win_nums.include?(i)
        answer[0] += 1 if win_nums.include?(i)
    end
    answer[0] = find_val(answer[0])
    answer[1] = find_val(answer[1])
    
    return answer
end

def find_val(v)
    case(v)
        when 0..1 
            6
        when 2 
            5
        when 3 
            4
        when 4 
            3
        when 5 
            2
        when 6 then 1
    end
end