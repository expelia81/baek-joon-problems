def solution(id_pw, db)
    answer = ''
    db = db.to_h 
    puts db[id_pw[0]] == id_pw[1].to_s
    puts db.include? id_pw[0]
    return "login" if (db.include? id_pw[0]) && (db[id_pw[0]] == id_pw[1].to_s)
    return "wrong pw" if db.include? id_pw[0]
    return "fail"
end