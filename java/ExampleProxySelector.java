
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Example implementation of a ProxySelector. ProxySelectors allow you to specify
 * how Java will connect to a remote host.
 *
 * @author WonderProxy
 **/
public class ExampleProxySelector extends ProxySelector
{
  /**
   * Cached list of proxies.
   **/
  protected ArrayList<Proxy> proxies;

  /**
   * Default constructor.
   **/
  public ExampleProxySelector( String hostname, int port )
  {
    proxies = new ArrayList<Proxy>();
    proxies.add( new Proxy( Proxy.Type.HTTP, new InetSocketAddress( hostname, port ) ) );
  }

  /**
   * This method allows you to adjust your list based on problems connecting to a proxy.
   **/
  public void connectFailed( URI uri, SocketAddress addr, IOException e ){}

  /**
   * This selector always returns the same list of proxies.
   **/
  public List<Proxy> select( URI uri )
  {
    return proxies;
  }
}
