using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;
using System.Windows;

namespace USB
{
    public class Service
    {
        public static DataTable getStatusTable()
        {
            string sql = "SELECT StatusT FROM statustable";
            DataTable dt = new DataTable();
            try
            {
                SqlConnection con = dal.getConnection();
                SqlDataAdapter da = new SqlDataAdapter(sql, con);
                da.Fill(dt);

            }
            catch (SqlException ex)
            {
                MessageBox.Show("Error while reading database table:\n\n" + ex.Message);
            }
            return dt;
        }

        public static DataTable opretningAfBruger(string navn, string add, string em, string user, string pass)
        {
            string sql = "INSERT into Kunde values";
            sql += " (@navn, @addresse, @email, @user, @pass)";

            DataTable dt = new DataTable();
            try
            {
                SqlConnection con = dal.getConnection();
                SqlDataAdapter da = new SqlDataAdapter(sql, con);
                da.SelectCommand.Parameters.AddWithValue("@navn", navn);
                da.SelectCommand.Parameters.AddWithValue("@addresse", add);
                da.SelectCommand.Parameters.AddWithValue("@email", em);
                da.SelectCommand.Parameters.AddWithValue("@user", user);
                da.SelectCommand.Parameters.AddWithValue("@pass", pass);
                da.Fill(dt);

            }
            catch (SqlException ex)
            {
                MessageBox.Show("Error while reading database table:\n\n" + ex.Message);
            }
            return dt;
        }
        public static DataTable redigeringAfBruger(int id, string navn, string add, string em, string user, string pass)
        {
            string sql = "UPDATE Kunde";
            sql += " SET Navn=@navn, Addresse=@addresse, EMail=@email, Brugernavn=@user, Password=@pass";
            sql += " WHERE KundeNummer=@id";
            DataTable dt = new DataTable();
            try
            {
                SqlConnection con = dal.getConnection();
                SqlDataAdapter da = new SqlDataAdapter(sql, con);
                da.SelectCommand.Parameters.AddWithValue("@id", id);
                da.SelectCommand.Parameters.AddWithValue("@navn", navn);
                da.SelectCommand.Parameters.AddWithValue("@addresse", add);
                da.SelectCommand.Parameters.AddWithValue("@email", em);
                da.SelectCommand.Parameters.AddWithValue("@user", user);
                da.SelectCommand.Parameters.AddWithValue("@pass", pass);
                da.Fill(dt);

            }
            catch (SqlException ex)
            {
                MessageBox.Show("Error while reading database table:\n\n" + ex.Message);
            }
            return dt;
        }
        public static DataTable redigeringAfUdlejning(int id, int pID, string status)
        {
            string sql = "UPDATE udlejning";
            sql += " SET ProduktStatus=@status";
            sql += " WHERE KundeNr=@id";
            sql += " AND PID=@pid";
            DataTable dt = new DataTable();
            try
            {
                SqlConnection con = dal.getConnection();
                SqlDataAdapter da = new SqlDataAdapter(sql, con);
                da.SelectCommand.Parameters.AddWithValue("@id", id);
                da.SelectCommand.Parameters.AddWithValue("@pid", pID);
                da.SelectCommand.Parameters.AddWithValue("@status", status);
                da.Fill(dt);

            }
            catch (SqlException ex)
            {
                MessageBox.Show("Error while reading database table:\n\n" + ex.Message);
            }
            return dt;
        }

        public static DataTable getKunder()
        {
            string sql = "SELECT KundeNummer, Navn FROM kunde";
            DataTable dt = new DataTable();
            try
            {
                SqlConnection con = dal.getConnection();
                SqlDataAdapter da = new SqlDataAdapter(sql, con);
                da.Fill(dt);

            }
            catch (SqlException ex)
            {
                MessageBox.Show("Error while reading database table:\n\n" + ex.Message);
            }
            return dt;
        }


        public static DataTable getProduktTable()
        {
            string sql = "SELECT Navn FROM produkter";
            DataTable dt = new DataTable();
            try
            {
                SqlConnection con = dal.getConnection();
                SqlDataAdapter da = new SqlDataAdapter(sql, con);
                da.Fill(dt);

            }
            catch (SqlException ex)
            {
                MessageBox.Show("Error while reading database table:\n\n" + ex.Message);
            }
            return dt;
        }

        internal static DataTable getKundeInfo(int kundeID)
        {
            string sql = "";
            sql += "SELECT Navn, Addresse, EMail, Brugernavn, Password";
            sql += " FROM kunde";
            sql += " WHERE KundeNummer=@suppId";
            DataTable dt = new DataTable();
            try
            {
                SqlConnection con = dal.getConnection();
                SqlDataAdapter da = new SqlDataAdapter(sql, con);
                da.SelectCommand.Parameters.AddWithValue("@suppId", kundeID);

                da.Fill(dt);

            }
            catch (SqlException ex)
            {
                MessageBox.Show("Error while reading database tables:\n\n" + ex.Message);
            }
            return dt;
        }

        internal static DataTable getUdlejninger(int kundeID)
        {
            string sql = "";
            sql += "SELECT u.UdlejningsNummer, k.KundeNummer, p.Navn, u.ProduktStatus";
            sql += " FROM udlejning u, kunde k, produkter p";
            sql += " WHERE u.KundeNr = k.KundeNummer";
            sql += " AND u.PID = p.ProduktID";
            sql += " AND KundeNummer=@suppId";

            DataTable dt = new DataTable();
            try
            {
                SqlConnection con = dal.getConnection();
                SqlDataAdapter da = new SqlDataAdapter(sql, con);
                da.SelectCommand.Parameters.AddWithValue("@suppId", kundeID);

                da.Fill(dt);

            }
            catch (SqlException ex)
            {
                MessageBox.Show("Error while reading database tables:\n\n" + ex.Message);
            }
            return dt;
        }

        internal static DataTable getUdlejning(int id)
        {
            string sql = "select u.KundeNr, u.PID, u.Afhentningstidspunkt, u.ProduktStatus, u.AntalDoegn, p.Navn";
            sql += " from udlejning u, produkter p";
            sql += " where u.PID = p.ProduktID";
            sql += " AND u.UdlejningsNummer=@suppId";
            DataTable dt = new DataTable();
            try
            {
                SqlConnection con = dal.getConnection();
                SqlDataAdapter da = new SqlDataAdapter(sql, con);
                da.SelectCommand.Parameters.AddWithValue("@suppId", id);

                da.Fill(dt);

            }
            catch (SqlException ex)
            {
                MessageBox.Show("Error while reading database tables:\n\n" + ex.Message);
            }
            return dt;
        }
    }
}
