## sapient-bookmyshow-casestudy
Bookmyshow kind of Movie Booking Platform Case Study Low Level Design Implementation using Spring Boot Framework

## POC on Low Level Design for Bookmyshow Projects Implementation

# Motive of this Project

   - Motive of this project POC is to explore on spring boot features.
   - Use of spring data JPA (Hibernate) with MYSQL.
   - Create a standarized project folder structure like Controller/DTO/Models/Services/Repository.
   - Create REST API's End points for CREATE/UPDATE/GET methods.
   - Use various design patterns like Builder/Strategy 

## API Implementations

   1. Create/Get Customer REST API End point.
   2. Create/Get City REST API End point.
   3. Create/Get Movie REST API End point.
   4. Create/Get Hall REST API End point.
   5. Create/Get Show REST API End point.
   6. Create/Get Theatre REST API End point.
   7. Create/Get Booking REST API End point.

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
    "name": "Madurai"
}


### Get City

HTTP Method : GET

http://localhost:8080/api/v1/city/{id}

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

## Show API

### Create Show

HTTP Method : POST

http://localhost:8080/api/v1/show

Sample JSON Body

{
    "hallId": 41,
    "movieId": 1,
    "startTime": "2024-01-20T08:14:00",
    "duration": 1
}


### Get Show

HTTP Method : GET

http://localhost:8080/api/v1/show/{id}

## Theatre API

### Create Theatre

HTTP Method : POST

http://localhost:8080/api/v1/theatre

Sample JSON Body

{
    "cityid": 1,
    "name": "Theatre-A",
    "address": "Theatre-A Address",
    "halls": [35,36],
    "shows": [10,11]
}


### Get Theatre

HTTP Method : GET

http://localhost:8080/api/v1/theatre/{id}

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

2. Create MYSQL Database "bookmyshow".

3. Create MYSQL user "bms_api_users" with password "testpass" which is specified in application.properties file.

4. Start the Spring boot Application.

5. Use Postman app for executing the REST API's and testing.

