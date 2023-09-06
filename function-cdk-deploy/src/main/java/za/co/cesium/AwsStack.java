package za.co.cesium;

import software.constructs.Construct;

import java.util.Arrays;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;
import software.amazon.awscdk.services.logs.RetentionDays;

public class AwsStack extends Stack {
    public AwsStack(final Construct parent, final String id) {
        this(parent, id, null);
    }

    public AwsStack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);

        Function.Builder.create(this, "HelloHandler")
            .runtime(Runtime.NODEJS_18_X)
            .code(Code.fromAsset("lambda"))
            .handler("hello.handler")
            .logRetention(RetentionDays.FIVE_YEARS)
            .build();

        Function.Builder.create(this, "FunctionApp")
            .runtime(Runtime.JAVA_17)
            .code(Code.fromAsset("../function-aws-lambda/target/aws-lambda-0.0.1-SNAPSHOT-aws.jar"))
            .handler("org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest")
            // .layers(Arrays.asList(layer))
            // .memorySize(1024)
            // .timeout(Duration.seconds(30))
            // .logRetention(RetentionDays.ONE_WEEK)
            .build();
    }
}
