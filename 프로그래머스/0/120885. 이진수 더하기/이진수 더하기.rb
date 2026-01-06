def solution(bin1, bin2)
    answer = bin1.to_i(2) + bin2.to_i(2)
    return answer.to_s(2)
end