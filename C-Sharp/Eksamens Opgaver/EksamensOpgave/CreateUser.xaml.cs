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

namespace EksamensOpgave
{
    /// <summary>
    /// Interaction logic for Window2.xaml
    /// </summary>
    public partial class CreateUser : Window
    {
        public CreateUser()
        {
            InitializeComponent();
            if (!Connection.CheckConnection())
            {
                MessageBox.Show("Forbindelse til database eksisterer ikke." +
                    "\nProgrammet kan ikke fortsætte.");
                Close();
            }
        }

        public void tilbage(object sender, RoutedEventArgs e)
        {
            MainWindow main = new MainWindow();
            App.Current.MainWindow = main;
            this.Close();
            main.Show();
        }

        
        public void createUser(object sender, RoutedEventArgs e)
        {
            string navn = Navn.Text;
            string email = Email.Text;
            string bruger = BrugerNavn.Text;
            string tele = Telefon.Text;

            DataTable opretBruger = services.createUser(navn, email, bruger, tele);
            
            MainWindow main = new MainWindow();
            App.Current.MainWindow = main;
            this.Close();
            main.Show();
        }
        
    }
}
