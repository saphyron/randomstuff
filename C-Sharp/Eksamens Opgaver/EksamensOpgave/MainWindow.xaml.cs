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
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            if (!Connection.CheckConnection())
            {
                MessageBox.Show("Forbindelse til database eksisterer ikke." +
                    "\nProgrammet kan ikke fortsætte.");
                Close();
            }
        }

        private void getUser(object sender, RoutedEventArgs e)
        {
            string name = BrugerNavn.Text;
            DataTable loginAut = services.loginAut(name);
            int aut = Int32.Parse(loginAut.Rows[0][0].ToString());
            if(aut > 0)
            {
                services.setID(aut);
                SalgsVindue salg = new SalgsVindue();
                App.Current.MainWindow = salg;
                this.Close();
                salg.Show();
            } else
            {
                MessageBox.Show("Bruger kunne ikke findes.");
            }
        }

        private void createUserWindow(object sender, RoutedEventArgs e)
        {
            CreateUser user = new CreateUser();
            App.Current.MainWindow = user;
            this.Close();
            user.Show();
        }
    }
}
