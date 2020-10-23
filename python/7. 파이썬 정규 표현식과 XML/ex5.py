'''
연습문제5.
ElementTree를 이용하여 다음 XML 문서를 작성하고 파일에 저장해 보자.

<blog date="20151231">
    <subject>Why python?</subject>
    <author>Eric</author>
    content>Life is too short, you need Python!</content>
</blog>
'''

from xml.etree.ElementTree import Element, SubElement, dump, ElementTree

blog = Element("blog", date="20151231")
SubElement(blog, "subject").text = "Why python?"
SubElement(blog, "author").text = "Eric"
SubElement(blog, "content").text = "Life is too short, you need Python!"

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

indent(blog)
dump(blog)

ElementTree(blog).write("연습문제5번.txt")