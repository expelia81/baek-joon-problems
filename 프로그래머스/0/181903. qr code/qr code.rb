def solution(q, r, code)
    answer = ''
    code.chars.each_with_index do |i, index| 
        answer << i if index%q == r
    end
    return answer
end