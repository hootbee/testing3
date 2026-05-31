# 과제3 CI 수행 보고서

## 1. 과제 목표
기존 Triangle 프로그램에 복수 속성 반환 기능(`getTypeFlags`)을 추가하고, Unit Test/Mocking Test/Integration Test 및 GitHub Actions 기반 CI 흐름을 구성한다.

## 2. 구현 내용
- `getTypeFlags()` 추가
- `isossceles` 오타를 `isosceles`로 수정
- `isImpossible()`에 0 이하 길이 + 삼각형 부등식 검증 추가
- `isRightAngled()`를 변 순서 무관하게 동작하도록 정렬 + `long` 연산으로 개선
- `classify()`는 대표 유형 1개 반환 동작 유지

## 3. 테스트 내용
### Unit Test
- `TriangleTest`
- 정상 케이스, 경계값 케이스, 변 순서 변경 케이스 포함

### Mocking Test
- `TriangleMockTest`
- Mockito `spy()` 기반 내부 판별 흐름 검증
- impossible 우선 반환/호출 차단 검증
- right-angled + scalene 동시 반환 검증

### Integration Test
- `TriangleIntegrationTest`
- `Triangle.main()` 실행 결과를 `System.out` 캡처로 검증
- 사용법(Usage) 출력 케이스 포함

## 4. Maven/CI 구성
- `pom.xml` 구성 (JUnit Jupiter, Mockito, Surefire/Failsafe)
- `.github/workflows/ci.yml` 추가
- workflow 이름: `Java CI with Maven`
- 실행 명령: `mvn -B clean verify`

## 5. 실행/검증 결과
- 로컬 `mvn clean verify`: 성공
- PR 생성 및 병합: 완료
- PR: [https://github.com/hootbee/testing3/pull/1](https://github.com/hootbee/testing3/pull/1)
- 저장소: [https://github.com/hootbee/testing3](https://github.com/hootbee/testing3)

## 6. 최종 상태
- 병합 커밋(main): `c5f486f`
- 현재 브랜치: `main`
- 주요 산출물 파일
  - `src/main/java/Triangle.java`
  - `src/test/java/TriangleTest.java`
  - `src/test/java/TriangleMockTest.java`
  - `src/test/java/TriangleIntegrationTest.java`
  - `pom.xml`
  - `.github/workflows/ci.yml`
  - `TEST_RESULTS.md`

## 7. 비고
- Java 25 환경에서 Mockito/Byte Buddy 호환을 위해 `-Dnet.bytebuddy.experimental=true`를 Surefire/Failsafe에 반영함.
