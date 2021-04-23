using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTestConsoleApp
{
    public class Calculator
    {
        public int add(int a, int b)
        {
            return a + b;
        }

        public int substract(int a, int b)
        {
            return a - b;
        }

        public double div(double a, double b)
        {
            return a / b;
        }
        public double divexcep(int a, int b)
        {
            return a / b;
        }

        public double mult(double a, double b)
        {
            return a * b;
        }

        public string Cpr(string del1, string del2)
        {
            int fivesix = Int32.Parse(del2.Remove(2));
            char c = del2[2];
            string c1 = c.ToString();
            int seven = Int32.Parse(c1);
            string del1mod = "";
            // Seven < 4
            if (seven < 4)
            {
                del1mod = del1.Insert(4, "19");
            } 
            // Seven == 4
            else if(fivesix < 37 && seven == 4)
            {
                del1mod = del1.Insert(4, "20");
            }
            else if (fivesix > 36 && seven == 4)
            {
                del1mod = del1.Insert(4, "19");
            }
            // 4 < seven < 9
            else if (fivesix < 58 && seven > 4 && seven < 9)
            {
                del1mod = del1.Insert(4, "20");
            }
            else if (fivesix > 57 && seven > 4 && seven < 9)
            {
                del1mod = del1.Insert(4, "18");
            }
            // seven == 9
            else if (fivesix < 37 && seven == 9)
            {
                del1mod = del1.Insert(4, "20");
            }
            else if (fivesix > 36 && seven == 9)
            {
                del1mod = del1.Insert(4, "19");
            }
            return del1mod + "-" + del2;
        }
    }
}
