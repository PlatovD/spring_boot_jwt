# JWT Authentication API

Этот проект предоставляет API для аутентификации и авторизации пользователей с использованием **JWT (JSON Web Tokens)**.

### Возможности

- Регистрация и аутентификация пользователей
- Access и refresh JWT токены
- Ролевая модель авторизации (USER, ADMIN)
- Защищенные endpoints

<br>
<br>

## Структура JWT токенов

Все токены в системе имеют стандартную JWT структуру:

`header.payload.signature`

### Пример токена:
```
eyJhbGciOiJIUzM4NCJ9.eyJyb2xlIjoiUk9MRV9VU0VSIiwiaWQiOjYsInR5cGUiOiJhY2Nlc3MiLCJlbWFpbCI6ImRpbWFAZ21haWwuY29tIiwic3ViIjoiRGltYXNpazEiLCJpYXQiOjE3NTY3MjI0NDQsImV4cCI6MTc1NjcyMzk0NH0.X8VJjVNk4TqPHQZf5p6nmcNqGhajaR1u01BiICJ6BshAcXmS1FB8Qt5v6Qpvactt
```

### Компоненты:
- **Header** (`eyJhbGciOiJIUzM4NCJ9`) - алгоритм и тип токена
- **Payload** (`eyJyb2xlIjoiUk9MRV9VU0VSIiwiaWQiOjYsInR5cGUiOiJhY2Nlc3MiLCJlbWFpbCI6ImRpbWFAZ21haWwuY29tIiwic3ViIjoiRGltYXNpazEiLCJpYXQiOjE3NTY3MjI0NDQsImV4cCI6MTc1NjcyMzk0NH0`) - данные пользователя
- **Signature** (`X8VJjVNk4TqPHQZf5p6nmcNqGhajaR1u01BiICJ6BshAcXmS1FB8Qt5v6Qpvactt`) - электронная подпись

<br>
<br>

## Быстрый старт

1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/PlatovD/spring_boot_jwt.git
   ```

2. Настройте базу данных в `application.properties` и не забудьте ее предварительно запустить:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8db.url=jdbc:mysql://mysql:3306/resume?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. Запустите приложение:
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

### Requests
```http
POST /auth/sign-up
Content-Type: application/json

{
  "name": "Dima",
  "email": "dima@gmail.com",
  "password": "my_1ecer10_pa66"
}
```

<br>

```http
POST /auth/sign-in
Content-Type: application/json

{
  "name": "Dima",
  "password": "my_1ecer10_pa66"
}
```

<br>

```http
POST /auth/refresh
Content-Type: application/json

{
  "refresh": "eyJhbGciOiJIUzM4NCJ9.eyJ0eXBlIjoicmVmcmVzaCIsInN1YiI6IkRpbWFzaWsxIiwiaWF0IjoxNzU2NzIyNDQ0LCJleHAiOjE3NTkzMTQ0NDR9.9BjU56pQHE4YHDyTeG4uq4-GFhQcZ8tPgfLFZoM2bhyroKfAzREbv19goHYRzU_B"
}
```

<br>

### Response:
```json
{
  "access_token": "eyJhbGciOiJIUzI1NiIs...",
  "refresh_token": "eyJhbGciOiJIUzI1NiIs...",
}
```

<br>

### Доступ к защищенным ресурсам
```http
GET /
Authorization: Bearer eyJhbGciOiJIUzI1NiIs...
```

<br>
<br>

## ⚙️ Настройка JWT

В `application.properties`:
```properties
jwt.duration.expiration.access=1500
jwt.duration.expiration.refresh=2592000
jwt.singing.key=yourkey
```
