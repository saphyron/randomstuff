import 'dart:convert';
import 'package:flutter/material.dart';
import 'launches.dart';
import 'package:http/http.dart' as http;
import 'Rockets.dart';
import 'rocketview.dart';

List<Launches> _launches;
List launches;
List<Rockets> _rockets;
List rockets;

void main() => runApp(new MaterialApp(
      title: "Launches",
      home: HomeLaunchView(),
    ));

class HomeLaunchView extends StatefulWidget {
  HomeLaunchView({Key key}) : super(key: key);

  @override
  _HomeLaunchViewState createState() => _HomeLaunchViewState();
}

class _HomeLaunchViewState extends State<HomeLaunchView> {
  bool isLoading = false;
  Future<List<Launches>> getLaunches() async {
    setState(() {
      isLoading = true;
    });
    final http.Response response =
        await http.get('https://api.spacexdata.com/v2/launches');
    if (response.statusCode == 200) {
      launches = jsonDecode(response.body);
      _launches = [];
      for (var launchMap in launches) {
        _launches.add(Launches.fromJson(launchMap));
      }
      setState(() {
        isLoading = false;
      });
      return _launches;
    } else {
      throw Exception('Failed to load response');
    }
  }

  Future<List<Rockets>> getRocket() async {
    final http.Response response =
        await http.get("https://api.spacexdata.com/v2/rockets/");
    if (response.statusCode == 200) {
      rockets = jsonDecode(response.body);
      _rockets = [];
      for (var rocketMap in rockets) {
        _rockets.add(Rockets.fromJson(rocketMap));
      }
      return _rockets;
    } else {
      throw Exception('Failed to load response');
    }
  }

  @override
  void initState() {
    super.initState();
    getLaunches();
    getRocket();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Launches',
      theme: ThemeData(
        primarySwatch: Colors.orange,
      ),
      home: Scaffold(
        appBar: AppBar(
          title: Text('Launches'),
        ),
        body: isLoading
            ? Center(
                child: CircularProgressIndicator(),
              )
            : ListView.separated(
                padding: const EdgeInsets.all(8),
                itemCount: _launches == null ? 0 : _launches.length,
                separatorBuilder: (BuildContext context, int index) => Divider(
                      color: Colors.purple,
                    ),
                itemBuilder: (BuildContext context, int index) {
                  return InkWell(
                    onTap: () {
                      Navigator.push(
                          context,
                          MaterialPageRoute(
                              builder: (context) =>
                                  RocketView(_launches[index], _rockets)));
                    },
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        Text("LaunchID: " +
                            _launches[index].flightNumber.toString()),
                        Text("Launchdate: " + _launches[index].launchDateUtc),
                      ],
                    ),
                  );
                }),
      ),
    );
  }
}
