
import java.net.Authenticator;
import java.net.ProxySelector;
import java.net.URL;
import java.net.URLConnection;

/**
 * Basic example showing the installation and usage of the authenticator and selector.
 *
 * @author WonderProxy
 **/
public class Example
{
  public static void main( String[] args )
  {
    // Set the Authenticator and ProxySelector
    Authenticator.setDefault( new ExampleAuthenticator( "username", "password" ) );
    ProxySelector.setDefault( new ExampleProxySelector( "boston.wonderproxy.com", 10000 ) );

    // Make requests to remote sites
    try
    {
      URL url = new URL( "http://www.example.com" );
      URLConnection conn = url.openConnection();

      // Work with the connection ...
    }
    catch( Exception e )
    {
      // Your standard error handling ...
    }
  }
}
