def solution(today, terms, privacies):
    now_year, now_month, now_day = map(int, today.split('.'))
    now_count = (now_year - 2000) * 12 + now_month
    term_data = {}
    for term in terms:
        term_type, valid_month = term.split()
        term_data[term_type] = int(valid_month)
        
    answer = []
        
    for i in range(len(privacies)):
        privacy_date, privacy_type = privacies[i].split()
        privacy_year, privacy_month, privacy_day = map(int, privacy_date.split('.'))
        
        privacy_count = (privacy_year - 2000) * 12 + privacy_month + term_data[privacy_type]
        
        if now_count > privacy_count or (now_count == privacy_count and now_day >= privacy_day):
            answer.append(i+1)
        
        
        
        
    print(term_data)
    
    return answer