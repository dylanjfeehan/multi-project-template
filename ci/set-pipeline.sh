#!/bin/bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"

echo "Executing script from $DIR"

# Set app name variable here and uncomment this line
APP_NAME=postgres-product-info-sink

fly -t pricing set-pipeline \
    --pipeline $APP_NAME \
    --config $DIR/pipeline.yml \
    --var "app_name=$APP_NAME" \
