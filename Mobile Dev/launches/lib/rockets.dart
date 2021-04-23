class Rockets {
  String id;
  String flickrImages;
  Rockets(this.id, this.flickrImages);

  Rockets.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    flickrImages = json['flickr_images'][0];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['id'] = this.id;
    data['flickr_images'] = this.flickrImages;
    return data;
  }
}
