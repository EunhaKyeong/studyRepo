from bs4 import BeautifulSoup
import requests

def get_keyword_number(keyword):
    url = "https://www.google.com/search?q={}".format(keyword)
    headers = {
        'user-agent' : 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36'
    }   

    #웹 요청
    res = requests.get(url, headers=headers)
    #print(type(res.text))

    #구문 분석 - 파싱
    soup = BeautifulSoup(res.text, 'lxml')
    #print(type(soup))

    #원하는 것만 찾기
    number = soup.select_one("#result-stats").text
    #print(number)

    #number.text에서 숫자만 추출
    number = int(number[number.find('약')+2:number.find('개')].replace(',', ''))
    return number

if __name__ == "__main__":
    print(get_keyword_number('galaxy'))