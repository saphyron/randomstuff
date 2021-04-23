import 'package:intl/intl.dart';

class Launches {
  int flightNumber;
  String missionName;
  String launchDateUtc;
  Rocket rocket;
  String path;

  String _formatDate(String date) {
    DateFormat dateFormat = DateFormat('dd/MM-yyyy HH:mm:ss');
    return dateFormat.format(DateTime.parse(date));
  }

  Launches({
    this.flightNumber,
    this.missionName,
    this.launchDateUtc,
    this.rocket,
    this.path,
  });

  Launches.fromJson(Map<String, dynamic> json) {
    flightNumber = json['flight_number'];
    missionName = json['mission_name'];
    launchDateUtc = _formatDate(json['launch_date_utc']);
    path = json['links']['mission_patch_small'];
    rocket =
        json['rocket'] != null ? new Rocket.fromJson(json['rocket']) : null;
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['flight_number'] = this.flightNumber;
    data['mission_name'] = this.missionName;
    data['launch_date_utc'] = this.launchDateUtc;
    if (this.rocket != null) {
      data['rocket'] = this.rocket.toJson();
    }
    data['links']['mission_patch_small'] = this.path;
    return data;
  }
}

class Rocket {
  String rocketId;
  String rocketName;
  String rocketType;

  Rocket({
    this.rocketId,
    this.rocketName,
    this.rocketType,
  });

  Rocket.fromJson(Map<String, dynamic> json) {
    rocketId = json['rocket_id'];
    rocketName = json['rocket_name'];
    rocketType = json['rocket_type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['rocket_id'] = this.rocketId;
    data['rocket_name'] = this.rocketName;
    data['rocket_type'] = this.rocketType;
    return data;
  }
}
