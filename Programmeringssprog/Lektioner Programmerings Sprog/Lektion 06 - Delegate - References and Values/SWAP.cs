//using System;
//using System.Collections.Generic;
//using System.Linq;
//using System.Text;
//using System.Threading.Tasks;

//namespace ConsoleApplication13
//{

//    /*    When you compile programs containing unsafe code, you must specify the Allow Unsafe Code option when building the project.
//     *    To do this, right-click the project in Solution Explorer and then click Properties. In the Properties window, click the Build tab, 
//     *    select Allow Unsafe Code, and then on the FILE menu, click Save All. */
//    class Program
//    {
//        static void Main(string[] args)
//        {
//            unsafe
//            {
//                int* pi; // pointer
//                int i = 99;

//                pi = &i; //points to i's address
//                *pi = 103;

//                Console.WriteLine(i);
//                Console.ReadLine();

//                i = 4;

//                Console.WriteLine(*pi);
//                Console.ReadLine();

//            }


//            int x = 99, y = 100;
//            unsafe
//            {
//                swap(&x, &y);
//            }
//            Console.WriteLine("x is now {0}, y is now {1}", x, y);
//            Console.ReadLine();
//        }

//        public static unsafe void swap(int* a, int* b)
//        {
//            int temp;
//            temp = *a;
//            *a = *b;
//            *b = temp;
//        }

//    }
//}
