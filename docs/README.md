# ⚾️ 숫자 야구 게임 

![header](https://capsule-render.vercel.app/api?type=wave&color=auto&height=300&section=header&text=여늘의%20숫자야구게임%20&fontSize=90&animation=fadeIn)

## 📢 프로젝트 소개 목차
1. [프로젝트 한줄 요약](#프로젝트-한줄-요약)
2. [프로젝트 구조도](#프로젝트-구조도)
3. [프로젝트 클래스 기능](#프로젝트-클래스-기능)
4. [프로젝트 작동 흐름](#프로젝트-작동-흐름)
5. [테스트케이스 결괴](#테스트케이스-진행-결과)
6. [기능 요구 사항 요약](#기능-요구-사항-요약)
7. [기능 목록 개발 과정](#기능-목록-작성)

<br>
<br>


### 📌 프로젝트 한줄 요약

📱 사용자가 컴퓨터가 선정한 숫자를 예측하여 맞추는 게임

<br>
<br>

### 📌 프로젝트 구조도

<b>추후 그림으로 업데이트</b>

<br>
<br>

### 📌 프로젝트 클래스 기능

<div text-align="center">
<table>
    <tr>
        <th text-align="center">Package</th>
        <th text-align="center">Class</th>
        <th text-align="center">Description</th>
    </tr>
    <tr>
        <td rowspan="5"><b>constant</b></td>
        <tr>
            <td><b>BallConstant</b></td>
            <td>혜택 금액에 따라 부여되는 12월 이벤트 배지를 관리하는 enum 클래스</td>
        </tr>
        <tr>
            <td><b>ComputerBallsConstant</b></td>
            <td>할인 이벤트가 적용되어 있는 달력을 관리하는 enum 클래스, 이 클래스를 기반으로 할인 정보(Discount) 생성</td>
        </tr>
        <tr>
            <td><b>GeneratorBallsConstant</b></td>
            <td>우테코 식당에서 제공되는 음식에 대한 정보를 관리하는 enum 클래스</td>
        </tr>
        <tr>
            <td><b>PlayerBallsConstant</b></td>
            <td>증정 상품을 관리하는 enum 클래스</td>
        </tr>
        </td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="2"><b>controller</b></td>
        <tr>
            <td><b>GameController</b></td>
            <td>DiscountGenerator의 매직넘버를 enum 클래스로 보관</td>
        </tr>
        </td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="6"><b>exception</b></td>
        <tr>
            <td><b>BallExceptionMessage</b></td>
            <td>프로젝트의 운영 흐름 제어</td>
        </tr>
        <tr>
            <td><b>ComputerBallsExceptionMessage</b></td>
            <td>프로젝트의 운영 흐름 제어</td>
        </tr>
        <tr>
            <td><b>ConvertorExceptionMessage</b></td>
            <td>프로젝트의 운영 흐름 제어</td>
        </tr>
        <tr>
            <td><b>InputViewExceptionMessage</b></td>
            <td>프로젝트의 운영 흐름 제어</td>
        </tr>
        <tr>
            <td><b>PlayerBallsExceptionMessage</b></td>
            <td>프로젝트의 운영 흐름 제어</td>
        </tr>
        </td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="6"><b>model</b></td>
        <tr>
            <td><b>Ball</b></td>
            <td>적용할 수 있는 할인 정보가 담겨있는 record 클래스</td>
        </tr>
        <tr>
            <td><b>ComputerBalls</b></td>
            <td>Calender 클래스의 정보를 기반으로, 입력된 날자에 적용할 수 있는 할인 정보(Discount)를 생성</td>
        </tr>
        <tr>
            <td><b>GeneratorBalls</b></td>
            <td>할인이 적용된 결과(할인 금액)을 할일별로 각 Integer 필드를 선언하여 관리하는 record 클래스</td>
        </tr>
        <tr>
            <td><b>PlayerBalls</b></td>
            <td>사용자가 주문한 주문 정보를 보관, 외부로부터 할인 정보를 메시지로 받으면 내부에 있는 주문 정보에 적용함</td>
        </tr>
        <tr>
            <td><b>PlayerResult</b></td>
            <td>Order, Discount를 필드로 관리하는 클래스, 혜택 내역들을 계산하게 만드는 클래스</td>
        </tr>
        </td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="6"><b>util</b></td>
        <tr>
            <td><b>CharacterUtil</b></td>
            <td>입력과 관련된 예외 문구를 관리하는 enum 클래스</td>
        </tr>
        <tr>
            <td><b>Convertor</b></td>
            <td>Order 클래스에서 발생하는 예외 문구를 관리하는 enum 클래스</td>
        </tr>
        <tr>
            <td><b>Generator</b></td>
            <td>VisitDay 클래스에서 발생하는 예외 문구를 관리하는 enum 클래스</td>
        </tr>
        <tr>
            <td><b>GeneratorImp</b></td>
            <td>VisitDay 클래스에서 발생하는 예외 문구를 관리하는 enum 클래스</td>
        </tr>
        <tr>
            <td><b>MessageFormat</b></td>
            <td>VisitDay 클래스에서 발생하는 예외 문구를 관리하는 enum 클래스</td>
        </tr>
        </td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="10"><b>view</b></td>
        <tr>
            <td><b>InputViewMessage</b></td>
            <td>입력문을 처리하는 클래스</td>
        </tr>
        <tr>
            <td><b>OutputViewMessage</b></td>
            <td>출력문을 처리하는 클래스</td>
        </tr>
        <tr>
            <td><b>InputView</b></td>
            <td>입력문을 처리하는 클래스</td>
        </tr>
        <tr>
            <td><b>OutputView</b></td>
            <td>출력문을 처리하는 클래스</td>
        </tr>
        </td>
    </tr>
    <tr>
</table>
</div>
<br>

<br>
<br>

### 📌 프로젝트 작동 흐름

최종 구현 완료 후 그림 첨부

<br>
<br>

### 📌 테스트 케이스 진행 결과

최종 구현 완료 후 테스트 케이스 진행 흐름 그림 첨부

<br>
<br>

### 📌 기능 요구 사항 요약

~~~
- 1~9 서로 다른 수로 이루어진 3개의 수를 맞추는 게임
  - 같은 수 같은 자리 : 스트라이크
  - 같은 수 다른 자리 : 볼
  - 낫싱


- 컴퓨터는 서로 다른 3개의 숫자 임의로 선택
- 플레이어는 서로 다른 3개의 숫자 입력


- 3개의 숫자를 모두 맞히면 게임 종료
  - 종료한 후 게임을 다시 시작하거나 완전히 종료 가능

  
- 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생 후 애플리케이션 종료
~~~
<br>
<br>

### 📌 기능 목록 작성

#### 입/출력

[✅] 사용자가 선택한 숫자 입력 받기
- 예외 처리 : 숫자가 아닌 값, 잘못된 입력 형식 -> IllegalArgumentException

[✅] 게임 재시작 여부 입력 받기
- 예외 처리 : 1~2 이외의 값, 잘못된 입력 형식 -> IllegalArgumentException

[✅] 입력에 대한 결과 출력


#### 기능
[✅] 컴퓨터가 1~9까지 서로 다른 임의의 수 선정 
- 예외 처리 : 숫자 3개 입력 x, 1~9 이외의 숫자 -> IllegalArgumentException

[✅] 사용자가 입력한 값과 컴퓨터가 선정한 값 비교
- 예외 처리 : 숫자 3개 입력 x, 1~9 이외의 숫자 -> IllegalArgumentException

[✅] 1~9까지 임의의 숫자 3개 생성, 중복 제거

[✅] 게임 재시작 기능
