using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;

namespace USB
{
    public class dal
    {
        static string conStr = @"Data Source=HOMED-AMD-R7\SQLEXPRESS;Initial Catalog=USB;Integrated Security=True";
        //static string conStr = @"Data Source=JOHN-LAPPY\SQLEXPRESS01;Initial Catalog=USB;Integrated Security=True";
        static SqlConnection con = null;

        public static SqlConnection getConnection()
        {
            if (con == null)
                con = new SqlConnection(conStr);

            return con;
        }

        public static bool CheckConnection()
        {
            SqlConnection con = getConnection();
            try
            {
                con.Open();
                con.Close();
                return true;
            }
            catch (SqlException ex)
            {
                return false;
            }
        }
    }
}