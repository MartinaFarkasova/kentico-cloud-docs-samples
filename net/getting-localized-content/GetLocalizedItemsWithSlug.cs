// DocSection: getting_localized_content_url_slug
using KenticoCloud.Delivery;

// Initializes a content delivery client
IDeliveryClient client = DeliveryClientBuilder
      .WithProjectId("975bf280-fd91-488c-994c-2f04416e5ee3")
      .Build();

// Gets the Home content item in Spanish based on the item's URL slug value
// Create strongly typed models according to https://developer.kenticocloud.com/docs/strongly-typed-models
DeliveryItemListingResponse<Home> response = await client.GetItemsAsync<Home>(
    new LanguageParameter("es-ES"),
    new EqualsFilter("system.type", "home"),
    new EqualsFilter("elements.url_pattern", "inicio")
    );

var items = response.Items;
// EndDocSection