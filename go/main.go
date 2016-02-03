package main

import (
	"flag"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"net/url"
)

func main() {
	var (
		server = flag.String("proxy-server", "", "Proxy server hostname and port")
		user   = flag.String("proxy-user", "", "Username for proxy authentication")
		pass   = flag.String("proxy-pass", "", "Password for proxy authentication")
	)
	flag.Parse()

	target := flag.Arg(0)
	if target == "" {
		target = "http://ip4.me"
	}

	// create a client that uses the proxy and make requests with the client
	client := &http.Client{Transport: ProxiedTransport(*server, *user, *pass)}
	resp, err := client.Get(target)
	if err != nil {
		log.Fatal(err)
	}
	printResponse(resp)

	// set a global proxy and make requests with the default client
	http.DefaultTransport = ProxiedTransport(*server, *user, *pass)
	resp, err = http.Get(target)
	if err != nil {
		log.Fatal(err)
	}
	printResponse(resp)

}

// ProxiedTransport creates an HTTP client transport that will proxy requests
// through the server requested, with user and pass for authentication
func ProxiedTransport(server string, user string, pass string) *http.Transport {
	return &http.Transport{
		Proxy: http.ProxyURL(&url.URL{
			Scheme: "http",
			User:   url.UserPassword(user, pass),
			Host:   server,
		})}

}

func printResponse(resp *http.Response) error {
	defer resp.Body.Close()

	bytes, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		return err
	}

	fmt.Print(string(bytes))

	return nil
}
