result = [0, 0]

def solution(users, emoticons):
    
    global result
    
    
                     
    discount(emoticons, [], users)
                
    
    return result

def discount(emoticons, discounted, users):
    global result
    # 할인율을 모두 반영한 경우
    if len(emoticons) == len(discounted):
        current = [0, 0]
        for user in users:
            total_price = 0
            for i in range(len(discounted)):
                # 일정 비율 이상 할인하는 경우
                if discounted[i] * 100 / emoticons[i] <= 100 - user[0]:
                    total_price += discounted[i]
                
            # 구매 비용의 합이 일정 가격 이상이 된다면
            if total_price >= user[1]:
                current[0] += 1
            else:
                current[1] += total_price
        if current[0] > result[0] or (current[0] == result[0] and current[1] > result[1]):
            result[0] = current[0]
            result[1] = current[1]        
        return
        
    for i in range(4):
        discount(emoticons, [*discounted, emoticons[len(discounted)] * (9-i) / 10], users)