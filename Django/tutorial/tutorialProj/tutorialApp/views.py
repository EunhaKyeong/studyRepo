from django.shortcuts import render
from tutorialApp.forms import *

# Create your views here.
def write(request):
    if request.method=='POST':  #저장 버튼을 누르면 request method는 POST 방식임.
        form = Form(request.POST)
        if form.is_valid():
            form.save() #DB에 form 내용을 저장.
    else:
        form = Form()
        
    return render(request, 'write.html', {'form':form})

def list(request):
    articleList = Article.objects.all()
    return render(request, 'list.html', {'articleList':articleList})

def view(request, contents_num="1"):
    article = Article.objects.get(id=contents_num)
    return render(request, 'view.html', {'article':article})