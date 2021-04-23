using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lektion_8___SQL2
{
    class Program
    {
        static void Main(string[] args)
        {
            //Connection String
            string conn = "Data Source = JOHN-LAPPY\\SQLEXPRESS01; Initial Catalog = Northwind; " +
                "Integrated Security = true";
            //Opgave 3
            ReadData1(conn);
            //Opgave 7.1
            //ReadData2(conn);
            //Opgave 7.2
            //ReadData3(conn);
            //Opgave 7.3
            //ReadData4(conn);
            //Opgave 8
            //ReadData5(conn);
            Console.ReadKey();
        }

        public static void ReadData1(string connectionString)
        {
            string queryString = "select freight " +
                "from orders";
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                SqlCommand command = new SqlCommand(queryString, connection);
                connection.Open();
                SqlDataReader reader = command.ExecuteReader();
                double total = 0;
                int counter = 0;
                while (reader.Read())
                {
                    IDataRecord record = (IDataRecord)reader;
                    double id = Convert.ToDouble(record[0]);
                    //string name = (string)record[1];
                    // .... Do stuff with data
                    total += id;
                    counter++;
                    //Console.WriteLine($"Denne gang blev der tilført {id}");
                }
                Console.WriteLine("Gennemsnittet er: " + total / counter);
                reader.Close();
            }
        }

        public static void ReadData2(string connectionString)
        {
            string queryString = "select * " +
                "from pets";
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                SqlCommand command = new SqlCommand(queryString, connection);
                connection.Open();
                SqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    IDataRecord record = (IDataRecord)reader;
                    int id = (int)record[0];
                    int idOwner = (int)record[1];
                    string name = (string)record[2];
                    int age = (int)record[3];
                    int weight = (int)record[4];
                    string species = (string)record[5];
                    Console.WriteLine($"Id: {id} OwnerID: {idOwner} Name: {name} " +
                        $"Age: {age} Weight: {weight} Species: {species}");
                }
                reader.Close();
            }
        }
        public static void ReadData3(string connectionString)
        {
            string queryString = "select p.name " +
                "from persons p, pets ps \n" +
                "where p.ID = ps.ID";
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                SqlCommand command = new SqlCommand(queryString, connection);
                connection.Open();
                SqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    IDataRecord record = (IDataRecord)reader;
                    string name = (string)record[0];
                    Console.WriteLine($"Name: {name} ");
                }
                reader.Close();
            }
        }
        public static void ReadData4(string connectionString)
        {
            string queryString = "select p.ID, p.name, ps.id, ps.name " +
                "from persons p, pets ps \n" +
                "where p.ID = ps.ID";
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                SqlCommand command = new SqlCommand(queryString, connection);
                connection.Open();
                SqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    IDataRecord record = (IDataRecord)reader;
                    int id = (int)record[0];
                    string name = (string)record[1];
                    int idPet = (int)record[2];
                    string name2 = (string)record[3];
                    Console.WriteLine($"Id: {id} Name of owner: {name} " +
                        $"IdPet {idPet} Pet Name: {name2}");
                }
                reader.Close();
            }
        }
        public static void ReadData5(string connectionString)
        {
            string queryString = "select p.name " +
                "from pets ps, persons p \n"+
                "where p.ID = ps.ID \n" +
                "and score = (select max(score) from persons)";
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                SqlCommand command = new SqlCommand(queryString, connection);
                connection.Open();
                SqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    IDataRecord record = (IDataRecord)reader;
                    string name = (string)record[0];
                    Console.WriteLine($"Name of owner: {name}");
                }
                reader.Close();
            }
        }

    }


}
