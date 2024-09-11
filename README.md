# Overture-Of-Promachina-backend
- 코인 배팅 시스템

## 개발 규칙
1. main은 항상 동작 가능해야한다.

## User_Repository
- save: 회원 가입시 정보 저장
- DuplicateCheckUser: 중복 LoginId 확인
- DuplicateCheckNickname: 중복 Nickname 확인
- FindNicknameByLoginID: 로그인시 LoginId기반 Nickname을 반환받아 사용
- FindAccountAndPriKeyByNickname: 코인 교환에 필요한 account와 key를 반환
