def solution(players, callings)
    answer = []
    map = {}
    players.each_with_index do |i, index|
        map[i] = index
    end
    
    callings.each do |i| 
        index = map[i] 
        temp = players[index]
        players[index] = players[index-1]
        players[index-1] = temp
        map[players[index-1]] = index-1
        map[players[index]] = index
    end
    
    
    
    return players
end