using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
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

namespace Lektion_07___Binding___Opgave_1_4
{
	/// <summary>
	/// Interaction logic for MainWindow.xaml
	/// </summary>
	public partial class MainWindow : Window
	{
		private ObservableCollection<User> users = new ObservableCollection<User>();

		public MainWindow()
		{
			InitializeComponent();

			users.Add(new User() { Name = "Morten M" });
			users.Add(new User() { Name = "Jane Doe" });

			lbUsers.ItemsSource = users;
		}

		private void btnAddUser_Click(object sender, RoutedEventArgs e)
		{
			users.Add(new User() { Name = txtbFirstName.Text + " " + txtbLastName.Text });
		}

		private void btnChangeUser_Click(object sender, RoutedEventArgs e)
		{
			if (lbUsers.SelectedItem != null)
				(lbUsers.SelectedItem as User).Name = txtbFirstName.Text + " " + txtbLastName.Text;
		}

		private void btnDeleteUser_Click(object sender, RoutedEventArgs e)
		{
			if (lbUsers.SelectedItem != null)
				users.Remove(lbUsers.SelectedItem as User);
		}

		private void firstname_TextChanged(object sender, TextChangedEventArgs e)
        {
			if(txtbFirstName.Text.Length == 0)
            {
				lblFirstName.Visibility = Visibility.Visible;
            } else
            {
				lblFirstName.Visibility = Visibility.Hidden;
			}
        }
		private void lastname_TextChanged(object sender, TextChangedEventArgs e)
		{
			if (txtbLastName.Text.Length == 0)
			{
				lblLastName.Visibility = Visibility.Visible;
			}
			else
			{
				lblLastName.Visibility = Visibility.Hidden;
			}
		}
	}

	public class User : INotifyPropertyChanged
	{
		private string name;
		public string Name
		{
			get { return this.name; }
			set
			{
				if (this.name != value)
				{
					this.name = value;
					this.NotifyPropertyChanged("Name");
				}
			}
		}

		public event PropertyChangedEventHandler PropertyChanged;

		public void NotifyPropertyChanged(string propName)
		{
			if (this.PropertyChanged != null)
				this.PropertyChanged(this, new PropertyChangedEventArgs(propName));
		}
	}
}