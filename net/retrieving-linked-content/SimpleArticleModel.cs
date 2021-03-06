// DocSection: linked_content_simple_article_model
// Create strongly typed models according to https://developer.kenticocloud.com/docs/strongly-typed-models

using System;
using System.Collections.Generic;
using KenticoCloud.Delivery;

namespace KenticoCloudModels
{
    public partial class SimpleArticle
    {
        public const string Codename = "simple_article";
        public const string TitleCodename = "title";
        public const string BodyCodename = "body";
        public const string AuthorCodename = "author";

        public string Title { get; set; }
        public string Body { get; set; }
        public IEnumerable<object> Author { get; set; }
        public ContentItemSystemAttributes System { get; set; }
    }
}
// EndDocSection