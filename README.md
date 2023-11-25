# Shop-online

## I. Các n**guyên tắc, mô hình và thực tiễn phát triển phần mềm trong shop-online application:**

1. **Nguyên tắc SOLID:**
    - **S (Single Responsibility Principle):** Mỗi class nên chỉ có một lý do để thay đổi. Ví dụ: Các service và repository được thiết kế để thực hiện một nhiệm vụ cụ thể.
    - **O (Open/Closed Principle):** Mở rộng chức năng mà không làm thay đổi mã nguồn hiện tại. Sử dụng interfaces và kế thừa để hỗ trợ việc mở rộng.
    - **L (Liskov Substitution Principle):** Đối tượng của một lớp con có thể thay thế đối tượng của lớp cha mà không làm thay đổi tính đúng đắn của chương trình.
    - **I (Interface Segregation Principle):** Không nên bắt buộc một class phải triển khai các phương thức mà nó không sử dụng. Sử dụng nhiều interface nhỏ thay vì một interface lớn.
2. **Mô hình MVC (Model-View-Controller):**
    - **Model:** Đại diện cho dữ liệu và logic xử lý.
    - **View:** Hiển thị dữ liệu cho người dùng và nhận các sự kiện từ họ.
    - **Controller:** Xử lý các sự kiện từ view và cập nhật model.
3. **RESTful API:**
    - Sử dụng các phương thức HTTP (GET, POST, PUT, DELETE) để thực hiện các thao tác trên tài nguyên (Theo tác trên Postman).
    - Sử dụng định danh URI để truy cập và thao tác dữ liệu.
    - Truyền tải dữ liệu dưới dạng JSON.
4. **Spring Boot:**
    - Framework phổ biến cho phát triển ứng dụng Java dựa trên Spring Framework.
    - Cung cấp cơ sở hạ tầng để xây dựng các dịch vụ web RESTful, xử lý nghiệp vụ, quản lý tầng DAO, và quản lý trạng thái ứng dụng.
5. **Spring Security:**
    - Bảo vệ các phương thức và tài nguyên trên ứng dụng.
    - Xác thực và kiểm soát quyền truy cập của người dùng.
6. **Spring Data JPA:**
    - Giúp tương tác với cơ sở dữ liệu một cách dễ dàng thông qua các repository.
    - Tự động tạo ra các câu truy vấn dựa trên tên phương thức.
7. **JWT (JSON Web Token):**
    - Sử dụng để xác thực người dùng và truyền tải thông tin giữa các bên dưới dạng JSON.
    - Dùng để duy trì trạng thái người dùng trên các yêu cầu khác nhau.
8. **Docker và Docker Compose:**
    - Đóng gói ứng dụng và các thành phần của nó thành các container để dễ dàng triển khai và quản lý.
    - Sử dụng Docker Compose để quản lý nhiều container cùng một lúc.
9. **PostgreSQL:**
    - Hệ quản trị cơ sở dữ liệu quan hệ.
    - Sử dụng để lưu trữ dữ liệu của ứng dụng.
10. **Redis:**
    - Hệ thống lưu trữ dữ liệu in-memory.
    - Sử dụng để lưu trữ cache và thông tin phiên người dùng.
11. **JUnit và Mockito:**
    - Sử dụng để viết unit test và kiểm thử các thành phần của ứng dụng.
12. **Nguyên tắc YAGNI (You Aren't Gonna Need It):**
    - Chỉ triển khai những tính năng cần thiết hiện tại, tránh triển khai những tính năng mà có thể sẽ không bao giờ được sử dụng.
13. **Git:**
    - Quản lý mã nguồn và theo dõi thay đổi trong dự án.

## II. Cấu trúc mã

Cấu trúc mã nguồn của dự án shop-online theo mô hình Maven và Spring Boot có thể được mô tả như sau:

1. **Thư mục `src/main/java`:**
    - **`com.example.shoponline.config`:** Chứa các file cấu hình của ứng dụng, trong đó:
        - **`com.example.shoponline.config.filter`:** Chứa các filter của ứng dụng, trong đó có **`JWTFilter`** để xác thực người dùng.
        - **`com.example.shoponline.config.security`:** Các cấu hình bảo mật, bao gồm **`RedisConfig, SpringSecurityConfig`**
    - **`com.example.shoponline.controller`:** Các controller xử lý các request từ phía client.
    - **`com.example.shoponline.customenum`:** Định nghĩa các enum như **`Category`**, **`OrderStatus`**, **`PriceRange`**,...
    - **`com.example.shoponline.dto`:** Chứa các class DTO (Data Transfer Object) để truyền dữ liệu giữa các tầng.
    - **`com.example.shoponline.entity`:** Các class entity ánh xạ với cơ sở dữ liệu.
    - **`com.example.shoponline.exception`:** Xử lý các ngoại lệ trong ứng dụng.
    - **`com.example.shoponline.mapper`:** Các class mapper để chuyển đổi giữa entity và DTO.
    - **`com.example.shoponline.repository`:** Các interface JpaRepository để tương tác với cơ sở dữ liệu.
    - **`com.example.shoponline.service`:** Chứa interface và implementation của các dịch vụ/chức năng.
    - **`com.example.shoponline.util`:** Các tiện ích hỗ trợ, ví dụ: **`AuthUtil`**, **`OTPUtil`**, **`ProductFactory`**.
2. **Thư mục `src/main/resources`:**
    - **`application.properties`:** File cấu hình chung của ứng dụng, bao gồm cấu hình cơ sở dữ liệu, JWT, và các cài đặt khác..
3. **Thư mục `src/test/java`:**
    - **`com.example.shoponline.util`:** Chứa các test cho các class trong **`util`** package.
4. **Thư mục `target`:**
    - Chứa các file và thư mục được tạo ra khi build dự án.
5. **Thư mục gốc:**
    - **`pom.xml`:** File cấu hình Maven, chứa các dependency và cài đặt cần thiết cho dự án.
    - **`.gitignore`:** File định nghĩa các file và thư mục không nên được đẩy lên Git.
    - **`docker-compose.yml`:** File định nghĩa Docker Compose để triển khai các container.

## III. Các bước chạy ứng dụng:

1. **Clone dự án từ GitHub:**
    
    ```bash
    git clone https://github.com/your-username/shop-online.git
    ```
    
2. **Mở dự án trong IDE (Integrated Development Environment):**
    - Import dự án vào IDE của bạn (IntelliJ IDEA, Eclipse, hoặc bất kỳ IDE nào bạn ưa thích).
    - Chờ IDE tải các phụ thuộc và xây dựng dự án.
3. **Cấu hình Cơ sở dữ liệu:**
    - Mở file **`src/main/resources/application.properties`**.
    - Đảm bảo rằng thông tin cấu hình cơ sở dữ liệu như **`spring.datasource.url`**, **`spring.datasource.username`**, và **`spring.datasource.password`** đúng với cài đặt hiện tại của bạn.
4. **Chạy PostgreSQL bằng Docker Compose:**
    - Mở terminal và di chuyển vào thư mục chứa file **`docker-compose.yml` và `redis.yml`**.
    - Chạy lệnh:
        
        ```bash
        docker-compose up -d
        redis up -d
        ```
        
    - Hoặc chạy trên IDE:
        
        ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f74af19a-f980-4dc9-a4dc-3d7fa7884490/e0b3223d-0ab0-4fb2-84cf-5234993ce8f6/Untitled.png)
        
5. **Chạy Ứng dụng:**
    - Chạy ứng dụng từ IDE
        
        ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f74af19a-f980-4dc9-a4dc-3d7fa7884490/31c9e705-0a60-4155-9c47-b7f92d930d1b/Untitled.png)
        
    - Hoặc sử dụng Maven wrapper:hoặc (đối với Windows)
        
        ```bash
        ./mvnw spring-boot:run
        ```
        
        ```bash
        mvnw spring-boot:run
        ```
        
6. **Kiểm tra Ứng dụng:**
    - Mở trình duyệt web và truy cập địa chỉ: **`http://localhost:8080`**.
7. **Kiểm tra các Endpoint:**
    - Sử dụng các công cụ như Postman hoặc cURL để thử nghiệm các endpoint như **`GET /product`**, **`POST /order`**, và các endpoint khác.

Lưu ý: Đảm bảo rằng Java Development Kit (JDK) đã được cài đặt trên máy tính.

## Ảnh chụp màn hình Postman

### 1 - Sign Up

![1-signup.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/f74af19a-f980-4dc9-a4dc-3d7fa7884490/d904bcb9-e3e2-45a6-bf33-cef845d459f5/1-signup.png)

### 2 - Login

![2-login.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/f74af19a-f980-4dc9-a4dc-3d7fa7884490/26ccc119-6747-471d-8eba-c5df24f68a7d/2-login.png)

### 3 - Post Product

Post Laptop category:

![3-PostProduct.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/f74af19a-f980-4dc9-a4dc-3d7fa7884490/f53b8578-00b0-43de-88d3-1be416c36c81/3-PostProduct.png)

Post Mobile category:

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f74af19a-f980-4dc9-a4dc-3d7fa7884490/99605e77-33fd-4d06-b810-ec22d483ba2b/Untitled.png)

### 4 - Get products

- by Category:
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f74af19a-f980-4dc9-a4dc-3d7fa7884490/222c0584-d5c0-4b3c-98f6-925fca669719/Untitled.png)
    
- by Price (LOW, MEDIUM, HIGH, …)
    
    ![5-filterByPrice.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/f74af19a-f980-4dc9-a4dc-3d7fa7884490/d80e72e7-54d9-4aac-a493-8868bd49c5d1/5-filterByPrice.png)
    

- by Name:
    
    ![6-getByName.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/f74af19a-f980-4dc9-a4dc-3d7fa7884490/be01f4f1-aee1-404f-b711-d5bc3a355655/6-getByName.png)
    
- by brand:
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f74af19a-f980-4dc9-a4dc-3d7fa7884490/36ab21d3-ad06-4156-ad13-4427747bd907/Untitled.png)
    

### 5- Post products to Cart:

![7-posttoCart.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/f74af19a-f980-4dc9-a4dc-3d7fa7884490/7a83e054-e244-4c93-9eb9-4bbcd318b5c4/7-posttoCart.png)

### 6 - Get all products in Cart:

![8-getCart.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/f74af19a-f980-4dc9-a4dc-3d7fa7884490/740b1f9b-d3b8-4d53-a7b9-48802cbbd7cd/8-getCart.png)

- Remove an product:
    
    ![9-removeFromCart.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/f74af19a-f980-4dc9-a4dc-3d7fa7884490/f0c525d9-7d58-4d25-b54a-dfc48febcc98/9-removeFromCart.png)
    

### 7 - Check out order

![10-checkoutorder.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/f74af19a-f980-4dc9-a4dc-3d7fa7884490/041db5b1-53a6-4df0-9dc3-e3cc915d96b0/10-checkoutorder.png)

Cảm ơn vì đã xem, chúc thầy cô một ngày tốt lành!
