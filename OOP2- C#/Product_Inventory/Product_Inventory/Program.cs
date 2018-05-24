using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Product_Inventory
{
    class Program
    {
        static void Main(string[] args)
        {

            Inventory shop = new Inventory();


            Pants pants1 = new Pants("Adidas", "Pants", "White", 50.2m);
            Pants pants2 = new Pants("Nike", "Pants", "Blue", 62.4m);
            Pants pants3 = new Pants("Asics", "Pants", "Red", 52.1m);
            Pants pants4 = new Pants("Puma", "Pants", "Black", 45.5m);
            Pants pants5 = new Pants("Gucci", "Pants", "Gray", 80.4m);

            Shirt shirt1 = new Shirt("Nike", "Shirt", "Black", 25.8m);
            Shirt shirt2 = new Shirt("Nike", "Shirt", "White", 25.8m);
            Shirt shirt3 = new Shirt("Adidas", "Shirt", "White", 28.8m);
            Shirt shirt4 = new Shirt("Puma", "Shirt", "Blue", 24.1m);
            Shirt shirt5 = new Shirt("Armani", "Shirt", "Green", 34.8m);

            shop.Add(pants1);
            shop.Add(pants2);
            shop.Add(pants3);
            shop.Add(pants4);
            shop.Add(pants5);
            shop.Add(pants1);

            shop.Add(shirt1);
            shop.Add(shirt2);
            shop.Add(shirt3);
            shop.Add(shirt4);
            shop.Add(shirt5);
            shop.AddExtaStock(shirt1, 4);

            shop.PrintAllProducts(); // prints all products

            Console.WriteLine();

            pants1.PrintInfo(); // prints info of a current product

            Console.WriteLine("Stock - " +pants1.Stock); // you can take a stock of a product

            shop.InventoryPrice(); // prints the sum of all products(total value)

            shirt1.TotalValue(); // prints the sum of one product(total value)

           
           

            Console.ReadLine();

        }
    }
}
