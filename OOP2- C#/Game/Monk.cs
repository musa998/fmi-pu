using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Game
{
    class Monk : Hero
    {
        Random rnnd = new Random();
        public Monk(double health, double attack, double armor, string name) : base(health, attack, armor, name)
        {
        }

        public override bool CanBlock()
        {
            return rnnd.Next(1, 101) <= 30;
        }
        public override void Attack(Hero defender)
        {
            double damage = ActualAttack() - defender.ActualArmor();
            if (defender.CanBlock() == false && damage > 0)
            {
                defender.HealthPoints -= AttackPoints;

                Console.WriteLine($"\t\t{Name} attack {defender.Name} with {damage}");
                Console.WriteLine();
                Console.WriteLine($"{Name}- Attack Points - {AttackPoints} - Armor Points - " +
                    $"{ArmorPoints} - Health  {HealthPoints}");
                Console.WriteLine($"{defender.Name}- Attack Points - {defender.AttackPoints} - Armor Points - " +
                   $"{defender.ArmorPoints} - Health  {defender.HealthPoints}");
            }
           
        }

       
    }
}
