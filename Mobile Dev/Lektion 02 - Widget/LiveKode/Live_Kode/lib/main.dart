import 'package:flutter/material.dart';

void main() {
  runApp(Home());
}

class Home extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text(
            'Katte',
            style: TextStyle(fontSize: 30),
          ),
          centerTitle: true,
        ),
        body: ListView(
          children: <Widget>[
            Container(
                margin: EdgeInsets.all(8),
                child: Stack(children: <Widget>[
                  Image.asset('assets/kat_6.jpg'),
                  Positioned(
                      bottom: 10,
                      right: 10,
                      child: Text(
                        'Sød kat',
                        style: TextStyle(fontSize: 30, color: Colors.black),
                      )),
                ])),
            Container(
                margin: EdgeInsets.all(8),
                child: Image.asset('assets/katte4.jpg')),
            Container(
                margin: EdgeInsets.all(8),
                child: Image.asset('assets/kat1.jpg')),
          ],
          scrollDirection: Axis.vertical,
        ),
      ),
    );
  }
}
