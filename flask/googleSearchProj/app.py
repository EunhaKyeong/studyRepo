from flask import Flask

app = Flask(__name__)

@app.route('/')
def index():
    return "<h1>This is Google Keyword Project! WELCOME!</h1>"

if __name__ == "__main__":
    app.run(debug=True) #debug=True : 코드의 변경이 있을 때마다 바로 적용될 수 있도록.