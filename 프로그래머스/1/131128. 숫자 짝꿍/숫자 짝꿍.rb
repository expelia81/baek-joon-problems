def solution(x, y)
    answer = ''
    arr1 = Array.new(10,0)
    arr2 = Array.new(10,0)
    arr3 = []
    x.chars.each do |i| 
        arr1[i.to_i]+=1 
    end
    y.chars.each do |i| 
        arr2[i.to_i]+=1 
    end
    (0..9).each do |i|
        max = [arr1[i], arr2[i]].min
        max.times do |count|
          arr3 << i.to_s
        end
    end
    arr3.sort!.reverse!
    answer = arr3.join
    return "-1" if arr3.empty?
    return "0" if arr3[0]=="0"
    return answer
end