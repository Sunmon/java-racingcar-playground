## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---

## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---

1. 피드백 강의 전까지 미션 진행

> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---

2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---

3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

## 기능 요구사항

1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
    - [x] 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.
    - [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다. (예: “1”)
    - [x] 숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다. (예: “1,2”)
    - [x] 구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다. (예: “1,2:3” => 6)
2. [x] 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
    - [x] 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며,
      결과 값은 6이 반환되어야 한다.
3. [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 프로그래밍 요구사항

- [] indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
    - depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- [] 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- [] method가 한 가지 일만 하도록 최대한 작게 만들어라.
- [] else를 사용하지 마라.