using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Product_Inventory
{
    class Inventory
    {
        private List<Product> products = new List<Product>();


        public void Add(Product product)
        {
            if (products.Contains(product))
            {
                int n = products.IndexOf(product);
                products[n].Increase();
            }
            else
            {
                products.Add(product);
            }
        }
        public void AddExtaStock(Product product, int stock)
        {
            if (products.Contains(product))
            {
                int n = products.IndexOf(product);
                products[n].AddToStock(stock);
            }
            else
            {
                Console.WriteLine("Product does not exist!");
            }
        }
      
        public void InventoryPrice()
        {
            decimal sum= 0m;
            foreach (var product in products)
            {
                sum += product.TakePrice();
            }
            Console.WriteLine("Sum of all - " + sum);
        }

        public void PrintAllProducts()
        {
            foreach (var p in products)
            {
                Console.WriteLine($"{p.Title} - {p.Brand} - {p.Description} - {p.Price}");
            }
        }

        //public bool CheckForEqualProducts(List<Product> list, Product product)
        //{
        //    for (int i = 0; i < list.Count; i++)
        //    {
        //        if (list[i].Title == product.Title && list[i].Brand == product.Brand &&
        //            list[i].Description == product.Description && list[i].Price == product.Price)
        //        {
        //            return true;
        //        }
        //        else
        //        {
        //            return false;
        //        }
        //    }
        //    return false;
        //}



    }
}
