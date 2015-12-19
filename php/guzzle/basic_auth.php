<?php
require 'vendor/autoload.php';

// Basic Auth
$client = new GuzzleHttp\Client();
$proxy = [
	'username' => '',
	'password' => '',
	'server' => 'london.wonderproxy.com',
	'port' => 10000
];
$res = $client->request('GET', 'http://freegeoip.net/json', ['proxy' => "tcp://{$proxy['username']}:{$proxy['password']}@{$proxy['server']}:{$proxy['port']}"]);
echo $res->getStatusCode();
// 200
echo $res->getHeader('content-type');
// 'application/json; charset=utf8'
echo $res->getBody();
