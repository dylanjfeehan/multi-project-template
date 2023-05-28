#!/bin/bash

# exit when any command fails
set -e

curl -L -O https://github.com/stedolan/jq/releases/download/jq-1.6/jq-linux64
mv jq-linux64 jq
chmod +x jq

ENDPOINT=/actuator/health

printf "Checking $BASE_APP_URL$ENDPOINT"
echo
http_status_code=$(curl --write-out '%{http_code}' --head --silent --output /dev/null $BASE_APP_URL$ENDPOINT)
if ! [[ $http_status_code == "200" ]]; then
    echo "$BASE_APP_URL$ENDPOINT returned status code $http_status_code"
    exit 1
fi

response=$(curl $BASE_APP_URL$ENDPOINT)

status=$(echo $response | ./jq '.status')

if ! [[ $status == "\"UP\"" ]]; then
    exit 1
    echo $response
fi