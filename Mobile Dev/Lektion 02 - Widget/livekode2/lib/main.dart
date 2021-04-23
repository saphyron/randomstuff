import 'package:flutter/material.dart';

void main() => runApp(
  MaterialApp(
    home: NinjaCard(), 
  )
);

class NinjaCard extends StatefulWidget {
  @override
  _NinjaCardState createState() => _NinjaCardState();
}

class _NinjaCardState extends State<NinjaCard> {
  int ninjaLevel = 0;

  @override
  Widget build(BuildContext context) {
    //Scaffold, predesigned layout med bjælke og body.
    return Scaffold(
      backgroundColor: Colors.grey[900],
      appBar: AppBar(
        title: Text('Ninja ID Card'),
        centerTitle: true,
        backgroundColor: Colors.grey[850],
        elevation: 0.0,
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: (){
          setState(() {
            ninjaLevel++;
          });
        },
        child: Icon(Icons.add),
        backgroundColor: Colors.grey[800],
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
            Container(
              child: Text(
                'Anjiin san level: $ninjaLevel',
                style: TextStyle(
                  fontSize: 30,
                  color: Colors.green[400]
                ),
              ),
            ),],
          scrollDirection: Axis.vertical,
        
      ),
    );
  }
}