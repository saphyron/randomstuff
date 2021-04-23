import 'package:flutter/material.dart';
import 'package:mars_app/model/planet.dart';

class PlanetRow extends StatelessWidget {
  final Planet planet;

  PlanetRow(this.planet);
  @override
  Widget build(BuildContext context) {

    final planetThumbnail = new Container(
      margin: new EdgeInsets.symmetric(
      vertical: 16.0,
      ),
      alignment: FractionalOffset.centerLeft,
      child: Image(
        image: new AssetImage(planet.image),
          height: 92.0,
          width: 92.0,
        ),
    );

    final planetCardContent = new Container(
      margin: new EdgeInsets.fromLTRB(76.0, 16.0, 16.0, 16.0),
      constraints: new BoxConstraints.expand(),
      child: new Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          new Container(height: 4.0),
          new Text(planet.name),
          new Container(height: 10.0),
          new Text(planet.location),
          new Container(
            margin: new EdgeInsets.symmetric(vertical: 8.0),
            height: 2.0,
            width: 8.0,
            color: new Color(0xFF00C6FF),
          ),
          new Row(
            children: <Widget>[
              new Image.asset("assets/img/ic_distance.png", height: 12.0),
              new Container(width: 8.0),
              new Text(planet.distance),
              new Container(width: 24.0),
              new Image.asset("assets/img/ic_gravity.png", height: 12.0),
              new Container(width: 8.0),
              new Text(planet.gravity),
            ]
          )
        ],
      ),
    );

    final planetCard = new Container(
      height: 124.0,
      margin: new EdgeInsets.only(
        left: 46.0,
      ),
      decoration: new BoxDecoration(
        color: new Color(0xFF333366),
        shape: BoxShape.rectangle,
        borderRadius: new BorderRadius.circular(8.0),
        boxShadow: <BoxShadow>[
          new BoxShadow(
            color: Colors.black12,
            blurRadius: 10.0,
            offset: new Offset(0.0, 10.0),
          ),
        ],
      ),
      child: planetCardContent,
    );

    

    return new Container(
      margin: const EdgeInsets.symmetric(
        vertical: 16.0,
        horizontal: 24.0
      ),
      child: new Stack(
        children: <Widget>[
          planetCard,
          planetThumbnail,
        ]
      ),
    );
  }
}