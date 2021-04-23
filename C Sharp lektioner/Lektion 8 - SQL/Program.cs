using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lektion_8___SQL
{
    class Program
    {
        static void Main(string[] args)
        {
            void ReadData(String connectionString)
            {
                String queryString = "select freight from orders";
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    SqlCommand command = new SqlCommand(queryString, connection);
                    connection.open();
                    SqlDataReader reader = command.ExecuteReader();
                    while (reader.Read())
                    {
                        IDataRecord record = (IDataRecord)reader;
                        int id = (int)record[0];
                        string name = (string)record[1];
                        // .... Do stuff with data
                    }
                    reader.Close();
                }
            }
        }
        
    }


}
