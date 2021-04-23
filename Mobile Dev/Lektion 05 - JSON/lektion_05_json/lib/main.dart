import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'randomuserModel.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  MyApp({Key key}) : super(key: key);
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  List<User> _users;

  getUsers() async {
    Map<String, dynamic> rawJSON;
    List<User> users = List<User>();

    final http.Response response =
        await http.get('https://randomuser.me/api/?results=500&nat=DK');
    rawJSON = json.decode(response.body);
    rawJSON['results'].forEach((user) {
      users.add(User.fromJson(user));
    });
    setState(() {
      _users = users;
    });
  }

  @override
  void initState() {
    super.initState();
    getUsers();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'RandomUsers',
      theme: ThemeData(
        primarySwatch: Colors.orange,
      ),
      home: Scaffold(
        appBar: AppBar(
          title: Text('Random User List'),
        ),
        body: ListView.builder(
            padding: const EdgeInsets.all(8),
            itemCount: _users == null ? 0 : _users.length,
            itemBuilder: (BuildContext context, int index) {
              String imageURL = _users[index].picture.thumbnail;
              return Container(
                height: 50,
                color: Colors.grey,
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [Text(_users[index].name), Image.network(imageURL)],
                ),
              );
            }),
      ),
    );
  }
}
