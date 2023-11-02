# Spring LV2 과제

## 도서관 서버 만들기

## 📌 TODO

1. 404 Error Status code 나오게 하기
2. ~~회원 등록 실패 시 memberId 1 증가하는 문제 해결하기~~

   JPA에서 MySQL과 연동해서 `@GeneratedValue`를 쓸 때 주로 사용하는 `IDENTITY` 전략은 기본 키 생성을 DB에 위임한다. JPA 영속성 컨텍스트에서
   Entity를 관리하기
   위해서는 PK값이 있어야하는데, MySQL AUTO_INCREMENT 기능으로 생성하는 PK를 영속성 컨텍스트 1차 캐시의 key 값으로 사용하여 관리하는 방식이다.

   그런데 JPA 입장에서는 DB에 query를 실행하기 전에는 AUTO_INCREMENT되는 값을 알 수 가 없다. 따라서 IDENTITY 전략을 사용할 떄는
   em.persist()
   가 호출되는 시점에 insert query가 실행되어 PK 값을 조회한다.

   entityTransaction.commit()이 실행되기 전에 오류가 발생해서 transaction이 rollback이 된다고 해도 DB에서 AUTO_INCREMENT한
   값은 그대로 유지된다. 따라서 다음 번에 호출한 query에서도 PK가 증가한 상태가 된다.

## Use case diagram

![use case diagram](https://github.com/hjunyoung/hjunyoung.github.io/assets/50318500/95a81a33-bc35-4a65-bcba-eb95f0667a7f)

## ERD

book의 language의 경우 **ISO 639-1 codes**를 사용

![ERD](https://github.com/hjunyoung/hjunyoung.github.io/assets/50318500/336db01f-f5ad-4e50-a5f4-1bd169f20685)

## API Spec

![API Spec](https://github.com/hjunyoung/hjunyoung.github.io/assets/50318500/e497ed98-bf7d-4921-8619-00fdb2538e74)

<details open>
  <summary><strong>POST /api/books</strong></summary>

Request

```json
{
  "title": "string",
  "author": "string",
  "language": "string",
  "publisher": "string"
}
```

Response `201` `400`

Status: 201

```json
{
  "id": "integer",
  "title": "string",
  "author": "string",
  "language": "string",
  "publisher": "string",
  "registeredAt": {
    "type": "string",
    "format": "date-time"
  },
  "available": "boolean"
}
```

Status: 400

```json
{
  "code": "string",
  "error type": "string",
  "message": "string"
}
```

</details>


<details open>
  <summary><strong>POST /api/members</strong></summary>

Request

```json
{
  "name": "string",
  "gender": "string",
  "rrn": "string",
  "phoneNumber": "string",
  "address": "string"
}
```

Response `201`  `400`

Status: 201

```json
{
  "id": "integer",
  "name": "string",
  "gender": "string",
  "phoneNumber": "string",
  "address": "string"
}
```

Status: 400

```json
{
  "code": "string",
  "error type": "string",
  "message": "string"
}
```

</details>


<details open>
  <summary><strong>GET /api/books</strong></summary>

Response `200`  `404`

Status: 200

```json
{
  "type": "array",
  "items": {
    "id": "integer",
    "title": "string",
    "author": "string",
    "language": "string",
    "publisher": "string",
    "registeredAt": {
      "type": "string",
      "format": "date-time"
    },
    "available": "boolean"
  }
}
```

Status: 404

```json
{
  "code": "string",
  "error type": "string",
  "message": "string"
}
```

</details>


<details open>
  <summary><strong>GET /api/books/{bookId}</strong></summary>

Response `200`  `404`

Status: 200

```json
{
  "id": "integer",
  "title": "string",
  "author": "string",
  "language": "string",
  "publisher": "string",
  "registeredAt": {
    "type": "string",
    "format": "date-time"
  },
  "available": "boolean"
}
```

Status: 404

```json
{
  "code": "string",
  "error type": "string",
  "message": "string"
}
```

</details>

<details open>
  <summary><strong>GET /api/records</strong></summary>


Response `200` `400` `404`

Status: 200

```json
{
  "type": "array",
  "items": {
    "id": "integer",
    "name": "string",
    "phoneNumber": "string",
    "title": "string",
    "author": "string",
    "borrowedAt": {
      "type": "string",
      "format": "date-time"
    },
    "returnStatus": "boolean"
  }
}
```

Status: 400, 404

```json
{
  "code": "string",
  "error type": "string",
  "message": "string"
}
```

</details>

<details open>
  <summary><strong>POST /api/books/{bookId}</strong></summary>

Response `201` `400`

Status: 201

```json
{
  "message": "string"
}

```

Status: 400

```json
{
  "code": "string",
  "error type": "string",
  "message": "string"
}
```

</details>

<details open>
  <summary><strong>PUT /api/books/{bookId}</strong></summary>

Response `200` `400`

Status: 200

```json
{
  "message": "string"
}
```

Status: 400

```json
{
  "code": "string",
  "error type": "string",
  "message": "string"
}
```

</details>

<br>


