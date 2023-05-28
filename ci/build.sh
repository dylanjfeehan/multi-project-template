#!/bin/bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
BUILD_OUTPUT=$DIR/../../build-output

cd git/

cp ./kafka/manifest.yml $BUILD_OUTPUT

if ./gradlew clean build; then
  echo "Gradle task succeeded" >&2
else
  echo "Gradle task failed" >&2
  exit 1
fi

cp ./kafka/build/libs/kafka-*-boot.jar $BUILD_OUTPUT/webapp.jar
