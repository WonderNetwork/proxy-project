require "net/http"
require "uri"

uri = URI.parse("http://freegeoip.net/json/")

proxy_addr = 'london.wonderproxy.com'
proxy_port = 10000
proxy_user = ''
proxy_pass = ''

http = Net::HTTP.new(uri.host, uri.port, proxy_addr, proxy_port, proxy_user, proxy_pass)
response = http.request(Net::HTTP::Get.new(uri.request_uri))

puts response.body
