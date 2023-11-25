# README.md

# Shop-online

## Các n**guyên tắc, mô hình và thực tiễn phát triển phần mềm trong shop-online application:**

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
    

## Cấu trúc mã

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
