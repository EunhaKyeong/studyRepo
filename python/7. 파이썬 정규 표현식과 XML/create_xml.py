'''
우리가 만들 xml
<note date = "20151231">
    <to>Tove</to>
    <from>Jani</from>
    <heading>Reminder</heading>
    <body>Don't forget me ths weekend!</body>
</note>
'''

from xml.etree.ElementTree import Element, dump, SubElement, ElementTree

note = Element("note")  #note란 Element 생성
to = Element("to")  #to란 Element 생성.
to.text = "Tove"    #to Element의 value는 Tove
note.append(to) #note Element 하위 Element를 to로 지정.

SubElement(note, "from").text = "Jani"  #note Element의 하위 Element로 from이란 Element를 만들고 이 Element의 value는 Jani이다.
SubElement(note, "heading").text = "Reminder"
SubElement(note, "body").text = "Don't forget me ths weekend!"

note.attrib["date"] = "20151231"    #note의 date란 속성을 추가하고 이 속성의 값은 20151231이다.
#note = Element("note", date="20151231")와 같이 Element 생성 시 어트리뷰트를 함께 생성할 수 있음.

def indent(elem, level=0):
    i = "\n" + level*" "
    if len(elem):
        if not elem.text or not elem.text.strip():
            elem.text = i + " "
        if not elem.tail or not elem.tail.strip():
            elem.tail = i
        for elem in elem:
            indent(elem, level+1)
        if not elem.tail or not elem.tail.strip():
            elem.tail = i
    else:
        if level and (not elem.tail or not elem.tail.strip()):
            elem.tail = i
indent(note)
dump(note)  #dump(tag)는 tag 이하의 인자를 출력해주는 함수이다.

#생성한 xml 파일에 쓰기
ElementTree(note).write("note.xml")