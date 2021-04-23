using System;
using System.Linq.Expressions;
using System.Threading;

namespace Uge_05___Opgave_6
    {
        class Program
        {
            static void Main(string[] args)
            {
                object lock1 = new object();
                object lock2 = new object();

                Console.WriteLine("Starting...");

                // thread 1
                if (Monitor.TryEnter(lock1))
                {
                    lock (lock1)
                    {
                        if (Monitor.TryEnter(lock2))
                        {
                            lock (lock2)
                            {
                                Console.WriteLine("Thread 1 got both locks");
                            }
                        }
                        Monitor.Exit(lock2);
                    }
                }
                Monitor.Exit(lock1);

                // thread 2
                if (Monitor.TryEnter(lock2))
                {
                    lock (lock1)
                    {
                        if (Monitor.TryEnter(lock1))
                        {
                            lock (lock1)
                            {
                                Console.WriteLine("Thread 2 got both locks");
                            }
                        }
                        Monitor.Exit(lock1);
                    }
                }
                Monitor.Exit(lock2);

                Console.WriteLine("Finished...");
            }
        }
    }
