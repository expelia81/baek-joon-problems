
def solution(ingredient)
  answer = 0
  arr = []
  target = [1,2,3,1]
  ingredient.each do |i|
    arr << i
    if arr.length >= 4
      if arr[-4] == 1 && arr[-3] == 2 && arr[-2] == 3 && arr[-1] == 1

        4.times do
          arr.pop
        end
        answer+=1
      end

    end
  end
  return answer
end