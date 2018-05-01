using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace ValidateID
{
    class Program
    {
        public enum Gender
        {
            Male, Fimale, AniMale_D
        }
        static void Main(string[] args)
        {
            Console.WriteLine("Enter EGN");
            string id ="";
            string birthDate = "";
            Gender gender;

         Validate(id,birthDate,out gender);


            Console.ReadLine();
        }
        public static void Validate(string id, string birhtDate, out Gender gender)
        {
            int month;
            int m;
            int birthDay;

            do
            {
                // Read the egn
                id = Console.ReadLine();

                 month = id[2] - '0';
                birthDay =int.Parse(id.Substring(4, 2));

                // check for the month 
                if (month == 2 || month == 3)
                {
                    m = int.Parse(id.Substring(2, 2)) - 20;
                }
                else if (month == 4 || month == 5)
                {
                    m = int.Parse(id.Substring(2, 2)) - 40;
                }
                else
                {
                    m = int.Parse(id.Substring(2, 2));
                }

                // Check the 10-th number 
                int[] power = { 2, 4, 8, 5, 10, 9, 7, 3, 6 };
                int sum = 0;
                for (int i = 0; i < id.Length-1; i++)
                {
                    sum += power[i] * (id[i] - '0');
                }

                int rem = sum % 11;

                int controler = 0;

                if (rem < 10)
                {
                    controler = rem;
                }

                // check all conditions and return (is valid or not)
                if (id.Length != 10 || !Regex.IsMatch(id, @"^\d+$") || month > 5 || m > 12 || birthDay > 31 || controler != (id[9] - '0'))
                {
                    Console.WriteLine("False(try again!)");
                   
                    month = id[2];
                }
                else
                {
                    Console.WriteLine("True");
                    break;
                }
   
            } while (true);

            string birthMonth = "";
            string birthYear = "";

            // set the birthYear

            if (month == 2 || month == 3)
            {
                birthYear = "18" + id.Substring(0, 2);

             //    m = int.Parse(id.Substring(2, 2)) - 20;
                if (m >=10)
                {
                    birthMonth = Convert.ToString(m);
                }
                else
                {
                    birthMonth = "0" + Convert.ToString(m);
                }
            }
            else if (month == 3 || month == 4)
            {

                birthYear = "20" + id.Substring(0, 2);
                // m = int.Parse(id.Substring(2, 2)) - 40;
                if (m >= 10)
                {
                    birthMonth = Convert.ToString(m);
                }
                else
                {
                    birthMonth = "0" + Convert.ToString(m);
                }
            }
            else
            {
                birthYear = "19" + id.Substring(0, 2);
                birthMonth = id.Substring(2, 2);
            }
            birhtDate = birthDay + "/" + birthMonth+ "/" + birthYear;
            Console.WriteLine(birhtDate);


            int gend = id[8];

            if (gend % 2 == 0)
            {
                gender = Gender.Male;
            }
            else if (gend % 2 != 0)
            {
                gender = Gender.Fimale;
            }
            else
            {
                gender = Gender.AniMale_D;
            }
            Console.WriteLine(gender);
        }
       
    }
}
