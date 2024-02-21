def solution(id_list, report, k):
    report_list = {}
    reported_list = {}
    for id_name in id_list:
        report_list[id_name] = []
        reported_list[id_name] = []
    
    for r in report:
        report_from, report_to = r.split()
        
        if report_to not in report_list[report_from]:
            report_list[report_from].append(report_to)
        if report_from not in reported_list[report_to]:
            reported_list[report_to].append(report_from)
        
        
    answer = []
    
    for name in report_list:
        count = 0
        for report_name in report_list[name]:
            if len(reported_list[report_name]) >= k:
                count += 1
        answer.append(count)
    return answer