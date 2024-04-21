# dugout-core
Core Backend Service for Dugout Application

# Steps to run locally
## Requirements
1. Java (version 17)
2. Maven
3. Postgres
4. Docker (optional)

## Environment variables
1. DB_USER=dugout_core
2. DB_PWD=DugOuT@123
3. POSTGRES_HOST=localhost
4. POSTGRES_PORT=5432

Setup these variables as per your local configurations


## Steps to setup postgres
1. (Optional for docker) Install docker image for postgres and run container with environment variables `POSTGRES_USER=dugout_core` `POSTGRES_PASSWORD=DugOuT@123`
2. Connect to postgres and create a database with name `dugout_core`


## Steps to run application
1. `mvn clean compile install`
2. `java -jar  target\dugoutcore-0.0.1-SNAPSHOT.jar`

## Using Script
After setting up postgres in your local environment run script `run.ps1` for Windows and `run.sh` for Linux and Mac users
