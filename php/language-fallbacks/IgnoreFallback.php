// DocSection: language_fallbacks_ignore
<?php

// Defined by Composer to include required libraries
require __DIR__ . '/vendor/autoload.php';

use KenticoCloud\Delivery\DeliveryClient;
use KenticoCloud\Delivery\QueryParams;

$client = new DeliveryClient('975bf280-fd91-488c-994c-2f04416e5ee3');

$items = $client->getItems((new QueryParams())
            ->language('en-US')
            ->equals('system.language', 'en-US')
            ->equals('system.type', 'article'));
// EndDocSection