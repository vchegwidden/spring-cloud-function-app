# spring-cloud-function-app
This project shows how to deploy spring-cloud-functions using multiple deployment strategies

## function-app-business
Contains the actual business logic and functions that wrap them

## function-app-stream
Deploys thwe function and connects to rabbitMQ using `spring-cloud-stream-binder-rabbit`

Run as a simple spring boot app. To run you need to start RabbitMQ using the `docker-compose.yaml` file first

## function-app-web
Deploys the functions as REST endpoints using `spring-cloud-function-web`

Run as a simple spring boot app.

To compile as a native app using GraalVM see `function-knative-deploy/README.md`

## function-app-lambda
Deploys the function as a lambda. There is a module `function-cdk-deploy` that will use the CDK to deploy the jar using the AWS CLI

## function-cdk-deploy
Deploys `function-app-lambda` as a lambda using CDK

## function-knative-deploy
Deploys as a KNative function. See `function-knative-deploy/README.md` for details