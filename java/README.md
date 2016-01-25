Using a Proxy in Java
=============
There are two ways to use a proxy in Java: System Properties and a ProxySelector.

System Properties
=============
System Properties provide a quick and easy way to start using a proxy as long as
you don't need to provide a username and password. Full details can be found in
the [Networking Properties](http://docs.oracle.com/javase/7/docs/api/java/net/doc-files/net-properties.html) of the Java API documentation.

Java supports setting proxy information for 3 protocols: FTP, HTTP, and HTTPS.
There are 3 basic properties that can be set for each protocol: proxyHost,
proxyPort, and nonProxyHosts. Despite what many websites say, there are no
proxyUsername and proxyPassword properties. HTTPS does not have its own nonProxyHosts
setting and will use the nonProxyHosts setting from HTTP.

Here are some example properties:

* http.proxyHost=boston.wonderproxy.com
* http.proxyPort=10000
* https.proxyHost=boston.wonderproxy.com
* https.proxyPort=10000
* ftp.proxyHost=boston.wonderproxy.com
* ftp.proxyPort=10000

These properties can either be specified at the command line when launching Java,
or within a running VM by using the System object. It's important to note that
these settings are for the entire VM. They will apply to every connection that is
made.

    java -Dhttp.proxyHost=boston.wonderproxy.com -Dhttp.proxyPort=10000 (other arguments)

    System.setProperty( "http.proxyHost", "boston.wonderproxy.com" );
    System.setProperty( "http.proxyPort", "10000" );

To add username/password support you'll need to use an Authenticator, see
the ExampleAuthenticator.

ProxySelector
=============
Starting with Java 5 you have a bit more control over proxy usage within a VM
with the creation of the ProxySelector and related classes. See the
ExampleProxySelector and ExampleAuthenticator for examples of how to use that
functionality.
