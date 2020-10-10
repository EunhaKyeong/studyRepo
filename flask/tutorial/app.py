from flask import Flask, render_template, request

#Flask 객체 인스턴스 생성
app = Flask(__name__) 

#localhost/ url에 접속해 index.html 페이지로 이동.
#웹 페이지를 하나씩 추가할 때마다 @app.rount()를 추가하고 아래 함수를 작성해야 함.
@app.route('/') 
def index():
    return render_template('index.html')

@app.route("/post", methods=['POST'])
def post():
    user = request.form['user']
    data = {'level':60, 'point':360, 'exp':45000}
    return render_template('post.html', user=user, data=data)

@app.route("/get", methods=['GET'])
def get():
    user = "반원"
    data = {'level':60, 'point':360, 'exp':45000}
    return render_template('get.html', user=user, data=data)

if __name__ == "__main__":
    #서버 실행
    app.run(debug=True)
    #host를 직접 지정하고 싶으면
    #app.run(host="127.0.0.1", port="5000", debug=True)

