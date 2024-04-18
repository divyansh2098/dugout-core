#!/bin/bash

$POSTGRES_HOST='localhost'
$POSTGRES_PORT='5432'
$DB_USER='dugout_core'
$DB_PWD='DugOut@123'

mvn clean compile install
java -jar ./target/dugoutcore-0.0.1-SNAPSHOT.jar
