
import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * Simple Authenticator implementation to handle passing authentication
 * to a proxy server.
 *
 * @author WonderProxy
 **/
public class ExampleAuthenticator extends Authenticator
{
  /**
   * Cached proxy authentication credentials.
   **/
  protected PasswordAuthentication proxyAuth;

  /**
   * Creates the cached credentials with a specified username and password. Those
   * values can be retrieved from anywhere.
   **/
  public ExampleAuthenticator( String username, String password )
  {
    proxyAuth = new PasswordAuthentication( username, password.toCharArray() );
  }

  /**
   * Returns the cached credentials. This is a basic implementation that only
   * verifies that the requestor is a proxy. A more complicated implementation
   * could check the URL and other parameters of the request to supply different
   * credenials.
   **/
  protected PasswordAuthentication getPasswordAuthentication()
  {
    if( getRequestorType() == RequestorType.PROXY )
    {
      return proxyAuth;
    }
    return null;
  }
}
