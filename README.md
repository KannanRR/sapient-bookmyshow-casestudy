## sapient-bookmyshow-casestudy
Bookmyshow kind of Movie Booking Platform Case Study Low Level Design Implementation using Spring Boot Framework

## POC on Low Level Design for Bookmyshow Projects Implementation

# Motive of this Project

   - Motive of this project POC is to explore on spring boot features.
   - Use of spring data JPA (Hibernate) with MYSQL.
   - Create a standarized project folder structure like Controller/DTO/Models/Services/Repository.
   - Create REST API's End points for CREATE/UPDATE/GET/DELETE methods.
   - Use various design patterns like Builder/Strategy 

## API Implementations

   1. CREATE/GET Customer REST API End point.
   2. CREATE/GET/UPDATE/DELETE City REST API End point.
   3. CREATE/GET/UPDATE/DELETE Movie REST API End point.
   4. CREATE/GET/UPDATE/DELETE Hall REST API End point.
   5. CREATE/GET/UPDATE/DELETE Show REST API End point.
   6. CREATE/GET/UPDATE/DELETE Theatre REST API End point.
   7. CREATE Booking REST API End point.

## API's Endpoints and Request JSON Formats

## Customer API

### Create Customer

HTTP Method : POST

http://localhost:8080/api/v1/customer

Sample JSON Body

{
    "fullName": "Kannan RR",
    "city": "mADURAI",
    "phoneNumber": "244343",
    "email": "kannan@gmail.com",
    "username": "kannan",
    "password": "kannan"
}

### Get Customer

HTTP Method : GET

http://localhost:8080/api/v1/customer/{id}

## City API

### Create City

HTTP Method : POST

http://localhost:8080/api/v1/city

Sample JSON Body

{
    "name": "Bangalore"
}

### Get City

HTTP Method : GET

http://localhost:8080/api/v1/city/{id}
Eg : http://localhost:8080/api/v1/city/1

### Update City

HTTP Method : PUT

http://localhost:8080/api/v1/city/{id}

Eg : http://localhost:8080/api/v1/city/1


Sample JSON Body

{
"name": "Bengaluru"
}

### Delete City

HTTP Method : DELETE

http://localhost:8080/api/v1/city/{id}
Eg : http://localhost:8080/api/v1/city/1

### Get all City

HTTP Method : GET

http://localhost:8080/api/v1/city/all

### Search City

HTTP Method : GET

http://localhost:8080/api/v1/city/search/{city}
Eg : http://localhost:8080/api/v1/city/search/b

## Movie API

### Create Movie

HTTP Method : POST

http://localhost:8080/api/v1/movie

Sample JSON Body

{
    "name": "Beast",
    "rating": "2.3"
}

### Get Movie

HTTP Method : GET

http://localhost:8080/api/v1/movie/{id}
Eg : http://localhost:8080/api/v1/movie/1

### Update Movie

HTTP Method : PUT

http://localhost:8080/api/v1/movie/{id}
Eg : http://localhost:8080/api/v1/movie/1

{
"name": "Beast",
"rating": "2.3"
}

### Delete Movie

HTTP Method : DELETE

http://localhost:8080/api/v1/movie/{id}
Eg : http://localhost:8080/api/v1/movie/1

## Hall API

### Create Hall

HTTP Method : POST

http://localhost:8080/api/v1/hall

Sample JSON Body

{
    "name": "Hall-NEW",
    "features": [
        "DOLBY_DIGITAL",
        "TWO_D"
    ],
    "seatRanges": {
        "PLATINUM": [
            {
                "rowNo": 0,
                "columnNo": 1
            },
            {
                "rowNo": 0,
                "columnNo": 2
            }
        ],
        "SILVER": [
            {
                "rowNo": 1,
                "columnNo": 1
            },
            {
                "rowNo": 1,
                "columnNo": 2
            }
        ]
    }
}


### Get Hall

HTTP Method : GET

http://localhost:8080/api/v1/hall/{id}
Eg : http://localhost:8080/api/v1/hall/1

### Update Hall

HTTP Method : PUT

http://localhost:8080/api/v1/hall/1

Sample JSON Body

{
  "name": "Hall-NEW-V2",
  "features": [
     "DOLBY_DIGITAL",
     "TWO_D"
  ],
  "seatRanges": {
  "PLATINUM": [
    {
      "rowNo": 0,
      "columnNo": 1
    },
    {
      "rowNo": 0,
      "columnNo": 2
    }
  ],
  "SILVER": [
    {
      "rowNo": 1,
      "columnNo": 1
    },
    {
      "rowNo": 1,
      "columnNo": 2
    }
  ]
 }
}

### Delete hALL

HTTP Method : DELETE

http://localhost:8080/api/v1/hall/{id}
Eg : http://localhost:8080/api/v1/hall/1

## Show API

### Create Show

HTTP Method : POST

http://localhost:8080/api/v1/show

Sample JSON Body

{
    "hallId": 1,
    "movieId": 1,
    "startTime": "2024-01-20T08:14:00",
    "duration": 1
}

### Update Show

HTTP Method : PUT

http://localhost:8080/api/v1/show/{1}
Eg : http://localhost:8080/api/v1/show/1

Sample JSON Body

{
"hallId": 1,
"movieId": 1,
"startTime": "2024-01-20T08:14:00",
"duration": 2
}

### Get Show

HTTP Method : GET

http://localhost:8080/api/v1/show/{id}
Eg : http://localhost:8080/api/v1/show/1

### Delete Show

HTTP Method : DELETE

http://localhost:8080/api/v1/show/{id}
Eg : http://localhost:8080/api/v1/show/1

## Theatre API

### Create Theatre

HTTP Method : POST

http://localhost:8080/api/v1/theatre

Sample JSON Body

{
    "cityid": 1,
    "name": "Theatre-A",
    "address": "Theatre-A Address",
    "halls": [2],
    "shows": [2]
}

### Update Theatre

HTTP Method : PUT

http://localhost:8080/api/v1/theatre/{id}
Eg : http://localhost:8080/api/v1/theatre/1

Sample JSON Body

{
"cityid": 1,
"name": "Theatre-A",
"address": "Theatre-A Address",
"halls": [3],
"shows": [3]
}

### Get Theatre

HTTP Method : GET

http://localhost:8080/api/v1/theatre/{id}
Eg : http://localhost:8080/api/v1/theatre/1

### Delete Theatre

HTTP Method : DELETE

http://localhost:8080/api/v1/theatre/{id}
Eg : http://localhost:8080/api/v1/theatre/1

## Booking API

### Create Booking

HTTP Method : POST

http://localhost:8080/api/v1/booking

Sample JSON Body

{
    "customerId": 1,
    "showId": 21,
    "showSeatsId": [35,36]
}

## How to Run this Project Locally

1. Import this Bookmyshow project Folder in to Intellij.

2. Create MYSQL Database "sapientbookmyshowv1".
   CREATE DATABASE sapientbookmyshowv1;

3. Create MYSQL user "bms_api_user_v1" with password "testpass" which is specified in application.properties file.
   CREATE USER 'bms_api_users_v1'@'localhost' IDENTIFIED BY 'testpass';
   GRANT CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT, REFERENCES, RELOAD on *.* TO 'bms_api_user_v1'@'localhost' WITH GRANT OPTION;

4. Start the Spring boot Application.

5. Use Postman app for executing the REST API's and testing.

