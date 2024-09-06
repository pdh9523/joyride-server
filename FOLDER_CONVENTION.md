아래 로직에서 Repository, Service, Dto, Entity는 따로 폴더 빼서 만들어주셔도 좋습니다.

```
project/
├── src/
│   ├── config/
│   │   ├── security/
│   │   │   ├── jwtConfiguration.java
│   │   │   └── securityConfiguration.java
│   │   ├── WebConfiguration.java       # Web configuration
│   │   └── SwaggerConfiguration.java   # Swagger configuration
│   ├── domain/
│   │   ├── user/
│   │   │   ├── entity/
│   │   │   │   └── User.java            # User Entity
│   │   │   ├── dto/
│   │   │   │   └── UserDto.java         # User DTO
│   │   │   ├── repository/
│   │   │   │   └── UserRepository.java  # User Repository Interface
│   │   │   ├── service/
│   │   │   │   ├── UserService.java     # User Service Interface
│   │   │   │   └── UserServiceImpl.java # User Service Implementation
│   │   ├── product/
│   │   │   ├── entity/
│   │   │   │   └── Product.java         # Product Entity
│   │   │   ├── dto/
│   │   │   │   └── ProductDto.java      # Product DTO
│   │   │   ├── repository/
│   │   │   │   └── ProductRepository.java # Product Repository Interface
│   │   │   ├── service/
│   │   │   │   ├── ProductService.java  # Product Service Interface
│   │   │   │   └── ProductServiceImpl.java # Product Service Implementation
│   │   ├── order/
│   │   │   ├── entity/
│   │   │   │   └── Order.java           # Order Entity
│   │   │   ├── dto/
│   │   │   │   └── OrderDto.java        # Order DTO
│   │   │   ├── repository/
│   │   │   │   └── OrderRepository.java # Order Repository Interface
│   │   │   ├── service/
│   │   │   │   ├── OrderService.java    # Order Service Interface
│   │   │   │   └── OrderServiceImpl.java # Order Service Implementation
│   └── interfaces/
│       ├── controller/
│       │   ├── UserController.java      # Controller for User
│       │   ├── ProductController.java   # Controller for Product
│       │   └── OrderController.java     # Controller for Order
│       └── api/
│       │   ├── UserApi.java             # API for User
│       │   ├── ProductApi.java          # API for Product
│       │   └── OrderApi.java            # API for Order
│       └── advice/
│           └── AdviceController.java    # Controller Advice
├── test/
└── docs/
```
