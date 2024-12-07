package stepik;

public enum TestConfig {

    BaseURI("baseUri"),
    BasePath("basePath");

    public final String value;

    TestConfig(String value) {
        this.value = Configuration.getConfiguration().getProperty(value);
    }
}