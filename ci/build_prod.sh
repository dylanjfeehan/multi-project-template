#!/bin/bash

cd git/

cp ./kafka/manifest.yml ../build-output/manifest.yml

if ./gradlew bootJar --info; then
  echo "Gradle task succeeded" >&1
else
  echo "Gradle task failed" >&2
  exit 1
fi

cp ./kafka/build/libs/kafka-*-boot.jar ../build-output/webapp.jar