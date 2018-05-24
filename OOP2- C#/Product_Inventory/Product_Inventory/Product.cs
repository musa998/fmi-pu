using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Product_Inventory
{
    class Product
    {
        public string Brand { get; set; }
        public string Title { get; set; }
        public decimal Price { get; set; }
        public string Description { get; set; }
        public int Stock { get; private set; }
        private int stock = 1;

        public Product(string brand, string titile, string description, decimal price)
        {
            this.Brand = brand;
            this.Title = titile;
            this.Description = description;
            this.Price = price;
            this.Stock = 1;
        }
        public void Increase()
        {
            stock++;
            this.Stock = stock;
        }
        public void AddToStock(int stockToSet)
        {
            stock += stockToSet;
            this.Stock = stock;
        }
        public decimal TakePrice()
        {
            return (Price * stock);
        }
        public void PrintInfo()
        {
            Console.WriteLine($"{this.Title} - {this.Brand} - {this.Description} - {this.Price}");
        }
        public void TotalValue()
        {
            Console.WriteLine("Sum - " +this.Stock * this.Price);
        }

    }
}
