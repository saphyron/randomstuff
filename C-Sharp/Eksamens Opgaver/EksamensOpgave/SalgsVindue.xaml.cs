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
    /// Interaction logic for Window1.xaml
    /// </summary>
    public partial class SalgsVindue : Window
    {
        public SalgsVindue()
        {
            InitializeComponent();
            if (!Connection.CheckConnection())
            {
                MessageBox.Show("Forbindelse til database eksisterer ikke." +
                    "\nProgrammet kan ikke fortsætte.");
                Close();
            }
        }
        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            string id = services.getID().ToString();
            idNummer.Content = id;

            opdaterliste();
        }

        private void bydSalg(object sender, RoutedEventArgs e)
        {
            int id = Int32.Parse(idNummer.Content.ToString());
            double bud = Convert.ToDouble(bydning.Text.ToString());
            DataRowView row = (DataRowView)salgsdata.SelectedItems[0];
            if (bud < (double)row.Row[3])
            {
                MessageBox.Show("Bud er for lavt");
                opdaterliste();
            } else { 
            pID.Content = (int)row.Row[0];

            DataTable getBud = services.getBud(id, (int)pID.Content);
            
            DataTable opdaterbud = services.opdaterprodukt((int)pID.Content, bud);
            MessageBox.Show("Tak for dit bud.");
            salgsdata.UnselectAllCells();
            opdaterliste();
            }
        }

        private void opdaterliste()
        {
            DataTable products = services.getsalg();
            salgsdata.ItemsSource = products.DefaultView;
            salgsdata.AutoGenerateColumns = true;
        }

    }
}
