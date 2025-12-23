def solution(name)
  n = name.length
  # 알파벳 변경 횟수 합계 (이 부분은 그리디하게 결정됨)
  moves = name.chars.map { |c| 
    [c.ord - 'A'.ord, 'Z'.ord - c.ord + 1].min 
  }.sum

  # 이동 횟수 초기값: 그냥 한 방향으로 끝까지 가기
  min_move = n - 1

  n.times do |cs|
    # 현재 지점(cs) 다음으로 'A'가 아닌 문자가 나오는 위치(next) 찾기
    nxt = cs + 1
    nxt += 1 while nxt < n && name[nxt] == 'A'

    # 1. 오른쪽으로 갔다가 왼쪽으로 돌아가는 경우
    # (cs: 시작부터 현재까지 거리, n-nxt: 뒤에서부터 nxt까지 거리)
    dist_to_left = cs * 2 + (n - nxt)

    # 2. 왼쪽으로 먼저 갔다가 오른쪽으로 돌아오는 경우
    dist_to_right = (n - nxt) * 2 + cs

    # 최솟값 갱신
    min_move = [min_move, dist_to_left, dist_to_right].min
  end

  moves + min_move
end