package za.co.cesium;

import software.amazon.awscdk.App;
import software.amazon.awscdk.assertions.Template;
import software.amazon.awscdk.assertions.Match;
import java.io.IOException;

import java.util.HashMap;
import java.util.logging.Handler;

import org.junit.jupiter.api.Test;

public class AwsStackTest {

    @Test
    public void testStack() throws IOException {
        App app = new App();
        AwsStack stack = new AwsStack(app, "test");

        Template template = Template.fromStack(stack);

        // template.hasResourceProperties("AWS::SQS::Queue", new HashMap<String, Number>() {{
        //   put("VisibilityTimeout", 300);
        // }});

        // template.resourceCountIs("AWS::SNS::Topic", 1);

        template.hasResourceProperties("AWS::Lambda::Function", new HashMap<String, String>(){{
          put("Handler", "hello.handler");
        }});
    }
}
