# Hoteldetails

Simple hotel microservice for the project. This service manages hotel records and exposes APIs used by other services (especially user aggregation flow).

## What it does

- Manages hotels in MySQL.
- Exposes REST APIs under `/api/hotels`.
- Registers with Eureka using service name `Hoteldetails`.
- Supports create, read-all, read-by-id, and update operations.

## Implementation summary

- Main class: `src/main/java/com/hotelmicroservice/Hoteldetails/HoteldetailsApplication.java`
- Controller: `src/main/java/com/hotelmicroservice/Hoteldetails/Controller/HotelController.java`
- Service layer: `src/main/java/com/hotelmicroservice/Hoteldetails/Services/Impl/HotelServiceImpl.java`
- Repository: `src/main/java/com/hotelmicroservice/Hoteldetails/Repositories/HotelRepo.java`
- Mapper: `src/main/java/com/hotelmicroservice/Hoteldetails/Mapper/HotelMapper.java`
- Entity/DTO: `src/main/java/com/hotelmicroservice/Hoteldetails/Entity/*`
- Exception handling: `src/main/java/com/hotelmicroservice/Hoteldetails/ExceptionHandle/*`

### Main application behavior

- `@SpringBootApplication` boots the service.
- `@EnableDiscoveryClient` enables Eureka registration/discovery.
- Service runs on port `8082` (from YAML).

## API endpoints

Base URL: `/api/hotels`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/hotels` | Create hotel |
| `GET` | `/api/hotels` | Get all hotels |
| `GET` | `/api/hotels/{id}` | Get hotel by id |
| `PUT` | `/api/hotels/{id}` | Update hotel by id |

### Example create/update payload

```json
{
  "name": "Taj Residency",
  "location": "Mumbai",
  "description": "City center business hotel"
}
```

## Data flow

### Create hotel

1. Controller receives `HotelDto`.
2. Service maps DTO to `Hotel` entity.
3. Repository saves to MySQL.
4. Saved entity is mapped back to DTO.

### Get by id

1. Repository lookup by id.
2. If missing, throws `ResourceNotFoundException`.
3. Global exception handler returns `404` response body.

## Error handling

- `ResourceNotFoundException` is handled in `GlobalExceptionHandler`.
- Current not-found response:
  - `message`: `Resource Not Found`
  - `code`: `404`
  - `status`: `Not Found`

## Configuration notes

From `src/main/resources/application.yml`:

- Application name: `Hoteldetails`
- Port: `8082`
- MySQL URL: `jdbc:mysql://localhost:3306/hotelservice`
- JPA: `ddl-auto=update`, SQL logging enabled
- Config Server import: `configserver:http://localhost:8085`

## Dependencies

Main dependencies from `build.gradle`:

- Spring Web MVC
- Spring Data JPA
- MySQL Driver
- Eureka Client
- Spring Cloud Config Client
- MapStruct
- Lombok

## Run locally

Prerequisites:

- Java 21
- MySQL running
- Eureka Server running (`http://localhost:8761`)
- Config Server running (`http://localhost:8085`)

```powershell
cd E:\SpringbootProject\application\HotelDetails\Hoteldetails
.\gradlew clean build
.\gradlew bootRun
```

Service URL:

- `http://localhost:8082`

## Notes for developers

- Keep Eureka and Config Server up before starting this service.
- Service ID matching in Eureka should stay consistent with gateway/user-service usage.
- Update endpoint expects path id + JSON body.

