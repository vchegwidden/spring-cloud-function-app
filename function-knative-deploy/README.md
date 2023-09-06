# To Start
1. `mk start --profile knative`
2. `mk tunnel --profile knative`

# To Deploy

1. Build the `function-app-web` project as a native image using `mvn spring-boot:build-image -P native`
2. Run native app to verify it works `docker run --rm -p 8080:8080 function-app-web:0.0.1-SNAPSHOT`
3. Tag image with `dev.local` prefix so KNative doesn't try to resolve digest from dockerhub `docker tag function-app-web:0.0.1-SNAPSHOT dev.local/function-app-web:0.0.1-SNAPSHOT`
3. Load image built into minikube `mk --profile knative image load dev.local/function-app-web:0.0.1-SNAPSHOT`
4. Apply the `service.yaml` file using `kubectl apply -f service.yaml` OR run `kn service create function-app-web --image=dev.local/function-app-web:0.0.1-SNAPSHOT`

# To Stop
`mk stop --profile knative`