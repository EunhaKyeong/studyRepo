#XML 문서 파싱하기
#파싱이란? : XML 문서를 읽고 해석하여 태그명, 속성명, 속성값 및 엘리먼트 내용을 분리해주는 프로그램.
from xml.etree.ElementTree import parse

tree = parse("note.xml") #parse() 함수를 사용하여 xml을 파싱함.
note = tree.getroot()
print(note)

#애트리뷰트값 읽기 : get() 메서드
print(note.get("date")) #note 태그의 date 애트리뷰트값 읽어오기
print(note.get("foo", "default"))   #note 태그의 foo 애트리뷰트값 읽어오기. 만약에 foo 애트리뷰트값이 존재하지 않으면 default 출력
print(note.keys())  #note 태그의 모든 애트리뷰트의 키값 읽어오기
print(note.items()) #note 태그의 모든 애튜리뷰트의 key, value 쌍 읽어오기 -> 튜플 형식.

#XML 태그 접근하기
from_tag = note.find("from")
from_tags = note.findall("from")
from_text = note.findtext("from")

print(from_tag)
print(from_tags)
print(from_text)