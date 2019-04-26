// DocSection: linked_content_get_article_with_author
<?php

// Defined by Composer to include required libraries
require __DIR__ . '/vendor/autoload.php';

use KenticoCloud\Delivery\DeliveryClient;

$client = new DeliveryClient('e6d2946e-0e24-003f-a397-9d2d458c6d6e');

$item = $client->getItem('the_origin_of_coffee', (new QueryParams())
            ->depth(1));
// EndDocSection