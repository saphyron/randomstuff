using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Obliatorisk_Opgave___Opgave_1_Graf
{


    class Program
    {
        static void Main(string[] args)
        {
            // Instanciser Graferne
            MyGraph<string> myGraph1 = new MyGraph<string>();
            MyGraph<string> myGraph2 = new MyGraph<string>();
            MyGraph<string> myGraph3 = new MyGraph<string>();

            // Bygger Graferne
            // Graf 1 er opgaven.
            Node<String> start, target;
            CreateGraph1(ref myGraph1, out start, out target);
            Console.WriteLine(GetPath(myGraph1, start, target));
            CreateGraph2(ref myGraph2, out start, out target);
            Console.WriteLine(GetPath(myGraph2, start, target));
            CreateGraph3(ref myGraph3, out start, out target);
            Console.WriteLine(GetPath(myGraph3, start, target));
        }

        /// <summary>
        /// Denne del af koden skriver hvilken by vi er kommet til og hvor langt vi har bevæget os fra start.
        /// </summary>
        /// <param name="graph">Her tager vi klassen MyGraph som parameter, MyGraph er den Graf vi går igennem. Denne Graf er relativ hardkoded da jeg ikke er særlig god.</param>
        /// <param name="start">Her tager vi den start position vi bruger i koden.</param>
        /// <param name="target">Her tager vi den slut position vi bruger i koden.</param>
        /// <returns>Retuner ruten.</returns>
        private static string GetPath(MyGraph<string> graph, Node<String> start, Node<String> target)
        {
            Dictionary<Node<String>, Node<String>> predecessor = new Dictionary<Node<string>, Node<string>>();
            if (!Bfs(graph, start, target, predecessor))
            {
                return "No path available";
            }

            Node<String> currentNode = target;
            int distance = 0;
            string path = currentNode.Data + "\n";
            while (predecessor[currentNode] != null)
            {
                currentNode = predecessor[currentNode];
                path += currentNode.Data + "\n";
                distance++;
            }
            path += "\nDistance: " + distance;
            return path;
        }
        /// <summary>
        /// Dette er den magiske kode, Breath First Search. Det er den der går igennem hver Node.
        /// Man kan vælge at køre Depth First Search men jeg er endnu dårligere til den.
        /// </summary>
        /// <param name="graph">Her tager vi den Graf ind vi har lavet.</param>
        /// <param name="start">Her tager vi den start position vi har valgt.</param>
        /// <param name="target">Her tager vi den slut position vi har valgt.</param>
        /// <param name="predecessor">Dette er et check for at se om området er blevet besøgt før.</param>
        private static bool Bfs(MyGraph<string> graph, Node<String> start, Node<String> target,
            Dictionary<Node<String>, Node<String>> predecessor)
        {
            if (start == target) { return true; }

            Queue<Node<String>> queue = new Queue<Node<String>>();

            predecessor.Add(start, null);
            queue.Enqueue(start);

            while (queue.Count != 0)
            {
                Node<String> currentNode = queue.Dequeue();

                foreach (Edge<String> edge in currentNode.MyEdges)
                {
                    Node<String> node = edge.To;
                    if (!predecessor.ContainsKey(node))
                    {
                        predecessor.Add(node, currentNode);
                        queue.Enqueue(node);
                        if (node == target)
                        {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        /// <summary>
        /// Dette er lidt for hardkodet til min mening, men mine skills er ikke særlig gode og jeg kunne ikke lave det bedre. Har genbrugt så meget kode som muligt.
        /// </summary>
        /// <param name="myGraph"></param>
        /// <param name="n3"></param>
        /// <param name="n7"></param>
        private static void CreateGraph1(ref MyGraph<string> myGraph, out Node<String> n3, out Node<String> n7)
        {
            //Adds nodes to our graph
            Node<String> n1 = myGraph.AddNode("OREGON");
            Node<String> n2 = myGraph.AddNode("CALIFORNIA");
            n3 = myGraph.AddNode("IDAHO");
            Node<String> n4 = myGraph.AddNode("UTAH");
            Node<String> n5 = myGraph.AddNode("NEW MEXICO");
            Node<String> n6 = myGraph.AddNode("KANSAS");
            n7 = myGraph.AddNode("SOUTH DAKOTA");
            Node<String> n8 = myGraph.AddNode("NORTH DAKOTA");
            Node<String> n9 = myGraph.AddNode("IOWA");
            Node<String> n10 = myGraph.AddNode("TENNESSEE");
            Node<String> n11 = myGraph.AddNode("NEW YORK");
            Node<String> n12 = myGraph.AddNode("FLORIDA");
            Node<String> n13 = myGraph.AddNode("TEXAS");

            //Creates edges between the graphs nodes
            myGraph.AddEdge("OREGON", "CALIFORNIA");
            myGraph.AddEdge("CALIFORNIA", "UTAH");
            myGraph.AddEdge("UTAH", "IDAHO");
            myGraph.AddEdge("UTAH", "NEW MEXICO");
            myGraph.AddEdge("NEW MEXICO", "KANSAS");
            myGraph.AddEdge("NEW MEXICO", "TEXAS");
            myGraph.AddEdge("TEXAS", "TENNESSEE");
            myGraph.AddEdge("TEXAS", "FLORIDA");
            myGraph.AddEdge("TEXAS", "KANSAS");
            myGraph.AddEdge("KANSAS", "SOUTH DAKOTA");
            myGraph.AddEdge("SOUTH DAKOTA", "NORTH DAKOTA");
            myGraph.AddEdge("NORTH DAKOTA", "IOWA");
            myGraph.AddEdge("IOWA", "TENNESSEE");
            myGraph.AddEdge("TENNESSEE", "FLORIDA");
            myGraph.AddEdge("TENNESSEE", "NEW YORK");
        }
        private static void CreateGraph2(ref MyGraph<string> myGraph, out Node<String> n2, out Node<String> n12)
        {
            //Adds nodes to our graph
            Node<String> n1 = myGraph.AddNode("OREGON");
            n2 = myGraph.AddNode("CALIFORNIA");
            Node<String> n3 = myGraph.AddNode("IDAHO");
            Node<String> n4 = myGraph.AddNode("UTAH");
            Node<String> n5 = myGraph.AddNode("NEW MEXICO");
            Node<String> n6 = myGraph.AddNode("KANSAS");
            Node<String> n7 = myGraph.AddNode("SOUTH DAKOTA");
            Node<String> n8 = myGraph.AddNode("NORTH DAKOTA");
            Node<String> n9 = myGraph.AddNode("IOWA");
            Node<String> n10 = myGraph.AddNode("TENNESSEE");
            Node<String> n11 = myGraph.AddNode("NEW YORK");
            n12 = myGraph.AddNode("FLORIDA");
            Node<String> n13 = myGraph.AddNode("TEXAS");

            //Creates edges between the graphs nodes
            myGraph.AddEdge("OREGON", "CALIFORNIA");
            myGraph.AddEdge("CALIFORNIA", "UTAH");
            myGraph.AddEdge("UTAH", "IDAHO");
            myGraph.AddEdge("UTAH", "NEW MEXICO");
            myGraph.AddEdge("NEW MEXICO", "KANSAS");
            myGraph.AddEdge("NEW MEXICO", "TEXAS");
            myGraph.AddEdge("TEXAS", "TENNESSEE");
            myGraph.AddEdge("TEXAS", "FLORIDA");
            myGraph.AddEdge("TEXAS", "KANSAS");
            myGraph.AddEdge("KANSAS", "SOUTH DAKOTA");
            myGraph.AddEdge("SOUTH DAKOTA", "NORTH DAKOTA");
            myGraph.AddEdge("NORTH DAKOTA", "IOWA");
            myGraph.AddEdge("IOWA", "TENNESSEE");
            myGraph.AddEdge("TENNESSEE", "FLORIDA");
            myGraph.AddEdge("TENNESSEE", "NEW YORK");
        }
        private static void CreateGraph3(ref MyGraph<string> myGraph, out Node<String> n5, out Node<String> n13)
        {
            //Adds nodes to our graph
            Node<String> n1 = myGraph.AddNode("OREGON");
            Node<String> n2 = myGraph.AddNode("CALIFORNIA");
            Node<String> n3 = myGraph.AddNode("IDAHO");
            Node<String> n4 = myGraph.AddNode("UTAH");
            n5 = myGraph.AddNode("NEW MEXICO");
            Node<String> n6 = myGraph.AddNode("KANSAS");
            Node<String> n7 = myGraph.AddNode("SOUTH DAKOTA");
            Node<String> n8 = myGraph.AddNode("NORTH DAKOTA");
            Node<String> n9 = myGraph.AddNode("IOWA");
            Node<String> n10 = myGraph.AddNode("TENNESSEE");
            Node<String> n11 = myGraph.AddNode("NEW YORK");
            Node<String> n12 = myGraph.AddNode("FLORIDA");
            n13 = myGraph.AddNode("TEXAS");

            //Creates edges between the graphs nodes
            myGraph.AddEdge("OREGON", "CALIFORNIA");
            myGraph.AddEdge("CALIFORNIA", "UTAH");
            myGraph.AddEdge("UTAH", "IDAHO");
            myGraph.AddEdge("UTAH", "NEW MEXICO");
            myGraph.AddEdge("NEW MEXICO", "KANSAS");
            myGraph.AddEdge("NEW MEXICO", "TEXAS");
            myGraph.AddEdge("TEXAS", "TENNESSEE");
            myGraph.AddEdge("TEXAS", "FLORIDA");
            myGraph.AddEdge("TEXAS", "KANSAS");
            myGraph.AddEdge("KANSAS", "SOUTH DAKOTA");
            myGraph.AddEdge("SOUTH DAKOTA", "NORTH DAKOTA");
            myGraph.AddEdge("NORTH DAKOTA", "IOWA");
            myGraph.AddEdge("IOWA", "TENNESSEE");
            myGraph.AddEdge("TENNESSEE", "FLORIDA");
            myGraph.AddEdge("TENNESSEE", "NEW YORK");
        }
    }
}

