class User {
  String name;
  String email;
  Picture picture;

  User({
    this.name,
    this.email,
    this.picture
  });
  
  User.fromJson(Map<String, dynamic> json) {
    name = '${json['name']['first']} ${json['name']['last']}';
    email = json['email'];
    picture = json['picture'] != null ? Picture.fromJson(json['picture']) : null;
  }
}

class Picture {
  String large;
  String medium;
  String thumbnail;

  Picture({this.large, this.medium, this.thumbnail});

  Picture.fromJson(Map<String, dynamic> json){
    large = json['large'];
    medium = json['medium'];
    thumbnail = json['thumbnail'];
  }
}