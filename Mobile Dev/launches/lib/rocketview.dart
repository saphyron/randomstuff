import 'package:flutter/material.dart';
import 'launches.dart';
import 'Rockets.dart';

class RocketView extends StatelessWidget {
  final Launches selectedlaunch;
  final List<Rockets> rocketlist;

  RocketView(this.selectedlaunch, this.rocketlist);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text(selectedlaunch.missionName),
        ),
        body: SingleChildScrollView(
          child: Column(
            children: [
              for (var getID in rocketlist)
                if (selectedlaunch.rocket.rocketId == getID.id)
                  Image.network(getID.flickrImages),
              if (selectedlaunch.path == null)
                Text("Mission Patch not found!")
              else
                (Image.network(selectedlaunch.path)),
              Text(selectedlaunch.launchDateUtc),
            ],
          ),
        ));
  }
}
