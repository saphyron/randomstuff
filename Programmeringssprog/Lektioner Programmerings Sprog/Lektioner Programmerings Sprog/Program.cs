using System;

public delegate void PriceChangedHandler(object sender, decimal oldPrice, decimal newPrice);

public class Stock
{
    string symbol;
    decimal price;

    public Stock(string symbol)
    {
        this.symbol = symbol;
    }

    public event PriceChangedHandler PriceChanged;

    public decimal Price
    {
        get { return price; }

        set
        {
            if (price == value) return; // Exit if nothing has changed
            decimal oldPrice = price;
            price = value;
            if (PriceChanged != null) // If invocation list not
                PriceChanged(this, oldPrice, price); // empty, fire event.
        }
    }
}


class Program
{
    static void Main()
    {
        Stock stock = new Stock("THPW");
        stock.Price = 27.10M;
        // Register with the PriceChanged event
        stock.PriceChanged += stock_PriceChangedUp;
        stock.PriceChanged += stock_PriceChangedDown;
        stock.Price = 26.59M;
    }

    static void stock_PriceChangedUp(object sender, decimal oldPrice, decimal newPrice)
    {
        if ((newPrice > oldPrice))
        {
            Console.WriteLine("Prisen er gået op");
        }
    }

    static void stock_PriceChangedDown(object sender, decimal oldPrice, decimal newPrice)
    {
        if ((newPrice < oldPrice))
        {
            Console.WriteLine("Prisen er faldet");
        }
    }
}