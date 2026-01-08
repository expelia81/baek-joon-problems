def solution(picks, minerals)
  answer = 0
  
  # 1. 가진 곡괭이로 캘 수 있는 만큼만 광물 자르기 (중요)
  total_picks = picks.sum
  minerals = minerals[0...(total_picks * 5)]
  
  # 2. 5개씩 묶어서 피로도 계산 (each_slice가 훨씬 안전함)
  arr = minerals.each_slice(5).map do |chunk|
    temp = [0, 0, 0]
    chunk.each do |m|
      t = calc(m)
      temp[0] += t[0] # 다이아 곡괭이 사용시
      temp[1] += t[1] # 철 곡괭이 사용시
      temp[2] += t[2] # 돌 곡괭이 사용시
    end
    temp
  end

  # 3. 돌 곡괭이 피로도(가장 차이가 큰 기준) 내림차순 정렬
  # 가장 힘든 구간을 다이아 곡괭이에게 맡기기 위함
  arr.sort_by! { |s| -s[2] }

  # 4. 곡괭이 배분 (다이아 -> 철 -> 돌 순서)
  arr.each do |fatigue_set|
    if picks[0] > 0
      answer += fatigue_set[0]
      picks[0] -= 1
    elsif picks[1] > 0
      answer += fatigue_set[1]
      picks[1] -= 1
    elsif picks[2] > 0
      answer += fatigue_set[2]
      picks[2] -= 1
    else
      break # 곡괭이 다 씀
    end
  end

  answer
end

def calc(s)
    case s
        when 'diamond' then [1,5,25]
        when 'iron' then [1,1,5]
        else [1,1,1]
    end
end