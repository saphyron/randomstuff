using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;
using System.Windows;

namespace EksamensOpgave
{
    class services
    {
        public static int userID;

        public static DataTable loginAut(string navn)
        {
            string sql = "SELECT KundeNummer";
            sql += " FROM kunde";
            sql += " WHERE Brugernavn=@navn";
            DataTable dt = new DataTable();
            try
            {
                SqlConnection con = Connection.getConnection();
                SqlDataAdapter da = new SqlDataAdapter(sql, con);
                da.SelectCommand.Parameters.AddWithValue("@navn", navn);
                da.Fill(dt);

            }
            catch (SqlException ex)
            {
                MessageBox.Show("Error while reading database table:\n\n" + ex.Message);
            }
            return dt;
        }

        public static DataTable getBud(int id, int pID)
        {
            string sql = "if exists (select * from bydning where PiID=@pid)";
            sql += " begin";
            sql += " update bydning";
            sql += " set KundeNr=@id";
            sql += " where PiID=@pid";
            sql += " end";
            sql += " else";
            sql += " begin";
            sql += " insert into bydning values";
            sql += " (@id, @pid, 1)";
            sql += " end";
            DataTable dt = new DataTable();
            try
            {
                SqlConnection con = Connection.getConnection();
                SqlDataAdapter da = new SqlDataAdapter(sql, con);
                da.SelectCommand.Parameters.AddWithValue("@id", id);
                da.SelectCommand.Parameters.AddWithValue("@pid", pID);
                da.Fill(dt);

            }
            catch (SqlException ex)
            {
                MessageBox.Show("Error while reading database table:\n\n" + ex.Message);
            }
            return dt;
        }

        
        public static DataTable opdaterprodukt(int id, double bud)
        {
            string sql = "UPDATE produkter";
            sql += " SET Bud=@bud";
            sql += " WHERE ProduktID=@id";
            DataTable dt = new DataTable();
            try
            {
                SqlConnection con = Connection.getConnection();
                SqlDataAdapter da = new SqlDataAdapter(sql, con);
                da.SelectCommand.Parameters.AddWithValue("@id", id);
                da.SelectCommand.Parameters.AddWithValue("@bud", bud);
                da.Fill(dt);

            }
            catch (SqlException ex)
            {
                MessageBox.Show("Error while reading database table:\n\n" + ex.Message);
            }
            return dt;
        }

        public static void setID(int id)
        {
            userID = id;
        }
        public static int getID()
        {
            return userID;
        }



        internal static DataTable getsalg()
        {
            string sql = "";
            sql += "SELECT p.ProduktID, p.MetalType, p.Maengde, p.Bud, p.Auktionsfrist, b.KundeNr";
            sql += " from produkter p";
            sql += " left join bydning b";
            sql += " on b.piID = ProduktID";
            

            DataTable dt = new DataTable();
            try
            {
                SqlConnection con = Connection.getConnection();
                SqlDataAdapter da = new SqlDataAdapter(sql, con);

                da.Fill(dt);

            }
            catch (SqlException ex)
            {
                MessageBox.Show("Error while reading database tables:\n\n" + ex.Message);
            }
            return dt;
        }

        public static DataTable createUser(string navn, string email, string bruger, string tlf)
        {
            string sql = "INSERT into kunde values";
            sql += " (@navn, @email, @bruger, @telefon)";
            DataTable dt = new DataTable();
            try
            {
                SqlConnection con = Connection.getConnection();
                SqlDataAdapter da = new SqlDataAdapter(sql, con);
                da.SelectCommand.Parameters.AddWithValue("@navn", navn);
                da.SelectCommand.Parameters.AddWithValue("@email", email);
                da.SelectCommand.Parameters.AddWithValue("@bruger", bruger);
                da.SelectCommand.Parameters.AddWithValue("@telefon", tlf);
                da.Fill(dt);

            }
            catch (SqlException ex)
            {
                MessageBox.Show("Error while reading database table:\n\n" + ex.Message);
            }
            return dt;
        }
    }
}