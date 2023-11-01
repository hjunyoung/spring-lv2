# Spring LV2 과제

## 도서관 서버 만들기

## 📌 TODO

1. 404 Error Status code 나오게 하기
2. 회원 등록 실패 시 memberId 1 증가하는 문제 해결하기


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


