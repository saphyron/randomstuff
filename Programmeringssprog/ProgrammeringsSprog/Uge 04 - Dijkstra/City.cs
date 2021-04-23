using System;
using System.Collections.Generic;
using System.Text;

namespace Uge_04___Dijkstra
{
    class City
    {
        public String Name { get; set; }
        public List<Connection> Connections { get; set; }
        
        public City(String name)
        {
            Name = name;
            Connections = new List<Connection> { };
        }
    }
}
