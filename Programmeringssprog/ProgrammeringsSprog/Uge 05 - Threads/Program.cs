using System;
using System.Threading;

namespace Uge_05___Threads
{
    class Program
    {
        private static readonly object balanceLock = new object();
        static void Main(string[] args)
        {
            
            Thread t = new Thread(() => Print("test1"));
            Thread t1 = new Thread(() => Print("test2"));
            t.Start();
            t1.Start();
            
            Thread g = new Thread(() => Go());
            g.Start();
            g.Join();
            Console.WriteLine("Thread g has ended");
            
            Thread c = new Thread(() => CountTo(10));
            c.Start();
            new Thread(() =>
            {
                CountTo(5);
                CountTo(6);
            }).Start();
            Console.ReadLine();
            

        }

        static void Go()
        {
            for(int i = 0; i < 1000; i++)
            {
                Console.Write("y");
            }
        }
        static void CountTo(int maxNum)
        {
            for (int i = 0; i < maxNum; i++)
            {
                Console.WriteLine(i);
            }
        }
        static void Print(string name)
        {

            for (int i = 0; i < 10; i++)
            {
                lock (balanceLock)
                {
                    Console.WriteLine($"{name}: " + i + " ");
                    Thread.Sleep(100);
                }
            }


        }
        static void PrintNumber()
        {
            int num = 1;
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine(num);
                Thread.Sleep(1000);
                num++;
            }
            Console.ReadLine();
        }
    }
}
