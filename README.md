# CSIS-3275-Project-Backend

Resume-relation tables:
1. users (id (PK), username, user_password)
2. personal_info (id (PK), first_name, last_name, phone, email, city, province, country, profession, summary, user_id (FK))
3. jobs (id (PK), title, employer, job_location, job_start_date, job_end_date, description, user_id (FK))
4. education (id (PK), institution, edu_location, degree, field, edu_start_date, edu_end_date, description, user_id (FK))
5. misc_info (id (PK), soft_skill, hard_skill, lang, certification, user_id (FK))

Tables required by Spring Security:
1. roles (id (PK), name)
2. user_roles (user_id (PK, FK), role_id (PK, FK))


Relationships:
1. users – personal_info: one to one
2. users – jobs: one to many
3. users – education: one to many
4. users – misc_info: one to one
5. users – user_roles: one to many
6. roles – user_roles: one to many


Auth URL:
1. http://localhost:8080/signup
2. http://localhost:8080/signin
3. http://localhost:8080/signout


API URL (To be implemented):
1. http://localhost:8080/api/**