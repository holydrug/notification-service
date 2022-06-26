# notification-service

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

>Service class which can send mail to any email adress

    Sending mail works with rabbitmq broker which sent message to queue
    After that mail will be saved in own repository

    all methods declared in MailService interface

### Distribution service ###

>Service class what main purpose is link person repository with sending service

    That function is achieved by mapping Person's email to MailDto
    Next step for MailDto is fill MailSenderService to send mail with proper fields

## Rest controllers ##

> There are two controller:
> > PeopleController (is mapped to person-management/persons/)
> 
> > DistributionController (is mapped to dist/)

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
    

    