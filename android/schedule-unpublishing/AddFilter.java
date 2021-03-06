// DocSection: schedule_unpublishing_add_filter
import com.kenticocloud.delivery_core.*;
import com.kenticocloud.delivery_rx.*;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

Date now = new Date();

// Prepares an array to hold strongly-typed models
List<TypeResolver<?>> typeResolvers = new ArrayList<>();

// Registers the type resolvers
typeResolvers.add(new TypeResolver<>(Article.TYPE, new Function<Void, Article>() {
    @Override
    public Article apply(Void input) {
        return new Article();
    }
}));

// Prepares the DeliveryService configuration object
String projectId = "14372844-0a5d-434a-8423-605b8a631623";
IDeliveryConfig config = DeliveryConfig.newConfig(projectId)
    .withTypeResolvers(typeResolvers);

// Initializes a DeliveryService for Java projects
IDeliveryService deliveryService = new DeliveryService(config);

// Gets all articles using a simple request
List<Article> articles = deliveryService.<Article>items()
        .equalsFilter("system.type", "article")
        .get()
        .getItems();

List<Article> publishedItems = new ArrayList<>();

for (Article article : articles) {
    if (
        article.getPublishUntil() == null || article.getPublishUntil().after(now)) {
        publishedItems.add(article);
    }
}

// Gets all articles using RxJava2
deliveryService.<Article>items()
        .equalsFilter("system.type", "article")
        .getObservable()
        .subscribe(new Observer<DeliveryItemListingResponse<Article>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(DeliveryItemListingResponse<Article> response) {
                Date now = new Date();

                // Gets the retrieved articles
                List<Article> articles = response.getItems();

                List<Article> publishedItems = new ArrayList<>();

              	// Filters the articles, keeping those that should be public
                for (Article article : articles) {
                    if (article.getPublishUntil() == null || article.getPublishUntil().after(now)) {
                        publishedItems.add(article);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
// EndDocSection