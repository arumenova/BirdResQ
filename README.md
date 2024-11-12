# BirdResQ

## Description
BirdResQ is an animal rescue application that helps volunteers, admins, and users to report and manage injured birds. The platform allows users to create reports about injured birds, which admins can assign to volunteers for further action. Volunteers can update the bird's status, while admins have the capability to manage users, reports, and other administrative tasks.

## Class Diagram
![UML Class Diagram](images/Untitled%20Diagram.drawio.png)


## DEMO
![DEMO](https://www.loom.com/share/af110d0b03054726aa24c0dae9bf2cf6))

## Setup
Follow the steps below to set up and run the project on your local machine:

### Prerequisites
- **Java 17+**
- **Maven**
- **Spring Boot**
- **IntelliJ IDEA**

### Installation Steps
1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/birdresq.git
   ```

2. **Navigate to the project folder**:
   ```bash
   cd birdresq
   ```

3. **Import the project into IntelliJ IDEA**.

4. **Install dependencies**:
   ```bash
   mvn install
   ```

5. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

6. **Access the Application**:
   Open your browser and go to `http://localhost:8888`.

## Technologies Used
- **Java 17**
- **Spring Boot**
- **Spring Security**
- **Hibernate**
- **JPA**
- **Lombok**


## Controllers and Routes


1. AdminController
   Base Route: /api/admin

Description: Handles Admin account management, including creation and updates.

POST /create-account: Creates a new Admin account. Requires an AdminDto object in the request body. This endpoint is publicly accessible.
PUT /{email}: Updates an Admin account based on their email address. Requires an Admin object in the request body. Accessible only by admins.

2. BirdStatusInfoController
   Base Route: /api/bird-status-info

Description: Manages bird status updates, including the protection status of birds in reports.

PUT /{reportId}/bird-status: Updates the status of a bird associated with a specific report ID. Accepts birdStatus and volunteerId as request parameters. Accessible only by volunteers.
PUT /{reportId}/is-protected: Updates the protection status of a bird in a report. Requires isProtected as a request parameter. Accessible only by admins.

3. ReportController
   Base Route: /api/report

Description: Manages bird rescue reports, including creation, assignment of volunteers, status updates, and deletion.

POST /reports: Creates a new report. Accepts a ReportDto object in the request body. This endpoint is publicly accessible.
POST /{reportId}/assign-volunteer/{id}: Assigns a volunteer to a report based on report ID and volunteer ID. Accessible only by admins.
PUT /{reportId}/update: Updates the details of an existing report. Accepts a ReportDto object in the request body and is accessible by both volunteers and admins.
GET /{reportId}: Retrieves a report by its ID. Accessible by volunteers and admins.
GET /admin: Retrieves a list of all reports. Accessible only by admins.
PUT /{reportId}/status: Updates the status of a report. Accepts reportStatus and id as request parameters. Accessible only by admins.
DELETE /{reportId}: Deletes a report by its ID. Accessible only by admins

4. UserController
   Base Route: /api/user
Description: Handles User account management, allowing users to create an account.

POST /create: Creates a new user account. Accepts a User object in the request body. This endpoint is publicly accessible.

5. VolunteerController
   Base Route: /api/volunteer

Description: Manages Volunteer accounts, including account creation and updates.

POST /create-account: Creates a new Volunteer account. Requires a VolunteerDto object in the request body. This endpoint is publicly accessible.
PUT /{email}: Updates a Volunteer account based on their email. Requires a Volunteer object in the request body and is accessible only by volunteers.

## Extra Links

- [Presentation Slides](https://docs.google.com/presentation/d/13BNWjrI5KB-3kVDR10IB-TUA3vOOh3MdpgYAz39kGaI/edit#slide=id.g312d85cc63d_0_379)

## Future Work
- Add a Bird Tracking Feature.
- Implement Notifications.
- Apply Donation System.

## Resources
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Security Documentation](https://spring.io/projects/spring-security)

## Team Members
- **Adriana Yordanova** 

