# Todo
그날 할 작업들을 미리 적어놓고 완료할 때마다 체크하는 목적으로 생성했습니다. todo 목록은 일 단위로 생성됩니다.
### 11.09 목
- [x] 명세사항 읽으며 기능 분석하기
- [x] 바로 개발에 들어가지 말고 플로우차트를 그려보기
- [x] README 작성 - 기능개요작성
- [x] 클래스 및 Enum 생성하기

### 11.10 금
- [x] 플로우차트 그리기 => 이미지 만들어 리드미에 업로드 완료
- [x] 예외사항 생각해서 기능구현할때마다 TDD해야됨
- [x] 목표구현기능 정리 (총 7단계중 3단계까지 작성함 => 바뀔 상황을 대비)
- [x] 기능구현 시작
	- [x] 기능 1

```
금요일 작업 스스로 평가
기능을 7가지로 나누고 플로우 차트 그리는것까지 완료하긴 함
근데 2번기능까지는 괜찮은것 같은데 3번부터 이상해서 일단 3번 플로우차트 고침... 
4번부터는 내일 일단 3번까지 구현을 해보고 다시 그려봐야될 각
기획 언제 끝남 ㅠㅠㅠ 제출전까지 함께 할듯 ... ㅠㅠㅠ

+) 플로우차트를 미리 그려놓으니까 개발에 막힘이 없다. ㅎ 고대로 옮겨서 개발중
```

### 11.11 토
- [x] 기능2 플로우차트 변경
- [x] 기능구현 1
	- [x] 기능 2
	- [x] 기능 3
- [x]  4 ~ 7 단계 목표구현기능 정리하기
- [x] 기능구현 2
	- [x] 기능 3-2
	- [x] 기능 4

### 11.12 일
- [x] 기능구현
	- [x] 기능 5
	- [x] 기능 6
	- [x] 기능 7

### 11.13 월
- [ ] 리팩토링 및 수정
	- [x] 2번 기능 검증로직
	- [ ] 4번기능 조건 이상해서 수정 필요함
	- [ ] `n일에 받을 혜택 ~ ` 부분 고쳐야됨

### 11.15 수 : 여러가지 리팩토링 & 수정
**1. validator > menu > OrderCount**
- [x]  [`isInt()` : 이름 isInt 축약 풀기 => isInteger로 #2](https://github.com/8x15yz/java-christmas-6-8x15yz/issues/2)

**2. validator > menu > OrderMenu**
- [x]  api 불러오는 거 for문 바깥으로 보내서 카탈로그 하나만 불러오도록 함

**3. Preprocess 클래스**
- [x]  `part()` : 변수명 requests => response로 이름 바꾸기
- [x]  duplicate print 찍어서 제대로 돌아가고있는건지 두눈으로 확인하기

**4. validator 패키지 리뷰**
- [x]  OrderMenu / OrderCount 이름뜻 유추하기 힘듦 => MenuValidate / CountValidate 로 변경

**5. PromotionSystem 클래스에서**
- [x]  inputDay() 에서는 그냥 값만 입력받고 나옴
- [x]  그다음 total()에서 price 나왔을 때 gift() 돌리기 이전에 Reserve.set()을 가져와서 끼우기
- [x]  Reserve.set() 에서 인자를 하나 더 받아 (price)
- [x]  거기서 비교를 하고 만원 이하면 Enum 돌려서 다 false로 막기
- [x]  그 이후에 gift 랑 benefit이랑 돌리기

**6. 날짜 입력받는 부분에 추가할 기능**
- [x]  12월 `n`일에 우테코 식당에서 받을 이벤트 혜택 미리 보기! 로 나오도록 해야됨