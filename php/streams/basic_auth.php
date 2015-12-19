<?php

/* Makes a request using basic auth */

$proxy = [
	'username' => '',
	'password' => '',
	'server' => 'london.wonderproxy.com',
	'port' => 10000
];

$auth = base64_encode("{$proxy['username']}:{$proxy['password']}");
$opts = array(
    'http' => array(
    'proxy' => "tcp://{$proxy['server']}:{$proxy['port']}",
    'request_fulluri'=>true,
    'header' => array(
        "Proxy-Authorization: Basic $auth"
        )
    )
);
$context = stream_context_create($opts);

$fp = fopen('http://freegeoip.net/json', 'r', false, $context);
fpassthru($fp);
fclose($fp);
