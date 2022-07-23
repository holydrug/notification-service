# notification-service

## Table of content ##
- [Overview](#Overview)
- [Logic](#Logic)
    - [Person service](#Person-service)
    - [Mail service](#Mail-service)
    - [Distribution service](#Distribution-service)
- [Rest controllers](#Rest-controllers)
    - [People Controller](#People-Controller)
    - [Distribution Controller](#Distribution-Controller)
- [Modules](#Modules)
    - [Notification service sender module](#Notification-service-sender-module)
- [Additional abilities](#Additional-abilities)
    - [Logs](#Logs)
    - [Error Handling](#Error-Handling)
- [Miscellaneous](#Miscellaneous)
    - [Properties](#Properties)
    - [Mappers](#Mappers)
- [Docker](#Docker)
    - [Before building](#Before-building)
    - [Building](#Building)
- [Overview of docker compose services](#Overview-of-docker-compose-services)

## Overview ##

- Main purpose of project is manipulate with persons in mysql db
- Three primary service helps to achieve that
1. Person service
2. Mail service
3. Distribution service

## Logic ##

### Person service ###

>Default service class which can get data from person repository (Person entity storage)

    Main process of service works with dto's and in the end converts it to entity with mapstruct

    all methods declared in PersonService interface

#### Person entity ####
    All fields of that class are common except PhoneNumber 
    
    That object has Phone annotation which will validate class with proper fields
    Also with correct number program can find out carrier code
    (926 number will be discribed in RU region as MEGAFON)

### Mail service ###

>Service class which purpose is to send specific dto to queue

    Sending mail works with rabbitmq broker which sent message to queue
    After that mail will be saved in own repository

    all methods declared in MailService interface

### Distribution service ###

>Service class what main purpose is link person repository with sending service

    That function is achieved by mapping Person's email to MailDto
    Next step for MailDto is fill MailSenderService to send mail with proper fields

## Rest controllers ##

    There are two controller:
    PeopleController (is mapped to person-management/persons/)
 
    DistributionController (is mapped to dist/)

### People Controller ###

>GET request available:
- with nothing (to receive all persons)
- with id in path (to receive specific person with that id)

>POST request available:
- with nothing (to save person with proper @RequestBody PersonDto)



>PATCH request available:
- with id in path (to update user fields)



>DELETE request available:
- with id in path (to delete user)

### Distribution Controller ###

>POST request available:
- with nothing (to send mail to all Person from repository with @RequestBody MailDto mailDto)
- with carrier code as param (to send mails filtered to specific Operator with params = "carrierCode")

## Modules ##
### Notification service sender module ###

    That module connects to rabbitmq and consumes all messages from queue
    
    Message is converted with object mapper to understandable Mail local class
    Next step for Mail class will be sending it to MailSenderService to successful mailing
## Additional abilities ##

### Logs ###

> Project is covered with additional log layer

    Logs are configured with logback.xml in resources dir
    I configured 3 appender:

    "CONSOLE"               (filtered to INFO level to display in console)
    "STASH"                 (filtered to DEBUG level and save logs to logback/ used for docker)
    "FILE-ROLLING"          (filtered to DEBUG lever and save logs to logs/ used for yourself)

### Error Handling ###

> Project has NotificationServiceException which is main to extend other exceptions
>
> Main functionality is achieved by ApiError what convert all data in one pretty class automatically

    All available handlings you can find in GlobalExceptionHandler class

## Miscellaneous ##

### Properties ###

    Project has application.yml which replace application.properties
    Additional profile is application-dev.yml which discribes rabbitmq connect for MailService success connecnt

### Mappers ###

    Project uses Mapstruct to fast convert entities to dtos with specific qualifires
    That functional can be found in utils package

## Docker ##


### Before building ###
    Whole project is based on docker
    To successful run you need to invoke mysql database and rabbitmq images at least

> I configured docker-compose to run project without any issues with my configs
>
> If you wish, you can configure it in docker/docker-compose.yml
>
> Such as environments for rabbitmq or etc can be found and set also there

### Building ###

> To build local services execute command below from root project dir:

    cd docker/ &&
    docker-compose build notification-service notification-service-sender

# YOU NEED ENABLE VPN FROM RUSSIA TO DOWNLOAD ELK AND SKIP 403 ERROR #
> To run services execute command below

    docker-compose up -d
## Overview of docker compose services  ##

### notification-service ###
    Creates executable jar from Dockerfile
    Links docker logback/ dir with local logback/
    Depends on: mysql, notification-service-sender, rabbitmq
### notification-service-sender ###
    Creates executable jar from Dockerfile
    Depends on: rabbitmq 
### rabbitmq ###
    Invoke rabbitmq
    Also in docker/rabbitmq there are configurations with default session to handle any messages
    data also linked to local docker/rabbitmq/data/ dir
### mysql ###
    Invoke mysql
    Creates on start "notifications" empty database 
    data is also will be linked to local docker/mysql/data dir
### setup ELK ###
    Invoke setup of ELK
### elasticsearch ###
    To reduce memmory trouble I set ES_JAVA_OPTS: -Xms512m -Xmx512m 
    docker/elasticsearch/config/elasticsearch.yml is linked to docker container
### logstash ###
    To reduce memmory trouble I set LS_JAVA_OPTS: -Xms256m -Xmx256m
    docker/logstash/config/logstash.yml is linked to docker container
    docker/logstash/pipeline is linked to docker container
    Also I parse local logback to see logs in kibana
### kibana ###
    docker/kibana/config/kibana.yml is linked to docker container 

## Kubernetes ##

>You can check my yaml files in single node cluster Minikube

### Installing minikube on ARCH linux ###

    sudo pacman -S minikube kubectl

### Getting started minikube on ARCH linux ###

    minikube start && minikube dashboard

### Applying yaml files to minikube ###
  
> Locate terminal to kubernetes folder

1. You need create persistent volume to be able to manipulate with storage
   
    
    kubectl apply -f persistentvolume/persistentvolume.yaml

2. After that you should create persistent volume claim to get piece of that storage


    kubectl apply -f persistentvolume/persistentvolumeclaim.yaml   

3. Now you should configure rabbitmq config files with config-map


    kubectl apply -f configmaps/rabbitmq/rabbitmq-configmap.yaml   

4. After successful previous steps you can start rabbitmq


    kubectl apply -f controllers/rabbitmq/rabbitmq-deployment-with-pv.yaml  

5. Invoke mysql


    kubectl apply -f controllers/mysql/mysql-deployment.yaml 

6. Invoke base notification-service


    kubectl apply -f controllers/notification-service/notification-service-deployment.yaml

7. Invoke notification-service-sender


    kubectl apply -f controllers/notification-sender-service/notification-sender-service-deployment.yaml