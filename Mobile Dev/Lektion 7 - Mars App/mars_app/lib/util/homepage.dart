import 'package:flutter/material.dart';
import 'gradientappbarr.dart';
import 'homepagebody.dart';

class Homepage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      body: new Column(
        children: <Widget>[
          new GradientAppBar("Planets"),
          new HomePageBody(),
          new HomePageBody(),
          new HomePageBody(),
        ],
        )
    );
  }
}