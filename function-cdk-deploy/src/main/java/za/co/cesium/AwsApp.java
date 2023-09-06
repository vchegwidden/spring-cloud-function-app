package za.co.cesium;

import software.amazon.awscdk.App;

public final class AwsApp {
    public static void main(final String[] args) {
        App app = new App();

        new AwsStack(app, "AwsStack");

        app.synth();
    }
}
