import math

def solution(fees, records):
    
    parking = {}
    parkingTime = {}
    parkingFee = {}
    
    for record in records:
        t, carNum, content = record.split()
        hh, mm = map(int, t.split(':'))
        carNum = int(carNum)
        
        if content == "IN":
            parking[carNum] = [hh, mm]
            if carNum not in parkingTime:
                parkingTime[carNum] = 0
        else:
            oldHh, oldMm = parking[carNum]
            time = (hh-oldHh) * 60 + (mm - oldMm)
            parkingTime[carNum] += time
            parking[carNum] = []
            
    for carNum in parking:
        if len(parking[carNum]) == 0:
            continue
        oldHh, oldMm = parking[carNum]
        time = (23-oldHh) * 60 + (59 - oldMm)
        parkingTime[carNum] += time
    
    for carNum in parkingTime.keys():
        time = parkingTime[carNum]
        money = 0
        if time <= fees[0]:
            money = fees[1]
        else:
            money = fees[1] + math.ceil((time-fees[0]) / fees[2]) * fees[3]
        parkingFee[carNum] = money
            
    
    answer = []
    for f in sorted(parkingFee.items()):
        answer.append(f[1])
            
            
          
    return answer