from game.sound.echo import echo_test
echo_test()

'''
import game
game.sound.echo.echo_test()는 불가능
import game을 하게 되면 game 디렉토리의 모듈이나 __init__.py만 참조할 수 있다.
'''

'''
import game.sound.echo.echo_test도 불가능.
import의 가장 마지막 항목은 모듈이나 패키지여야 한다.
echo_test는 echo 모듈에 존재하는 함수이기 때문에 불가능하다.
'''