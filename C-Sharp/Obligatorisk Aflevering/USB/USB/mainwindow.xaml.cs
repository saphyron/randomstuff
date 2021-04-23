using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Data;

namespace USB
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            if (!dal.CheckConnection())
            {
                MessageBox.Show("Forbindelse til database eksisterer ikke." +
                    "\nProgrammet kan ikke fortsætte.");
                Close();
            }
        }
        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            DataTable kundeTable = Service.getKunder();
            cBoxKunde.ItemsSource = kundeTable.DefaultView;
            cBoxKunde.DisplayMemberPath = "Navn";
            cBoxKunde.SelectedValuePath = "KundeNummer";

            DataTable statusTable = Service.getStatusTable();
            ProduktStatusBox.ItemsSource = statusTable.DefaultView;
            ProduktStatusBox.DisplayMemberPath = "StatusT";
            ProduktStatusBox.SelectedValuePath = "StatusT";

            DataTable ProduktTable = Service.getProduktTable();
            ProduktNavnBox.ItemsSource = ProduktTable.DefaultView;
            ProduktNavnBox.DisplayMemberPath = "Navn";
            ProduktNavnBox.SelectedValuePath = "Navn";
        }

        private void cBoxKunde_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            int kundeID = (int)cBoxKunde.SelectedValue;

            DataTable products = Service.getUdlejninger(kundeID);
            dataGrid1.ItemsSource = products.DefaultView;
            dataGrid1.AutoGenerateColumns = true;

            DataTable kundeInfo = Service.getKundeInfo(kundeID);
            KundeNavnText.Text = kundeInfo.Rows[0]["Navn"].ToString();
            KundeAddresseText.Text = kundeInfo.Rows[0]["Addresse"].ToString();
            KundeEmailText.Text = kundeInfo.Rows[0]["EMail"].ToString();
            KundeBrugerNavnText.Text = kundeInfo.Rows[0]["Brugernavn"].ToString();
            KundePasswordText.Text = kundeInfo.Rows[0]["Password"].ToString();


        }
        private void datagridgetData(object sender, SelectionChangedEventArgs e)
        {
            DataRowView row = (DataRowView)dataGrid1.SelectedItems[0];
            int id = (int)row.Row[0];

            DataTable udlejningsprodukt = Service.getUdlejning(id);
            KundeNummerText.Text = udlejningsprodukt.Rows[0]["KundeNr"].ToString();
            ProduktIDText.Text = udlejningsprodukt.Rows[0]["PID"].ToString();
            AfhentningsDatoText.Text = udlejningsprodukt.Rows[0]["Afhentningstidspunkt"].ToString();
            ProduktStatusBox.Text = udlejningsprodukt.Rows[0]["ProduktStatus"].ToString();
            AntalDoegnText.Text = udlejningsprodukt.Rows[0]["AntalDoegn"].ToString();
            ProduktNavnBox.Text = udlejningsprodukt.Rows[0]["Navn"].ToString();
        }

        private void opret_bruger(object sender, RoutedEventArgs e)
        {
            string name = KundeNavnText.Text;
            string address = KundeAddresseText.Text;
            string eM = KundeEmailText.Text;
            string user = KundeBrugerNavnText.Text;
            string pass = KundePasswordText.Text;
            if(user == "")
            {
                user = "Temp";
            }
            if(pass == "")
            {
                pass = "PTemp";
            }
            DataTable opretningAfBruger = Service.opretningAfBruger(name, address, eM, user, pass);
            KundeNavnText.Text = "";
            KundeAddresseText.Text = "";
            KundeEmailText.Text = "";
            KundeBrugerNavnText.Text = "";
            KundePasswordText.Text = "";
        }
        private void rediger_bruger(object sender, RoutedEventArgs e)
        {
            string name = KundeNavnText.Text;
            string address = KundeAddresseText.Text;
            string eM = KundeEmailText.Text;
            string user = KundeBrugerNavnText.Text;
            string pass = KundePasswordText.Text;
            int id = (int)cBoxKunde.SelectedValue;
            DataTable redigeringAfBruger = Service.redigeringAfBruger(id ,name, address, eM, user, pass);

            KundeNavnText.Text = "";
            KundeAddresseText.Text = "";
            KundeEmailText.Text = "";
            KundeBrugerNavnText.Text = "";
            KundePasswordText.Text = "";
            
        }
        
        private void rediger_udlejning(object sender, RoutedEventArgs e)
        {
            int nR = int.Parse(KundeNummerText.Text);
            int pID = int.Parse(ProduktIDText.Text);
            string sBox = ProduktStatusBox.Text;
            
            DataTable redUdlej = Service.redigeringAfUdlejning(nR, pID, sBox);
        }
    }
    
}

