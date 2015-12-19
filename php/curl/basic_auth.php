<?php

$proxy = [
	'username' => '',
	'password' => '',
	'server' => 'london.wonderproxy.com',
	'port' => 10000
];

$ch = curl_init();

// set URL and other appropriate options
curl_setopt($ch, CURLOPT_URL, "http://freegeoip.net/json/");
curl_setopt($ch, CURLOPT_HEADER, false);
curl_setopt($ch, CURLOPT_HTTPPROXYTUNNEL, true);
curl_setopt($ch, CURLOPT_PROXYAUTH, CURLAUTH_BASIC);
curl_setopt($ch, CURLOPT_PROXYPORT, $proxy['port']);
curl_setopt($ch, CURLOPT_PROXY, 'london.wonderproxy.com');
curl_setopt($ch, CURLOPT_PROXYUSERPWD, "{$proxy['username']}:{$proxy['password']}");

// grab URL and pass it to the browser
curl_exec($ch);

// close cURL resource, and free up system resources
curl_close($ch);
