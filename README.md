
# SpringBook v2
![banner](https://github.com/OseiasYC/SpringBook/blob/main/banner.png)

Springboot project for managing and booking labs.
The main objective is to organize the reservation of laboratories at the university.
Teachers will be able to book a lab when it becomes available at the chosen time.

### Technologies and dependencies (A-Z):
* Bootstrap
* Flatpickr
* Java 17
* JavaScript (jQuery)
* Log4j2
* PostgreSQL
* Spring Boot 3.0.4
* Spring Boot DevTools
* Spring Boot Starter Data JPA
* Spring Boot Starter Security
* Spring Boot Starter Test
* Spring Boot Starter Thymeleaf
* Spring Boot Starter Web
* Spring Security Test

### Bussiness rules:
1. Labs with status false (unavailable) in the database are not displayed on front-end

2. The disciplines of each professor are redeemed in the bank to be displayed

3. The user cannot select past dates and times even if time passes and there is a past time on the input

4. If the current time equals the end time of a cell, it is deleted

5. User will not be able to make reservations if JS is disabled

6. A log file is generated with approval history, approvals and disapprovals

7. User can't book busy labs

8. It has two roles: admin and user. Admins and users can book labs, but only admin can manage bookings

### About:
[SpringBook v3 - The microservice version](https://github.com/OseiasYC/SpringBook-v3)
[Document C4 and Class diagram (PT-BR)](https://drive.google.com/file/d/1q-UWTaZNDym0gYJlheUn81lNEdjaPh-z/view?usp=share_link)

---
 _Build with ❤️ - [MIT](https://github.com/OseiasYC/SpringBook/blob/main/LICENSE)._
