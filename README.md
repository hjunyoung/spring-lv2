# Spring LV2 과제

## 도서관 서버 만들기

![use case diagram](https://github.com/hjunyoung/hjunyoung.github.io/assets/50318500/95a81a33-bc35-4a65-bcba-eb95f0667a7f)


## ERD

book의 language의 경우 **ISO 639-1 codes**를 사용

![ERD](https://github.com/hjunyoung/hjunyoung.github.io/assets/50318500/681bb3b9-0acc-450e-a3bf-3ca3c71f2fff)

## API Spec

![API Spec](https://github.com/hjunyoung/hjunyoung.github.io/assets/50318500/28ad4e9b-3de5-4f8d-866a-9fdbd0725477)

<details open>
  <summary><strong>POST /api/books</strong></summary>

Request

  ```json
  {
    "title": "string",
    "author": "string",
    "language": "string",
    "publisher": "string",
    "registeredAt": {
      "type": "string",
      "format": "date-time"
    }
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
    }
  }
```

Status: 400
```json
  {
    "message": "string",
  }
  ```
</details>


<details open>
  <summary><strong>POST /api/register</strong></summary>

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
    "message": "string",
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
      }
    }
  }
```

Status: 404
```json
  {
    "message": "string",
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
    }
  }
```

Status: 404
```json
  {
    "message": "string",
  }
  ```
</details>

<details open>
  <summary><strong>GET /api/members/{memberId}</strong></summary>


Response `200` `404`

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
      }
    }
  }
```

Status: 404
```json
  {
    "message": "string",
  }
  ```
</details>

<details open>
  <summary><strong>POST /api/members/{memberId}books/{bookId}</strong></summary>


Request

  ```json
  {
    "bookId": "integer",
    "memberId": "integer"
  }
  ```

Response `201` `400` `404`

  ```json
  {
    "message": "string"
  }
  ```
</details>

<details open>
  <summary><strong>PUT /api/members/{memberId}books/{bookId}</strong></summary>


Request

  ```json
  {
    "bookId": "integer",
    "memberId": "integer"
  }
  ```

Response `201` `400` `404`

  ```json
  {
    "message": "string"
  }
  ```
</details>

<br>


