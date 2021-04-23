using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

namespace Obligatorisk_Opgave___Opgave_2_BubbleSort
{
    class Program
    {
        // Random generator
        private static Random Random = new Random();
        static void Main(string[] args)
        {
            // Istanticere list of tilføjer værdier
            List<String> t = new List<String>();
            for (int i = 0; i < 1000; i++)
            {
                t.Add(Genererstrenge(10));
            }
            String[] ta = t.ToArray();
            // Vores dejlige sort kode som tog mig længere tid end forventet at lave.
            BubbleSort(ta);

            for(int i = 0; i< ta.Length; i++)
            {
                Console.WriteLine(ta[i]);
            }


        }
        public static String Genererstrenge(int t)
        {
            const string chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            return new string(Enumerable.Repeat(chars, t)
                .Select(s => s[Random.Next(s.Length)]).ToArray());
        }
        /// <summary>
        /// Tager et string array som parameter og sorterer via bubble sort algoritmen.
        /// Bubble sort algoritmen er meget langsom i forhold til andre.
        /// </summary>
        /// <param name="sa">string array som parameter</param>
        public static void BubbleSort(String[] sa)
        {
            bool swap = true;
            while (swap == true)
            {
                swap = false;
                int size = sa.Length - 1;
                for (int i = 0; i < size; i++)
                {
                    if (string.Compare(sa[i], sa[i + 1]) < 0)
                    {
                        String temp = sa[i];
                        sa[i] = sa[i + 1];
                        sa[i + 1] = temp;
                        swap = true;
                    }
                }
            }

        }
    }
}
