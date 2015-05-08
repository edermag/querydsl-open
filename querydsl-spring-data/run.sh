#!/bin/bash

if [ -z "$1" ]
  then
    echo "Build via maven ..."
    mvn clean package spring-boot:run
else
    if [ $1 = "gradle" ]
      then
        echo "Build via gradle ..."
        gradle bootRun
    else
        echo "Build via maven ..."
        mvn clean package spring-boot:run
    fi
fi

