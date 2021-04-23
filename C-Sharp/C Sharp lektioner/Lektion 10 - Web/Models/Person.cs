using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Lektion_10___Web.Models
{
    public class Person
    {
        string Name { get; set; }
        string Addresse { get; set; }
        int Alder { get; set; }
        string Information { get; set; }

        public Person(string navn, string addresse, int alder, string info)
        {
            Name = navn;
            Addresse = addresse;
            Alder = alder;
            Information = info;
        }
    }
}