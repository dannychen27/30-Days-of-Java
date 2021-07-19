package SoftwareTesting.TestDrivenDevelopment.Stubs;

public interface EmailServer {

    void send(String template, String distributionList, String[] parameters);
}
