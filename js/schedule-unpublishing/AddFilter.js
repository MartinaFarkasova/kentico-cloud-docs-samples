// DocSection: schedule_unpublishing_add_filter
const KenticoCloud = require('kentico-cloud-delivery);
const _ = require('underscore');

// Create strongly typed models according to https://developer.kenticocloud.com/docs/strongly-typed-models
class Article extends KenticoCloud.ContentItem {
    constructor() {
        super();
    }
}

const deliveryClient = new KenticoCloud.DeliveryClient({
    projectId: '14372844-0a5d-434a-8423-605b8a631623',
    typeResolvers: [
      new KenticoCloud.TypeResolver('article', () => new Article)
    ]
});

const d = new Date();
const now = d.toISOString();

deliveryClient.items()
    .type('article')
    .getObservable()
    .subscribe(response => console.log(_.filter(response.items, function (i) { 
        return ((i.PublishUntil > now || i.PublishUntil === undefined || i.PublishUntil === null))
    })));
// EndDocSection