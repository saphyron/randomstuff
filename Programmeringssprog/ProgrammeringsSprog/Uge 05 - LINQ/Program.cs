using System;
using System.Collections;
using System.Linq;

namespace Uge_05___LINQ
{
    class Program
    {
        static void Main(string[] args)
        {
            QueryStringArray();
            QueryIntArray();
            
        }

        static void QueryStringArray()
        {
            string[] dogs = { "Lasse hund", "Old Sniffer", "Scooby Doo", "Lassie", "Tikivavi", "Benji", "Flash Gorden", "Vovse", "Poopy", "Vovse-hunden", "Snoopy" };
            var dogSpaces = from dog in dogs
                            where dog.Contains(" ")
                            orderby dog
                            select dog;
            foreach (var i in dogSpaces)
            {
                Console.WriteLine(i);
            }
            Console.WriteLine();
        }
        static void QueryIntArray()
        {
            int[] nums = { -2, 5, 11, 12, 20, 23, 130, 235, 2345 };
            var numbers = from ns in nums
                          where ns >= 100
                          orderby ns descending
                          select ns;
            foreach (var i in numbers)
            {
                Console.WriteLine(i);
            }
            Console.WriteLine();
        }


    }

    class Animal
    {
        static void Main(string[] args)
        {
            

        }
        public string Name { get; set; }
        public double Weight { get; set; }
        public double Height { get; set; }
        public int AnimalID { get; set; }

        public Animal(string name = "No Name", double weight = 0,
        double height = 0)
        {
            Name = name;
            Weight = weight;
            Height = height;
        }
        public override string ToString()
        {
            return string.Format("{0}weighs{1}lbs and is {2] inches tall", Name, Weight, Height);
        }
        ArrayList mineDyr = new ArrayList()
        {
            new Animal{Name = "SunnyBoy", Height = 0.6, Weight = 1109},
            new Animal{Name = "Goffy", Height = 5, Weight = 11},
            new Animal{Name = "Joe", Height = 1.8, Weight = 100},
            new Animal{Name = "Lighty", Height = 0.8, Weight = 10},
            new Animal{Name = "OldJoker", Height = 1.1, Weight = 110}
        };
    }
}
